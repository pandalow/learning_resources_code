import time

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

form_url = "https://docs.google.com/forms/d/e/1FAIpQLSebHsIhtlyXKvMayaqas1GedB9S9kcb_-fZLUA4217C2JLdzA/viewform?usp=sf_link"


class FillForm:

    def __init__(self):
        chrome_options = webdriver.ChromeOptions()
        chrome_options.add_experimental_option("detach", True)
        chrome_options.add_argument("--disable-search-engine-choice-screen")

        self._driver = webdriver.Chrome(chrome_options)

    def fill_form(self, address_list: list, price_list: list, link_list: list):

        for item in range(0, len(address_list)):
            self._driver.get(url=form_url)
            time.sleep(2)
            forms = self._driver.find_elements(By.XPATH, "//input[@type='text']")
            print(address_list)
            print(forms[0].text)
            forms[0].send_keys(address_list[item])
            forms[1].send_keys(price_list[item])
            forms[2].send_keys(link_list[item])

            WebDriverWait(self._driver,3).until(
                EC.element_to_be_clickable((By.XPATH,"//div[contains(text(),'Submit another response')]"))
            ).click()

        self._driver.quit()