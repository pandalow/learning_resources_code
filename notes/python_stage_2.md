# Python - Stage2

## Day-28

#### Dynamic typing

https://stackoverflow.com/questions/11328920/is-python-strongly-typed



#### _在循环中的用法:

在 Python 中，变量名 `_` 有一些特殊的用法。具体到你提到的代码片段：

```
python
复制代码
for _ in range(math.floor(reps/2)):
```

这里的 `_` 是一个惯例，用于表示一个临时变量，表示循环变量的值在循环体内不会被使用，或者说不关心它的具体值。

详细解释：

1. **`for` 循环的工作原理**： 在这个 `for` 循环中，`range(math.floor(reps/2))` 生成一个从 `0` 到 `math.floor(reps/2) - 1` 的整数序列，循环会遍历这个序列。在通常情况下，遍历的每个整数都会赋值给循环变量，比如 `i` 或者 `j`，并且可以在循环体内使用。
2. **使用 `_` 的场景**： 在某些情况下，你可能只关心循环的次数，而不关心每次循环时的具体值。在这种情况下，使用 `_` 作为循环变量是一种约定俗成的方式，表示这个变量的值是无关紧要的、不会被使用的。

#### Join

https://www.w3schools.com/python/ref_string_join.asp



#### Pyperclip

https://pypi.org/project/pyperclip/



## Day-30exception

#### Basic

```
try: # something that might cause exception

except # Do this if there was exception

else # Do this if there were no exception

finally # Do this no matter what happened
```

```
try:
	file = open("file_do_not_exist.txt")
except:
	file = open("file_do_not_exist.txt","w")
	file.write("Something")
```

`except`will ignore all errors

```
try:
	file = open("file_do_not_exist.txt")
except FileNotFoundError:
	file = open("file_do_not_exist.txt","w")
	file.write("Something")
```



#### Raise your own Exception

```
#BMI Example

height = float(input("Height: "))
weight = int(input("Weight: "))

if height > 3:
    raise ValueError("Human Height should not be over 3 meters.")

bmi = weight / height ** 2
print(bmi)
```



#### Json Liburary

Save:存储语句

```python
json.dump(new_data,file,indent=4)
```

Load: Convert json into dictionary

```python
with open("data.json","r") as file:
	data = json.load(file)
```

Update:

```python
with open("data.json","w") as file:
	# Reading old data
	data = json.load(file)
	# Updating old data wiht new data
	data = data.update(new_data)
	# Saving the update data
	json.dump(data, file, indent=4)
```



## Day32-SMTP&DateTime

Doc:https://docs.python.org/3/library/smtplib.html

#### SMTP Provider

`smtp.gmail.com` - gmail

`smtp.live.com` - hotmail

`smtp.mail.yahoo.com` - yahoo

```python
import smtplib

my_email = "zxj000hugh@gmail.com"
my_password = "123456"

with smtplib.SMTP("smtp.gmail.com") as connection:
    connection.starttls()
    connection.login(my_email,my_password)
    connection.sendmail(
        from_addr=my_email,
        to_addrs="zxj000hugh@163.com",
        msg="Subject: Title \n\n Content Content")
```



#### DateTime

引入包

`import datetime as dt`

防止后面混淆



使用方法 `dt.datetime.method()`

```
# get the current time
now = dt.datetime.now()

#2024-08-26 23:20:03.298596
```

now 返回了一个datetime对象, 支持多种方法

```
year = now.year
month = now.month

day_of_week = now.weekday()
```



- Set Datetime

```
date_of_birth = dt.datetime(year=1995,month=12,day=15)
```



- ex

```
import datetime as dt
import random
import smtplib

EMAIL = "zxj000hugh@gmail.com"
PASSWORD = "123456"

with open("quotes.txt","r") as file:
    quotes_list = file.readlines()

now = dt.datetime.now()

if now.weekday() == 1:
    quote = random.choice(quotes_list)

    with smtplib.SMTP("smtp.gmail.com") as connection:
        connection.starttls()
        connection.login(EMAIL,PASSWORD)
        connection.sendmail(EMAIL,"cindy@qq.com",msg=f"Subject: Best Wishes \n\n"
                                                     f"{quote}")
```



可以用tuple做为key

```
data = {(row["month"].row["day"]):row for (key,row) in birthday_info.iterrows()}
```



#### Host on the cloud

Python anywhere

https://www.pythonanywhere.com/





## API

#### Intro

https://en.wikipedia.org/wiki/API



#### API End point

- know the end point
- make a request

```
import requests
response = requests.get(url="http://api.open-notify.org/iss-now.json")
```

Status code

`response.status_code`

#### requests module

https://docs.python-requests.org/en/latest/

- Json format

```
data = response.json()
longitude = data["iss_position"]["longitude"]
latitude = data["iss_position"]["latitude"]

position = (latitude,longitude)
```



#### Kanye rest

https://kanye.rest/



#### API Parameters

dict to save params, send it into params

```python
parameters = {
    "amount":10,
    "type":"boolean",
}

response = requests.get("https://opentdb.com/api.php",params=parameters)
response.raise_for_status()

```

https://sunrise-sunset.org/api

#### Unescapting

https://www.w3schools.com/html/html_entities.asp

```python
import html
q_text = html.unescape(self.current_question.text)
```

#### DataType

用`:`来定义, 保证该类型为约定类型

```python
def __init__(self, quiz_brain:QuizBrain)
```

使用说明

```python
# 命名方式
age: int
name: str
height: float
is_human: bool

# function中的使用方式
def police_check(age: int) -> bool:
    if age > 18:
        can_drive = True
    else:
        can_drive = False
    return can_drive


if police_check(12):
    print("You may pass")
else:
    print("Pay a fine.")

```

Type Hint:

```
def greeting(name:str)->str:
	return "hello" + name
```

Dynamic typing

#### Online Json Viewer

https://jsonviewer.stack.hu/

#### Twilio

Twilio allows us to send the sms message

https://www.twilio.com/docs/messaging/quickstart/python



#### Environment Variable

https://en.wikipedia.org/wiki/Environment_variable

Command in cmd:

`env`

- Security

如何存储environment variable

`export AUTH_KEY = xxxxx`

如何获得environment variable

`os.environ.get("OWN_API_KEY")`



## API List

https://apilist.fun/



#### Pixela

https://pixe.la/



#### POST

```python
pixela_endpoint = "https://pixe.la//v1/users"
user_payload = {
    "token": "dakdaldngn182jff",
    "username": "zhuang",
    "agreeTermsOfService": "yes",
    "notMinor": "yes",
}
response = requests.post(url=pixela_endpoint,json=user_payload)
```



#### Request-header

```python
graph_config = {
    "id": "graph1",
    "name": "Coding Practicing",
    "unit": "line",
    "type": "int",
    "color": "sora",

}
headers = {
    "X-USER-TOKEN": TOKEN
}

GRAPH_ID = "graph1"
# graph_response = requests.post(url=f"{pixela_endpoint}/{user_name}/graphs", json=graph_config, headers=headers)
# graph_response.raise_for_status()
```



#### Date Format



String format time:

`datatime.strftime('%Y%m%d')`

https://www.w3schools.com/python/python_datetime.asp



#### Env Object

https://www.geeksforgeeks.org/python-os-environ-object/

```python
# importing os module  
import os 
  
# Method 1 
print("MY_HOME:", os.environ.get('MY_HOME', "Environment variable does not exist")) 
  
# Method 2 
try: 
    print("MY_HOME:", os.environ['MY_HOME']) 
except KeyError:  
    print("Environment variable does not exist") 
```



使用列表推导式时，通常是为了简化代码或生成一个新列表，但当涉及条件判断和对原始数据的就地修改时，列表推导式可能会变得复杂且难以阅读。特别是当代码中的意图是修改现有的数据结构而不是创建新的列表时，传统的 `for` 循环更清晰明了。



#### [How to create a DateTime equal to 15 minutes ago?]

https://stackoverflow.com/questions/4541629/how-to-create-a-datetime-equal-to-15-minutes-ago/4541668



#### Split() method

https://www.w3schools.com/python/ref_string_split.asp



## WebScraping



#### Beautiful soup

HTML parser

```
from bs4 import BeautifulSoup
with open("website.html", "r") as file:
    text = file.read()


soup = BeautifulSoup(text,'html.parser')
print(soup.title)
```



#### Syntax

`sout.<tag>`

`soup.title.name`显示组件名字

`soup.title.string`显示组件内容

`soup.prettify()`打印出带缩进的html内容



#### Get tag

```
anchor_tag = soup.find_all(name="a")

for tag in anchor_tag:
    print(tag.getText())
```



Get attribute

```
tag.get("href")
```



Find method

Find the first element

```
heading = soup.find(name='h1',id='name')
```



class

because the class is inbuild element in python, so if you want to find the specfic class using

`class_`



#### Narrow down

Using css nested to narrow down the specfic element:

```
company_url = soup.select_one(selector="p a")
name = soup.select_one(selector="#name")
headings = soup.select(selector=".heading")
```



#### Get text

`getText` 会递归地获取所有子标签中的文本，所以它能够正确地获取 `<a>` 标签内的文本。



#### find & selector区别

`find` 和 `find_all` 方法

- **用途**: `find` 用于查找第一个符合条件的元素，而 `find_all` 用于查找所有符合条件的元素。
- **参数**:
  - `name`: 标签名，如 `'span'`, `'a'`, `'div'` 等。
  - `attrs`: 可以通过字典的形式传递属性，如 `{'class': 'my-class'}`。
  - `text`: 用于查找包含特定文本的标签。
  - `recursive`: 是否递归查找子元素，默认为 `True`。
- **优点**:
  - 语法简单、直观，适合查找单一标签或特定属性的元素。
  - 适用于明确知道要查找的元素类型或特定属性时。
- **缺点**:
  - 在复杂的选择条件下，不如 CSS 选择器灵活。
  - 查找某些嵌套结构时，可能需要多个 `find` 或 `find_all` 的嵌套。

`select` 和 `select_one` 方法

- **用途**: `select` 使用 CSS 选择器语法来查找元素，类似于 jQuery 的选择器。`select_one` 用于查找第一个匹配的元素。
- **参数**:
  - 接受一个 CSS 选择器字符串，可以是标签、类、ID、属性、伪类等的组合。
- **优点**:
  - 使用 CSS 选择器，语法灵活，适合复杂的选择条件。
  - 可以轻松查找嵌套的元素，如 `div > span > a` 这样的结构。
  - 能够同时使用类、ID、属性等选择条件。
- **缺点**:
  - 对于不熟悉 CSS 选择器的人来说，可能会稍显复杂。
  - 对于非常简单的查找操作，可能会显得多余。



#### 链式调用

在 BeautifulSoup 中，你可以通过链式调用来访问嵌套的标签，但是这种方式仅适用于你确实知道 HTML 结构并且这些标签都存在的情况下。也就是说，如果你写 `line.span.a.span`，这意味着你期望 `line` 包含一个 `span` 标签，这个 `span` 标签又包含一个 `a` 标签，而 `a` 标签里面还有一个 `span` 标签。如果这些标签的层级结构存在，那么这个链式调用是有效的。



#### Adding Headers

当你需要越过机器人验证时, When making a request to Amazon or any website, your browser will send some additional data along with the request. Typically this will be information regarding what browser you are using, what computer you have, and what your preferred language is. This information is included in the **headers**. By using the headers, Amazon's server can respond with the right website for your region and your language.

1. See the headers that your own browser is sending by going to this website:

http://myhttpheader.com/

Try different browsers (e.g., Chrome, Brave, Firefox, Safari) and see how the headers change. Here's what I see:



![img](https://img-c.udemycdn.com/redactor/raw/article_lecture/2024-07-10_16-01-14-722daf274c04cc43e33e0370d79c5fc8.png)

There you can see my language settings and that I used a Mac computer to make the request.

- Add the headers to your code

**Why would you want to do this?**

If you pass some headers along then Amazon's servers can give you the instant pot page in your language and also in your currency.

Also, it will make your request look (slightly) more human and less like a bot. Why? Headers include data that is sent over by a browser rather than a script. And many web servers like Amazon's may block requests they think originate from bots.

At the moment we are making a request without adding any headers:

```
response = requests.get("https://www.udemy.com/")
```

Here's how you can pass some headers alongside your requests: 

```
response = requests.get("https://www.udemy.com/", headers={"Accept-Language":"en-US"})
```

Here is more detailed information on how you pass headers with the requests library:

https://stackoverflow.com/questions/6260457/using-headers-with-the-python-requests-librarys-get-method

Add some headers to your request in the main.py. At minimum add the `User-Agent` and `Accept-Language`. At most copy the full header from https://httpbin.org/headers (excluding the `host` and `X-Amzn-Trace-id`)



## Selenium Webdriver

#### selenium driver

the bridge between selenium and browroser

```
from selenium import webdriver

# Keep website open
chrome_option = webdriver.ChromeOptions()
chrome_option.add_experimental_option('detach',True)

# Automation opent the website
driver = webdriver.Chrome(options=chrome_option)
driver.get('https://o.pandalow.com')
```



- How to quit

```
driver.quit() # quit the Browser
driver.close() # close the tab page
```

#### Find element locate

Selenium 可以直接调用浏览器, 所以不需要传入任何headers的参数来实现爬取网络信息

```
whole_price = driver.find_element(By.CLASS_NAME,value='a-price-whole')
fraction_price = driver.find_element(By.CLASS_NAME,value='a-price-fraction')

print(f"There is price : {whole_price.text}.{fraction_price.text}")

driver.quit()
```

#### Find form

```
input_area = driver.find_element(By.NAME,value='q')
input_area.get_attribute("placeholder")
```



#### By Css Selector

```
driver.find_element(By.CSS_SELECTOR,value='.documentation-widget a')
```

#### By Xpath

使用chrome的开发者工具就能获得xpath了

![image-20240903015511109](/Users/zhuangxiaojian/Library/Application Support/typora-user-images/image-20240903015511109.png)

```
driver.find_element(By.XPATH, value = '//*[@id="tabs--1-tab-4"]/span')
```



#### Interaction

Click

```
article_count = driver.find_element(By.XPATH,'//*[@id="articlecount"]/a[1]')
# article_count.click()
portals_link = driver.find_element(By.LINK_TEXT,'Content portals')
portals_link.click()
```

Type 

```
search_area = driver.find_element(By.NAME,'search')
search_area.send_keys('Python',Keys.ENTER)
```





#### Window handle

1. The Facebook login page opens in a new window. In order for our selenium code to work on the new window, we have to switch to the window in front.

In Selenium, each window has a identification handle, we can get all the window handles with:

```
driver.window_handles
```

The above line of code returns a list of all the window handles. The first window is at position 0 e.g.

```
base_window = driver.window_handles[0]
```

New windows that have popped out from the base_window are further down in the sequence e.g.

```
fb_login_window = driver.window_handles[1]
```

We can switch our Selenium to target the new facebook login window by:

```
driver.switch_to.window(fb_login_window)
```

You can print the driver.title to verify that it's the facebook login window that is currently target:

```
print(driver.title)
```

The full code to switch to the new pop-up window is thus:

```
base_window = driver.window_handles[0]fb_login_window = driver.window_handles[1]driver.switch_to.window(fb_login_window)print(driver.title)
```

If successful the printed title should be "Facebook" and not "Tinder | Match. Chat. Date."

2. Using what you have learnt about Selenium, fill in the Facebook login form and submit it to log in.

![img](https://img-c.udemycdn.com/redactor/raw/2020-08-21_15-33-57-3f82315199d6c26b232010d4be600fd1.png)

NOTE: Avoid invoking the Facebook Login too frequently, see if you can test your code without logging in, you don't want to appear like a bot to Facebook as there is always the chance that they might disable your FB account. Alternatively, you can try setting up an alternative Facebook account.

If successful, you should see the pop-up window disappear and you're back on the Tinder page. e.g.

![img](https://img-c.udemycdn.com/redactor/raw/2020-08-21_15-36-03-c39aaf979df1854cc259aebafd8a2ae7.png)

3. At this point, you should revert back to the base_window and verify by printing the title of the Selenium controlled window title.

```
driver.switch_to.window(base_window)print(driver.title)
```

If successful, it should print "Tinder | Match. Chat. Date."





## WebDevelopment



Client Server Database



#### Flask

https://pypi.org/project/Flask/

- Quick Start Doc

https://flask.palletsprojects.com/en/3.0.x/quickstart/



-  Library vs Frame Work

https://anarsolutions.com/libraries-vs-frameworks/#:~:text=To%20make%20it%20even%20simpler,have%20to%20follow%20the%20blueprint.

Library 是个工具, FrameWork是有规则需要遵守



#### Start Server

```
from flask import Flask

app = Flask(__name__)

@app.route("/")
def hello_world():
    return "<p>Hello, World!</p>"
```

Running

```
$ flask --app hello run
 * Serving Flask app 'hello'
 * Running on http://127.0.0.1:5000 (Press CTRL+C to quit)
```



#### Command in MAC

https://github.com/appbrewery/terminal-mac-cheatsheet/tree/master/%E4%B8%AD%E6%96%87



Kernal(内核与操作系统交互) - shell (interface)

`pwd` 展示当前路径

`ls`展示当前文件下文件

`cd` 跳转路径

`mkdir`创建新文件夹

`touch filename`创建新文件

`rm filename`删除文件

`rm -rf filename`删库



#### Flask name

- Built in Type

definition.**__name__**

The name of the class, function, method, descriptor, or generator instance.



在 Python 中，`__name__` 是一个内置变量，它的值取决于当前模块的执行方式：

1. 如果模块是被直接运行的（如执行脚本），`__name__` 的值是 `"__main__"`。
2. 如果模块是被导入到其他模块中执行的，`__name__` 的值就是模块的名字。

因此，`__name__ == "__main__"` 常用于检查代码是否是直接运行的，帮助控制代码的执行逻辑，避免在模块被导入时执行不必要的代码。



在 Python 中，`__main__` 是指执行 Python 文件时的上下文。当脚本被直接运行时，特殊变量 `__name__` 被设置为 `"__main__"`。这让你能够区分脚本是直接运行还是被另一个脚本作为模块导入。

例如：

```
python
复制代码
if __name__ == "__main__":
    # 只有当脚本直接执行时，这段代码才会运行
    main()
```

这段代码确保只有在脚本被直接执行时，特定的代码才会运行，而不会在导入为模块时执行。



在 `Flask(__name__)` 语句中，`__name__` 并不总是等于 `"__main__"`。`__name__` 的值取决于该模块是如何执行的：

- 如果这个 Flask 应用是直接运行的主程序，`__name__` 就等于 `"__main__"`。
- 如果这个 Flask 应用被另一个模块导入，`__name__` 就会是模块的名称（比如 `app` 或其他模块名称）。

`Flask(__name__)` 使用 `__name__` 是为了告诉 Flask 当前模块的上下文，用于寻找静态文件、模板等。



在 Python 中，当你导入一个模块时，可以通过 `__name__` 来判断该模块的名称。你可以在模块内部使用 `__name__` 来了解该模块是被导入的，还是作为主程序执行的。

例如，假设有一个名为 `module_example.py` 的模块：

```
# module_example.py

print(f"The name of this module is: {__name__}")
```

如果你直接运行这个文件，`__name__` 将输出 `"__main__"`，因为这是主程序。如果你在另一个文件中导入它，如：

```
import module_example
```

那么 `__name__` 会输出 `"module_example"`，这是该模块的名称。



#### *@Sign - Python Decorators* IMPORTANT!!

Python 装饰器, 在原有function上, 增加新的功能

https://pythontutor.com/visualize.html#mode=edit

- pass function
- nested function
  - 可以在一个function中建一个新的function, 同时不要忘记调用该function
- return function
- decorator function

```python
def decorator_function(function):
	def wrapper_function():
			function()
  return wrapper_function
```

**@Sign 可以自动捕获该decorator_function并执行 - 语法糖**

```python
## Simple Python Decorator Functions
import time

def delay_decorator(function):
    def wrapper_function():
        time.sleep(2)
        #Do something before
        function()
        function()
        #Do something after
    return wrapper_function

@delay_decorator
def say_hello():
    print("Hello")

#With the @ syntactic sugar
@delay_decorator
def say_bye():
    print("Bye")

#Without the @ syntactic sugar
def say_greeting():
    print("How are you?")
decorated_function = delay_decorator(say_greeting)
decorated_function()

```

- Basic knowledge

```python
## ********Day 54 Start**********
## Functions can have inputs/functionality/output
def add(n1, n2):
    return n1 + n2

def subtract(n1, n2):
    return n1 - n2

def multiply(n1, n2):
    return n1 * n2

def divide(n1, n2):
    return n1 / n2

##Functions are first-class objects, can be passed around as arguments e.g. int/string/float etc.

def calculate(calc_function, n1, n2):
    return calc_function(n1, n2)

result = calculate(add, 2, 3)
print(result)

##Functions can be nested in other functions

def outer_function():
    print("I'm outer")

    def nested_function():
        print("I'm inner")

    nested_function()

outer_function()

## Functions can be returned from other functions
def outer_function():
    print("I'm outer")

    def nested_function():
        print("I'm inner")

    return nested_function

inner_function = outer_function()
inner_function


```

-  Challenge

```python
import time

current_time = time.time()
print(current_time)  # seconds since Jan 1st, 1970


# Write your code below 👇

def speed_calc_decorator(function):
    def wrapper_function():
        start_time = time.time()
        function()
        end_time = time.time()
        print(f"{function.__name__} run speed is {end_time - start_time}")

    return wrapper_function

@speed_calc_decorator
def fast_function():
    for i in range(1000000):
        i * i

@speed_calc_decorator
def slow_function():
    for i in range(10000000):
        i * i

fast_function()
slow_function()
```



#### Flask URLS & Converter

Variable Rules

- You can add variable sections to a URL by marking sections with `<variable_name>`. Your function then receives the `<variable_name>` as a keyword argument. 

- Optionally, you can use a converter to specify the type of the argument like `<converter:variable_name>`.

```
from markupsafe import escape

@app.route('/user/<username>')
def show_user_profile(username):
    # show the user profile for that user
    return f'User {escape(username)}'

@app.route('/post/<int:post_id>')
def show_post(post_id):
    # show the post with the given id, the id is an integer
    return f'Post {post_id}'

@app.route('/path/<path:subpath>')
def show_subpath(subpath):
    # show the subpath after /path/
    return f'Subpath {escape(subpath)}'
```

Converter types:

| `string` | (default) accepts any text without a slash |
| -------- | ------------------------------------------ |
| `int`    | accepts positive integers                  |
| `float`  | accepts positive floating point values     |
| `path`   | like `string` but also accepts slashes     |
| `uuid`   | accepts UUID strings                       |

#### Debug Mode

```
if __name__ == '__main__':
    app.run(debug=True)
```



#### Rendering Html

在返回时加上标签

```
@app.route('/<name>')
def print_name(name):
    return f'<h1>{name}</h1>'

```



#### Advanced Decorators

Decorator 可以在warpper里接受args和kargs作为附加参数

```python
class User:

    def __init__(self,name):
        self.username = name
        self.is_logged_in = False


# Decorator with args and kwargs
def is_authenticated(function):
    def wrapper(*args,**kwargs):
        if kwargs['user'].is_logged_in == True:
            function(kwargs['user'])
    return wrapper
@is_authenticated
def post_blog(user):
    print(f"{user.username} is posted a blog")


john = User('john')
john.is_logged_in = True
post_blog(user=john)
```



#### Rendering Template

```python
from flask import Flask,render_template

app = Flask(__name__)

@app.route('/')
def home():
    return render_template("angela.html")
```



get template: https://html5up.net/



一个重要命令: document.body.contentEditable=true 支持你直接编辑网页的内容



https://unsplash.com/ 找背景图片



#### JINJIA Template

Jinja in Python is similar to Java's JSP (JavaServer Pages). Both are template engines used to generate dynamic web pages by embedding code within HTML. In Jinja, you use Python expressions and control structures within the HTML, while in JSP, you embed Java code. Both allow for rendering templates with data passed from the backend, helping create dynamic, data-driven web pages.



```html
<h1>{{5*6}}</h1>
<h2>
  {{num}}
</h2>
```



```python
@app.route('/')
def home():
    random_number = random.randint(0,10)
    return render_template('index.html',num=random_number)
```



#### Multiline with JINja



```
<body>
    {% for article in blog:%}
    <h1>{{article.title}}</h1>
    <h2>{{article.subtitle}}</h2>
    <p>{{article.body}}</p>
    {% endfor %}
</body>
```



#### Url build

`<a href="{{ url_for('blog',num=3)}}">Go to blog</a>`



## Data classes

https://docs.python.org/3/library/dataclasses.html

`__post_init__` 是 `dataclass` 提供的一个特殊方法，它在类的默认 `__init__` 方法运行之后自动调用。你可以使用这个方法执行需要额外初始化的逻辑，比如实例化复杂对象或者处理依赖于其他字段的逻辑。

在 `dataclass` 中，字段的初始化顺序是根据定义的顺序，某些字段（如未提供初始值的）需要在 `__init__` 方法后进一步配置，因此 `__post_init__` 提供了一个机会来进行这些自定义初始化操作。

例如：

```
@dataclass
class MyClass:
    a: int
    b: int = 10

    def __post_init__(self):
        print(f"MyClass initialized with a={self.a}, b={self.b}")
```

这样，当你创建 `MyClass` 实例时，会首先调用默认的 `__init__`，然后自动调用 `__post_init__`。

在 `dataclass` 中，`field` 是一个函数，用来指定更详细的字段配置。你可以通过它为某个字段设定默认值、默认工厂函数（比如 `default_factory`），或是设置是否在初始化时忽略该字段（通过 `init=False`）。

在你的例子中：

- `default_factory=webdriver.ChromeOptions`：这意味着 `_chrome_option` 将使用 `webdriver.ChromeOptions()` 的返回值作为默认值。
- `init=False`：表示 `_driver` 字段不会通过 `__init__` 方法进行初始化，而需要在 `__post_init__` 或其他地方手动设置。



#### Format

在 `dataclass` 中，字段的定义通常是 "变量 + 类型注解 + 默认值" 的格式。但类型注解并不是强制的。如果你不想指定变量类型，依然可以使用 `dataclass`，只需提供变量名和默认值即可。

例如：

```
from dataclasses import dataclass

@dataclass
class Example:
    name: str = "John"  # 带有类型注解
    age = 25            # 没有类型注解
```

虽然类型注解可以提高代码的可读性，并帮助 IDE 提供更好的自动补全和类型检查，但它在 Python 中是可选的。





#### HTML Forms in Flask

post method



NOTE:

The action attribute of the form can be set to `"/login"` e.g.

```
<form action="/login" method="post">
```

or it can be dynamically generated with `url_for` e.g.

```
<form action="{‌{ url_for('receive_data') }}" method="post">
```

Depending on where your server is hosted, the `"/login"` path may change. So it's usually a better idea to use `url_for` to dynamically generate the url for a particular function in your Flask server.





we can create a decorator in our **main.py** that will trigger a method when it receives a **POST** request:

```
from flask import request

@app.route('/login', methods=['GET', 'POST'])
def login():
    if request.method == 'POST':
        return do_the_login()
    else:
        return show_the_login_form()
        
# 或者下面这样的

@app.get('/login')
def login_get():
    return show_the_login_form()

@app.post('/login')
def login_post():
    return do_the_login()
```

Notice that the `methods` parameter accepts a **list**, so you can have **multiple** methods targeted by one route. e.g.

```
@app.route("/contact", methods=["GET", "POST"]
```

More on this in the documentation here: https://flask.palletsprojects.com/en/2.3.x/quickstart/#http-methods





### The Request Object

The request object is documented in the API section and we will not cover it here in detail (see [`Request`](https://flask.palletsprojects.com/en/2.3.x/api/#flask.Request)). Here is a broad overview of some of the most common operations. First of all you have to import it from the `flask` module:

```
from flask import request
```

The current request method is available by using the [`method`](https://flask.palletsprojects.com/en/2.3.x/api/#flask.Request.method) attribute. To access form data (data transmitted in a `POST` or `PUT` request) you can use the [`form`](https://flask.palletsprojects.com/en/2.3.x/api/#flask.Request.form) attribute. Here is a full example of the two attributes mentioned above:

```
@app.route('/login', methods=['POST', 'GET'])
def login():
    error = None
    if request.method == 'POST':
        if valid_login(request.form['username'],
                       request.form['password']):
            return log_the_user_in(request.form['username'])
        else:
            error = 'Invalid username/password'
    # the code below is executed if the request method
    # was GET or the credentials were invalid
    return render_template('login.html', error=error)
```

What happens if the key does not exist in the `form` attribute? In that case a special [`KeyError`](https://docs.python.org/3/library/exceptions.html#KeyError) is raised. You can catch it like a standard [`KeyError`](https://docs.python.org/3/library/exceptions.html#KeyError) but if you don’t do that, a HTTP 400 Bad Request error page is shown instead. So for many situations you don’t have to deal with that problem.

To access parameters submitted in the URL (`?key=value`) you can use the [`args`](https://flask.palletsprojects.com/en/2.3.x/api/#flask.Request.args) attribute:

```
searchword = request.args.get('key', '')
```

We recommend accessing URL parameters with get or by catching the [`KeyError`](https://docs.python.org/3/library/exceptions.html#KeyError) because users might change the URL and presenting them a 400 bad request page in that case is not user friendly.

For a full list of methods and attributes of the request object, head over to the [`Request`](https://flask.palletsprojects.com/en/2.3.x/api/#flask.Request) documentation.

### If

The if statement in Jinja is comparable with the Python if statement. In the simplest form, you can use it to test if a variable is defined, not empty and not false:

```
{% if users %}
<ul>
{% for user in users %}
    <li>{{ user.username|e }}</li>
{% endfor %}
</ul>
{% endif %}
```

For multiple branches, elif and else can be used like in Python. You can use more complex [Expressions](https://jinja.palletsprojects.com/en/3.0.x/templates/#expressions) there, too:

```
{% if kenny.sick %}
    Kenny is sick.
{% elif kenny.dead %}
    You killed Kenny!  You bastard!!!
{% else %}
    Kenny looks okay --- so far
{% endif %}
```

If can also be used as an [inline expression](https://jinja.palletsprojects.com/en/3.0.x/templates/#if-expression) and for [loop filtering](https://jinja.palletsprojects.com/en/3.0.x/templates/#loop-filtering).



**pldk tduk juac gjeb**



## WTForms

- **Easy Form Validation** - Makes sure the user is entering data in the required format in all the required fields. e.g. checking that the user's email entry has a "@" and a "." at the end. All without having to write your own validation code.
- **Less Code** - If you have a number of forms in your website, using WTForm can dramatically reduce the amount of code you have to write (or copy & paste).
- **Built in CSRF Protection** - CSRF stands for [Cross Site Request Forgery](https://owasp.org/www-community/attacks/csrf), it's an attack that can be made on website forms which forces your users to do unintended actions (e.g. transfer money to a stranger) or compromise your website's security if it's an admin.

Flask developers will usually choose Flask-WTF to create forms in their websites. However, in the wild, you might also see projects that are built with HTML Forms. So it's important to understand how both of them work.



#### Requirements.txt

Installing packages and the requirements.txt

The **requirements.txt** file is a file where you can specify all the dependencies (the installed packages that your project depends on) and their versions. This means that you can share your project without all the installed packages, making it a lot more lightweight. When someone downloads your project (like you have done here), the requirements.txt file tells their code editor which packages need to be installed. [Read more on this here](https://docs.google.com/document/d/e/2PACX-1vRIW_TuZ6z0ASjAoxgJgmzjGYLCDx019tKvphaTwK_Za7fnMKywUuXI0-s5wr0nQI_gprm6J6y7L9rL/pub).



#### Creating Form

```
from flask_wtf import FlaskForm
from wtforms import StringField
from wtforms.validators import DataRequired


class LoginForm(FlaskForm):
    email = StringField(label='email',validators=[DataRequired()])
    password = StringField(label='password',validators=[DataRequired()])
    

@app.route("/login")
def login():
    form = LoginForm()
    return render_template("login.html", form=form)
```



在WTForms中，`FlaskForm` 继承自 `Form`，这是一个特殊的类，利用了 Python 的元类编程技术来动态创建类中的字段。这使得你可以直接在类定义中声明字段，而不需要显式地在 `__init__` 方法中初始化它们。具体原因可以归结为以下几点：

1. 元类的作用

WTForms 使用了元类（metaclass）来处理字段的声明。在 Python 中，元类可以拦截类的创建过程，从而允许对类的定义进行自定义处理。在 WTForms 中，`Form` 类的元类是 `BaseFormMeta`，它负责处理类中声明的字段。

当你定义一个表单类（如 `LoginForm`），Python 会先调用这个元类，在类的创建阶段就会自动收集所有声明的字段（如 `email` 和 `password`）。因此，你不需要手动编写 `__init__` 方法。

2. 字段的自动收集

`BaseFormMeta` 会扫描类的所有属性，并将那些 `Field` 类型的属性（如 `StringField`）自动收集起来，放入一个内部的字段列表中，并为你准备好这个表单类的所有字段。所以表单的字段定义只需要在类体内声明即可，元类会负责将这些字段封装进表单的内部结构里。

3. `__init__` 方法已经由父类处理

`Form` 类本身有自己的 `__init__` 方法，负责初始化表单实例。这就是为什么你在创建表单类时不需要定义自己的 `__init__` 方法，表单实例会自动根据传入的 `data`、`formdata` 等来进行初始化操作。

代码示例

以你提供的代码为例：

```
class LoginForm(FlaskForm):
    email = StringField(label='email', validators=[DataRequired()])
    password = StringField(label='password', validators=[DataRequired()])
```

1. 当你实例化 `LoginForm` 时，元类会在类创建阶段收集 `email` 和 `password` 字段。
2. 在实例化时，`Form` 的 `__init__` 方法会接收传入的数据，并根据定义的字段进行初始化，而你不需要手动处理这些字段的初始化。

总结

WTForms 通过元类（`BaseFormMeta`）来处理字段声明，因此不需要在每个表单类中显式地定义 `__init__` 方法。元类会自动收集并管理所有字段的初始化和验证逻辑。这种设计使得表单类的定义更加简洁，同时保持了灵活性和可扩展性。

如果你对元类或 WTForms 的底层机制有更多疑问，可以深入研究 `BaseFormMeta` 如何工作，它是实现这一自动化过程的关键部分。

#### Basic Fields

https://wtforms.readthedocs.io/en/3.0.x/fields/#basic-fields



#### **Adding Validation**

One of the biggest reasons why we would choose WTForms over HTML Forms is the built-in validation. Instead of us having to write our own validation code e.g. emails should contain a "@" and a "." to be valid or make sure that passwords are minimum of 8 characters, we can use all these validation rules straight out of the box from WTForms.



The `validators` parameter accepts a **List** of validator **Objects**. DataRequired makes the two fields required fields, so the user must type something, otherwise an error will be generated.



When a form is submitted, there may be a number of errors, so a List of `errors` can be generated and passed over to our form HTML as a property on the field which generated the error, e.g.

```
form.<field>.errors
```

https://wtforms.readthedocs.io/en/3.0.x/crash_course/#validators

Tell the form to validate

`validate_on_submit()`.

```
class LoginForm(FlaskForm):
    email = EmailField(label='email', validators=[DataRequired(), Email("Invalid email address")])
    password = PasswordField(
        label='password',
        validators=[
            DataRequired(),
            Length(min=8,message="Your password should over 8")
        ]
    )
    submit = SubmitField(label='Login')
```



#### Receiving Data

With WTForms, it's even easier to get hold of the form data. All you have to do is to tap into the

```
<form_object>.<form_field>.data
```



one thing we should check before printing the field data is whether if the form has been submitted (POST request) or if it's GET request when the form is being rendered.

Previously we used

```
if request.method == "POST"
```

Now, we're simply going to check the return value of `validate_on_submit()` which will be `True` if validation was successful **after the user submitted the form**, or `False` if it failed.





```
@app.route("/login",methods=['GET','POST'])
def login():
    form = LoginForm()
    email = form.email.data
    password = form.password.data
    if email == "admin@email.com" and password == "12345678" and form.validate_on_submit():
        return render_template('success.html')
    elif form.validate_on_submit():
        return render_template('denied.html')

    return render_template("login.html", form=form)
```

#### Template Inheritance

You actually want to use the same design template for your entire website, but you might need to change some code in your header or footer. In these cases, it's better to use **Template Inheritance** instead.



if we create a base.html file that has the following code:

```
<!DOCTYPE html><html lang="en"><head>    <meta charset="UTF-8">    <title>{% block title %}{% endblock %}</title></head><body>    {% block content %}{% endblock %}</body></html>
```

It has predefined areas (or blocks) where new content can be inserted by a child webpage inheriting from this template.

1. We could re-write the success.html page to inherit from this base.html template:

```
#1.{% extends "base.html" %}#2.{% block title %}Success{% endblock %}#3.{% block content %}   <div class="container">      <h1>Top Secret </h1>      <iframe src="https://giphy.com/embed/Ju7l5y9osyymQ" width="480" height="360" frameBorder="0" class="giphy-embed" allowFullScreen></iframe>      <p><a href="https://giphy.com/gifs/rick-astley-Ju7l5y9osyymQ">via GIPHY</a></p>   </div>{% endblock %}
```

> \#1. This line of code tells the templating engine (Jinja) to use "base.html" as the template for this page.
>
> \#2. This block inserts a custom title into the header of the template.
>
> \#3. This block provides the content of the website. The part that is going to vary between webpag

- **Super Blocks**

```
<style>
{% block styling %}
body{
    background: purple;
}
{% endblock %}
</style>
```



On the **denied.html** page, add a super block using `{‌{ super() }}`, this will inject all the code in the styling block to this child page. Then afterwards before the `{% endblock %}`, we can add some more styling to change the colour of the `<h1>`.



#
