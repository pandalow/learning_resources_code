import requests
import os
from dotenv import load_dotenv

load_dotenv()

class DataManager:
    #This class is responsible for talking to the Google Sheet.

    def __init__(self):

        API_KEY = os.getenv("API_KEY")
        self.headers = {
            "Authorization": API_KEY
        }

    def get_data(self) -> dict:
        response = requests.get(url="https://api.sheety.co/ea818906e75b16123a0ed4a60ce3d91d/flightDeals/prices",
                                headers=self.headers)
        response.raise_for_status()
        return response.json()['prices']

    def update(self, row_id: int, json_file: dict):
        response = requests.put(
            url=f"https://api.sheety.co/ea818906e75b16123a0ed4a60ce3d91d/flightDeals/prices/{row_id}",
            json=json_file,
            headers=self.headers
        )
        response.raise_for_status()
