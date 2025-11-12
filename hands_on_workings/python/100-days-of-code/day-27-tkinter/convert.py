from tkinter import *

window = Tk()
window.minsize(height=200, width=400)
window.title("Mile to Kilo Convert")

input_area = Entry(width=10, textvariable="0")
input_area.grid(column=1,row=0)

miles = Label(text="Miles")
miles.grid(column=2,row=0)

is_equal_to = Label(text="is equal to")
is_equal_to.grid(column=0,row=1)

kilo_meter = Label(text=0)
kilo_meter.grid(column=1,row=1)

def convert():
    meter = input_area.get()
    meter *= 10
    kilo_meter.config(text=meter)

button = Button(text="Calculate",command=convert)

button.grid(column=1,row=2)
window.mainloop()