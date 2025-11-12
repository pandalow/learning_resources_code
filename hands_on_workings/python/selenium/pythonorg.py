from selenium import webdriver
from selenium.webdriver.common.by import By

chrome_option = webdriver.ChromeOptions()
chrome_option.add_experimental_option('detach', True)

driver = webdriver.Chrome(options=chrome_option)

driver.get("https://www.python.org/")

widget = driver.find_element(By.XPATH,'//*[@id="content"]/div/section/div[2]/div[2]')

times = widget.find_elements(By.CSS_SELECTOR,'div ul li time')
titles = widget.find_elements(By.CSS_SELECTOR,'div ul li a')

events = {index: {'time': times[index].text, 'name':titles[index].text} for index in range(0,len(times))}

print(events)
driver.quit()
