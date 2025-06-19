import os
import requests
import datetime as dt
from twilio.rest import Client

STOCK = "TSLA"
COMPANY_NAME = "Tesla Inc"

now = dt.datetime.now()
yesterday = str(now.date() - dt.timedelta(1))
day_before_yesterday = str(now.date() - dt.timedelta(2))

parameters = {
    # ?function=TIME_SERIES_DAILY&symbol=IBM&apikey=demo
    "function": "TIME_SERIES_DAILY",
    "symbol": STOCK,
    "apikey": os.environ.get("API_KEY"),
    "data": "json"
}
news_parameters = {
    "q": COMPANY_NAME,
    "from": day_before_yesterday,
    "to": yesterday,
    "sortBy": "popularity",
    "pageSize": 3,
    "page": 1,
    "apiKey": os.environ.get("NEWS_API_KEY"),
}


def calculate_trends(yesterday_close_value: float, day_before_yesterday_value: float) -> float:
    f_value = abs(yesterday_close_value - day_before_yesterday_value)
    s_value = f_value / yesterday_close_value * 100
    return s_value


## STEP 1: Use https://www.alphavantage.co
# When STOCK price increase/decreases by 5% between yesterday and the day before yesterday then print("Get News").
response = requests.get(url="https://www.alphavantage.co/query", params=parameters)
response.raise_for_status()

data = response.json()["Time Series (Daily)"]

trend_value = calculate_trends(float(data[yesterday]["4. close"]), float(data[day_before_yesterday]["4. close"]))

if trend_value > 5:

    ## STEP 2: Use https://newsapi.org
    # Instead of printing ("Get News"), actually get the first 3 news pieces for the COMPANY_NAME.
    news_response = requests.get("https://newsapi.org/v2/everything", params=news_parameters)
    news_response.raise_for_status()

    news_data = news_response.json()["articles"]

    news_tuple = [{"title": item["title"], "description": item["description"]} for item in news_data]

    ## STEP 3: Use https://www.twilio.com
    # Send a seperate message with the percentage change and each article's title and description to your phone number.
    client = Client(os.environ.get("AUTH_SID"), os.environ.get("AUTH_TOKEN"))

    for item in news_tuple:
        message_body = (f"TSLA {trend_value} \n"
                        f"Headline: {item["title"]} \n"
                        f"Brief: {item["description"]}")
        message = client.messages.create(
            body=message_body,
            from_="+14156504439",
            to="+353874796931"
        )

#Optional: Format the SMS message like this: 
"""
TSLA: 🔺2%
Headline: Were Hedge Funds Right About Piling Into Tesla Inc. (TSLA)?. 
Brief: We at Insider Monkey have gone over 821 13F filings that hedge funds and prominent investors are required to file by the SEC The 13F filings show the funds' and investors' portfolio positions as of March 31st, near the height of the coronavirus market crash.
or
"TSLA: 🔻5%
Headline: Were Hedge Funds Right About Piling Into Tesla Inc. (TSLA)?. 
Brief: We at Insider Monkey have gone over 821 13F filings that hedge funds and prominent investors are required to file by the SEC The 13F filings show the funds' and investors' portfolio positions as of March 31st, near the height of the coronavirus market crash.
"""
