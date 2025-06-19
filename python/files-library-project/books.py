from flask_wtf import FlaskForm
from wtforms import StringField,SubmitField,FloatField
from wtforms.validators import DataRequired,URL


class BookForm(FlaskForm):
    title = StringField('Title',validators=[DataRequired()])
    author = StringField('Author',validators=[DataRequired()])
    rating = FloatField('Rating',validators=[DataRequired()])
    submit = SubmitField('Submit')