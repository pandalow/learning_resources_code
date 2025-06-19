from quiz_brain import QuizBrain
from tkinter import *

THEME_COLOR = "#375362"


class QuizInterface:

    def __init__(self, quiz_brain: QuizBrain):
        self.quiz_brain = quiz_brain
        self.window = Tk()
        self.window.title("Quizzer")
        self.window.config(bg=THEME_COLOR, padx=20, pady=20)
        self.score = Label(text="score:0", bg=THEME_COLOR, fg="white")
        self.score.grid(row=0, column=1)
        self.canvas = Canvas(width=300, height=250, bg="white")
        self.canvas.grid(row=1, column=0, columnspan=2, pady=50)
        self.quiz_text = self.canvas.create_text(150,
                                                 125,
                                                 text="This is a sample question",
                                                 width=280,
                                                 font=("Arial", 20, "italic"))

        wrong_photo = PhotoImage(file="./images/false.png")
        right_photo = PhotoImage(file="./images/true.png")

        self.false_button = Button(image=wrong_photo, highlightthickness=0, command=self.question_is_false)
        self.true_button = Button(image=right_photo, highlightthickness=0, command=self.question_is_true)
        self.false_button.grid(row=2, column=0)
        self.true_button.grid(row=2, column=1)

        self.get_next_question()

        self.window.mainloop()

    def get_next_question(self):
        self.canvas.config(bg="white")
        if self.quiz_brain.still_has_questions():
            quiz = self.quiz_brain.next_question()
            self.score.config(text=f"Score: {self.quiz_brain.score}")
            self.canvas.itemconfig(self.quiz_text, text=quiz)
        else:
            self.canvas.itemconfig(text="You have reached the end of the quiz")
            self.true_button.config(state="disabled")
            self.false_button.config(state="disabled")

    def question_is_true(self):
        self.check_result(self.quiz_brain.check_answer("True"))

    def question_is_false(self) -> bool:
        result = self.quiz_brain.check_answer("False")
        self.check_result(result)

    def check_result(self, result: bool):
        print(result)
        if result:
            self.canvas.config(bg="green")
        else:
            self.canvas.config(bg="red")

        self.window.after(1000, self.get_next_question)
