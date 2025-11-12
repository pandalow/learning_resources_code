import time

from selenium import webdriver
from selenium.common import NoSuchElementException, ElementClickInterceptedException
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class InstaFollower:

    def __init__(self):
        chrome_option = webdriver.ChromeOptions()
        chrome_option.add_argument("--disable-search-engine-choice-screen")
        chrome_option.add_experimental_option('detach', True)

        self._driver = webdriver.Chrome(options=chrome_option)
        self._wait = WebDriverWait(self._driver, 10)



    def login(self):
        self._driver.get('https://www.instagram.com/accounts/login/')
        self._wait.until(
            EC.element_to_be_clickable((By.XPATH,"//button[contains(text(),'Allow all cookies')]"))
        ).click()

        time.sleep(1)
        self._driver.find_element(By.XPATH,"//label//input[@name='username']").send_keys('deanjeaf313@gmail.com')
        self._driver.find_element(By.XPATH,"//label//input[@name='password']").send_keys('Zxj@03279891',Keys.ENTER)
        time.sleep(3)

        self._wait.until(
            EC.element_to_be_clickable((By.XPATH,"//div/div[contains(text(),'Not now')]"))
        ).click()

        time.sleep(10)

        notifications_prompt = self._driver.find_element(by=By.XPATH, value="//button[contains(text(), 'Not Now')]")
        if notifications_prompt:
            notifications_prompt.click()

    def find_followers(self,name):
        self._driver.get(f"https://www.instagram.com/{name}")
        self._wait.until(
            EC.element_to_be_clickable((By.PARTIAL_LINK_TEXT,"followers"))
        ).click()
        time.sleep(5)
        modal_xpath = "/html/body/div[6]/div[1]/div/div[2]/div/div/div/div/div[2]/div/div/div[2]"
        modal = self._driver.find_element(by=By.XPATH, value=modal_xpath)
        for i in range(10):
            # In this case we're executing some Javascript, that's what the execute_script() method does.
            # The method can accept the script as well as an HTML element.
            # The modal in this case, becomes the arguments[0] in the script.
            # Then we're using Javascript to say: "scroll the top of the modal (popup) element by the height of the modal (popup)"
            self._driver.execute_script("arguments[0].scrollTop = arguments[0].scrollHeight", modal)
            time.sleep(2)

    def follow(self):
        follow_buttons = self._driver.find_elements(By.XPATH,"//button[contains(text(),'follow')]")
        for item in follow_buttons:
            try:
                item.click()
                time.sleep(1)
            except ElementClickInterceptedException:
                # TODO Cancel follow
                pass




