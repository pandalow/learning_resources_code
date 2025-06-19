from turtle import Turtle, Screen

tim = Turtle()
screen = Screen()


def move_forward():
    tim.forward(10)


def move_back():
    tim.back(10)


def turn_right():
    tim.right(25)


def turn_left():
    tim.left(25)


def clean_screen():
    screen.clear()


while True:
    screen.listen()
    screen.onkey(fun=move_forward, key='w')
