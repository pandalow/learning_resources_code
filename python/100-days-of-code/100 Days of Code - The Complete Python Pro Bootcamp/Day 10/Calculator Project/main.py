from art import logo


def add(n1, n2):
    return n1 + n2


def subtract(n1, n2):
    return n1 - n2


def multiply(n1, n2):
    return n1 * n2


def division(n1, n2):
    return n1 / n2


calculation = {
    "+": add,
    "-": subtract,
    "*": multiply,
    "/": division,
}

# print(calculation["*"](4, 8))




def calculator():
    result = int(input("What is the first number"))
    operator = input("What is your type of mathematcial operator? + - * / ?")
    for key in calculation:
        print(key)

    l_num = int(input("What is the second number"))

    result = calculation[operator](result, l_num)
    print(f"The result is {result}")

    is_continue = input("Do you want to continue? Y / N").lower() == "y"

    if not is_continue:
        print(f"The final result is {result}")
        result = 0
    else:
        calculator()

print(logo)
calculator()