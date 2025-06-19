import random
# import day_4_module.day_4_pi_module as pi_module
#
# random_integer = random.randint(1, 10)
#
# random_float = random.random()
# print(random_integer)
# print(random_float*5)
#


# states_of_china = ["Beijing", "Zhejiang"]
#
# province = states_of_china[-1]
#
# states_of_china[1] = "Shanghai"
#
# states_of_china.append("Hubei")
# states_of_china.extend(["Jiangsu", "Liaoning"])


# line1 = ["⬜️","️⬜️","️⬜️"]
# line2 = ["⬜️","⬜️","️⬜️"]
# line3 = ["⬜️️","⬜️️","⬜️️"]
# map = [line1, line2, line3]
# print("Hiding your treasure! X marks the spot.")
# position = input() # Where do you want to put the treasure?
# # 🚨 Don't change the code above 👆
# # Write your code below this row 👇
#
# col = 0
#
# if position[0] == 'A':
#   col = 0
# elif position[0] == 'B':
#   col = 1
# elif position[0] == 'C':
#   col = 2
#
# # # Smart idea using index
# # letter = position[0].lower()
# # abc = ["a", "b", "c"]
# # letter_index = abc.index(letter)
#
# map[int(position[1])-1][col] = 'X'
#
#
# # Write your code above this row 👆
# # 🚨 Don't change the code below 👇
# print(f"{line1}\n{line2}\n{line3}")

rock = '''
    _______
---'   ____)
      (_____)
      (_____)
      (____)
---.__(___)
'''

paper = '''
    _______
---'   ____)____
          ______)
          _______)
         _______)
---.__________)
'''

scissors = '''
    _______
---'   ____)____
          ______)
       __________)
      (____)
---.__(___)
'''

# Write your code below this line 👇


input_choose = int(input("What you want to choose? rock(0), paper(1) or scissor(2)."))
game = [rock,paper,scissors]
computer_choose = random.randint(0, 2)
print(game[input_choose])
print('Computer Choose:')
print(game[computer_choose])

if (input_choose == 0 and computer_choose == 2) or (input_choose == 1 and computer_choose == 0) or (input_choose == 2 and computer_choose == 1):
    print('You win')
elif input_choose == computer_choose:
    print('Draw game')
else:
    print('You lose')
