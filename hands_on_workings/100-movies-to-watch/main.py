import requests
from bs4 import BeautifulSoup

URL = "https://web.archive.org/web/20200518073855/https://www.empireonline.com/movies/features/best-movies-2/"

# Write your code below this line 👇

response = requests.get(url=URL)
response.raise_for_status()

html_mark_up = response.text

soup = BeautifulSoup(html_mark_up,'html.parser')

title_list = soup.find_all(name="div",class_="article-title-description__text")

title = [title.h3.getText() for title in title_list ]
reversed_title = title[::-1]

with open("100 movies to watch.txt",'w') as file:
    for item in reversed_title:
        file.write(f"{item}\n")


