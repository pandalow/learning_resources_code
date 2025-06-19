from bs4 import BeautifulSoup
import smtplib
import requests

MY_EMAIL = 'zxj000hugh@gmail.com'
MY_PASSWORD = '03279891@Zxj'

headers = {
    'Accept': "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
    'Accept-Encoding': "gzip, deflate, br, zstd",
    'Accept-Language': "zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7",
    'Host': "www.amazon.com",
    "Priority": "u=0, i",
    'Sec-Ch-Ua-Mobile': "?0",
    'Sec-Ch-Ua-Platform': "macOS",
    'Sec-Fetch-Dest': "document",
    'Sec-Fetch-Mode': "navigate",
    'Sec-Fetch-Site': "cross-site",
    'Sec-Fetch-User': "?1",
    'Upgrade-Insecure-Requests': "1",
    "User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36",
    "X-Amzn-Trace-Id": "Root=1-66d643fc-6d3d5ff6678c7337763cb145",
}

end_point = "https://www.amazon.com/dp/B075CYMYK6?ref_=cm_sw_r_cp_ud_ct_FM9M699VKHTT47YD50Q6&th=1"
response = requests.get(url=end_point,headers=headers)
response.raise_for_status()
result = response.text


soup = BeautifulSoup(result, 'html.parser')

price = soup.find(name='span',class_='aok-offscreen')
print(price.getText().strip().split(' ')[0].split('$')[1])
# price_number = float(price.getText().split('$')[1])

#
# if price_number < 100:
#     with smtplib.SMTP('smtp.gmail.com') as connection:
#         connection.starttls()
#         result = connection.login(user=MY_EMAIL,password=MY_PASSWORD)
#         connection.sendmail(
#             from_addr=MY_EMAIL,
#             to_addrs=MY_EMAIL,
#             msg=f"Subject: The Target Product price is below your avg \n\n"
#             f"The price is {price_number}"
#         )
