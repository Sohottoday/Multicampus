sample_list = list(range(0, 31))
print(sample_list)
print(sample_list[1:3])     # index의 개념이 아닌 공간의 의미이다. 즉, 1부터 3사이의 공간을 불러온다는 의미이기 때문에 2칸을 불러온다는 뜻.
print(sample_list[10:-1])
print(sample_list[0:len(sample_list):3])
print(sample_list[0::3])
print(sample_list[::-1])