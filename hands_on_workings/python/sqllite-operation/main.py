import sqlite3
from flask import Flask
from flask_sqlalchemy import SQLAlchemy
from sqlalchemy.orm import DeclarativeBase, Mapped, mapped_column
from sqlalchemy import Integer, String, Float

# db = sqlite3.connect('books-collection.db')
# cursor = db.cursor()
#
# cursor.execute('CREATE TABLE books (id INTEGER PRIMARY KEY,'
#                ' title vachar(250) NOT NULL UNIQUE,'
#                'author varchar(250) NOT NULL,'
#                'rating FLOAT NOT NULL )')
#
# cursor.execute("INSERT INTO books VALUES(1,'Harry Potter','J.K.Rowling','9.3')")
# db.commit()

class Base(DeclarativeBase):
    pass

db = SQLAlchemy(model_class=Base)
app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///new-books-collection.db'

db.init_app(app)

class Book(Base):
    __tablename__ = 'books'
    id:Mapped[int] = mapped_column(primary_key=True)
    title:Mapped[str] = mapped_column(String(250),nullable=False,unique=True)
    author:Mapped[str] = mapped_column(String(250),nullable=False)
    rating:Mapped[float] = db.Column(Float,nullable=False)

    def __repr__(self):
        return f'<Book {self.title}>'

with app.app_context():
    # db.create_all()
    # harry_potter = Book(id=2, title='Harry', author='J.K.', rating=9.3)
    # db.session.add(harry_potter)
    # db.session.commit()

    book = db.session.execute(db.select(Book).where(Book.id==2)).scalar()
    print(book.author)

