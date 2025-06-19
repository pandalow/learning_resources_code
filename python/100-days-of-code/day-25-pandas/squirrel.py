import pandas

data = pandas.read_csv("2018_Central_Park_Squirrel_Census_-_Squirrel_Data_20240821.csv")

# fur_data = data["Primary Fur Color"].value_counts()
#
# fur_data.to_csv("fur_color.csv")


grey_squirrel = data[data["Primary Fur Color"] == "Gray"]
gray_squirrel_count = grey_squirrel["Unique Squirrel ID"].count()
cinnamon_squirrel = data[data["Primary Fur Color"] == "Cinnamon"]
cinnamon_squirrel_count = cinnamon_squirrel["Unique Squirrel ID"].count()
black_squirrel = data[data["Primary Fur Color"] == "Black"]
black_squirrel_count = black_squirrel["Unique Squirrel ID"].count()

data_dict = {
    "Fur Color":["Gray","Black","Cinnamon"],
    "Counts": [gray_squirrel_count,black_squirrel_count,cinnamon_squirrel_count]
}

pandas.DataFrame(data_dict).to_csv("new_squirrel.csv")
