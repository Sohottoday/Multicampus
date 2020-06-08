# 시퀀스(sequence)
## 데이터가 순서대로 나열된 형식
## 데이터에 순서(번호)를 붙여 나열한 것
# (주의!) 순서대로 나열된 것이 정렬되었다 라는 뜻은 아니다.
# 가변 시퀀스 - list, 불변 시퀀스 - tuple, str, range()

# 1. 리스트(list)
my_list1 = [10, '문자열', True]
print(my_list1)
print(type(my_list1))
print(my_list1[0])

#a = []
#b = list()

# 2. 튜플(tuple)
# 튜플은 수정 불가능(불변, immutable)하고 읽을 수 밖에 없다.
# 직접 사용하기 보다는 파이썬 내부에서 사용하고 있다.
my_tuple11 = (1, 2)
print(my_tuple11)
print(type(my_tuple11))

my_tuple2 = 1, 2       # 이러한 경우 내부적으로 튜플이 사용된다.
print(my_tuple2)
print(type(my_tuple2))

x, y = 1, 2
print(x)
print(y)

# 하나의 요소로 구성된 튜플은 값 뒤에 쉼표를 붙여서 만든다
single_tuple = ('hello', )
print(type(single_tuple))

# range()
## range는 숫자의 시퀀스를 나타내기 위해 사용
## 숫자들의 시퀀스로 반복 할 필요가 있으면 사용하는 함수
## list나 tuple에 비해 범위의 크기에 무관하게 항상 같은 양의 메모리를 사용한다.
## (주의) range가 돌려준 객체(iterable)는 list인 것 같지만 list가 아니다.
## 반복할 때 원하는 시퀀스 항목들을 순서대로 돌려주는 객체이지만, 실제로 리스트를 만들지 않아서 공간을 절약하는 원리이다.
print(type(range(1)))
print(list(range(10)))
# python documentation 에서 확인해 보자
