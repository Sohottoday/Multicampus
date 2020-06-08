classroom = {
    'teacher' : 'kim',
    'student1' : 'hong',
    'student2' : 'choi'
}

for member in classroom:
    print(member)           # 그냥 member를 출력하면 key만 나온다.

for member in classroom:
    print(classroom[member])    # 위를 활용해 value값 출력

# 실제로는 아래와 같은 방식으로 많이 쓴다.
for member in classroom.keys():
    print(member)

for member in classroom.values():
    print(member)

for key, value in classroom.items():
    print(key, value)
