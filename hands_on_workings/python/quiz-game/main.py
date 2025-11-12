from question_model import Question
from data import question_data
from quiz_brain import QuizBrain

question_bank = []
for data in question_data:
    question_bank.append(Question(data["text"],data["answer"]))

print(question_bank)

quiz_brain = QuizBrain(question_bank)

quiz_brain.still_has_questions()