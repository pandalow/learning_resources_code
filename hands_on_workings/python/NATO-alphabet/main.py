# student_dict = {
#     "student": ["Angela", "James", "Lily"],
#     "score": [56, 76, 98]
# }

# Looping through dictionaries:
# for (key, value) in student_dict.items():
# Access key and value
# pass

import pandas

# student_data_frame = pandas.DataFrame(student_dict)

# Loop through rows of a data frame
# for (index, row) in student_data_frame.iterrows():
# Access index and row
# Access row.student or row.score
# pass

# Keyword Method with iterrows()
# {new_key:new_value for (index, row) in df.iterrows()}

# TODO 1. Create a dictionary in this format:
# {"A": "Alfa", "B": "Bravo"}
nato_pandas = pandas.read_csv("nato_phonetic_alphabet.csv")

nato_dict = {row.letter: row.code for (index, row) in nato_pandas.iterrows()}


# TODO 2. Create a list of the phonetic code words from a word that the user inputs.
def generate_quest():
    user_name = input("What's your name?")
    try:
        # 可以用 dict的特殊功能来转换
        user_name_list = [nato_dict[letter.upper()] for letter in user_name]
    except KeyError:
        print("Sorry, only letters in the alphabet please")
        generate_quest()
    else:
        print(user_name_list)
# nato_list = [words for (letter, words) in nato_dict.items() if letter.lower() in user_name_list]

generate_quest()