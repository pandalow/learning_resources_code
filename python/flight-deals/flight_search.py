import os
from dotenv import load_dotenv
import requests

load_dotenv()

class FlightSearch:
    #This class is responsible for talking to the Flight Search API.

    def __init__(self):

        self._AMD_API_KEY = os.getenv("AMD_API_KEY")
        self._API_SECRET = os.getenv("API_SECRET")
        self._token = self._get_token()

    def _get_token(self) -> str:
        # Header with content type as per Amadeus documentation
        header = {
            'Content-Type': 'application/x-www-form-urlencoded'
        }
        body = {
            'grant_type': 'client_credentials',
            'client_id': self._AMD_API_KEY,
            'client_secret': self._API_SECRET,
        }
        response = requests.post(url='https://test.api.amadeus.com/v1/security/oauth2/token', data=body, headers=header)
        print(response.json()['access_token'])
        return response.json()['access_token']

    def get_itat_code(self, city: str) -> str:
        headers = {"Authorization": f"Bearer {self._token}"}
        parameters = {
            "keyword": city,
            "max": "2",
            "include": "AIRPORTS",
        }
        response = requests.get(url="https://test.api.amadeus.com/v1/reference-data/locations/cities",
                                params=parameters,
                                headers=headers
                                )
        response.raise_for_status()

        try:
            code = response.json()["data"][0]['iataCode']
        except IndexError:
            print(f"IndexError: No airport code found for {city}.")
            return "N/A"
        except KeyError:
            print(f"KeyError: No airport code found for {city}.")
            return "Not Found"

        return code
