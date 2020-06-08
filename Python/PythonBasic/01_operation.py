# 논리 연산자1
print('--- and ---')
print(True and True)
print(True and False)
print(False and True)
print(False and False)

print('--- or ---')
print(True or True)
print(True or False)
print(False or True)
print(False or False)

print('--- not ---')
print(not True)
print(not 0)

# 단축평가
# 첫 번째 값이 확실할 때, 두번째 값은 확인하지 않음
# 조건문에서 뒷 부분을 판단하지 않아도 되기 때문에 속도 향상
print('--- 단축 평가 ---')
vowels = 'aeiou'
print(('a' and 'b') in vowels)
print(('b' and 'a') in vowels)
print('a' and 'b')      # and 는 앞의 문자가 True라고 해서 무조건 True가 아니라 뒤쪽 값에대한 보장이 없기 때문에 뒤의 값이 나온다.

# and는 둘 다 True일 경우만 True이기 때문에 첫 번째 값이 True라도 두번째 값을 확인해야 한다.
print(3 and 5)  # 5
print(3 and 0)  # 0
print(0 and 3)  # 0     0은 False 이므로 and 입장에서는 이미 False이기 때문에 뒤의 값을 확인하지 않는다.
print(0 and 0)  # 0     왼쪽 0

print(5 or 3)  # 5
print(3 or 0)  # 3
print(0 or 3)  # 3     
print(0 or 0)  # 0      오른쪽 0

# Containment Test
# in 연산자를 통해 요소가 속해있는지 여부를 확인할 수 있다.
print('--- in ---')
print('a' in 'apple')
print(1 in [1,2,3])