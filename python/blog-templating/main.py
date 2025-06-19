from flask import Flask, render_template
import requests
from post import Post

app = Flask(__name__)

response = requests.get(url='https://api.npoint.io/c790b4d5cab58020d391')
blogs = response.json()
blogs_object = [Post(blog['id'], blog['title'], blog["subtitle"], blog['body']) for blog in blogs]
print(blogs_object)

@app.route('/')
def home():
    return render_template("index.html", blogs=blogs_object)


@app.route('/post/<item_id>')
def post(item_id):
    blog =None
    for item in blogs_object:
        print(type(item.id))
        if item.id == int(item_id):
            blog = item
    print(blog)
    return render_template("post.html", blog = blog )

if __name__ == "__main__":
    app.run(debug=True)

