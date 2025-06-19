import requests
import spotipy
from spotipy.oauth2 import SpotifyOAuth
from bs4 import BeautifulSoup

CLIENT_ID = "ab6f1bd595954946a05ebb7355136ead"
CLIENT_SECRET = "1c33a7875e8b4b81b99af8f8c571d277"
REDIRECT_URI = "http://example.com"

date = input("which year do you want to travel to? Type the date in this format YYYY-MM-DD")

end_point = "https://www.billboard.com/charts/hot-100"

response = requests.get(url=f"{end_point}/{date}")
response.raise_for_status()

soup = BeautifulSoup(response.text, "html.parser")

title_article = soup.select("li ul li h3")

title = [item.getText().strip() for item in title_article]

sp = spotipy.Spotify(auth_manager=SpotifyOAuth(client_id=CLIENT_ID,
                                               client_secret=CLIENT_SECRET,
                                               redirect_uri=REDIRECT_URI,
                                               show_dialog=True,
                                               cache_path="token.txt",
                                               scope="playlist-modify-private",
                                               username="xiaojianzhuang"))

user_id = sp.current_user()['id']
year = date.split('-')[0]

id_list = [sp.search(q=f"track:{item} year:{year}",type="track") for item in title]
print(id_list)