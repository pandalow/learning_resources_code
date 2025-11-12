from flask import Flask, render_template
from flask_bootstrap import Bootstrap5
from loginform import LoginForm

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
app.secret_key = "generate_eeee_key"
bootstrap = Bootstrap5(app)


@app.route("/")
def home():
    return render_template('index.html')

@app.route("/login",methods=['GET','POST'])
def login():
    form = LoginForm()
    email = form.email.data
    password = form.password.data
    if email == "admin@email.com" and password == "12345678" and form.validate_on_submit():
        return render_template('success.html')
    elif form.validate_on_submit():
        return render_template('denied.html')

    return render_template("login.html", form=form)


if __name__ == '__main__':
    app.run(debug=True)
