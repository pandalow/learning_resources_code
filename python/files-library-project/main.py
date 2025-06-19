from flask import Flask, render_template, request, redirect, url_for
from sql_lite import db, Book
from books import BookForm
from flask_bootstrap import Bootstrap4


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
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///new-books-collection.db'
Bootstrap4(app)
db.init_app(app)

all_books = []

with app.app_context():
    db.create_all()

@app.route('/')
def home():
    books = db.session.execute(db.select(Book).order_by(Book.id)).scalars()
    return render_template('index.html',all_books=list(books))

@app.route('/edit/<book_id>',methods=['GET','POST'])
def edit(book_id):
    book = db.session.execute(db.select(Book).where(Book.id == book_id)).scalar()
    if request.method == 'POST':
        book.rating = request.form['rating']
        db.session.commit()
        return redirect(url_for('home'))
    return render_template('edit.html',book=book)


@app.route("/add", methods=['GET', 'POST'])
def add():
    form = BookForm()
    if form.validate_on_submit():
        new_book = Book(
            title=form.title.data,
            author=form.author.data,
            rating=form.rating.data,
        )
        db.session.add(new_book)
        db.session.commit()
        return redirect(url_for('home'))
    return render_template('add.html',form=form)

@app.route("/delete/<book_id>",methods=['GET','POST'])
def delete(book_id):
    book = db.session.execute(db.select(Book).where(Book.id == book_id)).scalar()
    db.session.delete(book)
    db.session.commit()
    return redirect(url_for('home'))


if __name__ == "__main__":
    app.run(debug=True)

