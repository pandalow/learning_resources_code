from bs4 import BeautifulSoup
import requests

hacker_news_endpoint = "https://news.ycombinator.com/news"

response = requests.get(url="https://news.ycombinator.com/news")
response.raise_for_status()

website_html = response.text

soup = BeautifulSoup(website_html, 'html.parser')

title = soup.find_all(name="span", class_="titleline")

article_text = []
link_list = []

for element in title:
    text = element.getText()
    article_text.append(text)
    link = element.find(name='a').get("href")
    link_list.append(link)

upvote = [int(score.span.span.getText().split()[0]) if score.span.span else 0 for score in
          soup.find_all(name='td', class_="subtext")]

largest_number = max(upvote)
index_number = upvote.index(largest_number)

print(f"{article_text[index_number]}, {link_list[index_number]}, {upvote[index_number]}")


# with open("website.html", "r") as file:
#     text = file.read()
#
#
# soup = BeautifulSoup(text,'html.parser')
# # print(soup.title)
#
# anchor_tag = soup.find_all(name="a")
#
# for tag in anchor_tag:
#     # print(tag.getText())
#     tag.get("href")
#
# heading = soup.find(name='h1',id='name')
#
# company_url = soup.select_one(selector="p a")
# name = soup.select_one(selector="#name")
# headings = soup.select(selector=".heading")
