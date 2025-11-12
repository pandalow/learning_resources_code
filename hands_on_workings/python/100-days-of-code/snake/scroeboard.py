from turtle import Turtle

SCORE_BOARD_POSITION = (0, 250)
ALIGNMENT = "center"
FONT = ("Courier", 24, "normal")


class ScoreBoard(Turtle):

    def __init__(self):
        super().__init__()
        self.score = 0
        self.speed("fastest")
        self.color("white")
        self.hideturtle()
        self.penup()
        self.goto(SCORE_BOARD_POSITION[0], SCORE_BOARD_POSITION[1])
        self.update_scoreboard()

    def increase_score(self):
        self.score += 1
        self.update_scoreboard()

    def update_scoreboard(self):
        self.clear()
        self.write(f"Score :{self.score} ", True, ALIGNMENT, FONT)
