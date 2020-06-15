# class Dog:

#     kind = 'canine' # 클래스 변수

#     def __init__(self, name):
#         self.name = name    # 인스턴스 변수


# my_dog = Dog('gazi')
# your_dog = Dog('namu')

# print(my_dog.kind)
# print(your_dog.kind)

# print(my_dog.name)
# print(your_dog.name)

class Dog:

    #tricks = []             # mistaken use of a class variable
    # 전체 공유가 아닌 각자의 값을 가지려면 init에 생성되어야 한다.
    def __init__(self, name):
        self.name = name
        self.tricks = []

    def add_trick(self, trick):
        self.tricks.append(trick)

#    @classmethod    # 클래스를 통해 불러오는 클래스 메서드라는 뜻
#    def my_count(cls):
#        cls.dog_count += 1


my_dog = Dog('gazi')
your_dog = Dog('namu')

my_dog.add_trick('hello')
your_dog.add_trick('byebye')

print(my_dog.tricks)
print(your_dog.tricks)

print(help(str.capitalize))

variable = 'apple'

# 단축형
print(variable.capitalize())
# self가 작성되는 이유
print(str.capitalize(variable))


# 절차 지향 vs 객체 지향
# 데이터가 흘러 다니는 것으로 보는 시각 -> 데이터가 중심이 되는 시각으로 변함.

# 절차 지향
# greeting(데이터)
def greeting(name):
    return f'hello, {name}'

print(greeting('harry'))

# 객체 지향
# 데이터.greeting
class Person:
    def __init__(self, name):
        self.name = name

    def greeting(self):
        return f'hello, {self.name}'

my_var = Person('andrew')
print(my_var.greeting())
    