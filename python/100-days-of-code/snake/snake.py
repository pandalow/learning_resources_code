from turtle import Turtle
import time

SCREEN_POSITION = [(0, 0), (-20, 0), (-40, 0)]
MOVE_DISTANCE = 20
UP = 90
LEFT = 180
RIGHT = 0
DOWN = 270


class Snake:

    def __init__(self):
        self.segments = []
        self.draw_snake()
        self.head = self.segments[0]

    def draw_snake(self):
        for position in SCREEN_POSITION:
            self.add(position)

    def move(self):
        for seg_num in range(len(self.segments) - 1, 0, -1):
            self.segments[seg_num].goto(
                self.segments[seg_num - 1].xcor(),
                self.segments[seg_num - 1].ycor()
            )
        self.head.forward(MOVE_DISTANCE)

    def add(self,position):
        segment = Turtle("square")
        segment.color("white")
        segment.penup()
        segment.goto(position)
        self.segments.append(segment)

    def extend(self):
        self.add(self.segments[-1].position())


    def up(self):
        if self.head.heading() != DOWN:
            self.head.setheading(UP)

    def down(self):
        if self.head.heading() != UP:
            self.head.setheading(DOWN)

    def right(self):
        if self.head.heading() != LEFT:
            self.head.setheading(RIGHT)

    def left(self):
        if self.head.heading() != RIGHT:
            self.head.setheading(LEFT)
