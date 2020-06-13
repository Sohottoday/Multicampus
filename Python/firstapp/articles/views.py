import random
import requests
from pprint import pprint
from datetime import datetime
from django.shortcuts import render

# Create your views here.
def index(request):
    return render(request, 'articles/index.html')


def dinner(request):
    foods = ['족발', '햄버거', '치킨', '초밥']
    pick = random.choice(foods)
    context = {
        'pick': pick,
    }
    return render(request, 'articles/dinner.html', context)


def ranimg(request):
    URL = 'http://picsum.photos/200/300.jpg'
    context = {
        'url' : URL,
    }
    return render(request, 'articles/ranimg.html', context)


def hello(request, name):
    context = {
        'name' : name,
    }
    return render(request, 'articles/hello.html', context)


def myname(request, myname, age):
    context = {
        'myname' : myname,
        'age' : age
    }
    return render(request, 'articles/myname.html', context)

def add(request, num1, num2):
    result = num1 + num2
    context = {
        'num1' : num1,
        'num2' : num2,
        'result' : result
    }
    return render(request, 'articles/add.html', context)


def dtl_practice(request):
    foods = ['짜장면', '초밥', '차돌짬뽕', '콩국수']
    empty_list = []
    messages = 'Life is short, You need Python'
    datetime_now = datetime.now()
    context = {
        'foods': foods,
        'empty_list' : empty_list,
        'messages' : messages,
        'datetime_now' : datetime_now,
    }
    return render(request, 'articles/dtl_practice.html', context)


def readreverse(request, testword):
    reverseword = testword[::-1]
    context = {
        'testword' : testword,
        'reverseword' : reverseword,
    }
    return render(request, 'articles/readreverse.html', context)


def throw(request):
    return render(request, 'articles/throw.html')


def catch(request):
    #pprint(request.GET)
    #print(request.GET.get('message'))
    context = {
        'message' : request.GET.get('message'),
        'color' : request.GET.get('color'),
    }
    return render(request, 'articles/catch.html', context)


def yourname(request):
    return render(request, 'articles/yourname.html')


def yournumber(request):
    rannum = sorted(random.sample(range(1,46),6))
    context = {
        'yourname' : request.GET.get('yourname'),
        'yournumber' : rannum
    }
    return render(request, 'articles/yournumber.html', context)


def artii(request):
    response = requests.get('http://artii.herokuapp.com/fonts_list').text
    fonts_list = response.split('\n')
    #font = random.choice(fonts_list)
    context = {
        'fonts' : fonts_list
    }
    return render(request, 'articles/artii.html',context)


def artii_result(request):
    word = request.GET.get('word')
    font = request.GET.get('selectfont')
    
    ARTII_URL = f'http://artii.herokuapp.com/make?text={word}&font={font}'
    #'http://artii.herokuapp.com/make?text={0}&font={1}'.format(word, font)
    
    # Artii api 주소로 우리가 만든 데이터와 함께 요청을 보낸다.
    result = requests.get(ARTII_URL).text

    context = {
        'result' : result,
    }
    return render(request, 'articles/artii_result.html', context)