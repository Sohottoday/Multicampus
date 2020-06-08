# set
## 순서가 없는 자료 구조
## 집합의 요소는 unique하다. 중복을 허용하지 않는다.
## 순서가 없으므로 set는 요소의 위치나 삽입 순서를 기록하지 않는다.
## 따라서 set는 인덱싱, 슬라이싱 또는 기타 시퀀스와 유사한 동작을 지원하지 않는다.
## 수학에서의 집합과 동일하게 처리된다.

set_a = {1, 2, 3}
set_b = {3, 6, 9}

print(set_a - set_b)    # 차집합
print(set_a | set_b)    # 합집합
print(set_a & set_b)    # 교집합

set_c = {1, 1, 1}
print(set_c)

set_d = set()      # 빈 중괄호로 만들면 dictionary가 되버린다.

# dictionary
## dictionary는 key와 value가 쌍으로 이루어져 있으며, 궁극의 자료구조라고 한다.
dict_a = {}
dict_b = dict()
print(type(dict_a), type(dict_b))

dict_a = {1: 1, 2: 2, 3: 3}     # key는 중복이 되어선 안되며 중복되면 나중에 작성된 key값으로 설정된다.
print(dict_a)
# key는 불변(immutable)한 모든 것이 가능(str, int, float, boolean, tuple, range)
# value는 list, dict를 포함한 모든 것이 가능하다.
phone_book = {
    '서울' : '02',
    '경기' : '031',
    '경남' : '055'
    }
print(phone_book['서울'])       # 딕셔너리는 부조건 key로 접근한다.

#print(dir(dict))
print(phone_book.values())