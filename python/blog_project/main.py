from flask import Flask, render_template,request
import smtplib
import requests

app = Flask(__name__)

app_id = 'pldk tduk juac gjeb'

end_point = 'https://api.npoint.io/e3d27e660ffd295e4439'
response = requests.get(end_point)
response.raise_for_status()
fetch_data = response.json()

def send_email(forms):
    with smtplib.SMTP('smtp.gmail.com') as connection:
        connection.starttls()
        connection.login(user='zxj000hugh@gmail.com',password='pldktdukjuacgjeb')
        connection.sendmail(from_addr='zxj000hugh@gmail.com',
                            to_addrs='zxj000hugh@gmail.com',
                            msg=f"Subject: Connection \n\n {forms['name'],forms['message']}")

@app.route('/')
def home():
    print(fetch_data)
    return render_template('index.html', data=fetch_data)


@app.route('/contact', methods=['GET','POST'])
def contact():
    if request.method == 'GET':
        return render_template('contact.html')
    elif request.method == 'POST':
        print(request.form['name'])
        send_email(forms=request.form)
        return render_template('contact.html',result='Successfully sent message')


@app.route('/about')
def about_us():
    return render_template('about.html')


@app.route('/post/<item_id>')
def post(item_id):
    blog = {}
    for item in fetch_data:
        if item['id'] == int(item_id):
            blog = item
    print(blog)
    return render_template('post.html', blog=blog)


@app.route('/form-entry',methods=['POST'])
def receive_data():
    if request.method == 'POST':
        return "Successfully sent your message"


if __name__ == "__main__":
    app.run(debug=True)
