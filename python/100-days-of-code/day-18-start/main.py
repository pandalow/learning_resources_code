import turtle
from turtle import Turtle
import random

tim = Turtle()
turtle.colormode(255)


def random_color():
    r = random.randint(0, 255)
    g = random.randint(0, 255)
    b = random.randint(0, 255)

    colormode = (r, g, b)
    return colormode



while range(0,255):
    color = random_color()
    tim.pencolor(color)
    tim.circle(35)
    tim.left(50)
