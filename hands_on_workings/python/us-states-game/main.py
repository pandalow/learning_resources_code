import turtle
from turtle import Screen, Turtle
import pandas

screen = Screen()
IMAGE = "blank_states_img.gif"
screen.addshape(IMAGE)
screen.title("GUESS STATE")

tim = Turtle()

turtle.shape(IMAGE)
tim.penup()
tim.hideturtle()

guess_state = []
while len(guess_state) < 50:
    answer = turtle.textinput(f"{len(guess_state)}/50 Guess the state", "Whats state do you know?")

    # Check if the guess among the states
    data = pandas.read_csv('50_states.csv')
    if answer == "EXIT":
        missing_state = [item for item in data.state.to_list() if item not in guess_state]
        new_data = pandas.DataFrame(missing_state)
        new_data.to_csv("missing_state.csv")
        break
    if answer in data.state.to_list():
        guess_state.append(answer)
        position_x = data[data.state == answer].x
        position_y = data[data.state == answer].y
        tim.goto(position_x.item(), position_y.item())
        tim.write(answer, True, "center")

turtle.mainloop()
