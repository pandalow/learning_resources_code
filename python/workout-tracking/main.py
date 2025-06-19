import os
import requests
import datetime as dt


APP_ID = "0a62664b"
APP_KEY = "575a9b20a9e69619e850881fd2e97cee"

headers = {
    "x-app-id": APP_ID,
    "x-app-key": APP_KEY,
}

# TODO Using the Nutritionix API Guide, figure out how to print the exercise stats for plain text input.

WEIGHT = 85
HEIGHT = 172.5
AGE = 35

query = input("Tell me which exercise you did?")

parameters = {
    "query": query,
    "weight_kg": WEIGHT,
    "height_cm": HEIGHT,
    "age": AGE,
}
end_point = "https://trackapi.nutritionix.com/v2/natural/exercise"

response = requests.post(url=end_point, json=parameters, headers=headers)
response.raise_for_status()

query_data = response.json()['exercises']

sheety_headers = {
    "Authorization": "Basic cGFuZGFsb3c6MTIzNDU2"
}
sheety_end_point = "https://api.sheety.co/ea818906e75b16123a0ed4a60ce3d91d/myWorkouts/workouts"

for item in query_data:
    exercise_description = item["name"]
    exercise_duration = item["duration_min"]
    calories = item["nf_calories"]
    print(dt.datetime.now().strftime("%d/%m/%Y"))
    print(dt.datetime.now().strftime("%X"))

    add_row_json = {
        "workout": {
            "date": dt.datetime.now().strftime("%d/%m/%Y"),
            "time": dt.datetime.now().strftime("%X"),
            "exercise":exercise_description.title(),
            "duration":exercise_duration,
            "calories":calories,
        }
    }
    sheety_response = requests.post(url=sheety_end_point, json=add_row_json, headers=sheety_headers)
    sheety_response.raise_for_status()
    print(sheety_response)