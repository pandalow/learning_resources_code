import random
from art import logo, vs
from game_data import data


# TODO random choice tow
def get_compare_data():
    compare_a = random.choice(data)
    compare_b = compare_a
    while compare_a == compare_b:
        compare_b = random.choice(data)
    return compare_a, compare_b


# TODO compare the two data and return the values
def compare(compare_a, compare_b):
    if compare_a['follower_count'] > compare_b['follower_count']:
        return 'a'
    elif compare_a['follower_count'] < compare_b['follower_count']:
        return 'b'
    else:
        return ''


def game():
    loop_continue = True
    score = 0
    while loop_continue:
        # TODO print the info about to data
        print(logo)
        a, b = get_compare_data()
        print(f"Compare A: {a['name']}, {a['description']}, from {a['country']}")
        print(vs)
        print(f"Compare B: {b['name']}, {b['description']}, from {b['country']}")

        # TODO input the selection
        user_choice = input("Who has more followers? Type 'A' or 'B': ").lower()
        compare_result = compare(a, b)

        if user_choice == compare_result:
            # TODO right choice
            score += 1
            print(f"You're right! Current score: {score}.")
        else:
            # TODO Break the loop
            print(f"You're Wrong! Final score: {score}.")
            loop_continue = False


game()
