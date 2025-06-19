class QuizBrain:
    def __init__(self, quiz_list):
        self.quiz_number = 0
        self.quiz_list = quiz_list
        self.score = 0

    def next_question(self):
        question = self.quiz_list[self.quiz_number]
        self.quiz_number += 1
        user_answer = input(f"Q:{self.quiz_number}  {question.text} (True/False)")
        self.check_answer(user_answer,question.answer)

    def still_has_questions(self):
        if self.quiz_number < len(self.quiz_list):
            self.next_question()
            self.still_has_questions()
        else:
            print("You've completed the whole quiz")
            print(f"You got the final score is : {self.score}/{self.quiz_number}")
            return

    def check_answer(self,user_answer,current_answer):
        if user_answer == current_answer:
            print("You got right")
            self.score += 1

        else:
            print("You are wrong")

        print(f"The correct answer is {current_answer}")
        print(f"Your score is {self.score}/{self.quiz_number}")
        print("\n")