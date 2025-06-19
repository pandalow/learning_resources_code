from flask import Flask, jsonify, render_template, request
from flask_sqlalchemy import SQLAlchemy
from sqlalchemy.orm import DeclarativeBase, Mapped, mapped_column
from sqlalchemy import Integer, String, Boolean
import random

'''
Install the required packages first: 
Open the Terminal in PyCharm (bottom left). 

On Windows type:
python -m pip install -r requirements.txt

On MacOS type:
pip3 install -r requirements.txt

This will install the packages from requirements.txt for this project.
'''

app = Flask(__name__)

# CREATE DB
class Base(DeclarativeBase):
    pass
# Connect to Database
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///cafes.db'
db = SQLAlchemy(model_class=Base)
db.init_app(app)


# Cafe TABLE Configuration
class Cafe(db.Model):
    id: Mapped[int] = mapped_column(Integer, primary_key=True)
    name: Mapped[str] = mapped_column(String(250), unique=True, nullable=False)
    map_url: Mapped[str] = mapped_column(String(500), nullable=False)
    img_url: Mapped[str] = mapped_column(String(500), nullable=False)
    location: Mapped[str] = mapped_column(String(250), nullable=False)
    seats: Mapped[str] = mapped_column(String(250), nullable=False)
    has_toilet: Mapped[bool] = mapped_column(Boolean, nullable=False)
    has_wifi: Mapped[bool] = mapped_column(Boolean, nullable=False)
    has_sockets: Mapped[bool] = mapped_column(Boolean, nullable=False)
    can_take_calls: Mapped[bool] = mapped_column(Boolean, nullable=False)
    coffee_price: Mapped[str] = mapped_column(String(250), nullable=True)

    def to_dict(self):
        return {column.name: getattr(self, column.name) for column in self.__table__.columns}

with app.app_context():
    db.create_all()


@app.route("/")
def home():
    return render_template("index.html")

@app.route("/random",methods=['GET'])
def get_random():
    cafes = db.session.execute(db.select(Cafe)).scalars().all()
    cafe = random.choice(cafes)
    return jsonify(
        cafe = cafe.to_dict())
    # return jsonify(
    #     cafe={
    #         # Omit the id from the response
    #         # "id": cafe.id,
    #         "name": cafe.name,
    #         "map_url": cafe.map_url,
    #         "img_url": cafe.img_url,
    #         "location": cafe.location,
    #
    #         # Put some properties in a sub-category
    #         "amenities": {
    #             "seats": cafe.seats,
    #             "has_toilet": cafe.has_toilet,
    #             "has_wifi": cafe.has_wifi,
    #             "has_sockets": cafe.has_sockets,
    #             "can_take_calls": cafe.can_take_calls,
    #             "coffee_price": cafe.coffee_price,
    #         }
    #     }
    # )
# HTTP GET - Read Record
@app.route('/all')
def get_all():
    cafes = db.session.execute(db.select(Cafe).order_by(Cafe.name)).scalars().all()
    cafe_list = [cafe.to_dict() for cafe in cafes]

    return jsonify(data = cafe_list)

@app.route('/search')
def find_cafe():
    location = request.args.get('loc')
    cafes = db.session.execute(db.select(Cafe).where(Cafe.location == location)).scalars().all()
    cafe_list = [cafe.to_dict() for cafe in cafes]
    if len(cafe_list) > 0:
        return jsonify(
            cafes = cafe_list
        )
    else:
        return jsonify(
            error = {
                'Not Found':"Sorry, I couldn't find any cafe with that location."
            }
        ), 404
# HTTP POST - Create Record
@app.route('/add',methods=['POST'])
def add_cafe():
    new_cafe = Cafe(
        name=request.form.get("name"),
        map_url=request.form.get("map_url"),
        img_url=request.form.get("img_url"),
        location=request.form.get("loc"),
        has_sockets=bool(request.form.get("sockets")),
        has_toilet=bool(request.form.get("toilet")),
        has_wifi=bool(request.form.get("wifi")),
        can_take_calls=bool(request.form.get("calls")),
        seats=request.form.get("seats"),
        coffee_price=request.form.get("coffee_price"),
    )
    db.session.add(new_cafe)
    db.session.commit()
    return jsonify(response={"success": "Successfully added the new cafe."})

# HTTP PUT/PATCH - Update Record
@app.route('/update_price/<int:cafe_id>',methods=['PATCH'])
def update_price(cafe_id):
    cafe = db.get_cafe(cafe_id)
    if not cafe:
        return jsonify({"error": "Cafe not found"}), 404
    cafe.coffee_price = request.form.get("new_price")
    db.session.commit()
    return jsonify(response={"success": "Successfully updated."})

# HTTP DELETE - Delete Record
@app.route('/report-closed/<int:cafe_id>',methods=['DELETE'])
def report_closed(cafe_id):
    api_key = request.form.get('api-key')
    if api_key == 'TopSecretAPIKey':
        delete_cafe = db.get_or_404(cafe_id)
        if not delete_cafe:
            return jsonify({"error": "Cafe not found"}), 404
        else:
            db.session.delete(delete_cafe)
            db.session.commit()
            return jsonify(response={"success": "Successfully deleted the cafe."}),200
    else:
        return jsonify({"error": "Invalid API key"}), 403

if __name__ == '__main__':
    app.run(debug=True)
