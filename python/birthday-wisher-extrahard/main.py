##################### Extra Hard Starting Project ######################
import random
import smtplib
import pandas
import datetime as dt

my_email = "zxj000hugh@gmail.com"
my_password = "123456"


# 1. Update the birthdays.csv
birthday_info = pandas.read_csv("birthdays.csv")
# 2. Check if today matches a birthday in the birthdays.csv
now = dt.datetime.now()
current_time = (now.month,now.day)
print(current_time)

data = {(row["month"].row["day"]):row for (key,row) in birthday_info.iterrows()}
# 3. If step 2 is true, pick a random letter from letter templates and replace the [NAME] with the person's actual
# name from birthdays.csv

if current_time in data:
    pick_num = random.randint(1,3)
    birthday_person = data[current_time]
    with open(f"./letter_templates/letter_{pick_num}.txt") as file:
        letter = file.read()
        override_letter = letter.replace("[NAME]", birthday_person["name"])
# 4. Send the letter generated in step 3 to that person's email address.

    with smtplib.SMTP("smtp.gmail.com") as connection:
        connection.starttls()
        connection.login(my_email,my_password)
        connection.sendmail(from_addr=my_email,to_addrs=my_email,msg=f"Subject: Happy Birthday\n\n{override_letter}")


