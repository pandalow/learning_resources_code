programming_dictionary = {
    "Bug": "An error in a program that prevents the program from running as expected.",
    "Function": "A piece of code that you can easily call over and over again.",
}

print(programming_dictionary["Bug"])

programming_dictionary["Loop"] = "The action of doing something"

empty_dictionary = {}

# Wipe an existing dictiorary

programming_dictionary = {}

# Edit an item in a dictionary
programming_dictionary["Bug"] = "A moth in your computer"


#Loop through a
for key in programming_dictionary:
    print(key)
    print(programming_dictionary[key])
