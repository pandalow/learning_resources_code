# Python-Stage 3



## Bootstrap-Flask

1. Install Bootstrap-Flask to your project using pip:

```
pip install bootstrap-flask
```

Start templates

```
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
```


how to use template

```
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
```



#### Create Form

https://bootstrap-flask.readthedocs.io/en/stable/macros/#render-form

Literally, in 1 line of code, you can create your form. It's as simple as:

```
{% from 'bootstrap4/form.html' import render_form %}
{{ render_form(form) }}
```

What this line of code will do is generate all the labels, inputs, buttons, styling for your form just by taking the WTForm **object that was passed to the template (`form`).****

form 是传过来的参数



#### Pandas Supplier

你可以通过 `pandas` 读取 CSV 并生成类似你提到的结构，也就是嵌套列表形式，第一行是列名，后面是每一行数据。以下是实现此功能的代码示例：

示例代码：

```
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
```

解释：

1. `df.columns.tolist()`：获取列名并转为列表。
2. `df.itertuples(index=False, name=None)`：通过 `itertuples` 方法遍历 DataFrame 的每一行，`index=False` 表示不返回索引，`name=None` 表示返回普通元组，而不是带属性的命名元组。
3. 将每一行转换为列表，并将其添加到 `output` 列表中。

假设 CSV 数据如下：

```
csv


复制代码
Cafe Name,Location,Open,Close,Coffee,Wifi,Power
Lighthaus,https://goo.gl/maps/2EvhB4oq4gyUXKXx9,11AM,3:30PM,☕☕☕☕️,💪💪,🔌🔌🔌
Esters,https://goo.gl/maps/13Tjc36HuPWLELaSA,8AM,3PM,☕☕☕☕,💪💪💪,🔌
Ginger & White,https://goo.gl/maps/DqMx2g5LiAqv3pJQ9,7:30AM,5:30PM,☕☕☕,✘,🔌
Mare Street Market,https://goo.gl/maps/ALR8iBiNN6tVfuAA8,8AM,1PM,☕☕,💪💪💪,🔌🔌🔌
```

生成的输出将是：

```
python


复制代码
[['Cafe Name', 'Location', 'Open', 'Close', 'Coffee', 'Wifi', 'Power'],
 ['Lighthaus', 'https://goo.gl/maps/2EvhB4oq4gyUXKXx9', '11AM', '3:30PM', '☕☕☕☕️', '💪💪', '🔌🔌🔌'],
 ['Esters', 'https://goo.gl/maps/13Tjc36HuPWLELaSA', '8AM', '3PM', '☕☕☕☕', '💪💪💪', '🔌'],
 ['Ginger & White', 'https://goo.gl/maps/DqMx2g5LiAqv3pJQ9', '7:30AM', '5:30PM', '☕☕☕', '✘', '🔌'],
 ['Mare Street Market', 'https://goo.gl/maps/ALR8iBiNN6tVfuAA8', '8AM', '1PM', '☕☕', '💪💪💪', '🔌🔌🔌']]
```

这将生成与您要求的格式完全匹配的嵌套列表结构。