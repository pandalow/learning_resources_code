from turtle import Turtle

ALIGNMENT = "center"
FONT = ("Courier", 24, "normal")


class Scoreboard(Turtle):

    def __init__(self):
        super().__init__()
        self.score = 0
        self.color("white")
        self.penup()
        self.goto(0, 270)
        self.hideturtle()
        self.high_score = self.read_score()
        self.update_scoreboard()

    def update_scoreboard(self):
        self.clear()
        self.write(f"Score: {self.score} High Score: {self.high_score}", align=ALIGNMENT, font=FONT)

    def reset(self):
        if self.score > self.high_score:
            self.high_score = self.score
        self.score = 0

        with open("score.txt", "w") as file:
            file.write(str(self.high_score))

        self.update_scoreboard()

    def read_score(self):
        with open("score.txt", "r") as file:
            return int(file.read())

    def increase_score(self):
        self.score += 1
        self.update_scoreboard()
