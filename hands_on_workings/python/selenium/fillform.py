from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys


chrome_option = webdriver.ChromeOptions()
chrome_option.add_experimental_option('detach',True)

driver = webdriver.Chrome(chrome_option)

driver.get('https://secure-retreat-92358.herokuapp.com/')

fName = driver.find_element(By.NAME,value='fName')
fName.send_keys('Xiaojian')
lName = driver.find_element(By.NAME,value='lName')
lName.send_keys('Zhuang')
email = driver.find_element(By.NAME,value='email')
email.send_keys('zxj000hugh@gmail.com',Keys.ENTER)