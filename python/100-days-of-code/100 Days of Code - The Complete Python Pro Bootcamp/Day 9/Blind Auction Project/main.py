# TODO-1: Ask the user for input
# TODO-2: Save data into dictionary {name: price}
# TODO-3: Whether if new bids need to be added
# TODO-4: Compare bids in dictionary
import art
print(art.logo)


def find_highest(bid_dic):
    winner = ''
    max_price = 0

    for key in bid_dic:
        if bid_dic[key] >= max_price:
            max_price = bid_dic[key]
            winner = key
    print(f"The winner is {winner} and the price is {max_price}")


bid = {}
continue_bid = True
while continue_bid:
    bid_name = input("Whats your name?")
    bid_price = int(input("What is your Bid price?"))
    bid[bid_name] = bid_price
    continue_bid = (input("Do you have another bid? Y/N") == "Y")
    print("\n" * 100)
find_highest(bid)








# def find_highest_bidder(bidding_dictionary):
#     winner = ""
#     highest_bid = 0
#
#     max(bidding_dictionary)
#
#     for bidder in bidding_dictionary:
#         bid_amount = bidding_dictionary[bidder]
#         if bid_amount > highest_bid:
#             highest_bid = bid_amount
#             winner = bidder
#
#     print(f"The winner is {winner} with a bid of ${highest_bid}.")
#
#
# bids = {}
# continue_bidding = True
# while continue_bidding:
#     name = input("What is your name?: ")
#     price = int(input("What is your bid?: $"))
#     bids[name] = price
#     should_continue = input("Are there any other bidders? Type 'yes' or 'no'. \n").lower()
#     if should_continue == "no":
#         continue_bidding = False
#         find_highest_bidder(bids)
#     elif should_continue == "yes":
#         print("\n" * 20)



