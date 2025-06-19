import pandas
import random

name = "Zhuang"
letters = [item for item in name]
print(letters)

names = ["zhuang", "cindy", "cool", "Jiejie"]
# new_upper_names_list = [name.upper() for name in names if len(name)>5]

student_score = {student: random.randint(1, 100) for student in names}
passed_student = {student: score for (student, score) in student_score.items() if score > 40}
