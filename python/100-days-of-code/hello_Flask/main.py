from flask import Flask

app = Flask(__name__)
print(app)


def make_bold(function):
    def wrap_function():
        element = function()
        return f"<b>{element}</b>"
    return wrap_function

def make_emphasis(function):
    def wrap_function():
        return "<em>"+function()+"</em>"
    return wrap_function

def make_underline(function):
    def wrap_function():
        return f"<u>{function()}</u>"
    return wrap_function

@app.route("/")
def hello_world():
    return "<p>Hello, World!</p>"


@app.route("/bye")
@make_bold
@make_emphasis
@make_underline
def bye():
    return "bye"

@app.route('/<name>')
def print_name(name):
    return (f"<h1 style='text-align:center'>{name}</h1>"
            f"")




if __name__ == '__main__':
    app.run(debug=True)
