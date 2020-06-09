import random

# random.choice : 시퀀스형태의 객체 중 하나를 선택해서 뽑아냄
numbers = [1, 2, 3, 4, 5]
result = random.choice(numbers)
print(result)

pick = random.choice(range(10))
print(pick)

# random.sample(x, y) : x만큼의 범위에서 y개만큼 랜덤 추출하라.
n = random.sample(range(20), 3)
print(n)

print(dir(random))