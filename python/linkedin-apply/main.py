from selenium import webdriver
from selenium.common import NoSuchElementException
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from dotenv import load_dotenv
import time
import os

load_dotenv()

chrome_option = webdriver.ChromeOptions()
chrome_option.add_argument("--disable-search-engine-choice-screen")
chrome_option.add_experimental_option('detach', True)

driver = webdriver.Chrome(options=chrome_option)
driver.get(
    'https://www.linkedin.com/jobs/search/?currentJobId=4000187322&f_LF=f_AL&geoId=105178154&keywords=python%20developer&origin=JOB_SEARCH_PAGE_LOCATION_AUTOCOMPLETE&refresh=true')

# accept_button = driver.find_element(By.CSS_SELECTOR, value='.artdeco-global-alert-action__wrapper button')
# accept_button.click()

try:
    a_button = driver.find_element(By.CSS_SELECTOR, value='.sign-in-modal button')
except NoSuchElementException:
    sign_in_button = driver.find_element(By.LINK_TEXT, value='Sign in')
    sign_in_button.click()

    username_input = driver.find_element(By.ID, value='username')
    password_input = driver.find_element(By.ID, value='password')

else:
    a_button.click()
    print('sign in')

    username_input = driver.find_element(By.ID, value='base-sign-in-modal_session_key')
    password_input = driver.find_element(By.ID, value='base-sign-in-modal_session_password')

username_input.send_keys(os.getenv('username'))
password_input.send_keys(os.getenv('password'), Keys.ENTER)

time.sleep(3)

def abortion():
    close_button = driver.find_element(By.XPATH,'/html/body/div[3]/div/div/button')
    close_button.click()

    save_application = driver.find_element(By.XPATH,'/html/body/div[3]/div[2]/div/div[3]/button[2]')
    save_application.click()

    save_button = driver.find_element(By.CSS_SELECTOR,value='.jobs-save-button')
    save_button.click()


job_cards = driver.find_elements(By.CSS_SELECTOR, value='div.job-card-container')
for card in job_cards:
    card.click()
    time.sleep(2)

    apply_button = driver.find_element(By.CSS_SELECTOR, value='.jobs-apply-button--top-card button')
    apply_button.click()
    phone = driver.find_element(By.CLASS_NAME,value="artdeco-text-input--input")
    phone.send_keys(os.getenv('phone'))
    next_button = driver.find_element(By.CSS_SELECTOR,value='footer div button')
    next_button.click()

    submit_button = driver.find_element(By.XPATH,'/html/body/div[3]/div/div/div[2]/div/div[2]/form/footer/div[2]/button[2]')
    if submit_button.get_attribute('aria-label') == 'Continue to next step':
        abortion()
    else:
        print('continute')
        abortion()
    time.sleep(1)

driver.quit()
