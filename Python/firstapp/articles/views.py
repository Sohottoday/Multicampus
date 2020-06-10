import random
from datetime import datetime
from django.shortcuts import render

# Create your views here.
def index(request):
    return render(request, 'index.html')


def dinner(request):
    foods = ['족발', '햄버거', '치킨', '초밥']
    pick = random.choice(foods)
    context = {
        'pick': pick,
    }
    return render(request, 'dinner.html', context)


def ranimg(request):
    URL = 'http://picsum.photos/200/300.jpg'
    context = {
        'url' : URL,
    }
    return render(request, 'ranimg.html', context)


def hello(request, name):
    context = {
        'name' : name,
    }
    return render(request, 'hello.html', context)


def myname(request, myname, age):
    context = {
        'myname' : myname,
        'age' : age
    }
    return render(request, 'myname.html', context)

def add(request, num1, num2):
    result = num1 + num2
    context = {
        'num1' : num1,
        'num2' : num2,
        'result' : result
    }
    return render(request, 'add.html', context)


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
    return render(request, 'dtl_practice.html', context)

def readreverse(request, testword):
    reverseword = testword[::-1]
    context = {
        'testword' : testword,
        'reverseword' : reverseword,
    }
    return render(request, 'readreverse.html', context)