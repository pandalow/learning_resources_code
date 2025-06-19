# String instead of String.charAt(0)
print("Hello"[0])

print("123" + "345")

# Integer
print(123 + 345)

print(123_456_789)

# Float
3.14159

# Boolean
True
False

# Type check
num_char = len(input("What is your name?"))
print(type(num_char))

# Type cast
new_num_char = str(num_char)

# float division
print(type(8 // 3))

# Continuing divide
result = 4 / 2
result /= 2
print(result)

# f-string
score = 0
height = 1.8
isWinning = True

print(f"your score is {score}, your height is {height}, your are Winning is {isWinning}")

print("Welcome to the tip caculator")
total_bill = input("What was the total bill? $")
percentage = input("How much tip do you like to give? 10, 15 or 20? ")
total_tip = float(total_bill) * (1 + int(percentage) / 100)
people = input("How many people do you spilt the bill? ")
each_person_bill = total_tip / int(people)
rounded_bill = round(each_person_bill, 2)
rounded_bill = "{:.2f}".format(each_person_bill)
print(f"Each person should pay:${rounded_bill}")
