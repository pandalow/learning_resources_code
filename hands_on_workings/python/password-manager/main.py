import json
from tkinter import *
from tkinter import messagebox
import random
import pyperclip
import json

# ----------------------------- PASSWORD SEARCH --------------------------------- #
def search_website():
    try:
        with open("password.json","r") as file:
            data = json.load(file)
            website_input=website_entry.get()
            if len(website_input) == 0:
                raise ValueError("No Data Found Error")
            else:
                email_add = data[website_input]["email"]
                password_add = data[website_input]["password"]
    except FileNotFoundError:
        messagebox.showinfo(title="Warning", message="No Such File Found")
    except ValueError:
        messagebox.showinfo(title="Warning",message="No Data Found Error")
    else:
        messagebox.showinfo(title="Detail",message=f"Your email is {email_add}, Your password is {password_add}")

# ---------------------------- PASSWORD GENERATOR ------------------------------- #
def generate_password():
    letters = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
               'v',
               'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
               'R',
               'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']
    numbers = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
    symbols = ['!', '#', '$', '%', '&', '(', ')', '*', '+']

    letters_list = [random.choice(letters) for _ in range(random.randint(8, 10))]
    numbers_list = [random.choice(numbers) for _ in range(random.randint(2, 4))]
    symbols_list = [random.choice(symbols) for _ in range(random.randint(2, 4))]

    password_list = letters_list + numbers_list + symbols_list
    random.shuffle(password_list)

    password = "".join(password_list)
    password_entry.insert(0, password)
    pyperclip.copy(password)


# ---------------------------- SAVE PASSWORD ------------------------------- #
def save_data():
    website_str = website_entry.get()
    email_str = email_entry.get()
    password_str = password_entry.get()
    new_data = {
        website_str: {
            "email": email_str,
            "password": password_str
        }
    }

    is_empty = len(website_str) == 0 or len(password_str) == 0
    if is_empty:
        messagebox.showinfo(title="warning", message="Hey, You left the empty field")
    else:
        is_ok = messagebox.askokcancel(title="confirm",
                                       message=f"Your detail is {website_str}, {email_str},{password_str}")
        if is_ok:
            try:
                with open("password.json", "r") as file:
                    # Reading old data
                    data = json.load(file)
            except:
                with open("password.json", "w") as file:
                    json.dump(new_data, file, indent=4)
            else:
                # Updating old data wiht new data
                data = data.update(new_data)
                with open("password.json", "w") as file:
                    json.dump(data, file, indent=4)
            finally:
                website_entry.delete(0, END)
                password_entry.delete(0, END)


# ---------------------------- UI SETUP ------------------------------- #

window = Tk()
window.title("Password Manager")
window.config(padx=50, pady=50)
canvas = Canvas(width=200, height=200, highlightthickness=0)
logo_image = PhotoImage(file="logo.png")
canvas.create_image(100, 100, image=logo_image)
canvas.grid(row=0, column=1)

website_label = Label(text="Website")
website_label.grid(row=1, column=0)

website_entry = Entry(width=21)
website_entry.grid(row=1, column=1)
website_entry.focus()

search_button = Button(text="search",width=15,command=search_website)
search_button.grid(row=1,column=2)

email_label = Label(text="Email/Username")
email_label.grid(row=2, column=0)

email_entry = Entry(width=40)
email_entry.grid(row=2, column=1, columnspan=2)
email_entry.insert(0, "zxj000hugh@gmail.com")
password_label = Label(text="Password")
password_label.grid(row=3, column=0)

password_entry = Entry(width=21)
password_entry.grid(row=3, column=1)

password_button = Button(text="Generate Password",width=15, command=generate_password)
password_button.grid(row=3, column=2)

add_button = Button(text="Add", width=35, command=save_data)
add_button.grid(row=4, column=1, columnspan=2)

window.mainloop()
