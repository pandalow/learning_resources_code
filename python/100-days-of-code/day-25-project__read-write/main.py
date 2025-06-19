# with open("my_file.txt") as file:
#     content = file.read()
#     print(content)

with open("my_file.txt", mode="w") as file:
    file.write("New text.")
