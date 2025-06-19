#TODO: Create a letter using starting_letter.txt
with open("./Input/Letters/starting_letter.txt", "r") as file:
    starting_content = file.read()

print(starting_content)

# for each name in invited_names.txt
with open("./Input/Names/invited_names.txt", "r") as file:
    name_list = file.readlines()

for name in name_list:
    new_name = name.strip()
    # Replace the [name] placeholder with the actual name.
    new_file = starting_content.replace("[name]",new_name)
    # Save the letters in the folder "ReadyToSend".
    with open(f"./Output/ReadyToSend/{name}.txt", "w") as write_file:
        write_file.write(new_file)

# Hint1: This method will help you: https://www.w3schools.com/python/ref_file_readlines.asp
# Hint2: This method will also help you: https://www.w3schools.com/python/ref_string_replace.asp
# Hint3: THis method will help you: https://www.w3schools.com/python/ref_string_strip.asp
