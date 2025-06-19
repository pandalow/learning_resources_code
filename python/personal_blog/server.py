from flask import Flask, render_template
import random
import datetime as dt
import requests

app = Flask(__name__)


@app.route('/')
def home():
    random_number = random.randint(0, 10)
    name = "pandalow"
    year = dt.datetime.now().year
    return render_template('index.html', num=random_number, current_year=year, name=name)


@app.route('/guess/<name>')
def guess(name):
    parameters = {
        'name': name
    }
    response = requests.get(url="https://api.genderize.io", params=parameters)
    gender = response.json()['gender']
    age_response = requests.get(url='https://api.agify.io', params=parameters)

    age = age_response.json()['age']

    return render_template('index.html', gender=gender, age=age, name=name)


@app.route('/blog/<num>')
def blog(num):
    print(num)
    response = requests.get(url="https://api.npoint.io/c790b4d5cab58020d391")
    blog = response.json()
    print(blog)
    return render_template("blog.html", blog=blog)


if __name__ == '__main__':
    app.run(debug=True)
