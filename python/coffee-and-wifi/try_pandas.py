import pandas

data = pandas.read_csv('cafe-data.csv')

empty_list = [data.columns.tolist()]

for item in data.itertuples(name=None, index=False):
    empty_list.append(list(item))

print(empty_list)
