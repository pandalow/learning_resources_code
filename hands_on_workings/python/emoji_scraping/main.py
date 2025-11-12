from selenium import webdriver
from selenium.webdriver.common.by import By
import os
import requests

# 设置 Chrome 选项
chrome_options = webdriver.ChromeOptions()
chrome_options.add_experimental_option("detach", True)
chrome_options.add_argument("--disable-search-engine-choice-screen")

# 创建 WebDriver 实例
driver = webdriver.Chrome(options=chrome_options)

# 打开目标网页
driver.get("https://fabiaoqing.com/search/bqb/keyword/%E5%A5%B3/type/bq/page/3.html")

# 创建文件夹用于保存图片
folder_name = "images"
if not os.path.exists(folder_name):
    os.makedirs(folder_name)

# 获取所有图片元素
images = driver.find_elements(By.XPATH, "//*[@id='bqb']//img")

# 下载每一张图片
for img in images:
    img_url = img.get_attribute("data-original") or img.get_attribute("src")
    print(f"图片 URL: {img_url}")  # 打印 URL
    if img_url:
        try:
            headers = {
                "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3"
            }
            response = requests.get(img_url, headers=headers)
            if response.status_code == 200:
                # 获取图片的文件名
                file_name = os.path.join(folder_name, img_url.split("/")[-1])
                with open(file_name, 'wb') as file:
                    file.write(response.content)
            else:
                print(f"请求失败，状态码: {response.status_code}")
        except requests.exceptions.RequestException as e:
            print(f"下载图片失败: {e}")

# 关闭浏览器
driver.quit()
