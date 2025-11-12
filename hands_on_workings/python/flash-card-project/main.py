from tkinter import *
import pandas
import random

BACKGROUND_COLOR = "#B1DDC6"
# TODO Read the data from the french_words.csv file in the data folder.
try:
    file = pandas.read_csv("words_to_learn.csv")
except FileNotFoundError:
    file = pandas.read_csv("./data/french_words.csv")

word_dict = file.to_dict(orient="records")

# TODO Pick a random French word/translation and put the word into the flashcard.
#  Every time you press the ❌ or ✅ buttons, it should generate a new random word to display.

picked_item = {}


# TODO 1. When the user presses on the ✅ button, it means that they know the current
#  word on the flashcard and that word should be removed from the list of words that might come up.
def remove_word():
    word_dict.remove(picked_item)
    to_learn = pandas.DataFrame(word_dict)
    to_learn.to_csv("words_to_learn.csv")
    pick_french_word()

def pick_french_word():
    global picked_item, timer_state
    window.after_cancel(timer_state)
    picked_item = random.choice(word_dict)
    french_word = picked_item["French"]
    canvas.itemconfig(hint, text="French", fill="black")
    canvas.itemconfig(words, text=french_word, fill="black")
    canvas.itemconfig(bg_image, image=card_back_image)

    timer_state = window.after(3000, flip_card)


def flip_card():
    english_word = picked_item["English"]
    canvas.itemconfig(hint, text="English", fill="white")
    canvas.itemconfig(words, text=english_word, fill="white")
    canvas.itemconfig(bg_image, image=back_image)


# ---- UI SET ---- #
window = Tk()
window.title("Flashy")
window.config(bg=BACKGROUND_COLOR, pady=50, padx=50)

card_back_image = PhotoImage(file="./images/card_front.png")
canvas = Canvas(bg=BACKGROUND_COLOR, width=800, height=526, highlightthickness=0)
bg_image = canvas.create_image(400, 260, image=card_back_image)
hint = canvas.create_text(400, 150, text="French", fill="black", font=("Ariel", 40, "italic"))
words = canvas.create_text(400, 263, text="travoue", fill="black", font=("Ariel", 60, "bold"))
back_image = PhotoImage(file="./images/card_back.png")
canvas.grid(row=0, column=0, columnspan=2)

timer_state = window.after(3000, flip_card)

wrong_image = PhotoImage(file="./images/wrong.png")
wrong_button = Button(image=wrong_image, highlightthickness=0, command=pick_french_word)
wrong_button.grid(row=1, column=0)

right_image = PhotoImage(file="./images/right.png")
right_button = Button(image=right_image, highlightthickness=0, command=remove_word)
right_button.grid(row=1, column=1)

pick_french_word()
window.mainloop()
