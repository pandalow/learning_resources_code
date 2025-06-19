import datetime as dt
import random
import smtplib

EMAIL = "zxj000hugh@gmail.com"
PASSWORD = "123456"

with open("quotes.txt","r") as file:
    quotes_list = file.readlines()

now = dt.datetime.now()

if now.weekday() == 1:
    quote = random.choice(quotes_list)

    with smtplib.SMTP("smtp.gmail.com") as connection:
        connection.starttls()
        connection.login(EMAIL,PASSWORD)
        connection.sendmail(EMAIL,"cindy@qq.com",msg=f"Subject: Best Wishes \n\n"
                                                     f"{quote}")