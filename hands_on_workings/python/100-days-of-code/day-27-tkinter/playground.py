def add(*args):
    total = 0
    for num in args:
        total += num
    return total


def calculate(**kwargs):
    print(type(kwargs))
    for key, value in kwargs.items():
        print(key)
        print(value)
    new_dict = {key: value + 1 for (key, value) in kwargs.items()}


class Car:
    def __init__(self, **kwargs):
        self.make = kwargs.get("make")
        self.model = kwargs.get("model")
        self.color = kwargs.get("color")
