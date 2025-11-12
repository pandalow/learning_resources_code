from tkinter import *

window = Tk()
window.title("day-27-training")
window.minsize(width=500, height=300)

label_1 = Label(text="This is a label", font=("Arial", 27, "bold"))
label_1.grid(row=0, column=0)

label_1['text'] = "New Text"
label_1.config(text="New Text")


def handle_button_click():
    value = input.get()
    label_1.config(text=value)


# Button
new_button = Button(text="New Button")
new_button.grid(row=0, column=2)
button = Button(text="Click Me", command=handle_button_click)
button.grid(row=1,column=1)

# Entry
input = Entry(width=10)
input.grid(row=2,column=3)

window.mainloop()
