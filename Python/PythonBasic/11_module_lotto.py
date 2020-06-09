import random
import requests

numbers = range(1, 46)
lotto = random.sample(numbers, 7)
print(lotto)

lotto_url = 'https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=914'

response = requests.get(lotto_url)
#print(response)
#print(response.content)
lotto_info = response.json()        # 딕셔너리 타입으로 전환해준다 json을

bonus_num = lotto_info['bnusNo']        # 값이 없으면 에러
bonus_num = lotto_info.get('bnusNo')        # 값이 없으면 None로 처리
print(bonus_num)

#winner = [lotto_info.get('drwtNo1'),lotto_info.get('drwtNo2'), lotto_info.get('drwtNo3'), lotto_info.get('drwtNo4'), lotto_info.get('drwtNo5'),lotto_info.get('drwtNo6')]
#print(winner)

winner = []
for i in range(1, 7):
#    winner.append(lotto_info.get(f'drwtNo{i}'))
    winner.append(lotto_info.get('drwtNo{}'.format(i)))
print(winner)

good = []
for x in lotto:
    for w in winner:
        if x == w:
            good.append(w)

if len(good) == 6:
    print('1등 당첨')
elif len(good) == 5:
    if lotto in bonus_num:
        print('2등 당첨')
    else:
        print('3등 당첨')
elif len(good) == 4:
    print('4등 당첨')
elif len(good) == 3:
    print('5등 당첨')
else:
    print('꽝')

print(good)
print(len(good))

# 파이썬다운 활용
match_num = set(lotto) & set(winner)    # set의 교집합 활용
print(len(match_num))