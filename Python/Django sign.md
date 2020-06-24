### 회원 가입, 로그인, 로그아웃



- 회원가입은 create의 로직과 비슷하다.

- `python manage.py migrate` 를 진행하면 자동으로 auth 관련 DB가 생성된다.

- models.py 같은것들을 따로 만들 필요 없이 django의 내장 login 관련 메서드를 활용한다.
- views.py

``` python
from django.shortcuts import render, redirect
from django.contrib.auth.forms import UserCreationForm, AuthenticationForm
from django.contrib.auth import login as auth_login
from django.contrib.auth import logout as auth_logout

# Create your views here.

def signup(request):
    if request.method == 'POST':
        form = UserCreationForm(request.POST)
        if form.is_valid():
            form.save()
            return redirect('accounts:login')
    else:
        form = UserCreationForm()
    context = {
        'form' : form,
    }
    return render(request, 'accounts/signup.html', context)


def login(request):
    if request.method == 'POST':
        form = AuthenticationForm(request, request.POST)
        if form.is_valid():
            auth_login(request, form.get_user())
            return redirect('todos:index')
    else:
        form = AuthenticationForm()
    context = {
        'form' : form
    }
    return render(request, 'accounts/login.html', context)


def logout(request):
    auth_logout(request)
    return redirect('accounts:login')
```



- base.html

``` html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    {% comment %} user 관련 메서드를 활용하면 된다. username, is_authenticated, password 등등 {% endcomment %}
    {% if user.is_authenticated %}
    <a href="{% url 'todos:index' %}">인덱스</a>
    <span> {{ user.username }} 님 환영합니다. </span>
    <a href="{% url 'accounts:logout' %}">로그아웃</a>
    {% else %}
    <a href="{% url 'accounts:signup' %}">회원가입</a>
    <a href="{% url 'accounts:login' %}">로그인</a>
    
    {% endif %}
    {% block body %}
    {% endblock  %}
</body>
</html>
```



- signup.html

``` html
{% extends 'base.html' %}

{% block body %}
    <form action="{% url 'accounts:login' %}" method="POST">
        {% csrf_token %}
        {{form}}
        <button>로그인</button>
    </form>
{% endblock  %}
```



- login.html

``` html
{% extends 'base.html' %}

{% block body %}
<form action='{% url 'accounts:signup' %}' method= 'POST'>
    {% csrf_token %}
    {{ form.as_p }}
    <button >가 입</button>
</form>

{% endblock  %}
```



- 1대 N에서의 models.py
- 로그인 한 유저마다 내용이 달라지게 해야 함

```PYTHON
from django.db import models
from django.conf import settings

# Create your models here.
class Todo(models.Model):
    content = models.CharField(max_length=100)
    due_date = models.DateField()
    user = models.ForeignKey(settings.AUTH_USER_MODEL, on_delete=models.CASCADE)
```







- 1대 N에서의 views.py
- decorators를 새로 불러와줘야 한다.

``` python
from django.shortcuts import render, redirect
from django.contrib.auth.decorators import login_required
from django.views.decorators.http import require_POST
from .forms import TodoForm
from .models import Todo

# Create your views here.
@login_required
def index(request):
    form = TodoForm()
    context = {
        'form' : form,
    }
    return render(request, 'todos/index.html', context)

@login_required
def create(request):
    form = TodoForm(request.POST)
    if form.is_valid():
        todo = form.save(commit = False)    # commit = 아직 확정은 짓지 않겠다 라는 의미
        todo.user = request.user
        todo.save()
        return redirect('todos:index')

@login_required
@require_POST
def delete(request, content_pk):
    content = Todo.objects.get(pk=content_pk)
    content.delete()
    return redirect('todos:index')

    
```

- 1대 N에서의 html(ex)오늘의 할 일)

``` python
{% extends 'base.html' %}

{% block body %}
<h1 class="text-center">오늘의 할 일</h1>
<hr>
<form action="{% url 'todos:create' %}" method="POST" class="m-4">
    {% csrf_token %}
    {{ form }}
    <button class="btn btn-success btn-lg">저 장</button>
</form>

<hr>
{% comment %} 현재 로그인한 사용자 정보를 확인하여 그 사람의 글만 출력해야 한다 {% endcomment %}

{% for todo in user.todo_set.all %} 
<div class="container-md  bg-secondary text-white m-3 border-2 border-warning rounded text-monospace">
<p>{{ todo.content }}</p>
<p class="d-inline text-right">{{ todo.due_date }}</p>

<form action="{% url 'todos:delete' todo.pk %}" method="POST" class="d-inline">
    {% csrf_token %}
    <button class="d-inline btn btn-danger">삭 제</button>
</form><br>
</div>
{% endfor %}
{% endblock  %}
```



- django user creation form 을 검색해 django 홈페이지에서 기본적으로 제공하는것들을 확인할 수 있다.



### 회원가입 업그레이드

- settings.py

``` python
AUTH_USER_MODEL = 'accounts.User'
```



- models.py

``` python
from django.db import models
from django.contrib.auth.models import AbstractUser

# Create your models here.
class User(AbstractUser):       # django에서는 이 부분을 처음에 정의하기를 추천한다.
    phone = models.CharField(max_length=20)
```



- `python manage.py makemigrations`
- `python manage.py migrate`



- forms.py

``` python
from django.contrib.auth.forms import UserCreationForm
from .models import User
from django.contrib.auth import get_user_model

# get_user_model => AUTH_USER_MODEL에 적용시킨 모델 클래스
# User = get_user_model

class CustomUserCreationForm(UserCreationForm):
    class Meta:
        model = get_user_model()
        fields = ('username', 'password1', 'password2', 'phone')
```



- views.py

``` python
from django.shortcuts import render, redirect
from django.contrib.auth.forms import UserCreationForm, AuthenticationForm
from .forms import CustomUserCreationForm
from django.contrib.auth import login as auth_login
from django.contrib.auth import logout as auth_logout
from django.contrib.auth.decorators import login_required
from django.views.decorators.http import require_POST

# Create your views here.
@login_required
def signup(request):
    if request.user.is_authenticated:
        return redirect('questions:index')

    if request.method=='POST':
        form = CustomUserCreationForm(request.POST)
        if form.is_valid():
            user = form.save()
            auth_login(request, user)
            return redirect('questions:index')
    else:
        form = CustomUserCreationForm()
    context = {
        'form' : form
    }
    return render(request, 'accounts/form.html', context)


@login_required
def login(request):
    if request.user.is_authenticated:
        return redirect('questions:index')

    if request.method=='POST':
        form = AuthenticationForm(request, request.POST)
        if form.is_valid():
            user = form.get_user()
            auth_login(request, user)
            return redirect('questions:index')
    else:
        form = AuthenticationForm()
    context = {
        'form' : form
    }
    return render(request, 'accounts/form.html', context)


def logout(request):
    auth_logout(request)
    return redirect('accounts:login')

```



- form.html 
- 어떤 형식으로 넘어오느냐에 따라 표현 방식이 달라지게 셋팅
- `request.resolver_match.url_name`

``` html
{% extends 'base.html' %}

{% block content %}

{% if request.resolver_match.url_name == 'signup' %}
    <h1>회원가입</h1>
{% else %}
    <h1>로그인</h1>
{% endif %}

<form action="" method="POST">  
    {% csrf_token %}
    {{ form }}
    <button>저 장</button>
</form>
{% endblock %}
```



- 1대 N에서의 코드

- models.py

``` python
from django.db import models
from django.conf import settings

# Create your models here.
class Question(models.Model):
    title = models.CharField(max_length=100)
    answer_a = models.CharField(max_length=100)
    answer_b = models.CharField(max_length=100)
    user = models.ForeignKey(settings.AUTH_USER_MODEL, on_delete=models.CASCADE)


class Answer(models.Model):
    choice = models.CharField(max_length=100)
    question = models.ForeignKey(Question, on_delete=models.CASCADE)
    user = models.ForeignKey(settings.AUTH_USER_MODEL, on_delete=models.CASCADE)
    
```



- forms.py

``` python
from django import forms
from .models import Question, Answer

class QuestionForm(forms.ModelForm):
    class Meta:
        model = Question
        exclude = ('user',)


class AnswerForm(forms.ModelForm):
    CHOICES = [
        ['a', 'RED'],
        ['b', 'BLUE'],
    ]

    choice = forms.ChoiceField(choices=CHOICES)

    class Meta:
        model = Answer
        exclude = ('user', 'question')
```



- urls.py

``` python
from django.urls import path
from . import views

app_name = 'questions'

urlpatterns = [
    path('', views.index, name='index'),
    path('create/', views.create, name='create'),
    path('<int:question_pk>/', views.detail, name='detail'),
    path('<int:question_pk>/answers/create/,', views.answer_create, name='answer_create'),
]

```



- views.py

``` python
from django.shortcuts import render, redirect, get_object_or_404
from .forms import QuestionForm, AnswerForm
from .models import Question, Answer

# Create your views here.
def index(request):
    return render(request, 'questions/index.html')


def create(request):
    if request.method == 'POST':
        form = QuestionForm(request.POST)
        if form.is_valid():
            question = form.save(commit=False)
            question.user = request.user
            question.save()
            return redirect('questions:detail', question.pk)
    else:
        form = QuestionForm()
    context = {
        'form' : form
    }
    return render(request, 'questions/form.html', context)


def detail(request, question_pk):
    #Question = Question.objects.get(pk = question_pk)
    question = get_object_or_404(Question, pk=question_pk)

    answers = question.answer_set.all()
    answer_a = len(answers.filter(choice='a'))
    answer_b = answers.filter(choice='b').count()
    
    answer_form = AnswerForm()
    context = {
        'question' : question,
        'answer_form' : answer_form,
        'answer_a' : answer_a,
        'answer_b' : answer_b,

    }
    return render(request, 'questions/detail.html', context)
            

def answer_create(request, question_pk):
    question = get_object_or_404(Question, pk=question_pk)
    form = AnswerForm(request.POST)
    if form.is_valid():
        answer = form.save(commit=False)
        answer.user = request.user
        answer.question = question
        answer.save()
        return redirect('questions:detail', question_pk)

```



- content.html

``` html
{% extends 'base.html' %}

{% block content %}

{{ question.title }}
{{ question.answer_a }} or
{{ question.answer_b }}

<hr>

<form action="{% url 'questions:answer_create' question.pk %}" method='POST'>
    {% csrf_token %}
    {{ answer_form }}
    <button>저 장</button>
</form>

{% for answer  in question.answer_set.all %}
    {{ answer.choice }}

{% endfor %}
    {{ answer_a }}
    {{ answer_b }}

{% endblock  %}
```





