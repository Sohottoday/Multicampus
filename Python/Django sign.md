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

