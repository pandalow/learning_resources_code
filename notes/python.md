# Python

## Day-1

#### Length of str

```
# Caculate the length of string
len(str)
```

#### Input

```
# Ask user input 
input("What is your name")
# The input field can printout the var then ask input
```

## Day-2

#### Basic type

```
# String instead of String.charAt(0)
print("Hello"[0])

print("123" + "345")

# Integer , no comma
print(123 + 345)

print(123_456_789)

# Float
3.14159

# Boolean
True
False
```

#### Type cast

```
# Convert to string
str(var) 
# Convert to integer
int(var)
# Convert to float
float(var)
```

#### Type Check

```
# Using type() to check type:
type()
```

#### PEMDAS & **

You have already know what it is

- () > ** > * or / > + or - 

- ** means 乘方 
  
  ```
  2 ** 3 = 8
  ```

Modular : % 

#### Float div

```
# // means float divison, the result will be automatically rounded, eg: 

print(type(8//3))

# Output: 3
```

#### Continue mathmatical

```
# Continuing divide
result = 4/2
result /= 2
print(result)

```

#### F-String

```
# f-string
score = 0
height = 1.8
isWinning = True

print(f"your score is {score}, your height is {height}, your are Winning is {isWinning}")
```

#### How to round numbers in Python

You are running into the [old problem](https://en.wikipedia.org/wiki/IEEE_754) with floating point numbers that not all numbers can be represented exactly. The command line is just showing you the full floating point form from memory.

With floating point representation, your rounded version is the same number. Since computers are binary, they store floating point numbers as an integer and then divide it by a power of two so 13.95 will be represented in a similar fashion to 125650429603636838/(2**53).

Double precision numbers have 53 bits (16 digits) of precision and regular floats have 24 bits (8 digits) of precision. The [floating point type in Python uses double precision](http://docs.python.org/tutorial/floatingpoint.html) to store the values.

For example,

```py
>>> 125650429603636838/(2**53)
13.949999999999999

>>> 234042163/(2**24)
13.949999988079071

>>> a = 13.946
>>> print(a)
13.946
>>> print("%.2f" % a)
13.95
>>> round(a,2)
13.949999999999999
>>> print("%.2f" % round(a, 2))
13.95
>>> print("{:.2f}".format(a))
13.95
>>> print("{:.2f}".format(round(a, 2)))
13.95
>>> print("{:.15f}".format(round(a, 2)))
13.949999999999999
```

If you are after only two decimal places (to display a currency value, for example), then you have a couple of better choices:

1. Use integers and store values in cents, not dollars and then divide by 100 to convert to dollars.
2. Or use a fixed point number like [decimal](https://docs.python.org/library/decimal.html).

#### Reference

https://docs.python.org/3/tutorial/floatingpoint.html

## Day-3 Conditional

#### if else::notice intents

```
print("Welcome to the rollercoaster!")
height = int(input("What is your height in cm? "))

if height > 120:
    print("You can ride the rollercoaster")
else:
    print("Sorry, you have to grow taller before you can ride")
```

#### Comparison Operators

== java

#### Elif

elif == else if in java

#### Multiple if

是的，在Python和Java中，`if-else`语句的执行逻辑是相似的。代码会按顺序从上到下执行，一旦找到满足条件的分支，就会执行相应的代码块，然后跳过后续的条件判断和代码块。

#### Logical Operators

```
A and B
C or D
not E
```



## Day-4 Python List

#### Random

https://en.wikipedia.org/wiki/Mersenne_Twister

```
import random
import day_4_module.day_4_pi_module as pi_module

random_integer = random.randint(1, 10)

random_float = random.random()
print(random_integer)
print(random_float*5)

```



#### List

```
fruits =[item1,item2]
```

negative index, 从后往前数

```
states_of_china = ["Beijing", "Zhejiang"]

province = states_of_china[-1]

output = 'zhejiang'
```

Append - 添加

```
states_of_china.append("Hubei")
```

注意out of bountds

#### Nested List

```
first =[]
second =[] 
nested = [first,second]
```

## Day-5 Loop

#### Enhanced loop

```
fruits = ['Apple','Peach','Pear']
print(fruits)
# enhanced the fruits
for fruits in fruits:
    # Indentation is really important
    print(fruits)
    print(fruits + ' pie')
```

#### Range -- for loop in java

```
# Range
for number in (1, 10):
    # Not include 10
    print(number)

for number in (1,11,3):
    # Step by 3
    print(number)
```



## Day-6 Def & While

#### Function

```
def my_function():
    print("hello")
    print("bye")

my_function()

```

NOTICE the indentation!!! 4 space

using tabs ->| 

#### While

While something_is_ture:

```
def turn_right():
    turn_left()
    turn_left()
    turn_left()

def pass_hurdle():
    move()
    turn_left()
    move()
    turn_right()
    move()
    turn_right()
    move()
    turn_left()

while not at_goal():
    pass_hurdle()
```



When for loop == iterate the list, or range doing sth

when while loop ==  for some condition meet -- danger~~



## Day-7 Review loop

```
if guess not in chosen_word:
```

直接遍历查找



```
import hangman_words

words = hangman_words.word_list
```



## Day-8 Parameters

#### Diff between Arg and Para

```
def greet_with_name(name):
    print(f"Hello {name}")
    print(f"How do you do {name}")

greet_with_name("Zhuang")
```

name = parameter;  Zhuang = argument



#### Postitional argument

Parameter的位置要有序输入 or 指定对应的Parameter和Argument关系

```
def greet_with_name(name,location):
    print(f"Hello {name}")
    print(f"What is it like in {location}")

greet_with_name(name="Angela", location="London")
```

**创建一个循环的方式:* , 用模 %

```
 shift_index %= (len(alphabet))
```



## Day-9 Dicitionaries

### Key - Value

```
{Key: Value}
```

A dictionary in Python functions similarly to a dictionary in real life. It's a data structure that allows us to associate a key to a value and pair the two pieces of data together.

This is how you create a dictionary in Python:

```
# An example dictionary colours = {    "apple": "red",     "pear": "green",     "banana": "yellow" } 
```

This is how you retrieve items from a dictionary:

```
print(colours["pear"]) #Will print "green" 
```

This is how to create an empty dictionary:

```
my_empty_dictionary = {} 
```

This is how you can add new items to an existing dictionary:

```
colours["peach"] = "pink" 
```

This is also how you can edit an existing value in a dictionary:

```
colours["apple"] = "green" 
```

This is how to loop through a dictionary and print all the keys:

```
for key in colours:    print(key) 
```

This is how to loop through a dictionary and print all the values:

```
for key in colours:    print(colours[key]
```



#### Nesting

```
{
    key: [List],
    key2: {Dict},
}
```

```
capitals = {
    "France":"Paris",
    "Germany":"Berlin"
}

travel_log ={
    "France": ["Paris", "Lille", "Dijon"],
    "Germany": ["Stuttgart", "Berlin"],
}

print(travel_log["France"][1])
```

#### Exercise

```python
import art
print(art.logo)


def find_highest(bid_dic):
    winner = ''
    max_price = 0

    for key in bid_dic:
        if bid_dic[key] >= max_price:
            max_price = bid_dic[key]
            winner = key
    print(f"The winner is {winner} and the price is {max_price}")


bid = {}
continue_bid = True
while continue_bid:
    bid_name = input("Whats your name?")
    bid_price = int(input("What is your Bid price?"))
    bid[bid_name] = bid_price
    continue_bid = (input("Do you have another bid? Y/N") == "Y")
    print("\n" * 100)
find_highest(bid)
```

## Function outputs

#### Return multple values

Python 的函数可以返回多个值。通过返回一个元组（tuple），您可以有效地返回多个值。以下是一些示例说明如何在 Python 中返回多个值以及如何使用它们：

```
def get_coordinates():
    x = 5
    y = 10
    return x, y

# 调用函数并获取返回的多个值
x, y = get_coordinates()
print(f"x = {x}, y = {y}")
```

```
def get_person_info():
    name = "Alice"
    age = 30
    email = "alice@example.com"
    return name, age, email

# 调用函数并获取返回的多个值
name, age, email = get_person_info()
print(f"Name: {name}, Age: {age}, Email: {email}")
```

```
def format_name(f_name, l_name):
    formated_f_name = f_name.title()
    formated_l_name = l_name.title()
    return f"{formated_f_name} {formated_l_name}"


print(format_name("AnGEla", "YU"))
```



#### Docstring

```
def format_name(f_name, l_name):
    """
    Take a first and last name and format it to
    return the title case version of the name
    :param f_name:
    :param l_name:
    :return:
    """
    formated_f_name = f_name.title()
    formated_l_name = l_name.title()
    return f"{formated_f_name} {formated_l_name}"


formatted_name = format_name("AnGeLa", "YU")

length = len(formatted_name)


```

#### Storing function into var

You can storing function into variable , with out paratesis(), because the parentsis will trigger the function

```
def add(n1, n2):
    return n1 + n2

my_favourite_operation = add;
```



## Day-12 Scope

#### Global var

Naming space , function可以访问外面的, 但是外面的访问不到function里的

```
Variables (or functions) declared inside functions have local scope (also called function scope). They are only seen by other code within the same block of code.

e.g.

def my_function():
    my_local_var = 2

# This will cause a NameErrorr
print(my_local_var) 
Global Scope
Variables or functions declared at the top level (unindented) of a code file have global scope. It is accessible anywhere in the code file.

e.g.

my_global_var = 3

def my_function():
    # This works no problems
    print(my_global_var)
```

- 用global keywords

```
You can force the code allow you to modify something with global if you use the global keyword before you use it.

e.g. This will give you an error

a = 1
def my_function():
    a += 1
    print(a)
But this will work

a = 1
def my_function():
    global a
    a += 1
    print(a)
```



#### Block Variables

Python 没有 blcok的概念, while, for loop 中和创建的所有变量, 都可以被直接使用, 而不需要事先声明

```
Python is a bit different from other programming languages in that it does not have block scope.

This means that variables created nested in other blocks of code e.g. for loops, if statements, while loops etc. don't get local scope. They are given function scope if they are within a function or global scope if they are not.

e.g.

# Accessible anywhere
my_global_var = 1

def my_function():
    # Only accessible within my_function()
    my_local_var = 2

for _ in range(10):
    # Accessible anywhere
    my_block_var = 3
```

#### Constants

常量用大写, 可以避免混淆, 作为global var

```
You can define global constants in your code file for easy access. Their job is meant to be "set and forget" so you can use their values but never need to mofy them.

Naming Convention
Global constants are normally declared in ALL_CAPS with a underscore in between.

e.g.

PI = 3.14159
GOOGLE_URL = "https://www.google.com"
```



## Day-13 Debug

#### Describe the problem

The first step of solving a problem is being able to describe the problem. 

#### Reproduce the Bug

Some bugs are sneaky, they only occur under certain conditions. In order to debug them, we need to be able to reliably reproduce the bug and diagnose our problem to figure out which conditions trigger the bug.

#### Play computer (扮演计算机)

Playing computer is an important skill in debugging. You need to be able to go through your code line by line as if you were the computer to help you figure out what is going wrong.

#### Fixing the errors

Fix any errors (red underlines) that show up in the editor before you run your code. The warnings (yellow) are optional fixes, sometimes it will cause a problem down the line other times it's fine and the editor just doesn't understand what you are trying to do.

#### Catching Exceptions

You can use a try/except block in Python to catch any exceptions that might occur. For example if you imagine there could be a chance of user error. You can prevent it crashing your code by anticipating it. You trap the dangerous code inside a try block and use an except block to catch any potential errors. Then you define what should happen when that error occurs instead of simply just crashing and stopping the code.

#### Fix the error

Using try-except( == try catch)

```
try:
    age = int(input("How old are you?"))
except ValueError:
    print("Input the integer number")
    age = int(input("How old are you?"))

if age > 18:
    print(f"You can drive at age {age}.")

```

#### Using Print

print() is your friend. It can help expose hidden values while your code is running. In a for loop, the loop will follow some rules to perform a repeated block of code. But during the loop it's difficult to see the intermediate values, that's a perfect example of how you can use print to expose those intermediate values and help you debug your code.

#### Use Debugger

Most IDEs (Intelligent Development Environments) such as PyCharm will have built-in tools for debugging. This is normally known as the debugger. In many ways, they are like print statements on steroids.

Debuggers allows us to peek into our code during execution and pause on chosen lines to figure out what is the inner mechanism and where it's going wrong.

There are a couple of things that are the same in most IDEs which you should be familiar with:

1. **Breakpoint** - You can set a breakpoint by clicking on a line in the gutter of the code (where the line numbers are). This line will be where the program pauses during debug run.
2. **Step Over** - This button will go through the execution of your code line by line and allow you to view the intermediate values of your variables.
3. **Step Into** - This will enter into any other modules that your code references. e.g. If you use a function from the random module it will show you the original code for that function so you can better understand its functionality and how it relates to your problems.
4. **Step Into My Code** - This does the same thing as Step Into, but it limits the scope to your own project code and ignores library code such as random.

#### Take a Break & Ask a friends

## Day-16 OOP Concept

#### Turtle Graphics

https://docs.python.org/3/library/turtle.html

#### Object and Attribute

```
# Instance
car = Car()
# attribute
car.speed 
# method
car.run()
```

#### Python Package



## Day-17 OOP

#### Adding Attribute

通过 init 函数作为构造器, 将attribute放到class中

```
def __init__(self,seats):
    self.seats = seats
    self.seats2 = 0
```

#### Adding Method

```
def method_name(self # 这个作为自己的参数, user):
    self.seat = 222,
    user.follower = 222,
```



## Day-18 Import Modules

Using stackover

Read the official documentation

```
import turtle

tim = turtle.Turtle()

from turtle import turtle
tim = Turtle()

from turtle import *

# alising
import turtle as t
```



## Day-19 Tuple

```
在 Python 中，tuple（元组）是一种不可变的序列数据类型。它与列表（list）类似，可以存储任意类型的多个元素，但与列表不同的是，元组一旦创建就不能修改——不能增加、删除或更改其中的元素。

元组的特点
不可变性：

元组一旦创建，就不能再修改它的内容。这意味着元组的元素不能被重新赋值、添加或删除。
有序：

元组中的元素是有序的，并且可以通过索引来访问。
支持多种数据类型：

元组可以包含不同类型的元素，例如整数、字符串、列表、甚至其他元组。
允许重复：

元组中的元素可以重复。
轻量级：

元组相比于列表更轻量级，因为其不可变性使得元组的内存使用和处理速度更高效，尤其是在需要大量读取的场景下。
```



#### Color gram

https://pypi.org/project/colorgram.py/



## Function as Input

```
在 Python 中，“高阶函数”（Higher-Order Functions）和“回调函数”（Callback Functions）虽然都是与函数操作有关的概念，但它们并不是同一个意思。它们有不同的用途和定义。

高阶函数（Higher-Order Functions）
高阶函数是指能够接收其他函数作为参数，或者返回一个函数作为结果的函数。在 Python 中，函数本身是一等公民（First-Class Citizen），意味着函数可以像其他对象一样被传递、返回和赋值。

示例：

python
复制代码
def apply_function(func, value):
    return func(value)

def square(x):
    return x * x

result = apply_function(square, 5)
print(result)  # 输出: 25
在这个例子中，apply_function 就是一个高阶函数，它接收一个函数 func 作为参数，并将其应用到 value 上。

常见的高阶函数包括 map(), filter(), reduce() 等。

回调函数（Callback Functions）
回调函数是指一个函数被作为参数传递给另一个函数，并在特定事件或条件发生时调用。回调函数通常用于异步操作或事件驱动的编程场景中。

示例：

python
复制代码
def on_event(callback):
    # 模拟一个事件触发
    print("Event occurred!")
    # 调用回调函数
    callback()

def handle_event():
    print("Handling the event...")

# 传递回调函数
on_event(handle_event)
在这个例子中，handle_event 是一个回调函数，它被传递给 on_event 函数，并在事件发生后被调用。

区别总结
高阶函数是一个更广泛的概念，指的是能够接收一个或多个函数作为参数，或者返回一个函数作为结果的函数。任何能够操作函数的函数都可以称为高阶函数。

回调函数是一个更具体的应用场景，指的是一个函数被传递给另一个函数，并在某个特定时刻（例如事件触发、操作完成时）被调用。回调函数通常作为高阶函数的参数来使用。

简而言之，所有的回调函数都是高阶函数的一部分，因为回调函数是被作为参数传递给另一个函数的。但不是所有的高阶函数都涉及回调操作。高阶函数的概念更为广泛，而回调函数则更侧重于执行特定操作或响应特定事件的情境。
```



Higher order function

```
def function_a(something):
    dosomthing

def function_b():


def function_a(function_b)
```



Instance in python IS same as JAVA, they are definitely indenpendently

## Day-20 Snake Game

#### Reverse order

```
        for seg_num in range(len(self.segments)-1, 0, -1):
            self.segments[seg_num].goto(
                self.segments[seg_num - 1].xcor(),
                self.segments[seg_num - 1].ycor()
            )
        self.segments[0].forward(MOVE_DISTANCE)
```



## Day-21 Inheritance

#### Basic Code

```
class Animal:
    def __init__(self):
        self.num_eyes = 2

    def breathe(self):
        print("Inhale, exhale.")

class Fish(Animal):
    def __init__(self):
        super().__init__()

    def breathe(self):
        super().breathe()
        print("doing this underwater.")

    def swim(self):
        print("moving in water.")

nemo = Fish()
nemo.breathe()

```

The call to super() in the initialiser is recommended, but not strictly required.



#### Slicing list

```
piano_keys = ["a", "b", "c", "d", "e", "f", "g"]
piano_tuple = ("do", "re", "mi", "fa", "so", "la", "ti")
# c, d, e
piano = piano_keys[2:5]
print(piano)
# 逆序的列表
piano_keys[::-1]
print(piano_tuple[1:])
```



在 Python 中，`slice` 是一个对象，表示一个序列的切片。切片允许你从列表、元组、字符串等序列类型中提取一个子集。切片通常用于截取序列的某一部分，并可以通过指定起始位置、结束位置以及步长来灵活控制切片的内容。

- 基本语法

Python 中，切片的语法如下：

```
python
复制代码
sequence[start:stop:step]
```

- `start`：切片的起始索引（包含）。如果不指定，默认从序列的开头开始（即索引 `0`）。

- `stop`：切片的结束索引（不包含）。切片会包含到 `stop-1` 的位置。如果不指定，默认切片到序列的末尾。

- `step`：步长，默认为 `1`。表示每隔多少个元素取一次。

- 示例

```
# 创建一个列表
my_list = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

# 提取前五个元素
first_five = my_list[0:5]
print(first_five)  # 输出: [0, 1, 2, 3, 4]

# 提取索引为2到7的元素
subset = my_list[2:8]
print(subset)  # 输出: [2, 3, 4, 5, 6, 7]

# 每隔一个元素提取一次
every_other = my_list[::2]
print(every_other)  # 输出: [0, 2, 4, 6, 8]

# 从索引为1到7的元素中，每隔两个元素提取一次
subset_with_step = my_list[1:8:2]
print(subset_with_step)  # 输出: [1, 3, 5, 7]

# 逆序列表
reversed_list = my_list[::-1]
print(reversed_list)  # 输出: [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
```



## Day 24 file read and write

#### open() method

https://docs.python.org/3/tutorial/inputoutput.html#reading-and-writing-files

不要用下面这个

```
file = open("my_file.txt")
content = file.read()
print(content)
file.close()
```

用下面这个带with keyword的, 会自动化管理你的file close:

```
with open("my_file.txt") as file:
    content = file.read()
    print(content)
```



#### Write

mode = "r" : 只读模式

mode = "w" : 写模式

mode = "a" : append 添加模式

```
with open("my_file.txt", mode="w") as file:
    file.write("New text.")
```

https://www.w3schools.com/python/python_file_write.asp

解读

```
在 Python 的文件读写中，字符和字节是有明确区分的。这种区分对于处理文本数据和二进制数据至关重要。

字符 (Text) vs. 字节 (Bytes)
字符（Text）：字符是指人类可读的文本数据。Python 使用 Unicode 来表示字符，每个字符对应一个 Unicode 码点。Python 的 str 类型用于表示文本数据。

字节（Bytes）：字节是最基本的计算机数据单元。Python 的 bytes 类型用于表示二进制数据，即一系列的字节序列。字节序列通常用于处理非文本数据（如图像、音频文件）或需要以特定编码存储或传输的文本。

文件模式
当你在 Python 中打开文件时，使用不同的模式来指定文件是以字符还是字节的形式进行读写：

文本模式 (t)：

默认模式，用于处理文本数据（字符串）。
读取和写入时会自动进行编码和解码。
读取时，文件内容会被解码为 str 类型的字符串。
写入时，str 类型的内容会被编码为字节并写入文件。
例如：

python
复制代码
with open('example.txt', 'w', encoding='utf-8') as file:
    file.write("Hello, world!")

with open('example.txt', 'r', encoding='utf-8') as file:
    content = file.read()
    print(content)  # 输出: Hello, world!
二进制模式 (b)：

用于处理二进制数据（字节）。
读取时，文件内容会作为 bytes 对象被读取，不进行解码。
写入时，数据必须是 bytes 对象。
例如：

python
复制代码
with open('example.bin', 'wb') as file:
    file.write(b'\x48\x65\x6c\x6c\x6f')

with open('example.bin', 'rb') as file:
    content = file.read()
    print(content)  # 输出: b'Hello'
文件模式的组合
以下是一些常见的文件模式：

'r'：以文本模式读取文件（默认模式）。
'w'：以文本模式写入文件，文件不存在则创建，存在则清空文件。
'rb'：以二进制模式读取文件。
'wb'：以二进制模式写入文件，文件不存在则创建，存在则清空文件。
'a'：以文本模式追加写入文件。
'ab'：以二进制模式追加写入文件。
关键区别与应用场景
文本模式 (t) 适用于需要读取或写入人类可读的文本文件（如 .txt, .csv）。
二进制模式 (b) 适用于处理非文本文件（如图片、音频文件）或需要处理特定编码的文本数据时。
当你处理需要明确编码的文本文件时，文本模式会非常方便，因为它会自动为你处理编码和解码。而当你处理需要精确控制字节流的文件（如网络协议数据、图像文件）时，二进制模式是必要的。
```



#### file paths

Absolute file paths  & Relative file paths

相对路径可以省略./ 



#### Hints

readlines- 逐行读取

https://www.w3schools.com/python/ref_file_readlines.asp

replace - 调换

https://www.w3schools.com/python/ref_string_replace.asp

strip - 删掉空格

https://www.w3schools.com/python/ref_string_strip.asp

## *CSV and Pandas*



#### CSV libiary

How to use CSV dependencies

`csv.reader(file)` 可以读取文件, 并生成Csv对象, 可被row遍历

```
import csv

with open("weather_data.csv",'r') as csv_file:
    data = csv.reader(csv_file)
    temperature = []
    for row in data:
        if row[1] != "temp":
            temperature.append(int(row[1]))

    print(temperature)
```



#### Pandas

https://pandas.pydata.org/docs/

https://pandas.pydata.org/docs/reference/index.html

```
import pandas

data = pandas.read_csv("weather_data.csv")
print(data)
print(data["temp"])
```

pandas 数据结构

```
Pandas 在读取文件（如 CSV、Excel 等）后，实际上存储的是一个 DataFrame 对象，而不是一个字典。虽然 DataFrame 可以理解为某种形式上的“表格”，其中包含行和列，但它的内部结构比字典更复杂和强大。

DataFrame 的内部结构
行和列：DataFrame 由多个 Series 组成，行和列都有对应的索引。每一列是一个 Series 对象，并且所有列共享相同的行索引。

索引：DataFrame 有行索引（index）和列索引（columns），这些索引用于标识数据的位置。

DataFrame 与字典的比较
虽然 DataFrame 并不是字典，但你可以通过类比字典来理解它的一些特性：

类似于字典的列结构：

DataFrame 的每一列可以看作是一个 Series，而整个 DataFrame 可以看作是一个由列名（键）到列数据（值）的映射。换句话说，DataFrame 在某种程度上可以视为“列名到列数据”的字典。
例如，假设你有一个 DataFrame，你可以通过列名来访问数据：

import pandas as pd

data = {
    'Name': ['Alice', 'Bob', 'Charlie'],
    'Age': [25, 30, 35],
    'City': ['New York', 'Los Angeles', 'Chicago']
}

df = pd.DataFrame(data)

# 通过列名访问数据
print(df['Name'])

这将输出：
vbnet
0      Alice
1        Bob
2    Charlie
Name: Name, dtype: object
类似于字典的行结构：

你也可以将 DataFrame 的每一行看作一个字典（如果你使用 to_dict 方法将其转换），其中行索引是键，行数据是值。
例如，将 DataFrame 转换为字典：


row_dict = df.to_dict(orient='index')
print(row_dict)
这将输出：
{0: {'Name': 'Alice', 'Age': 25, 'City': 'New York'},
 1: {'Name': 'Bob', 'Age': 30, 'City': 'Los Angeles'},
 2: {'Name': 'Charlie', 'Age': 35, 'City': 'Chicago'}}
DataFrame 的优势
相比于字典，DataFrame 提供了更强大的功能：

向量化运算：DataFrame 允许你对数据进行高效的向量化操作，而不必编写复杂的循环。
数据选择与过滤：你可以根据条件轻松地过滤数据，并且 DataFrame 支持基于标签的选择。
数据合并与连接：DataFrame 支持各种数据合并和连接操作，类似于 SQL 中的 JOIN。
缺失数据处理：DataFrame 有内置的缺失数据处理功能，可以轻松处理 NaN 等缺失值。
数据聚合：通过 groupby 等方法，你可以对数据进行复杂的聚合操作。
结论
虽然 DataFrame 可以在某些方面与字典类比，但它远不止是一个简单的字典。DataFrame 是一个多维的、带有标签的数据结构，专门为高效处理和分析大规模数据而设计。如果你需要处理表格数据，DataFrame 是一个非常强大的工具，比字典更适合此类任务。
```

#### Series and Dataframes

Series = column 列

Dataframes = 表格



`Series.mean()`取平均值

`Series.max()`取最大值

`Data[""]`从Dataframes取Series

`Data.to_dict()`转字典

`data.condition`查看列所有数据

`data[data.day == 'Monday']` 获得行的数据



取出行后依然可以用series取column的值

```
monday = data[data.day == "Monday"]
print(monday.temp)
# 取出特定的数值
monday[0] 

```



创建DataFrame

```
# 把创建后的数据传进去就行了
pandas.DataFrame(data_dict)
```

存储数据时, dict的格式是 列标签->列字段的格式, 如下,

```python

grey_squirrel = data[data["Primary Fur Color"] == "Gray"]
gray_squirrel_count = grey_squirrel["Unique Squirrel ID"].count()
cinnamon_squirrel = data[data["Primary Fur Color"] == "Cinnamon"]
cinnamon_squirrel_count = cinnamon_squirrel["Unique Squirrel ID"].count()
black_squirrel = data[data["Primary Fur Color"] == "Black"]
black_squirrel_count = black_squirrel["Unique Squirrel ID"].count()

# Gray: gray counts, Black : black_counts ...
data_dict = {
    "Fur Color":["Gray","Black","Cinnamon"],
    "Counts": [gray_squirrel_count,black_squirrel_count,cinnamon_squirrel_count]
}

pandas.DataFrame(data_dict).to_csv("new_squirrel.csv")


Example Output:
,Fur Color,Counts
0,Gray,2473
1,Black,103
2,Cinnamon,392

```



`item()`Return the first element of the underlying data as a Python scalar.

## Dictionary Comprehension and Dict Comprehension

#### List Comprehension

- Basic

`new_list = [new_item for item in list]`

ex:

```python
numbers = [1,2,3]
new_numbers = [n+1 for n in numbers]
```

- Python sequences - list, str, tuple, range

Range:

`range_list = [item * 2 for item in range(1,5)]`

- Condition
  - only add new_item if the test is true

`new_list = [new_item for item in list if test]`

Ex:

`short_names = [name for name in names if len(name) < 5]`

`new_upper_names_list = [name.upper() for name in names if len(name)>5]`



## Dictionary Comprehension

- 基本款, 不需要处理value

`new_dict = {new_key:new_value for item in list}`

ex

`student_score = {student: random.randint(1, 100) for student in names}`

- 通过item()去遍历所有的key和value, 用于对value进行处理

`new_dict = {new_key:new_value for (key,value) in dict.item()}`

Ex:

`passed_student = {student: score for (student, score) in student_score.items() if score > 40}`

- if condition

`new_dict = {new_key:new_value for (key,value) in dict.item() if test}`



#### Pandas Dataframes Loop - *iterrows*

```python
#For Loop
numbers = [1, 2, 3]
new_list = []
for n in numbers:
    add_1 = n + 1
    new_list.append(add_1)

#List Comprehension
new_list = [n + 1 for n in numbers]

#String as List
name = "Angela"
letters_list = [letter for letter in name]

#Range as List
range_list = [n * 2 for n in range(1, 5)]

#Conditional List Comprenhension
names = ["Alex", "Beth", "Caroline", "Dave", "Elanor", "Freddie"]
short_names = [name for name in names if len(name) < 5]

upper_case_names = [name.upper() for name in names if len(name) > 4]

#Dictionary Comprehension
import random
student_grades = {name: random.randint(1, 100) for name in names}
print(student_grades)

passed_students = {
    student: grade
    for (student, grade) in student_grades.items() if grade >= 60
}
print(passed_students)


```

- 解答::

```python
#在处理 Pandas DataFrame 时，iterrows() 和 items() 是两种不同的迭代方法，它们适用于不同的用途。这里解释为什么在循环遍历 DataFrame 行时通常使用 iterrows() 而不是 items()。

iterrows() vs items()：
iterrows():

#iterrows() 是 Pandas 提供的一种方法，用于逐行迭代 DataFrame。
#它返回一个元组，其中第一个元素是行索引，第二个元素是包含行数据的 Pandas Series 对象。
#典型用法：

for index, row in df.iterrows():
    print(index, row['column_name'])
iterrows() 是用来逐行遍历 DataFrame 的标准方法，适用于需要按行处理数据的情况。
items():

#items() 用于逐列迭代 DataFrame。它返回一个元组，其中第一个元素是列名，第二个元素是包含该列数据的 Pandas Series 对象。
典型用法：

for column_name, column_data in df.items():
    print(column_name, column_data)

#items() 适合逐列处理数据的情况，而不是逐行处理数据。
#为什么迭代 DataFrame 行时使用 iterrows()：
#迭代的粒度：
#iterrows() 是逐行迭代的，而 items() 是逐列迭代的。通常在处理数据时，逐行处理是更常见的需求。例如，你可能需要对每一行的数据进行某种计算、转换或判断，这时逐行处理（使用 iterrows()）更合适。
# 操作的方便性：
# 使用 iterrows() 时，每一行的数据都会被封装在一个 Series 对象中，可以方便地通过列名访问该行中的数据。而使用 items() 则更适合在需要对整个列进行操作时使用。
# 兼容性：
# iterrows() 生成的 Series 对象更容易与 Pandas 的其他操作兼容。因为 Series 是 Pandas 的基本数据结构之一，它提供了丰富的方法和属性，可以很方便地操作行数据。
# 何时使用 items()：
# 如果你需要对 DataFrame 的每一列进行处理，而不是每一行，可以考虑使用 items()，例如：

for column_name, column_data in df.items():
    print(f"Processing column: {column_name}")
    # 进行某种列操作
# 当你希望逐列处理数据并且每次操作一整列数据时，items() 是更合适的选择。

#总结
#iterrows()：用于逐行遍历 DataFrame，适合需要按行处理数据的情况。
#items()：用于逐列遍历 DataFrame，适合需要按列处理数据的情况。
#所以，在遍历 DataFrame 的行时，我们更常用 iterrows()，因为它直观且直接提供了行数据，而 items() 更适合逐列操作。
```

#### Trainning Project

```
# TODO 1. Create a dictionary in this format:
# {"A": "Alfa", "B": "Bravo"}
nato_pandas = pandas.read_csv("nato_phonetic_alphabet.csv")

nato_dict = {row.letter: row.code for (index, row) in nato_pandas.iterrows()}

# TODO 2. Create a list of the phonetic code words from a word that the user inputs.
user_name = input("What's your name?")
# 可以用 dict的特殊功能来转换
user_name_list = [nato_dict[letter.upper()] for letter in user_name]
print(user_name_list)
```

## Day- 27 Tkinter

Doc: https://docs.python.org/3/library/tkinter.html#the-packer

TLC DOc = https://tcl.tk/man/tcl8.6/TkCmd/pack.htm

#### Basic

```
window = tkinter.Tk()
window.title("")
window.minisize(width=50,height=70)
```



#### Label

```
label_1 = tkinter.Label(text="This is a label",font=("Arial",27,"bold"))
```

#### Pack

```
label.pack()
```

#### Advanced Arguments

##### Default values

- Argument with default values:

```
# The a, b, c has been setting the default value
def function(a=1,b=2,c=3):
        expression a + b * c
```

##### Unlimited args

- Many positional arguments

*args 是把所有的参数组合成一个tuple

```
# * represent to take any number of argument in function
def add(*args):
    for n in args:
        print(n)
```

```python
def add(*args):
        print(args[0])
    total = 0
    for num in args:
        total += num
    return total

```

- Many keyword arguments

**kwargs 是把所有参数组合成一个key:value的dictionary

```
def calculate(**kwargs):
    print(type(kwargs))
    for key, value in kwargs.items():
        print(key)
        print(value)
    new_dict = {key: value + 1 for (key, value) in kwargs.items()}
```

```
class Car:
    def __init__(self, **kwargs):
        self.make = kwargs["make"]
        # Get method 如果无法获得对应的字典信息, 就会返回null
        self.model = kwargs.get("model")
```

理想的多参数创建方法

```
class Car:
    def __init__(self, **kwargs):
        self.make = kwargs.get("make")
        self.model = kwargs.get("model")
        self.color = kwargs.get("color")
```

在Python中，`*args` 和 `**kwargs` 是用于传递可变数量的参数的两种不同的方式。下面分别解释 `*args` 和 `**kwargs` 的含义和用法：

`*args`

- `*args` 用于将**任意数量的非关键字参数**传递给一个函数。
- 在函数定义中，`*args` 前面的星号（`*`）表示将传入的多个位置参数（即非关键字参数）打包成一个元组传递给函数。
- 在函数内部，你可以像访问元组那样访问这些参数。

**示例：**

```
python
复制代码
def example_function(*args):
    for arg in args:
        print(arg)

example_function(1, 2, 3, 4)
```

**输出：**

```
python
复制代码
1
2
3
4
```

在这个例子中，`example_function` 可以接受任意数量的参数，所有这些参数会被打包成一个元组 `args`，然后你可以迭代访问它们。

`**kwargs`

- `**kwargs` 用于将**任意数量的关键字参数**传递给一个函数。
- 在函数定义中，`**kwargs` 前面的双星号（`**`）表示将传入的多个关键字参数打包成一个字典传递给函数。
- 在函数内部，你可以像访问字典那样访问这些参数。

**示例：**

```
python
复制代码
def example_function(**kwargs):
    for key, value in kwargs.items():
        print(f"{key}: {value}")

example_function(name="Alice", age=30, location="Wonderland")
```

**输出：**

```
python
复制代码
name: Alice
age: 30
location: Wonderland
```

在这个例子中，`example_function` 可以接受任意数量的关键字参数，所有这些参数会被打包成一个字典 `kwargs`，然后你可以迭代访问它们。

总结

- **`\*args`** 用于接收任意数量的位置参数，并将它们打包为一个元组传递给函数。
- **`\**kwargs`** 用于接收任意数量的关键字参数，并将它们打包为一个字典传递给函数。

这两种方式都提供了处理函数参数的灵活性，可以让函数接受不同数量和类型的参数。

##### Button & Entry

command 可以为 onClick的监听事件, 传函数进去,但不要加()

```
def handle_button_click():
    label_1.config(text="New label") if label_1["text"] == "Button Got Clicked" else label_1.config(text="Button Got Clicked")


# Button
button = Button(text="Click Me", command=handle_button_click)
button.pack()
```

ENTRY

```
def handle_button_click():
    value = input.get()
    label_1.config(text=value)


# Button
button = Button(text="Click Me", command=handle_button_click)
button.pack()

# Entry
input = Entry(width=10)
input.pack()
```

##### text&spinbox&scale&checkbutton&radio button&listbox

```
from tkinter import *

#Creating a new window and configurations
window = Tk()
window.title("Widget Examples")
window.minsize(width=500, height=500)

#Labels
label = Label(text="This is old text")
label.config(text="This is new text")
label.pack()

#Buttons
def action():
    print("Do something")

#calls action() when pressed
button = Button(text="Click Me", command=action)
button.pack()

#Entries
entry = Entry(width=30)
#Add some text to begin with
entry.insert(END, string="Some text to begin with.")
#Gets text in entry
print(entry.get())
entry.pack()

#Text
text = Text(height=5, width=30)
#Puts cursor in textbox.
text.focus()
#Adds some text to begin with.
text.insert(END, "Example of multi-line text entry.")
#Get's current value in textbox at line 1, character 0
print(text.get("1.0", END))
text.pack()

#Spinbox
def spinbox_used():
    #gets the current value in spinbox.
    print(spinbox.get())
spinbox = Spinbox(from_=0, to=10, width=5, command=spinbox_used)
spinbox.pack()

#Scale
#Called with current scale value.
def scale_used(value):
    print(value)
scale = Scale(from_=0, to=100, command=scale_used)
scale.pack()

#Checkbutton
def checkbutton_used():
    #Prints 1 if On button checked, otherwise 0.
    print(checked_state.get())
#variable to hold on to checked state, 0 is off, 1 is on.
checked_state = IntVar()
checkbutton = Checkbutton(text="Is On?", variable=checked_state, command=checkbutton_used)
checked_state.get()
checkbutton.pack()

#Radiobutton
def radio_used():
    print(radio_state.get())
#Variable to hold on to which radio button value is checked.
radio_state = IntVar()
radiobutton1 = Radiobutton(text="Option1", value=1, variable=radio_state, command=radio_used)
radiobutton2 = Radiobutton(text="Option2", value=2, variable=radio_state, command=radio_used)
radiobutton1.pack()
radiobutton2.pack()


#Listbox
def listbox_used(event):
    # Gets current selection from listbox
    print(listbox.get(listbox.curselection()))

listbox = Listbox(height=4)
fruits = ["Apple", "Pear", "Orange", "Banana"]
for item in fruits:
    listbox.insert(fruits.index(item), item)
listbox.bind("<<ListboxSelect>>", listbox_used)
listbox.pack()
window.mainloop()


```

#### Layout and Position

Pack , Place, Grid

`tkinter` 提供了三种主要的布局管理器：`pack`、`place` 和 `grid`。它们用于控制窗口中小部件（如按钮、标签等）的布局方式。每种布局管理器都有不同的特性和适用场景。

1. `pack` 布局管理器

`pack` 是最简单的布局管理器，它根据你提供的方向，将小部件按顺序排列。`pack` 管理器不需要指定具体的坐标，而是根据参数将小部件填充到容器（如窗口）中。

**主要选项：**

- `side`: 指定小部件应该放置在容器的哪一侧，取值为 `top`、`bottom`、`left` 或 `right`。
- `fill`: 指定是否和如何填充容器的可用空间，取值为 `NONE`（默认）、`X`（水平填充）、`Y`（垂直填充）或 `BOTH`（水平和垂直填充）。
- `expand`: 如果设置为 `True`，则在容器中有空闲空间时扩展小部件以填满空间。

**示例：**

```
python
复制代码
import tkinter as tk

root = tk.Tk()

button1 = tk.Button(root, text="Button 1")
button1.pack(side="top", fill="x")

button2 = tk.Button(root, text="Button 2")
button2.pack(side="bottom", fill="x")

root.mainloop()
```

**特点：**

- `pack` 适用于简单的布局管理。

- 容易理解和使用，但对于复杂的布局可能不够灵活。
2. `place` 布局管理器

`place` 布局管理器允许你通过指定绝对坐标或相对坐标来精确控制小部件的位置和大小。它提供了最精确的布局控制方式。

**主要选项：**

- `x` 和 `y`: 小部件左上角的绝对坐标。
- `relx` 和 `rely`: 小部件左上角的相对坐标（相对于容器的宽度和高度，取值范围为 0.0 到 1.0）。
- `width` 和 `height`: 小部件的绝对宽度和高度。
- `relwidth` 和 `relheight`: 小部件的相对宽度和高度（相对于容器的宽度和高度，取值范围为 0.0 到 1.0）。

**示例：**

```
python
复制代码
import tkinter as tk

root = tk.Tk()

button1 = tk.Button(root, text="Button 1")
button1.place(x=50, y=100)

button2 = tk.Button(root, text="Button 2")
button2.place(relx=0.5, rely=0.5, anchor="center")

root.mainloop()
```

**特点：**

- `place` 提供了对小部件位置和大小的最大控制。

- 适用于需要精确布局的小部件。

- 由于需要手动计算坐标和大小，可能在窗口大小调整时不太灵活。
3. `grid` 布局管理器

`grid` 是最灵活的布局管理器之一，它允许你将容器划分为行和列，然后将小部件放置在特定的单元格中。`grid` 非常适合构建表格或网格状布局。

**主要选项：**

- `row` 和 `column`: 小部件放置的行号和列号（从 0 开始）。
- `rowspan` 和 `columnspan`: 小部件跨越的行数和列数。
- `sticky`: 指定如果单元格比小部件大，小部件应如何对齐，取值可以是 `N`, `S`, `E`, `W` 的任意组合。

**示例：**

```
python
复制代码
import tkinter as tk

root = tk.Tk()

label1 = tk.Label(root, text="Label 1")
label1.grid(row=0, column=0)

label2 = tk.Label(root, text="Label 2")
label2.grid(row=0, column=1)

button = tk.Button(root, text="Button")
button.grid(row=1, column=0, columnspan=2, sticky="we")

root.mainloop()
```

**特点：**

- `grid` 适合创建表格布局或其他需要按行列排列的小部件。
- 非常灵活，可以轻松地管理复杂布局。
- 比 `pack` 更适合多控件的复杂布局，但比 `place` 简单。

总结

- **`pack`**: 适用于简单的布局，按顺序排列小部件。使用简单但不太灵活。
- **`place`**: 提供了最大程度的控制，可以精确指定小部件的大小和位置，适用于需要精确布局的场景。
- **`grid`**: 非常灵活，适合创建表格或网格布局，在管理复杂布局时非常有用。

##### Padding

```
window.config(padx=20,pady=20)
```



## Day-28 Event Driven



#### after

在 `tkinter` 中，`after` 方法是一个非常有用的工具，它用于在指定的时间后执行一个回调函数，或者可以用来创建重复调用的定时器。

- **`after` 方法的基本用法**

`after` 方法的基本形式如下：

```
widget.after(ms, func=None, *args)
```

- **`ms`**: 一个整数，表示延迟的时间，单位是毫秒（1000 毫秒 = 1 秒）。

- **`func`**: 一个可选的函数引用。当指定的时间 `ms` 过去后，这个函数将被调用。如果不传递这个参数，`after` 方法就相当于创建一个延迟，它会暂停程序执行指定的时间，然后继续运行后面的代码。

- **`\*args`**: 传递给 `func` 的额外参数。

- 用途 1: 延迟执行函数

你可以使用 `after` 来安排某个函数在一段时间后执行。例如：

```
import tkinter as tk

def say_hello():
    print("Hello, world!")

root = tk.Tk()
root.after(2000, say_hello)  # 2秒后执行say_hello函数
root.mainloop()
```

在这个例子中，`say_hello` 函数将在 2000 毫秒（2 秒）后被调用，并且输出 "Hello, world!"。

- **用途 2: 创建定时器或重复任务**

`after` 还可以用来创建一个重复执行的任务。例如，如果你想让一个函数每隔一段时间重复执行一次，你可以这样做：

```
python
复制代码
import tkinter as tk

def update_label():
    current_text = label.cget("text")
    new_text = int(current_text) + 1
    label.config(text=str(new_text))
    root.after(1000, update_label)  # 1秒后再次调用update_label

root = tk.Tk()

label = tk.Label(root, text="0")
label.pack()

update_label()  # 开始定时更新

root.mainloop()
```

在这个例子中，`update_label` 函数每隔 1 秒被调用一次，并且每次都会更新标签的文本，标签中的数字会每秒增加 `1`。

-用途 3: 延迟执行某段代码

你也可以使用 `after` 来简单地延迟代码的执行，而不调用特定的函数：

```
python
复制代码
root.after(5000)  # 延迟5秒
```

这将在主循环中延迟 5000 毫秒（5 秒）之后继续执行后面的代码。

- 总结

`tkinter` 的 `after` 方法主要用于以下几个场景：

- **延迟执行**：在指定的时间后执行一个函数。
- **定时器**：创建一个重复调用的定时器，用于定时更新界面或执行某些任务。
- **延迟暂停**：使程序暂停指定的毫秒数，然后继续执行。

这个方法非常适合用于动画、定时器、周期性任务以及在某些操作完成后自动执行后续操作的场景。

## Day-28

#### Dynamic typing

https://stackoverflow.com/questions/11328920/is-python-strongly-typed

#### _在循环中的用法:

在 Python 中，变量名 `_` 有一些特殊的用法。具体到你提到的代码片段：
    python
    复制代码
    for _ in range(math.floor(reps/2)):

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

    try: # something that might cause exception
    
    except # Do this if there was exception
    
    else # Do this if there were no exception
    
    finally # Do this no matter what happened
    
    try:
        file = open("file_do_not_exist.txt")
    except:
        file = open("file_do_not_exist.txt","w")
        file.write("Something")

`except`will ignore all errors
    try:
        file = open("file_do_not_exist.txt")
    except FileNotFoundError:
        file = open("file_do_not_exist.txt","w")
        file.write("Something")

#### Raise your own Exception

    #BMI Example
    
    height = float(input("Height: "))
    weight = int(input("Weight: "))
    
    if height > 3:
        raise ValueError("Human Height should not be over 3 meters.")
    
    bmi = weight / height ** 2
    print(bmi)

#### Json Liburary

Save:存储语句
    json.dump(new_data,file,indent=4)

Load: Convert json into dictionary
    with open("data.json","r") as file:
        data = json.load(file)

Update:
    with open("data.json","w") as file:
        # Reading old data
        data = json.load(file)
        # Updating old data wiht new data
        data = data.update(new_data)
        # Saving the update data
        json.dump(data, file, indent=4)

## Day32-SMTP&DateTime

Doc:https://docs.python.org/3/library/smtplib.html

#### SMTP Provider

`smtp.gmail.com` - gmail

`smtp.live.com` - hotmail

`smtp.mail.yahoo.com` - yahoo
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

#### DateTime

引入包

`import datetime as dt`

防止后面混淆

使用方法 `dt.datetime.method()`
    # get the current time
    now = dt.datetime.now()

    #2024-08-26 23:20:03.298596

now 返回了一个datetime对象, 支持多种方法
    year = now.year
    month = now.month

    day_of_week = now.weekday()

* Set Datetime
    date_of_birth = dt.datetime(year=1995,month=12,day=15)

* ex
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

可以用tuple做为key
    data = {(row["month"].row["day"]):row for (key,row) in birthday_info.iterrows()}

#### Host on the cloud

Python anywhere

https://www.pythonanywhere.com/

## API

#### Intro

https://en.wikipedia.org/wiki/API

#### API End point

* know the end point

* make a request
    import requests
    response = requests.get(url="http://api.open-notify.org/iss-now.json")

Status code

`response.status_code`

#### requests module

https://docs.python-requests.org/en/latest/

* Json format
    data = response.json()
    longitude = data["iss_position"]["longitude"]
    latitude = data["iss_position"]["latitude"]
    position = (latitude,longitude)

#### Kanye rest

https://kanye.rest/

#### API Parameters

dict to save params, send it into params
    parameters = {
        "amount":10,
        "type":"boolean",
    }

    response = requests.get("https://opentdb.com/api.php",params=parameters)
    response.raise_for_status()

https://sunrise-sunset.org/api

#### Unescapting

https://www.w3schools.com/html/html_entities.asp
    import html
    q_text = html.unescape(self.current_question.text)

#### DataType

用`:`来定义, 保证该类型为约定类型
    def __init__(self, quiz_brain:QuizBrain)

使用说明
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

Type Hint:
    def greeting(name:str)->str:
        return "hello" + name

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

* Security

如何存储environment variable

`export AUTH_KEY = xxxxx`

如何获得environment variable

`os.environ.get("OWN_API_KEY")`

## API List

https://apilist.fun/

#### Pixela

https://pixe.la/

#### POST

    pixela_endpoint = "https://pixe.la//v1/users"
    user_payload = {
        "token": "dakdaldngn182jff",
        "username": "zhuang",
        "agreeTermsOfService": "yes",
        "notMinor": "yes",
    }
    response = requests.post(url=pixela_endpoint,json=user_payload)

#### Request-header

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

#### Date Format

String format time:

`datatime.strftime('%Y%m%d')`

https://www.w3schools.com/python/python_datetime.asp

#### Env Object

https://www.geeksforgeeks.org/python-os-environ-object/
    # importing os module  
    import os 

    # Method 1 
    print("MY_HOME:", os.environ.get('MY_HOME', "Environment variable does not exist")) 

    # Method 2 
    try: 
        print("MY_HOME:", os.environ['MY_HOME']) 
    except KeyError:  
        print("Environment variable does not exist")

使用列表推导式时，通常是为了简化代码或生成一个新列表，但当涉及条件判断和对原始数据的就地修改时，列表推导式可能会变得复杂且难以阅读。特别是当代码中的意图是修改现有的数据结构而不是创建新的列表时，传统的 `for` 循环更清晰明了。

#### [How to create a DateTime equal to 15 minutes ago?]

https://stackoverflow.com/questions/4541629/how-to-create-a-datetime-equal-to-15-minutes-ago/4541668

#### Split() method

https://www.w3schools.com/python/ref_string_split.asp

## WebScraping

#### Beautiful soup

HTML parser
    from bs4 import BeautifulSoup
    with open("website.html", "r") as file:
        text = file.read()


    soup = BeautifulSoup(text,'html.parser')
    print(soup.title)

#### Syntax

`sout.<tag>`

`soup.title.name`显示组件名字

`soup.title.string`显示组件内容

`soup.prettify()`打印出带缩进的html内容

#### Get tag

    anchor_tag = soup.find_all(name="a")
    
    for tag in anchor_tag:
        print(tag.getText())

Get attribute
    tag.get("href")

Find method

Find the first element
    heading = soup.find(name='h1',id='name')

class

because the class is inbuild element in python, so if you want to find the specfic class using

`class_`

#### Narrow down

Using css nested to narrow down the specfic element:
    company_url = soup.select_one(selector="p a")
    name = soup.select_one(selector="#name")
    headings = soup.select(selector=".heading")

#### Get text

`getText` 会递归地获取所有子标签中的文本，所以它能够正确地获取 `<a>` 标签内的文本。

#### find & selector区别

`find` 和 `find_all` 方法

* **用途**: `find` 用于查找第一个符合条件的元素，而 `find_all` 用于查找所有符合条件的元素。
* **参数**:
  * `name`: 标签名，如 `'span'`, `'a'`, `'div'` 等。
  * `attrs`: 可以通过字典的形式传递属性，如 `{'class': 'my-class'}`。
  * `text`: 用于查找包含特定文本的标签。
  * `recursive`: 是否递归查找子元素，默认为 `True`。
* **优点**:
  * 语法简单、直观，适合查找单一标签或特定属性的元素。
  * 适用于明确知道要查找的元素类型或特定属性时。
* **缺点**:
  * 在复杂的选择条件下，不如 CSS 选择器灵活。
  * 查找某些嵌套结构时，可能需要多个 `find` 或 `find_all` 的嵌套。

`select` 和 `select_one` 方法

* **用途**: `select` 使用 CSS 选择器语法来查找元素，类似于 jQuery 的选择器。`select_one` 用于查找第一个匹配的元素。
* **参数**:
  * 接受一个 CSS 选择器字符串，可以是标签、类、ID、属性、伪类等的组合。
* **优点**:
  * 使用 CSS 选择器，语法灵活，适合复杂的选择条件。
  * 可以轻松查找嵌套的元素，如 `div > span > a` 这样的结构。
  * 能够同时使用类、ID、属性等选择条件。
* **缺点**:
  * 对于不熟悉 CSS 选择器的人来说，可能会稍显复杂。
  * 对于非常简单的查找操作，可能会显得多余。

#### 链式调用

在 BeautifulSoup 中，你可以通过链式调用来访问嵌套的标签，但是这种方式仅适用于你确实知道 HTML 结构并且这些标签都存在的情况下。也就是说，如果你写 `line.span.a.span`，这意味着你期望 `line` 包含一个 `span` 标签，这个 `span` 标签又包含一个 `a` 标签，而 `a` 标签里面还有一个 `span` 标签。如果这些标签的层级结构存在，那么这个链式调用是有效的。

#### Adding Headers

当你需要越过机器人验证时, When making a request to Amazon or any website, your browser will send some additional data along with the request. Typically this will be information regarding what browser you are using, what computer you have, and what your preferred language is. This information is included in the **headers**. By using the headers, Amazon's server can respond with the right website for your region and your language.

1. See the headers that your own browser is sending by going to this website:

http://myhttpheader.com/

Try different browsers (e.g., Chrome, Brave, Firefox, Safari) and see how the headers change. Here's what I see:

![img](https://img-c.udemycdn.com/redactor/raw/article_lecture/2024-07-10_16-01-14-722daf274c04cc43e33e0370d79c5fc8.png)

There you can see my language settings and that I used a Mac computer to make the request.

* Add the headers to your code

**Why would you want to do this?**

If you pass some headers along then Amazon's servers can give you the instant pot page in your language and also in your currency.

Also, it will make your request look (slightly) more human and less like a bot. Why? Headers include data that is sent over by a browser rather than a script. And many web servers like Amazon's may block requests they think originate from bots.

At the moment we are making a request without adding any headers:
    response = requests.get("https://www.udemy.com/")

Here's how you can pass some headers alongside your requests:
    response = requests.get("https://www.udemy.com/", headers={"Accept-Language":"en-US"})

Here is more detailed information on how you pass headers with the requests library:

https://stackoverflow.com/questions/6260457/using-headers-with-the-python-requests-librarys-get-method

Add some headers to your request in the main.py. At minimum add the `User-Agent` and `Accept-Language`. At most copy the full header from https://httpbin.org/headers (excluding the `host` and `X-Amzn-Trace-id`)

## Selenium Webdriver

#### selenium driver

the bridge between selenium and browroser
    from selenium import webdriver

    # Keep website open
    chrome_option = webdriver.ChromeOptions()
    chrome_option.add_experimental_option('detach',True)

    # Automation opent the website
    driver = webdriver.Chrome(options=chrome_option)
    driver.get('https://o.pandalow.com')

* How to quit
    driver.quit() # quit the Browser
    driver.close() # close the tab page

#### Find element locate

Selenium 可以直接调用浏览器, 所以不需要传入任何headers的参数来实现爬取网络信息
    whole_price = driver.find_element(By.CLASS_NAME,value='a-price-whole')
    fraction_price = driver.find_element(By.CLASS_NAME,value='a-price-fraction')

    print(f"There is price : {whole_price.text}.{fraction_price.text}")

    driver.quit()

#### Find form

    input_area = driver.find_element(By.NAME,value='q')
    input_area.get_attribute("placeholder")

#### By Css Selector

    driver.find_element(By.CSS_SELECTOR,value='.documentation-widget a')

#### By Xpath

使用chrome的开发者工具就能获得xpath了


    driver.find_element(By.XPATH, value = '//*[@id="tabs--1-tab-4"]/span')

#### Interaction

Click
    article_count = driver.find_element(By.XPATH,'//*[@id="articlecount"]/a[1]')
    # article_count.click()
    portals_link = driver.find_element(By.LINK_TEXT,'Content portals')
    portals_link.click()

Type
    search_area = driver.find_element(By.NAME,'search')
    search_area.send_keys('Python',Keys.ENTER)

#### Window handle

1. The Facebook login page opens in a new window. In order for our selenium code to work on the new window, we have to switch to the window in front.

In Selenium, each window has a identification handle, we can get all the window handles with:
    driver.window_handles

The above line of code returns a list of all the window handles. The first window is at position 0 e.g.
    base_window = driver.window_handles[0]

New windows that have popped out from the base_window are further down in the sequence e.g.
    fb_login_window = driver.window_handles[1]

We can switch our Selenium to target the new facebook login window by:
    driver.switch_to.window(fb_login_window)

You can print the driver.title to verify that it's the facebook login window that is currently target:
    print(driver.title)

The full code to switch to the new pop-up window is thus:
    base_window = driver.window_handles[0]fb_login_window = driver.window_handles[1]driver.switch_to.window(fb_login_window)print(driver.title)

If successful the printed title should be "Facebook" and not "Tinder | Match. Chat. Date."

2. Using what you have learnt about Selenium, fill in the Facebook login form and submit it to log in.

![img](https://img-c.udemycdn.com/redactor/raw/2020-08-21_15-33-57-3f82315199d6c26b232010d4be600fd1.png)

NOTE: Avoid invoking the Facebook Login too frequently, see if you can test your code without logging in, you don't want to appear like a bot to Facebook as there is always the chance that they might disable your FB account. Alternatively, you can try setting up an alternative Facebook account.

If successful, you should see the pop-up window disappear and you're back on the Tinder page. e.g.

![img](https://img-c.udemycdn.com/redactor/raw/2020-08-21_15-36-03-c39aaf979df1854cc259aebafd8a2ae7.png)

3. At this point, you should revert back to the base_window and verify by printing the title of the Selenium controlled window title.
    driver.switch_to.window(base_window)print(driver.title)

If successful, it should print "Tinder | Match. Chat. Date."

## WebDevelopment

Client Server Database

#### Flask

https://pypi.org/project/Flask/

* Quick Start Doc

https://flask.palletsprojects.com/en/3.0.x/quickstart/

* Library vs Frame Work

https://anarsolutions.com/libraries-vs-frameworks/#:~:text=To%20make%20it%20even%20simpler,have%20to%20follow%20the%20blueprint.

Library 是个工具, FrameWork是有规则需要遵守

#### Start Server

    from flask import Flask
    
    app = Flask(__name__)
    
    @app.route("/")
    def hello_world():
        return "<p>Hello, World!</p>"

Running
    $ flask --app hello run
     * Serving Flask app 'hello'
     * Running on http://127.0.0.1:5000 (Press CTRL+C to quit)

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

* Built in Type

definition.**__name__**

The name of the class, function, method, descriptor, or generator instance.

在 Python 中，`__name__` 是一个内置变量，它的值取决于当前模块的执行方式：

1. 如果模块是被直接运行的（如执行脚本），`__name__` 的值是 `"__main__"`。
2. 如果模块是被导入到其他模块中执行的，`__name__` 的值就是模块的名字。

因此，`__name__ == "__main__"` 常用于检查代码是否是直接运行的，帮助控制代码的执行逻辑，避免在模块被导入时执行不必要的代码。

在 Python 中，`__main__` 是指执行 Python 文件时的上下文。当脚本被直接运行时，特殊变量 `__name__` 被设置为 `"__main__"`。这让你能够区分脚本是直接运行还是被另一个脚本作为模块导入。

例如：
    python
    复制代码
    if __name__ == "__main__":
        # 只有当脚本直接执行时，这段代码才会运行
        main()

这段代码确保只有在脚本被直接执行时，特定的代码才会运行，而不会在导入为模块时执行。

在 `Flask(__name__)` 语句中，`__name__` 并不总是等于 `"__main__"`。`__name__` 的值取决于该模块是如何执行的：

* 如果这个 Flask 应用是直接运行的主程序，`__name__` 就等于 `"__main__"`。
* 如果这个 Flask 应用被另一个模块导入，`__name__` 就会是模块的名称（比如 `app` 或其他模块名称）。

`Flask(__name__)` 使用 `__name__` 是为了告诉 Flask 当前模块的上下文，用于寻找静态文件、模板等。

在 Python 中，当你导入一个模块时，可以通过 `__name__` 来判断该模块的名称。你可以在模块内部使用 `__name__` 来了解该模块是被导入的，还是作为主程序执行的。

例如，假设有一个名为 `module_example.py` 的模块：
    # module_example.py

    print(f"The name of this module is: {__name__}")

如果你直接运行这个文件，`__name__` 将输出 `"__main__"`，因为这是主程序。如果你在另一个文件中导入它，如：
    import module_example

那么 `__name__` 会输出 `"module_example"`，这是该模块的名称。

#### *@Sign - Python Decorators* IMPORTANT!!

Python 装饰器, 在原有function上, 增加新的功能

https://pythontutor.com/visualize.html#mode=edit

* pass function

* nested function
  
  * 可以在一个function中建一个新的function, 同时不要忘记调用该function

* return function

* decorator function
    def decorator_function(function):
  
        def wrapper_function():
                function()
      return wrapper_function

**@Sign 可以自动捕获该decorator_function并执行 - 语法糖**
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

* Basic knowledge
  
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
  
  

* Challenge
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

#### Flask URLS & Converter

Variable Rules

* You can add variable sections to a URL by marking sections with `<variable_name>`. Your function then receives the `<variable_name>` as a keyword argument.

* Optionally, you can use a converter to specify the type of the argument like `<converter:variable_name>`.

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

Converter types:

| `string` | (default) accepts any text without a slash |
| -------- | ------------------------------------------ |
| `int`    | accepts positive integers                  |
| `float`  | accepts positive floating point values     |
| `path`   | like `string` but also accepts slashes     |
| `uuid`   | accepts UUID strings                       |

#### Debug Mode

    if __name__ == '__main__':
        app.run(debug=True)

#### Rendering Html

在返回时加上标签
    @app.route('/<name>')
    def print_name(name):
        return f'<h1>{name}</h1>'

#### Advanced Decorators

Decorator 可以在warpper里接受args和kargs作为附加参数
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

#### Rendering Template

    from flask import Flask,render_template
    
    app = Flask(__name__)
    
    @app.route('/')
    def home():
        return render_template("angela.html")

get template: https://html5up.net/

一个重要命令: document.body.contentEditable=true 支持你直接编辑网页的内容

https://unsplash.com/ 找背景图片

#### JINJIA Template

Jinja in Python is similar to Java's JSP (JavaServer Pages). Both are template engines used to generate dynamic web pages by embedding code within HTML. In Jinja, you use Python expressions and control structures within the HTML, while in JSP, you embed Java code. Both allow for rendering templates with data passed from the backend, helping create dynamic, data-driven web pages.
    <h1>{{5*6}}</h1>
    <h2>
      {{num}}
    </h2>

    @app.route('/')
    def home():
        random_number = random.randint(0,10)
        return render_template('index.html',num=random_number)

#### Multiline with JINja

    <body>
        {% for article in blog:%}
        <h1>{{article.title}}</h1>
        <h2>{{article.subtitle}}</h2>
        <p>{{article.body}}</p>
        {% endfor %}
    </body>

#### Url build

`<a href="{{ url_for('blog',num=3)}}">Go to blog</a>`

## Data classes

https://docs.python.org/3/library/dataclasses.html

`__post_init__` 是 `dataclass` 提供的一个特殊方法，它在类的默认 `__init__` 方法运行之后自动调用。你可以使用这个方法执行需要额外初始化的逻辑，比如实例化复杂对象或者处理依赖于其他字段的逻辑。

在 `dataclass` 中，字段的初始化顺序是根据定义的顺序，某些字段（如未提供初始值的）需要在 `__init__` 方法后进一步配置，因此 `__post_init__` 提供了一个机会来进行这些自定义初始化操作。

例如：
    @dataclass
    class MyClass:
        a: int
        b: int = 10

        def __post_init__(self):
            print(f"MyClass initialized with a={self.a}, b={self.b}")

这样，当你创建 `MyClass` 实例时，会首先调用默认的 `__init__`，然后自动调用 `__post_init__`。

在 `dataclass` 中，`field` 是一个函数，用来指定更详细的字段配置。你可以通过它为某个字段设定默认值、默认工厂函数（比如 `default_factory`），或是设置是否在初始化时忽略该字段（通过 `init=False`）。

在你的例子中：

* `default_factory=webdriver.ChromeOptions`：这意味着 `_chrome_option` 将使用 `webdriver.ChromeOptions()` 的返回值作为默认值。
* `init=False`：表示 `_driver` 字段不会通过 `__init__` 方法进行初始化，而需要在 `__post_init__` 或其他地方手动设置。

#### Format

在 `dataclass` 中，字段的定义通常是 "变量 + 类型注解 + 默认值" 的格式。但类型注解并不是强制的。如果你不想指定变量类型，依然可以使用 `dataclass`，只需提供变量名和默认值即可。

例如：
    from dataclasses import dataclass

    @dataclass
    class Example:
        name: str = "John"  # 带有类型注解
        age = 25            # 没有类型注解

虽然类型注解可以提高代码的可读性，并帮助 IDE 提供更好的自动补全和类型检查，但它在 Python 中是可选的。

#### HTML Forms in Flask

post method

NOTE:

The action attribute of the form can be set to `"/login"` e.g.
    <form action="/login" method="post">

or it can be dynamically generated with `url_for` e.g.
    <form action="{‌{ url_for('receive_data') }}" method="post">

Depending on where your server is hosted, the `"/login"` path may change. So it's usually a better idea to use `url_for` to dynamically generate the url for a particular function in your Flask server.

we can create a decorator in our **main.py** that will trigger a method when it receives a **POST** request:
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

Notice that the `methods` parameter accepts a **list**, so you can have **multiple** methods targeted by one route. e.g.
    @app.route("/contact", methods=["GET", "POST"]

More on this in the documentation here: https://flask.palletsprojects.com/en/2.3.x/quickstart/#http-methods

### The Request Object

The request object is documented in the API section and we will not cover it here in detail (see [`Request`](https://flask.palletsprojects.com/en/2.3.x/api/#flask.Request)). Here is a broad overview of some of the most common operations. First of all you have to import it from the `flask` module:
    from flask import request

The current request method is available by using the [`method`](https://flask.palletsprojects.com/en/2.3.x/api/#flask.Request.method) attribute. To access form data (data transmitted in a `POST` or `PUT` request) you can use the [`form`](https://flask.palletsprojects.com/en/2.3.x/api/#flask.Request.form) attribute. Here is a full example of the two attributes mentioned above:
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

What happens if the key does not exist in the `form` attribute? In that case a special [`KeyError`](https://docs.python.org/3/library/exceptions.html#KeyError) is raised. You can catch it like a standard [`KeyError`](https://docs.python.org/3/library/exceptions.html#KeyError) but if you don’t do that, a HTTP 400 Bad Request error page is shown instead. So for many situations you don’t have to deal with that problem.

To access parameters submitted in the URL (`?key=value`) you can use the [`args`](https://flask.palletsprojects.com/en/2.3.x/api/#flask.Request.args) attribute:
    searchword = request.args.get('key', '')

We recommend accessing URL parameters with get or by catching the [`KeyError`](https://docs.python.org/3/library/exceptions.html#KeyError) because users might change the URL and presenting them a 400 bad request page in that case is not user friendly.

For a full list of methods and attributes of the request object, head over to the [`Request`](https://flask.palletsprojects.com/en/2.3.x/api/#flask.Request) documentation.

### If

The if statement in Jinja is comparable with the Python if statement. In the simplest form, you can use it to test if a variable is defined, not empty and not false:
    {% if users %}
    <ul>
    {% for user in users %}
        <li>{{ user.username|e }}</li>
    {% endfor %}
    </ul>
    {% endif %}

For multiple branches, elif and else can be used like in Python. You can use more complex [Expressions](https://jinja.palletsprojects.com/en/3.0.x/templates/#expressions) there, too:
    {% if kenny.sick %}
        Kenny is sick.
    {% elif kenny.dead %}
        You killed Kenny!  You bastard!!!
    {% else %}
        Kenny looks okay --- so far
    {% endif %}

If can also be used as an [inline expression](https://jinja.palletsprojects.com/en/3.0.x/templates/#if-expression) and for [loop filtering](https://jinja.palletsprojects.com/en/3.0.x/templates/#loop-filtering).

**pldk tduk juac gjeb**

## WTForms

* **Easy Form Validation** - Makes sure the user is entering data in the required format in all the required fields. e.g. checking that the user's email entry has a "@" and a "." at the end. All without having to write your own validation code.
* **Less Code** - If you have a number of forms in your website, using WTForm can dramatically reduce the amount of code you have to write (or copy & paste).
* **Built in CSRF Protection** - CSRF stands for [Cross Site Request Forgery](https://owasp.org/www-community/attacks/csrf), it's an attack that can be made on website forms which forces your users to do unintended actions (e.g. transfer money to a stranger) or compromise your website's security if it's an admin.

Flask developers will usually choose Flask-WTF to create forms in their websites. However, in the wild, you might also see projects that are built with HTML Forms. So it's important to understand how both of them work.

#### Requirements.txt

Installing packages and the requirements.txt

The **requirements.txt** file is a file where you can specify all the dependencies (the installed packages that your project depends on) and their versions. This means that you can share your project without all the installed packages, making it a lot more lightweight. When someone downloads your project (like you have done here), the requirements.txt file tells their code editor which packages need to be installed. [Read more on this here](https://docs.google.com/document/d/e/2PACX-1vRIW_TuZ6z0ASjAoxgJgmzjGYLCDx019tKvphaTwK_Za7fnMKywUuXI0-s5wr0nQI_gprm6J6y7L9rL/pub).

#### Creating Form

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
    class LoginForm(FlaskForm):
        email = StringField(label='email', validators=[DataRequired()])
        password = StringField(label='password', validators=[DataRequired()])

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
    form.<field>.errors

https://wtforms.readthedocs.io/en/3.0.x/crash_course/#validators

Tell the form to validate

`validate_on_submit()`.
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

#### Receiving Data

With WTForms, it's even easier to get hold of the form data. All you have to do is to tap into the
    <form_object>.<form_field>.data

one thing we should check before printing the field data is whether if the form has been submitted (POST request) or if it's GET request when the form is being rendered.

Previously we used
    if request.method == "POST"

Now, we're simply going to check the return value of `validate_on_submit()` which will be `True` if validation was successful **after the user submitted the form**, or `False` if it failed.
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

#### Template Inheritance

You actually want to use the same design template for your entire website, but you might need to change some code in your header or footer. In these cases, it's better to use **Template Inheritance** instead.

if we create a base.html file that has the following code:
    <!DOCTYPE html><html lang="en"><head>    <meta charset="UTF-8">    <title>{% block title %}{% endblock %}</title></head><body>    {% block content %}{% endblock %}</body></html>

It has predefined areas (or blocks) where new content can be inserted by a child webpage inheriting from this template.

1. We could re-write the success.html page to inherit from this base.html template:
    #1.{% extends "base.html" %}#2.{% block title %}Success{% endblock %}#3.{% block content %}   <div class="container">      <h1>Top Secret </h1>      <iframe src="https://giphy.com/embed/Ju7l5y9osyymQ" width="480" height="360" frameBorder="0" class="giphy-embed" allowFullScreen></iframe>      <p><a href="https://giphy.com/gifs/rick-astley-Ju7l5y9osyymQ">via GIPHY</a></p>   </div>{% endblock %}

> \#1. This line of code tells the templating engine (Jinja) to use "base.html" as the template for this page.
> 
> \#2. This block inserts a custom title into the header of the template.
> 
> \#3. This block provides the content of the website. The part that is going to vary between webpag

* **Super Blocks**
  
  <style>
    {% block styling %}
    body{
        background: purple;
    }
    {% endblock %}
    </style>

On the **denied.html** page, add a super block using `{‌{ super() }}`, this will inject all the code in the styling block to this child page. Then afterwards before the `{% endblock %}`, we can add some more styling to change the colour of the `<h1>`.



# Python-Stage 3

## Bootstrap-Flask

1. Install Bootstrap-Flask to your project using pip:
    pip install bootstrap-flask

Start templates
    <!doctype html>
    <html lang="en">
        <head>
            {% block head %}
            <!-- Required meta tags -->
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

            {% block styles %}
                <!-- Bootstrap CSS -->
                {{ bootstrap.load_css() }}
            {% endblock %}

            <title>Your page title</title>
            {% endblock %}
        </head>
        <body>
            <!-- Your page content -->
            {% block content %}{% endblock %}

            {% block scripts %}
                <!-- Optional JavaScript -->
                {{ bootstrap.load_js() }}
            {% endblock %}
        </body>
    </html>

how to use template
    {% extends "base.html" %}
    {% block title %}Secrets{% endblock %}
    {% block content %}
        <div class="jumbotron">
          <div class="container">
            <h1>Welcome</h1>
            <p>Are you ready to discover my secret?</p>
            <a class="btn btn-primary btn-lg" href=" {{ url_for('login') }} "
              >Login</a
            >
          </div>
        </div>
    {% endblock %}

#### Create Form

https://bootstrap-flask.readthedocs.io/en/stable/macros/#render-form

Literally, in 1 line of code, you can create your form. It's as simple as:
    {% from 'bootstrap4/form.html' import render_form %}
    {{ render_form(form) }}

What this line of code will do is generate all the labels, inputs, buttons, styling for your form just by taking the WTForm **object that was passed to the template (`form`).****

form 是传过来的参数

#### Pandas Supplier

你可以通过 `pandas` 读取 CSV 并生成类似你提到的结构，也就是嵌套列表形式，第一行是列名，后面是每一行数据。以下是实现此功能的代码示例：

示例代码：
    python


    复制代码
    import pandas as pd

    # 读取 CSV 文件
    df = pd.read_csv('your_file.csv')

    # 获取列名作为第一项
    output = [df.columns.tolist()]  # 列名列表

    # 添加每一行的数据
    for row in df.itertuples(index=False, name=None):
        output.append(list(row))

    # 打印或返回结果
    print(output)

解释：

1. `df.columns.tolist()`：获取列名并转为列表。
2. `df.itertuples(index=False, name=None)`：通过 `itertuples` 方法遍历 DataFrame 的每一行，`index=False` 表示不返回索引，`name=None` 表示返回普通元组，而不是带属性的命名元组。
3. 将每一行转换为列表，并将其添加到 `output` 列表中。

假设 CSV 数据如下：
    csv


    复制代码
    Cafe Name,Location,Open,Close,Coffee,Wifi,Power
    Lighthaus,https://goo.gl/maps/2EvhB4oq4gyUXKXx9,11AM,3:30PM,☕☕☕☕️,💪💪,🔌🔌🔌
    Esters,https://goo.gl/maps/13Tjc36HuPWLELaSA,8AM,3PM,☕☕☕☕,💪💪💪,🔌
    Ginger & White,https://goo.gl/maps/DqMx2g5LiAqv3pJQ9,7:30AM,5:30PM,☕☕☕,✘,🔌
    Mare Street Market,https://goo.gl/maps/ALR8iBiNN6tVfuAA8,8AM,1PM,☕☕,💪💪💪,🔌🔌🔌

生成的输出将是：
    python


    复制代码
    [['Cafe Name', 'Location', 'Open', 'Close', 'Coffee', 'Wifi', 'Power'],
     ['Lighthaus', 'https://goo.gl/maps/2EvhB4oq4gyUXKXx9', '11AM', '3:30PM', '☕☕☕☕️', '💪💪', '🔌🔌🔌'],
     ['Esters', 'https://goo.gl/maps/13Tjc36HuPWLELaSA', '8AM', '3PM', '☕☕☕☕', '💪💪💪', '🔌'],
     ['Ginger & White', 'https://goo.gl/maps/DqMx2g5LiAqv3pJQ9', '7:30AM', '5:30PM', '☕☕☕', '✘', '🔌'],
     ['Mare Street Market', 'https://goo.gl/maps/ALR8iBiNN6tVfuAA8', '8AM', '1PM', '☕☕', '💪💪💪', '🔌🔌🔌']]

这将生成与您要求的格式完全匹配的嵌套列表结构。

# 


