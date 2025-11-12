from selenium import webdriver
from selenium.webdriver.common.by import By
import time

from selenium.webdriver.support.wait import WebDriverWait

chrome_option = webdriver.ChromeOptions()
chrome_option.add_experimental_option('detach', True)

driver = webdriver.Chrome(options=chrome_option)
driver.get('https://orteil.dashnet.org/experiments/cookie/')

cookie_clicker = driver.find_element(By.ID, value='cookie')
time_count = time.time() + 5
timeout = time.time() + 60 * 5

store_item = driver.find_elements(By.CSS_SELECTOR, value='#store div')
ids = [item.get_attribute('id') for item in store_item]
print(ids)

game_is_on = True

while game_is_on:
    cookie_clicker.click()

    if time.time() > time_count:
        time_count = time.time() + 5

        # Get Store Element in the store
        text = driver.find_elements(By.CSS_SELECTOR, '#store b')
        # Refresh price list
        price_list = []
        for item in text:
            try:
                price = item.text.strip().split('-')[1]
                price_list.append(int(price.strip().replace(',', '')))
            except IndexError:
                price_list.append(0)

        # Create store dict
        store_dict = {price_list[item]: ids[item] for item in range(0, len(price_list))}

        money = driver.find_element(By.ID, value='money').text
        if ',' in money:
            money.replace(',', '')

        affordable_dict = {}
        for key, ID in store_dict.items():
            if int(money) >= int(key):
                affordable_dict[key] = ID

        # Update the algo
        # Adding some UI interface
        index_key = max(affordable_dict)
        print(index_key)
        driver.find_element(By.ID, value=affordable_dict[index_key]).click()

driver.quit()
