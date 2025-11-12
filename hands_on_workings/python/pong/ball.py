from turtle import Turtle
import random


class Ball(Turtle):

    def __init__(self):
        super().__init__()
        self.shape("circle")
        self.penup()
        self.shapesize(stretch_len=0.5,stretch_wid=0.5)
        self.color("white")
        self.move_x = 10
        self.move_y = 10
        # random_x = random.randint(-350,350)
        # random_y = random.randint(-250,250)
        # self.goto(random_x,random_y)

    def move(self):
        self.goto(self.xcor()+self.move_x,self.ycor()+self.move_y)

    def bounce(self):
        self.move_y *= -1

    def bounce_paddle(self):
        self.move_x *= -1

    def reset_game(self):
        self.goto(0,0)
        self.bounce_paddle()
