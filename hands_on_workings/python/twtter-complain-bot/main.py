from speed_bot import InternetSpeedTwitterBot

PROMISED_DONW = 150
PROMISED_UP = 10
TWITTER_EMAIL = 'deanjeaf313@gmail.com'
TWITTER_PASSWORD = 'Zxj@03279891'

speed_bot = InternetSpeedTwitterBot()

# up, down = speed_bot.get_internet_speed()

# if int(up) < PROMISED_UP or int(down) < PROMISED_DONW:
speed_bot.tweet_at_provider(TWITTER_EMAIL,TWITTER_PASSWORD)
