import requests
import datetime as dt

TOKEN = "dakdaldngn182jff"

pixela_endpoint = "https://pixe.la/v1/users"
user_name = "zhuang"
user_payload = {
    "token": TOKEN,
    "username": user_name,
    "agreeTermsOfService": "yes",
    "notMinor": "yes",
}

# response = requests.post(url=pixela_endpoint,json=user_payload)
# response.raise_for_status()
graph_config = {
    "id": "graph1",
    "name": "Coding Practicing",
    "unit": "line",
    "type": "int",
    "color": "sora",

}
headers = {
    "X-USER-TOKEN": TOKEN
}

GRAPH_ID = "graph1"
# graph_response = requests.post(url=f"{pixela_endpoint}/{user_name}/graphs", json=graph_config, headers=headers)
# graph_response.raise_for_status()

now = dt.datetime.now().strftime("%Y%m%d")

pix_config = {
    "date": now,
    "quantity": "9"
}

pixela_graph_url = f"{pixela_endpoint}/{user_name}/graphs/{GRAPH_ID}"

# pixela_response = requests.post(url=pixela_graph_url, json=pix_config, headers=headers)
# pixela_response.raise_for_status()
# print(pixela_response)

put_date_time = dt.datetime(year=2024, month=8, day=30).strftime("%Y%m%d")
print(put_date_time)
pixela_graph_put_url = f"{pixela_endpoint}/{user_name}/graphs/{GRAPH_ID}/{put_date_time}"
put_data = {
    "quantity": "8",
}

pixela_put_response = requests.put(url=pixela_graph_url, json=put_data, headers=headers)
pixela_put_response.raise_for_status()
print(pixela_put_response)
