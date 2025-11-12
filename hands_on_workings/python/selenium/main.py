from selenium import webdriver
from selenium.webdriver.common.by import By

chrome_option = webdriver.ChromeOptions()
chrome_option.add_experimental_option('detach',True)

driver = webdriver.Chrome(options=chrome_option)
driver.get('https://appbrewery.github.io/instant_pot/')

whole_price = driver.find_element(By.CLASS_NAME,value='a-price-whole')
fraction_price = driver.find_element(By.CLASS_NAME,value='a-price-fraction')

print(f"There is price : {whole_price.text}.{fraction_price.text}")


input_area = driver.find_element(By.NAME,value='q')
input_area.get_attribute("placeholder")

driver.find_element(By.CSS_SELECTOR,value='.documentation-widget a')

driver.find_element(By.XPATH, value = '//*[@id="tabs--1-tab-4"]/span')
driver.quit()