from selenium import webdriver
from selenium.webdriver import Keys
from selenium.webdriver.common.by import By
import time


class InternetSpeedTwitterBot:

    def __init__(self):
        chrome_options = webdriver.ChromeOptions()
        chrome_options.add_experimental_option('detach',True)
        chrome_options.add_argument("--disable-search-engine-choice-screen")

        self._driver = webdriver.Chrome(chrome_options)
        self.down = 0
        self.up = 0

    def get_internet_speed(self)->tuple:
        self._driver.get('https://www.speedtest.net/')
        self._driver.find_element(By.XPATH,'//*[@id="onetrust-accept-btn-handler"]').click()

        test_button = self._driver.find_element(By.XPATH,'/html/body/div[3]/div/div[3]/div/div/div/div[2]/div[3]/div[1]/a')
        test_button.click()

        time.sleep(60)

        self._driver.find_element(By.XPATH,'//*[@id="container"]/div/div[3]/div/div/div/div[2]/div[3]/div[3]/div/div[8]/div/a').click()

        self.down = self._driver.find_element(By.XPATH,'/html/body/div[3]/div/div[3]/div/div/div/div[2]/div[3]/div[3]/div/div[3]/div/div/div[2]/div[1]/div[1]/div/div[2]/span').text
        self.up = self._driver.find_element(By.XPATH,'/html/body/div[3]/div/div[3]/div/div/div/div[2]/div[3]/div[3]/div/div[3]/div/div/div[2]/div[1]/div[2]/div/div[2]/span').text

        return self.up,self.down
    def tweet_at_provider(self,username:str,password:str):
        self._driver.get("https://x.com/i/flow/login")

        # Overcome some verify operation
        # self._driver.find_element(By.XPATH,'//*[@id="layers"]/div/div[2]/div/div/div/button').click()
        # self._driver.find_element(By.XPATH,'//*[@id="layers"]/div/div[1]/div/div/div/div[2]/button[1]').click()
        # self._driver.find_element(By.XPATH,'//*[@id="react-root"]/div/div/div[2]/main/div/div/div[1]/div/div/div[3]/div[3]/a').click()

        # Get Input area
        email = self._driver.find_element(By.XPATH,'//*[@id="layers"]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/div[4]/label/div/div[2]/div/input')
        email.send_keys(username,Keys.ENTER)

        # Get Password area
        pass_word = self._driver.find_element(By.XPATH,'//*[@id="layers"]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/div[4]/label/div/div[2]/div/inputot"]/div/div/div/main/div/div/div/div[2]/div[2]/div[1]/div/div/div/div[3]/div/label/div/div[2]/div[1]/input')
        pass_word.send_keys(password,Keys.ENTER)


        # Input the words
        text_area = self._driver.find_element(By.XPATH,'//*[@id="react-root"]/div/div/div[2]/main/div/div/div/div/div/div[3]/div/div[2]/div[1]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div/div/div[1]/div')
        text_area.send_keys('Hey Internet Provider, Holly Molly')

        post_button = self._driver.find_element(By.XPATH,'//*[@id="react-root"]/div/div/div[2]/main/div/div/div/div/div/div[3]/div/div[2]/div[1]/div/div/div/div[2]/div[2]/div[2]/div/div/div/button')
        post_button.click()

        self._driver.quit()