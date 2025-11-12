# # with open("./weather_data.csv",'r') as file:
# #     weather_data = file.readlines()
#
# # import csv
# #
# # with open("weather_data.csv",'r') as csv_file:
# #     data = csv.reader(csv_file)
# #     temperature = []
# #     for row in data:
# #         if row[1] != "temp":
# #             temperature.append(int(row[1]))
# #
# #     print(temperature)
#
# import pandas
#
# data = pandas.read_csv("weather_data.csv")
# # print(data)
# # print(data["temp"])
#
# data.to_dict()
#
# list_of_temp = data["temp"].to_list()
# # average = sum(list_of_temp)/len(list_of_temp)
# # print(average)
# # print(data["temp"].mean())
# # print(data["temp"].max())
# # print(data.condition)
#
# print(data[data.temp == data["temp"].max()])
#
# monday = data[data.day == "Monday"]
# print(monday.temp)