from flask_sqlalchemy import SQLAlchemy
from sqlalchemy.orm import DeclarativeBase, Mapped, mapped_column
from sqlalchemy import Integer, String, Float



class Base(DeclarativeBase):
    pass

db = SQLAlchemy(model_class=Base)

class Movie(db.Model):
    __tablename__ = 'movies'
    id:Mapped[int] = mapped_column(Integer, primary_key=True, autoincrement=True)
    title:Mapped[str] = mapped_column(String(250),nullable=False,unique=True)
    year:Mapped[int] = mapped_column(Integer,nullable=False)
    description:Mapped[str] = mapped_column(String(250),nullable=False)
    rating:Mapped[float] = mapped_column(Float,nullable=True)
    ranking:Mapped[int] = mapped_column(Integer,nullable=True)
    review:Mapped[str] = mapped_column(String(250),nullable=True)
    img_url:Mapped[str] = mapped_column(String(250),nullable=False)




