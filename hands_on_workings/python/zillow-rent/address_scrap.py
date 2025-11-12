from bs4 import BeautifulSoup
import requests
import re

end_point = 'https://appbrewery.github.io/Zillow-Clone/'


class ScraperWeb:

    def __init__(self):
        response = requests.get(url=end_point)
        response.raise_for_status()
        web_html = response.text
        self.soup = BeautifulSoup(web_html, 'html.parser')

    def find_address(self) -> tuple:
        # Fetch for address
        all_original_article = self.soup.find_all(name='article')
        address_list = [art.div.div.a.address.getText().replace('\n', '').replace('|', '').strip() for art in
                        all_original_article]

        # Fetch for link
        link_list = [art.div.div.a.get('href') for art in all_original_article]

        # Fetch the price by special query
        all_original_price = self.soup.select(selector="article div div div div span")
        price_list = [art.text.split(' ')[0].split('/')[0].split('+')[0] for art in all_original_price]

        return address_list, link_list, price_list
