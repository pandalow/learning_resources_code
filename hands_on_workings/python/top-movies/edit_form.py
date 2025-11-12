from flask_wtf import FlaskForm
from sqlalchemy import Float
from wtforms import StringField,SubmitField,FloatField
from wtforms.fields.choices import SelectField
from wtforms.validators import DataRequired, Length


class RatingForm(FlaskForm):
    rating = FloatField(label="Your Rating Out of 10",validators=[DataRequired()])
    review = StringField(label="Your Review",validators=[DataRequired(),Length(min=1,max=100)])
    submit = SubmitField(label="Submit")

class AddingForm(FlaskForm):
    title = StringField(label="Movie Title",validators=[DataRequired()])
    subtitle = SubmitField(label="Add Movie")