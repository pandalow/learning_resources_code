from flask import Flask
import random

app = Flask(__name__)

number = random.randint(0, 9)


def verify_number(function):
    def wrapper(*args,**kwargs):
        element = function(kwargs['num'])
        if int(kwargs['num']) == number:
            return (f"{element}<h1 style='color:red'>You found me</h1>"
                    "<img src='https://media.giphy.com/media/4T7e4DmcrP9du/giphy.gif'/>")
        elif int(kwargs['num']) > number:
            return (f"{element}<h1 style='color:blue'>Too High</h1>"
                    "<img src='https://media.giphy.com/media/3o6ZtaO9BZHcOjmErm/giphy.gif'/>")
        else:
            return (f"{element}<h1 style='color:black'>Too low</h1>"
                    "<img src='Low: https://media.giphy.com/media/jD4DwBtqPXRXa/giphy.gif'/>")

    return wrapper


@app.route('/')
def guess_number():
    return ("<h1>Guess a number between 0 and 9</h1>"
            "<img src='https://media.giphy.com/media/3o7aCSPqXE5C6T8tBC/giphy.gif'/>")


@app.route('/<num>')
@verify_number
def result(num):
    return ""


if __name__ == "__main__":
    app.run(debug=True)
