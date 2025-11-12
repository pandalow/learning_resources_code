from selenium import webdriver
from selenium.webdriver.common.by import By


class CookieScript:

    def __init__(self):
        chrome_option = webdriver.ChromeOptions()
        chrome_option.add_experimental_option('detach', True)
        chrome_option.add_argument('user-data-dir=/Users/zhuangxiaojian/Library/Application Support/Google/Chrome/Default')
        self._driver = webdriver.Chrome(options=chrome_option)
        self._driver.get('https://orteil.dashnet.org/cookieclicker/')


    def click_cookie(self):
        cookie = self._driver.find_element(By.ID,value='bigCookie')
        cookie.click()
