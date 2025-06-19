from flask import Flask, render_template, redirect, url_for, request
from flask_bootstrap import Bootstrap5
from edit_form import RatingForm,AddingForm
from dao import db,Movie
from movie_request import MovieRequest

'''
Red underlines? Install the required packages first: 
Open the Terminal in PyCharm (bottom left). 

On Windows type:
python -m pip install -r requirements.txt

On MacOS type:
pip3 install -r requirements.txt

This will install the packages from requirements.txt for this project.
'''

app = Flask(__name__)
app.config['SECRET_KEY'] = '8BYkEfBA6O6donzWlSihBXox7C0sKR6b'
Bootstrap5(app)

# CREATE DB
app.config["SQLALCHEMY_DATABASE_URI"] = "sqlite:///movies.db"
db.init_app(app)

movie_request = MovieRequest()

# CREATE TABLE
with app.app_context():
    db.create_all()

@app.route("/")
def home():
    movies = db.session.execute(db.select(Movie).order_by(Movie.rating)).scalars().all()

    for i in range(len(movies)):
        movies[i].ranking = len(movies) - i
    db.session.commit()

    return render_template("index.html",movies=movies)


@app.route("/edit",methods=["GET","POST"])
def edit():
    form = RatingForm()
    movie_id = int(request.args.get('id'))
    movie = db.session.execute(db.select(Movie).where(Movie.id == movie_id)).scalar()
    if form.validate_on_submit():
        movie.rating = form.rating.data
        movie.review = form.review.data
        db.session.commit()
        return redirect(url_for('home'))
    return render_template("edit.html", form=form)

@app.route('/delete')
def delete():
    movie_id = request.args.get('id')
    movie = db.get_or_404(Movie, movie_id)
    db.session.delete(movie)
    db.session.commit()
    return redirect(url_for('home'))

@app.route("/add",methods=["GET","POST"])
def add():
    data = []
    form = AddingForm()
    if form.validate_on_submit():
        title = form.title.data
        data = movie_request.get_movies(title)
        return render_template('select.html', data=data)
    else:
        return render_template('add.html',form=form)

@app.route("/insert")
def insert():
    movie_id = request.args.get('id')
    data = movie_request.get_details(movie_id)
    print(data)
    new_movie = Movie(
        title = data['original_title'],
        description = data['overview'],
        img_url = f"https://image.tmdb.org/t/p/w500{data['poster_path']}",
        year=  data['release_date'].split("-")[0],
    )
    db.session.add(new_movie)
    db.session.commit()

    return redirect(url_for('home'))

if __name__ == '__main__':
    app.run(debug=True)
