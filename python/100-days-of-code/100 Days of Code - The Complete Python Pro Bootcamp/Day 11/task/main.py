from art import logo
import random

cards = [11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10]


def pick_card(ini_cards, cards_list):
    # pick_num = random.randint(0, len(ini_cards) - 1)
    cards_list.append(random.choice(ini_cards))
    return cards_list


def calculate_score(cards_list):
    # for num in cards_list:
    #     if not num == 11:
    #         score += num
    #     else:
    if sum(cards_list) == 21 and len(cards_list) == 2:
        return 0
    if 11 in cards_list and sum(cards_list) > 21:
        cards.remove(11)
        cards.append(1)

    return sum(cards_list)


def opponent_pick_card(ini_cards, cards_list):
    if calculate_score(cards_list) < 17:
        return pick_card(ini_cards, cards_list)
    else:
        return


def play_game(my_cards, opponent_cards, rounds):
    if rounds == 0:
        # initial cards
        for times in range(1, 3):
            pick_card(cards, my_cards)
            pick_card(cards, opponent_cards)
    else:
        pick_card(cards, my_cards)
        opponent_pick_card(cards, opponent_cards)

    mscore = calculate_score(my_cards)
    oscore = calculate_score(opponent_cards)

    print(f"Your cards: {my_cards}, current score: {mscore}")
    print(f"Computer's first card: {opponent_cards[0]}")

    rounds += 1
    is_get_cards = input("Type 'y' to get another card, type 'n' to pass: ").lower()
    if mscore > 21:
        print("You went over, You lose")
        return
    elif oscore > 21:
        print("Computer went over, You win")
        return
    elif mscore == 0:
        print("Black Jace, You win")
    elif oscore == 0:
        print("Black jack, You lost")

    if is_get_cards == 'y':
        play_game(my_cards, opponent_cards, rounds)
    else:
        print(f"Your final hand: {my_cards}, final score: {mscore}")
        print(f"Computer's final hand: {opponent_cards}, final score: {oscore}")
        if mscore > oscore:
            print("You win")
        elif mscore < oscore:
            print("You lose")
        elif mscore == oscore:
            print("Draw")


is_continue = True

while is_continue:
    is_continue = input("Do you want to play a game of Blackjack? Type 'y' or 'n': ").lower() == "y"
    print(logo)
    my_cards = []
    opponent_cards = []
    play_game(my_cards, opponent_cards, 0)
