# TODO Screen, create a bg-black screen,
from turtle import Screen
import time

from ball import Ball
from paddle import Paddle
from scoreboard import ScoreBoard

screen = Screen()
screen.setup(800, 600)
screen.bgcolor("black")
screen.title('Pong')
screen.tracer(0)

#  listen the user action , move down & up
screen.listen()

# TODO 2 boards can be fight ball.
paddle_1 = Paddle((350, 0))
paddle_2 = Paddle((-350, 0))

screen.onkey(paddle_1.up, 'Up')
screen.onkey(paddle_1.down, 'Down')
screen.onkey(paddle_2.up, 'w')
screen.onkey(paddle_2.down, 's')

# TODO Ball
ball = Ball()
scoreboard = ScoreBoard()


game_is_on = True

while game_is_on:
    time.sleep(0.1)
    screen.update()
    ball.move()
    # TODO Detect the collision of wall and bounce
    if ball.ycor() > 280 or ball.ycor() < -280:
        ball.bounce()


    # TODO Detect the collision with the paddle
    if (ball.distance(paddle_1) < 50 and ball.xcor() > 320 or
            ball.distance(paddle_2) < 50 and ball.xcor() < -320):
        ball.bounce_paddle()
        scoreboard.right_points()
    # TODO GameOver condition
    if ball.xcor() > 380 or ball.xcor() < -389:
        ball.reset_game()
        scoreboard.left_points()



# TODO ScoreBoard


screen.exitonclick()
