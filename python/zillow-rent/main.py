from address_scrap import ScraperWeb
from fill_form import FillForm

soup = ScraperWeb()
address_list, link_list, price_list = soup.find_address()

driver = FillForm()

driver.fill_form(address_list,price_list,link_list)