#This file will need to use the DataManager,FlightSearch, FlightData, NotificationManager classes to achieve the program requirements.
from data_manager import DataManager
from flight_search import FlightSearch
from pprint import pprint

data_manager = DataManager()
sheet_data = data_manager.get_data()

flight_search = FlightSearch()

for item in sheet_data:
    if len(item["iataCode"]) == 0:
        item["iataCode"] = flight_search.get_itat_code(item['city'])

for item in sheet_data:
    put_parameters = {
        "price": {
            "iataCode": item["iataCode"],
        }
    }
    data_manager.update(item['id'], put_parameters)
