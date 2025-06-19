def my_function():
    print("hello")
    print("bye")

my_function()


# def turn_right():
#     turn_left()
#     turn_left()
#     turn_left()
#
#
# def pass_hurdle():
#     move()
#     turn_left()
#     move()
#     turn_right()
#     move()
#     turn_right()
#     move()
#     turn_left()
#
#
# for i in range(0, 6):
#     pass_hurdle()

def turn_right():
    turn_left()
    turn_left()
    turn_left()


def pass_hurdle():
    move()
    turn_left()
    move()
    turn_right()
    move()
    turn_right()
    move()
    turn_left()


number_of_hurdles = 6
while number_of_hurdles > 0:
    pass_hurdle()
    number_of_hurdles -= 1


def turn_right():
    turn_left()
    turn_left()
    turn_left()

def pass_hurdle():
    move()
    turn_left()
    move()
    turn_right()
    move()
    turn_right()
    move()
    turn_left()


while not at_goal():
    pass_hurdle()