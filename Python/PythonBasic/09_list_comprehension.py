my_list = []

for x in range(10):
    my_list.append(x ** 2)
print(my_list)

# list comprehension
## 단순히 반복문을 한 줄로 작성하는 것이 아님.
## 반복을 통해 리스트에 어떠한 것을 담는 경우 한 줄로 줄여 쓰는 것
## 시퀀스의 요소들 전부 또는 일부를 처리하고, 그 결과를 리스트로 돌려주는 간결한 방법
## 비어있는 리스트 객체를 만들 필요가 없다.
my_newlist = [x ** 2 for x in range(10)]
#my_newlist = list(x ** 2 for x in range(10))
print(my_newlist)

# 간결함
# 성능(일반화의 위험성)
# 표현력(Pythonic)

# list comprehension with if statements
numbers = list(range(10, 100, 10))
print(numbers)

my_numbers_1 = []
for number in numbers:
    if number % 4 == 0:
        my_numbers_1.append(number)
# if가 붙으면 if문은 오른쪽, append해야하는 값 자체는 왼쪽으로 간다.
my_numbers_2 = [number for number in numbers if number % 4 == 0]
print(my_numbers_2)

my_numbers_3 = []
for number in numbers:
    if number > 50:
        my_numbers_3.append(number + 7)
    else:
        my_numbers_3.append(number + 5)
# if/else가 되면 if/else 구문도 왼쪽으로 가고 참일때의 값을 if 왼쪽에, else 부분이 오른쪽으로 간다.
my_numbers_4 = [number + 7 if number >= 50 else number + 5 for number in numbers]
print(my_numbers_4)
# 조건 표현식
## true_value <if> 조건식 <else> false_value

# list comprehension을 남용하지 말자.(이해하기가 쉽지 않다)
# 가독성 > 간결함
gugudan = []
for a in range(2, 10):
    for b in range(1, 10):
        gugudan.append(a * b)
print(gugudan)

gugudan2 = [a * b for a in range(2, 10) for b in range(1, 10)]
print(gugudan2)