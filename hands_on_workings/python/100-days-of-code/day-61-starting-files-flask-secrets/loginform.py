from flask_wtf import FlaskForm
from wtforms import StringField, PasswordField, EmailField, SubmitField
from wtforms.validators import DataRequired, Email,Length,EqualTo


class LoginForm(FlaskForm):
    email = EmailField(label='email', validators=[
        DataRequired(),
        Email("Invalid email address")
    ])
    password = PasswordField(
        label='password',
        validators=[
            DataRequired(),
            Length(min=8,message="Your password should over 8")
        ]
    )
    submit = SubmitField(label='Login')
