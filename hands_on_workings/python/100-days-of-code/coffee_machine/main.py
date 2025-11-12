MENU = {
    "espresso": {
        "ingredients": {
            "water": 50,
            "coffee": 18,
        },
        "cost": 1.5,
    },
    "latte": {
        "ingredients": {
            "water": 200,
            "milk": 150,
            "coffee": 24,
        },
        "cost": 2.5,
    },
    "cappuccino": {
        "ingredients": {
            "water": 250,
            "milk": 100,
            "coffee": 24,
        },
        "cost": 3.0,
    }
}

COIN_VALUE = {
    "quarters": 0.25,
    "dimes": 0.10,
    "nickles": 0.05,
    "pennies": 0.01,
}

resources = {
    "water": 300,
    "milk": 200,
    "coffee": 100,
    "Money": 0,
}


def report():
    water = resources["water"]
    milk = resources["milk"]
    coffee = resources["coffee"]
    print(f"Water :{water}ml")
    print(f"Milk :{milk}ml")
    print(f"Coffee:{coffee}mg")


def consuming_resources(key, consumption):
    if key == 'latte' or key == 'cappuccino':
        consumption["milk"] -= MENU[key]["ingredients"]["milk"]
    consumption["water"] -= MENU[key]["ingredients"]["water"]
    consumption["coffee"] -= MENU[key]["ingredients"]["coffee"]

    return consumption


def detect_resources(prompt, resources):
    consumption_resources = consuming_resources(prompt, resources)

    for key in consumption_resources:
        if consumption_resources[key] < 0:
            print(f"Sorry there is not enough{key}")
            return False
        else:
            return True


def insert_coins(coins_dic):
    print("Please insert coins")
    quarters = int(input("How many quarters?"))
    coins_dic["quarters"] += quarters
    dimes = int(input("How many dimes?"))
    coins_dic["dimes"] += dimes
    nickles = int(input("How many nickles?"))
    coins_dic["nickles"] += nickles
    pennies = int(input("How many pennies?"))
    coins_dic["pennies"] += pennies

    return coins_dic


def calculate_coins(coin_dic):
    total_cash = 0
    for key in coin_dic:
        total_cash += coin_dic[key]*COIN_VALUE[key]
    return total_cash


def identify_enough_cash(prompt, coin_dic):
    total_cash = calculate_coins(coin_dic)
    if total_cash - MENU[prompt]["cost"] >= 0:
        return True
    else:
        print("Sorry that's not enough money. Money refunded.”")
        return False


def running_coffee_machine(prompt, resources):
    coin_box = {}
    # check resource sufficient
    is_making = detect_resources(prompt, resources)

    # process coins
    if is_making:
        coin_box = insert_coins(coin_box)

    # check transaction successful?
    is_making = identify_enough_cash(prompt, coin_box)
    if is_making:
        total_cash = calculate_coins(coin_box)
        total_cash -= MENU[prompt]["cost"]
        resources["Money"] += total_cash
        print(f"Here is the change ${total_cash}")

        # Make coffee
        resources = consuming_resources(prompt, resources)
        print(f"Here is your {prompt}, Enjoy")
    return resources


is_continue = True

# Prompt user by asking “What would you like?
prompt = input("What would you like? (espresso/latte/cappuccino): ").lower()

if prompt == 'off':
    is_continue = False
# print report
if prompt == "report":
    report()
if prompt == 'latte' or prompt == 'cappuccino' or prompt == 'espresso':
    running_coffee_machine(prompt, resources)
