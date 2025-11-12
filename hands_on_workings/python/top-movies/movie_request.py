import os
import requests
from dotenv import load_dotenv

load_dotenv(dotenv_path='.env')

class MovieRequest:
    def __init__(self):
        self.API_KEY = os.getenv('MOVIE_API_KEY')
        self.endpoint = os.getenv('MOVIE_ENDPOINT')
        self.headers = {
            "accept": "application/json",
            "Authorization": f"Bearer {self.API_KEY}"
        }
        print(self.endpoint)
        print(self.API_KEY)

    def get_movies(self, title):
        params = {
            "query":title,
        }
        response = requests.get(url=self.endpoint, headers=self.headers, params=params)
        response.raise_for_status()
        data = response.json()['results']

        return data
    def get_details(self, movie_id):

        response = requests.get(url=f"https://api.themoviedb.org/3/movie/{movie_id}", headers=self.headers)
        response.raise_for_status()
        data = response.json()
        return data
