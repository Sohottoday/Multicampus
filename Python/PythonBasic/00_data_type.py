print('Hello, World')

# Ctrl + Shift + p -> default를 입력하면 default shell을 통해 기본 터미널 설정이 가능하다. 이 부분을 git bash로 변경

number = 10
string = '문자열'
bools = True
print(number, string, bools)

# 숫자형 (int, float, complex)
a = 3
print(type(a))

# bool
print(type(False))
# 0, 0.0, (), [], {}, '', None -> False로 처리된다.

# 문자형
# '' 와 ""는 어떤것을 써도 상관 없지면 한 프로젝트에 정해두고 하나만 쓰는것이 약속
greeting = 'hi'
name = 'harry'
print(greeting, name)
print(type(name))

#age = input()     # 사용자의 입력을 받는 함수 = input
#print(age)
#print(type(age))

print("""
개행 문자 없이
여러 줄을
그대로 출력 가능합니다.
""")

print(3 * 'hey' + 'yo!')        # 문자열도 반복이 가능하며 +로 합칠 수 있다.

# string interpolation
name = 'kim'
# 1. %-formatting
print('hello, %s' %name)
# 2. .format()
print('Hello, {}'.format(name))
print('Hello, {0},{1}'.format(name, string))
# 3. f-string (Literal String Interpolation)
print(f'HELLO, {name}')

pi = 3.141592
print(f'원주율은 {pi:.4}. 반지름이 2배일 때 원의 넓이는 {pi*2*2}')