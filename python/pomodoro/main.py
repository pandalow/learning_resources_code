from tkinter import *
import math

# ---------------------------- CONSTANTS ------------------------------- #
PINK = "#e2979c"
RED = "#e7305b"
GREEN = "#9bdeac"
YELLOW = "#f7f5dd"
FONT_NAME = "Courier"
WORK_MIN = 25
SHORT_BREAK_MIN = 5
LONG_BREAK_MIN = 20
timer_state = None
reps = 0


# ---------------------------- TIMER RESET ------------------------------- #
def reset_timer():
    window.after_cancel(timer_state)
    canvas.itemconfig(count_timer, text="00:00")
    timer.config(text="Timer")
    check_button.config(text=" ")
    global reps
    reps = 0

# ---------------------------- TIMER MECHANISM ------------------------------- #
def handle_count_timer():
    global reps
    reps += 1
    print(reps)
    if reps % 2 == 1:
        count_down(WORK_MIN * 60)
        timer.config(text="WORK", fg=GREEN)
    elif reps % 8 == 0:
        count_down(LONG_BREAK_MIN * 60)
        timer.config(text="BREAK", fg=RED)
    else:
        count_down(SHORT_BREAK_MIN * 60)
        timer.config(text="BREAK", fg=PINK)


# ---------------------------- COUNTDOWN MECHANISM ------------------------------- #
def count_down(count):
    minute = math.floor(count / 60)
    second = count % 60

    if second < 10:
        second = f"0{second}"

    canvas.itemconfig(count_timer, text=f"{minute}:{second}")
    if count > 0:
        global timer_state
        timer_state = window.after(1000, count_down, count - 1)
    if count == 0:
        handle_count_timer()
        mark = ""
        work_session = math.floor(reps / 2)
        for _ in range(work_session):
            mark += "✔"
        check_button.config(text=mark)


# ---------------------------- UI SETUP ------------------------------- #
window = Tk()
window.title("Pomodoro")
window.config(bg=YELLOW, padx=100, pady=50)
canvas = Canvas(width=200, height=224, bg=YELLOW, highlightthickness=0)
tomato_image = PhotoImage(file="tomato.png")
canvas.create_image(100, 112, image=tomato_image)
count_timer = canvas.create_text(100, 130, text="00:00", fill="white", font=(FONT_NAME, 35, "bold"))
canvas.grid(row=1, column=1)

timer = Label(text="Timer", font=(FONT_NAME, 50, "bold"), fg=GREEN, bg=YELLOW)
timer.grid(row=0, column=1)

start_button = Button(text="start", highlightthickness=0, command=handle_count_timer)
start_button.grid(row=2, column=0)

reset_button = Button(text="reset", highlightthickness=0, command=reset_timer)
reset_button.grid(row=2, column=2)

check_button = Label(text="✓", bg=YELLOW, font=(FONT_NAME, 30, 'bold'), fg=GREEN)
check_button.grid(row=3, column=1)

window.mainloop()
