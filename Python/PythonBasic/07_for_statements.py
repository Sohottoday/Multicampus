# for문은 정해진 범위 내 시퀀스(string, tuple, list 같은)나 다른 반복가능한 객체(iterable)의 요소들을 순차적으로 실행한다.

for num in [0, 1, 2, 3, 4]:
    print(num)

for num in range(100):
    print(num)

result = []
for num in range(1, 31):
    if num % 2:
        result.append(num)
print(result)

lunch = ['짜장면', '초밥', '탕수육']
for idx, menu in enumerate(lunch):        # enumerate를 통해 리스트 내 index를 출력할 수 있다.
    print(idx, menu)

print(enumerate(lunch))
print(type(enumerate(lunch)))
print(list(enumerate(lunch)))
print(type(list(enumerate(lunch))[0]))
