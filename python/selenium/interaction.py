from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys

chrome_option = webdriver.ChromeOptions()
chrome_option.add_experimental_option('detach',True)

driver = webdriver.Chrome(options=chrome_option)
driver.get("https://en.wikipedia.org/wiki/Main_Page")

driver.find_elements()

article_count = driver.find_element(By.XPATH,'//*[@id="articlecount"]/a[1]')
# article_count.click()
# portals_link = driver.find_element(By.LINK_TEXT,'Content portals')
# portals_link.click()

search_area = driver.find_element(By.NAME,'search')
search_area.send_keys('Python',Keys.ENTER)
# driver.quit()