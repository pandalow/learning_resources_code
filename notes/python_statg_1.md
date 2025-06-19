# Python-Stage 1

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

````
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
````



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

