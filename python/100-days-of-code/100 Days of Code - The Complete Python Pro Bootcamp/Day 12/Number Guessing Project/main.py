# TODO print logo
from art import logo
import random

print(logo)
print("Welcome to the Number Guessing")
print("I,m thinking of a number between 1 and 100.")
# TODO print and finish difficulty selection , easy has 10 attempts, hard has 5 attempts
ATTEMPTS = 0
difficulty = input("Choose a difficulty. Type 'easy' or 'hard': ")
if difficulty == 'easy':
    ATTEMPTS = 10
else:
    ATTEMPTS = 5
print(f"You have {ATTEMPTS} attempts remaining to guess the number.")

# TODO generate the random number
GUESS_NUMBER = random.randint(1, 100)

while ATTEMPTS > 0:
    # TODO let the user input the value to guess
    user_guess = int(input("Make a guess: "))
    # TODO determine the user's guess is same as random value
    if user_guess < GUESS_NUMBER:
        print("Too low")
        ATTEMPTS -= 1
        print(f"You have {ATTEMPTS} attempts remaining to guess the number.")
    elif user_guess > GUESS_NUMBER:
        print("Too high")
        ATTEMPTS -= 1
        print(f"You have {ATTEMPTS} attempts remaining to guess the number.")
    else:
        # TODO if number is equals then finish , if not then continue loop
        print(f"You got it! The answer was {GUESS_NUMBER}")
        ATTEMPTS = 0

