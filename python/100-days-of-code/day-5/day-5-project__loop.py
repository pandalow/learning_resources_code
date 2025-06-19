fruits = ['Apple','Peach','Pear']
print(fruits)
# enhanced the fruits
for fruits in fruits:
    # Indentation is really important
    print(fruits)
    print(fruits + ' pie')

score = [150, 142, 192, 120]

sum_score = 0
for score in score:
    sum_score += score
print(sum_score)

max_score = 0
for score in score:
    if score > max_score:
        max_score = score

print(max_score)

# Range
for number in (1, 10):
    # Not include 10
    print(number)

for number in (1,11,3):
    # Step by 3
    print(number)

gauss_sum = 0

for number in range(1, 101):
    gauss_sum += number

print(gauss_sum)