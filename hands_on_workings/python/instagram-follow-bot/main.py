from insta_follower import InstaFollower


accounts = 'staceysolomon'
email = 'deanjeaf313@gmail,com'
password = 'Zxj@03279891'

insta = InstaFollower()

insta.login()
insta.find_followers(accounts)
insta.follow()