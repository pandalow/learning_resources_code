from turtle import Turtle

ini_pos = (350, 0)


class Paddle(Turtle):

    def __init__(self,position):
        super().__init__()
        self.draw(position)

    def draw(self,position):
        self.shape("square")
        self.penup()
        self.color("white")
        self.shapesize(5, 1)
        self.goto(position)

    def up(self):
        new_y = self.ycor() + 20
        self.goto(self.xcor(), new_y)

    def down(self):
        new_y = self.ycor() - 20
        self.goto(self.xcor(), new_y)
