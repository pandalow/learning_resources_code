#Password Generator Project
import random
letters = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']
numbers = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
symbols = ['!', '#', '$', '%', '&', '(', ')', '*', '+']

print("Welcome to the PyPassword Generator!")
nr_letters= int(input("How many letters would you like in your password?\n"))
nr_symbols = int(input(f"How many symbols would you like?\n"))
nr_numbers = int(input(f"How many numbers would you like?\n"))

# Eazy Level - Order not randomised:
# e.g. 4 letter, 2 symbol, 2 number = JduE&!91
random_letters = []
random_symbols = []
random_numbers = []
password = ''
for random_number in range(1, nr_letters):
    random_value = random.randint(1,26)
    random_letters.append(random_value)
for random_number in range(1, nr_symbols):
    random_value = random.randint(1,10)
    random_symbols.append(random_value)
for random_number in range(1,nr_numbers):
    random_value = random.randint(1, 9)
    random_numbers.append(random_value)

for random_symbol in random_symbols:
    password += symbols[random_symbol]
for random_letter in random_letters:
    password += letters[random_letter]
for random_number in random_numbers:
    password += numbers[random_number]
print(password)
# Hard Level - Order of characters randomised:
# e.g. 4 letter, 2 symbol, 2 number = g^2jk8&P

