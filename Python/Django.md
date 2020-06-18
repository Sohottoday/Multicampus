

### 파이썬 쟝고 설치

pip install django==2.1.15



### 파이썬 쟝고 프로젝트

- 파이썬 쟝고 프로젝트 파일 생성

  django-admin startproject firstapp

- 파이썬 서버 기동

  python manage.py runserver

- 하나의 프로젝트는 여러개의 앱을 가지게 된다.

  - 한 사이트에 게시판도 있고 로그인 기능도 있고 여러가지 기능이 있기 때문
  - django 프로젝트는 app들의 집합이고, 실제 요청을 처리하고 페이지를 보여주고 하는 것들은 이 app들의 역할.
  - app은 하나의 역할 및 기능 단위로 쪼개는 것이 일반적
  - 작은 규모의 서비스에서는 세부족으로 나누지는 않는다.
  - app 이름은 복수형으로 하는 것이 권장된다.

- 어플리케이션 만들기

  python manage.py startapp [어플리케이션이름]

  - admin.py : 

  - apps.py : 앱의 정보가 담겨있는 파일. 왠만해선 건들지 않는다.
  - models.py : 데이터베이스 즉, 다양한 모델들을 관리하는 파일
  - tests.py : 테스트 코드를 작성하는 파일
  - views.py : 여러가지 함수를 통해 다양한 일처리를 하는 파일

- 어플리케이션 등록

  - firstapp 내의 settings.py 에 INSTALLED_APPS에 등록해 준다.

  - INSTALLED_APPS에 작성할 때 순서는 보통

    - 1. local apps
      2. 3rd party app
      3. dango apps

    순서로 작성한다.

  - django 에서 trailing comma 사용이 가능하다.

  - LANGUAGE_CODE는 'ko-kr'로 해주면 한글로 진행할 수 있고 TIME_ZONE에 'Asia/Seoul'로 설정해 준다.

- URL 등록

  - firstapp 의 urls.py로 들어가 등록하려는 app에 있는 views.py를 등록해야 한다.

  - urls.py에서 from [app이름] import views를 작성 후 urlpatterns에 path('[주소명]/', views.index) 를 통해 등록시켜 준다.

    - views.index 는 views 안에 정의한 함수의 이름. 아래  함수 정의하는것 참조.

  - 등록하려는 app의 views에 들어가

    ```python
    def index(request):
        return render(request, [템플릿 이름 내의 html 이름])
    
    def index(request):
        return render(request, 'index.html')
    ```

    를 작성해 준다.	request 인자는 필수.

- 템플릿 생성

  - 반드시 app폴더 안에  templates 라는 이름으로 폴더를 하나 생성해 준다.
  - 그 안에서 html 파일을 생성해 진행한다.

- 기능

  - 페이지의 기능들은 views에 함수를 통해 작성한다
  - urls.py에 urlpatterns에 path를 먼저 등록한다.

  ```python
  path('dinner/', views.dinner),
  ```

  - views에 작동시키고자 하려는 함수를 정의한다

  ```python
  def dinner(request):
      foods = ['족발', '햄버거', '치킨', '초밥']
      pick = random.choice(foods)
      context = {
          'pick': pick,
      }
      return render(request, 'dinner.html', context)
  ```

  - 템플릿에서 views에 정의한 변수를 쓰고자 할 때에는 중괄호 2개 {{}} 로 표현한다.

  ```html
  <!DOCTYPE html>
  <html lang="en">
  <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Document</title>
  </head>
  <body>
      <h1>오늘의 저녁 메뉴</h1>
      <h2>{{pick}} 입니다.</h2>
  </body>
  </html>
  ```

- Variable Routing

  - url을 지정할 때 <타입:변수명> 형태로 path를 지정해 준다.
  - 기본값이 str이므로 생략도 가능하다.
  - 여러 인자를 주는 것도 가능하다.

  ```python
  path('hello/<str:name>/', views.hello),
  path('hello/<name>/', views.hello),
  path('add/<int:num1>/<int:num2>', views.add),
  ```

  - views에서 함수를 설정할 때 request와 함께 urls에서 지정한 변수도 함께 지정한다.

  ```python
  def hello(request, name):
      context = {
          'name' : name,
      }
      return render(request, 'hello.html', context)
  
  def add(request, num1, num2):
      result = num1 + num2
      context = {
          'num1' : num1,
          'num2' : num2,
          'result' : result
      }
      return render(request, 'add.html', context)
  ```

  - 템플릿 에서는 똑같이 출력해 준다.

  ```html
  <!DOCTYPE html>
  <html lang="en">
  <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Document</title>
  </head>
  <body>
      <h1> 안녕 {{ name }} !!!</h1>
  </body>
  </html>
  
  
  <!DOCTYPE html>
  <html lang="en">
  <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Document</title>
  </head>
  <body>
      <h2>첫번째 숫자는 {{num1}}이고 두번째 숫자는 {{num2}}입니다.</h2>
      <h2>두 숫자의 합은 {{result}}입니다.</h2>
      
  </body>
  </html>
  ```

- Django 익스텐션을 설치했다면 dtl 구문 사용 가능

  - 반복문
    - for 라고 치면 vsc에서는 자동으로 for문 양식이 뜬다.

  ```html
  {% for  in  %}{% endfor %}
  ```

  		- 파이썬 양식으로 작성하면 된다.

  - dtl문 주석 처리는 {% %} 대신 {# #}이런식으로 %를 #로 바꿔준다.
  - forempty구문은 비어있는 경우에 출력하는 방식도 설정할 수 있다.

- 조건문
  - if로 조건을 주어준 뒤 python if 처럼 사용하면 된다.
  - else if문도 가능하다.
- filter
  
- 변수나 객체 옆 | 을 넣어 사용한다.
  
- 단순히 내용을 채우고 싶다면 lorem 작성 후 tab
  - 원하는 길이만큼 사용 가능하다
    - lorem5 한 뒤 tab
    - lorem100 한 뒤 tab
  - lorem dtl을 이용할 때 random값을 안주면 같은내용, random을 주면 랜덤한 값이 나온다.

  

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h3>1. 반복문</h3>
    {% for food in foods %}
        <p>{{ food }}</p>
    {% endfor %}
    {% for food in foods %}
        <p>{{ forloop.counter}} {{ food }}</p>
    {% endfor %}

    {% for element in empty_list %}
        <p>{{element}}</p>
    {% empty %}
        <p>지금 아무것도 음슴</p>
    {% endfor %}

    <h3>2. 조건문</h3>
    {% if '짜장면' in foods %}
        <p>짜장면보단 짬뽕이 맛있따</p>
    {% endif %}

    {% for food in foods %}
        {% if forloop.first %}
            <p>짜장면엔 고추가루지!!</p>
        {% else %}
            <p>{{ food }}</p>
        {% endif %}
    {% endfor %}

    <h3>3. length filter</h3>
    {% for food in foods %}
        {% if food|length > 2 %}
            <p>메뉴 이름이 너무 길어요</p>
        {% else %}
            <p>{{ food }}, {{food|length}}</p>
        {% endif %}
    {% endfor %}

    <h3>4. lorem ipsum</h3>
    <p>{% lorem %}</p>
    <hr>
    {% lorem 3 w random %}

    <h3>5. 글자수 제한</h3>
    <p>{{ messages|truncatewords:3 }}</p>
    <p>{{ messages|truncatechars:10 }}</p>
    <hr>

    <h3>6. 글자 관련 필터</h3>
    <p>{{ 'ABC'|lower }}</p>
    <p>{{ messages|title }}</p>
    <p>{{ 'abc def gft'|capfirst }}</p>
    <p>{{ foods|random }}</p>
    
    <h3>7. 연산</h3>
    <p>{{ 4|add:6 }}</p>

    <h3>8. 날짜 표현</h3>
    <p>{{ datetime_now }}</p>
    <p>{% now " DATE_FORMAT" %}</p>
    <p>{% now "DATETIME_FORMAT" %}</p>
    <p>{% now "SHORT_DATE_FORMAT" %}</p>
    <p>{% now "SHORT_DATETIME_FORMAT" %}</p>
    

</body>
</html>
```

- django에서 검색창과 보여주는 view는 2개가 필요하다.

  - form태그의 input의 내용들은 request 객체에 모두 담긴다.
  - 모를때에는 검색할 때 뒤에 mdn을 붙이면 자세한 정보가 나온다 ex) input type mdn
  - form 에서 중요한 것
    - 데이터를 어디로 보낼 것인지 => action
    - 어떤 방식으로 보낼지 = method
    - 어떤 데이터를 보낼지 => input, type
    - 데이터의 이름은 어떻게 붙일지 => name
    - 제출 => submit
  -  request 객체 안에는 딕셔너리 타입으로 저장된다.
  - 가져오는 값의 이름은 input 태그의 name에 지정한다.

  ```html
  <!DOCTYPE html>
  <html lang="en">
  <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Document</title>
  </head>
  <body>
      <h1>Throw</h1>
      <form action="/catch/">
          <input type="text" name="message">
          <input type="submit">
      </form>
  </body>
  </html>
  ```

  ```python
  def throw(request):
      return render(request, 'throw.html')
  
  
  def catch(request):
      #pprint(request.GET)
      #print(request.GET.get('message'))
      context = {
          'message' : request.GET.get('message')
      }
      return render(request, 'catch.html', context)
  ```

  ```html
  <!DOCTYPE html>
  <html lang="en">
  <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Document</title>
  </head>
  <body>
      <h1>여기는 catch 입니다.</h1>
      <h2>검색 결과 : {{ message }}  </h2>
  </body>
  </html>
  ```




### django 설정들

- 하나의 urls.py에서 모든 path를 관리하기가 어려워짐
- 메인 urls.py 에서 하위 어플리케이션들을 import해준 뒤 urlpatterns에 등록해 준다.
- 하위 어플리케이션들은 포함시키는 것이기 때문에 include 해준다.

``` python
from django.contrib import admin
from django.urls import path, include
from articles import views
from pages import views 

urlpatterns = [
    path('admin/', admin.site.urls),
    path('articles/', include('articles.urls')),
    path('pages/', include('pages.urls')),
]
```



- 각각의 어플리케이션에 urls.py을 만들어 페이지들을 만들 때 등록해준다.
  - html파일 이름이 겹치는것을 대비하여 app_name까지 설정해 준다.
  - 또한 주소가 변경되는 등의 변수를 대비하기 위하여 name까지 설정해 준다.

```python
from django.urls import path
from . import views


app_name = 'articles'
urlpatterns = [
    path('', views.index, name="index"),
    path('dinner/', views.dinner),
    path('random/', views.ranimg),
    path('hello/<str:name>/', views.hello),
    path('myname/<myname>/<int:age>/', views.myname),
    path('add/<int:num1>/<int:num2>', views.add),
    path('dtl-practice/', views.dtl_practice),
    path('readreverse/<testword>', views.readreverse),
    path('throw/', views.throw, name='throw'),
    path('catch/', views.catch, name='catch'),
    path('yourname/', views.yourname, name='yourname'),
    path('yournumber/', views.yournumber, name='yournumber'),
    path('artii/', views.artii, name='artii'),
    path('artii-result', views.artii_result, name='artii_result'),
]
```

``` python
from django.urls import path
from . import views

app_name = 'pages'
urlpatterns = [
    path('', views.index, name='index'),
]
```

- 지정한 app_name을 통해 불러오는 경우
  - url + tab 을 통해 지정해 준다.

``` html
{% extends 'base.html' %}
{% block title %}THROW{% endblock  %}
{% block content %}

    <h1>Throw</h1>
    <form action="{% url 'articles:catch' %}" method="GET">
        <input type="text" name="message">
        <input type="color" name="color">
        <input type="submit">
    </form>
{% endblock  %}
```





- django namespace : app_name/templates 이후에 app_name 폴더를 하나 더 둠으로써 이름 공간을 생성한다.
  - 폴더 구조 : `app_name / templates / app_name / index.html`



##### 템플릿 상속(templates inheritance)

- 템플릿을 상속하는 이유는 여러 페이지에 동일한 구조를 적용시키기 위함.
- 템플릿의 재사용성에 초점. extends로 확장해서 가져옴
- django는 기본적으로 app_name/templates에서 템플릿을 찾기 때문에 설정이 필요함

- 설정은 settings.py에서 진행한다.
- 'DIRS' 부분을 `os.path.join(BASE_DIR, 'app_name', 'templates')` 로 변경한다.

``` python
TEMPLATES = [
    {
        'BACKEND': 'django.template.backends.django.DjangoTemplates',
        'DIRS': [os.path.join(BASE_DIR, 'firstapp', 'templates')],
        'APP_DIRS': True,
        'OPTIONS': {
            'context_processors': [
                'django.template.context_processors.debug',
                'django.template.context_processors.request',
                'django.contrib.auth.context_processors.auth',
                'django.contrib.messages.context_processors.messages',
            ],
        },
    },
]
```

#### static

- 웹사이트 구성 요소 중에서 image, css, js 파일과 같이 해당 내용이 고정되어 응답을 할 때 별도의 처리 없이 파일 내용을 그대로 보여주는 파일(정적 파일)을 사용할때 쓴다.
- django는 기본적으로 app_name도 static에서 찾는다.
- 보통 이미지는 images로, css파일은 stylesheets 로 만든다
  - `app_name/templates/app_name/stylesheets/~~~.css`

- static을 사용하기 위하여 settings.py에서 가장 아랫부분에 static 설정이 필요하다

``` python
STATICFILES_DIRS = [
    os.path.join(BASE_DIR, 'firstapp', 'static'), 
]
```



#### 상속과 static을 활용하기

- bast.html
  - static이 필요한 경우 static을 load해주고 하위 어플리케이션에서 넣을 내용을 block지정과 함께 이름을 부여한다.

``` html
{% load static %}
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>{% block title %}BASE TITLE{% endblock %}</title>
       <!-- CSS only -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <style>
        body {
            background-image : url('{% static 'firstapp/images/notebook.jpg' %}');
        }
        
    </style>
    {% block css %}{% endblock  %}
</head>
<body>
    <div class="container">
        {% block content %}
        {% endblock  %}
    
    </div>
 
    <!-- JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>
```



- 각각의 어플리케이션 템플릿.html
  - base.html을 extends한 뒤 필요한 내용을 집어넣는다.
  - 별도의 html 양식을 불러올 필요는 없다.
  - ex 1) 

``` html
{% extends 'base.html' %}
{% load static %}

{% block css %}
    <link rel="stylesheet" href="{% static 'pages/stylesheets/style.css' %}">
{% endblock  %}
{% block content %}
    <img src="{% static 'pages/images/blackhole.jpg' %}" alt="">
    <h1>두번째 앱의 index</h1>
    <img src="{% static 'firstapp/images/notebook.jpg' %}" alt="">
{% endblock  %}

```

- - ex 2)

``` html
{% extends 'base.html' %}
{% block title %}ARTII RESULT{% endblock  %}
{% block content %}

    <h1>결과!! </h1>
    <pre>{{result}}</pre>
    <a href="{% url 'articles:artii' %}">다시 돌리기</a>
    <a href="{% url 'articles:index' %}">index로 가기</a>
{% endblock  %}
```





## 클래스

- 객체를 표현하기 위한 문법
- 같은 종류의 집단에 속하는 속성(attribute)과 행위(behavior)를 정의한 것으로, OOP 프로그램의 기본적인 데이터 타입.
- 클래스의 이름 지정은 파스칼 케이스로 진행한다.
  - 스네이크 케이스 : My_List_All -> 띄워쓰기 등을 언더바로 구분한다.
  - 파스칼 케이스 : MyListAll -> 띄워쓰기 등을 대문자로 구분한다.

#### 인스턴스

- 클래스의 인스턴스/객체 (실제로 메모리상에 할당된 것)
- 인스턴스는 자신 고유의 속성(attribute)을 가지며 클래스에서 정의한 행위(behavior)를 수행할 수 있다.
- 인스턴스의 행위는 클래스에 정의된 행위에 대한 메서드를 공유함으로써 메모리를 경제적으로 사용할 수 있다.

#### 속성(attribute)

- 클래스/인스턴스가 가지고 있는 속성(값)

#### 메서드(method)

- 클래스/인스턴스가 할 수 있는 행위(함수)

#### self

- 인스턴스 자기 자신

### ORM

- OOP 프로그래밍에서 



## Models

### Model 작성 3단계

1. models.py 작성

``` python
from django.db import models

# Create your models here.
class Article(models.Model):
    title = models.CharField(max_length=20)     # CharField는 글자수 제한이 있는 클래스변수
    content = models.TextField()        # TextFired는 글자수 제한 없음
    created_at = models.DateTimeField(auto_now_add=True)    # auto_now_add : 데이터가 최초 생성된 시각
    updated_at = models.DateTimeField(auto_now=True)

```



2. migrations (설계도) 작성
   - `python manage.py makemigrations` 명령어 수행
   - Migrations for 'articles':
       articles\migrations\0001_initial.py
         - Create model Article 와 함께 py 파일 하나 생성됨
   - migrations 폴더 안의 0001_initial.py 내용은 models.py에 작성한 내용을 기반으로 생성된다.



3. migrate(db 작성, 구축)

- `python manage.py migrate` 명령어 수행



* 관련 명령어

  * `python manage.py sqlmigrate [app_name] [migration number]`

    * python manage.py sqlmigrate articles 0001 
    * SQL문으로 어떻게 해석되어 나가는지를 볼 수 있다.

  * `python manage.py shell`

    * ipython 환경으로 변경

    

* 쟝고의 shell을 쓰기 위해 `pip install django-extensions` 명령어를 통해 extensions을 설치해 준다.

  * 설치 후 settings.py 의 INSTALLED에 'django_extensions', 를 추가해 준다.
  * 명령창에 `python manage.py shell_plus` 를 실행해 주면 모든 import가 등록된다.



#### CharField()

- 길이의 제한이 있는 문자열을 넣을 때 사용

- max_length는 필수 인자
- 텍스트 양이 많을 경우 -> TextField()를 사용
- 

`python manage.py makemigrations`	          migrations 폴더에 파일 하나가 생성됨(models 기준으로)

`python manage.py sqlmigrate articles 0001`		(0001 번호는 migration 폴더 안의 py 파일의 축약형)

`python manage.py migrate`      정의한 내용대로 SQL 테이블 생성



- `auto_now_add`
  - 최초 생성 일자
  - django ORM 이 최소 insert 시에만 현재 날짜와 시간으로 갱신
- `auto_now`
  - 최종 수정 일자
  - django ORM이 save를 할 때마다 현재 날짜와 시간으로 갱신



### CRUD

#### objects

- models.py에 작성한 클래스를 불러와서 사용할 때 DB와의 인터페이스 역할을 하는 manager

#### READ

- QuerySet
  - objects 매니저를 사용하여 복수의 데이터를 가져오는 함수를 사용할 때 반환되는 객체 타입
  - 단일 객체는 Query(class의 인스턴스로 반환)
  - query(질문)를 DB에게 보내서 글을 조회하거나 생성, 수정, 삭제
  - query를 보내는 언어를 활용해서 DB에게 데이터에 대한 조작을 실행
- 전체 조회 : `Article.objects.all()`
- 선택 조회 : `Article.objects.get(pk = [찾는 프라이머리 키])`
  - 프라이머리키를 통한 조회
  - .get() 을 사용할 때 해당 객체가 없으면 DoesNotExist 에러가 발생.
  - 여러개일 경우에 MultipleObjectReturned 에러가 발생
  - 이와 같은 특징 때문에 unique 한 속성을 가지고 있는 데이터에 사용해야 한다(pk)

- 특정 조건 객체 가져오기
  - `Article.objects.filter(title = 'first')`
  - `Article.objects.filter(title = 'first', content = 'django!')`
- 내림차순
  - `Article.objects.order_by('-pk')`
  - -를 붙이면 내림차순
- Like
  - 특정 단어가 포함된 것 검색
    - `Article.objects.filter(title__contains = 'fi')`    언더바가 2개다
  - 특정 단어로 시작되는 것 검색
    - `Article.objects.filter(title__startswith = 'fi')`
  - 특정 단으로 끝나는 것 검색
    - `Article.objects.filter(content__endswith = '!')`



### CREATE

- create 하는 3가지 방법

```python
# 1
article = Article()
article.title = 'first'
article.content = 'django!'
article.save()

# 2
article = Article(title = 'second', content = 'django!!')
article.save()

# 3
Article.objects.create(title = 'second', content = 'django!!!')
```



### UPDATE

``` pytho
article = Article.objects.get(pk = 1)
article.title = 'edit title'
article.save()
```



### DELETE

```python
article = Article.objects.get(pk = 1)
article.delete()
```



##### object

- models.py에 작성한 클래스를 불러와서 사용할 때 DB와의 인터페이스 역할을 하는 manager
- python class ------- objects -----------DB(SQL)





#### 계정 또한 데이터이기 때문에 반드시 migrate 작업 후에 관리자 계정을 만들어야 한다.

### admin 작성 순서

1. python manage.py createsuperuser
2. admin.py 작성



- admin.py에 작성한 내용들

```python
from django.contrib import admin
from .models import Article

# Register your models here.
class ArticleAdmin(admin.ModelAdmin):
    list_display = ['pk', 'title', 'content', 'created_at',]
    list_editable = ['title']

admin.site.register(Article, ArticleAdmin)
# admin site에 등록(register) 하겠다.
```



#### READ 적용

- views.py

``` python
from django.shortcuts import render
from .models import Article

# Create your views here.
def index(request):
    articles = Article.objects.all()

    context = {
        'articles' : articles,
    }
    return render(request, 'articles/index.html', context)
```



- index.html

``` html
{% extends 'base.html' %}

{% block content %}
    <h1 class="text-center">Articles</h1>
    <hr>
    {% for article in articles %}
        <p>글 번호 : {{article.pk}}</p>
        <p>글 제목 : {{article.title}}</p>
        <p>글 내용 : {{article.content}}</p>
        <p>글 시간 : {{article.created_at}}</p>
        <hr>
    
    {% endfor %}
    <hr><hr>

{% endblock  %}
```







### ORM을 활용한 DJANGO APP 만들어보기

1. `django-admin startproject [project 이름] ` 을 통해 프로젝트 폴더 생성
2. `python manage.py start [APP 이름]` 을 통해 어플리케이션 폴더 생성
3. 



#### READ

``` PYTHON
from django.shortcuts import render
from .models import Article

# Create your views here.
def index(request):
    articles = Article.objects.all()

    context = {
        'articles' : articles,
    }
    return render(request, 'articles/index.html', context)
```



#### CREATE

- 필요한 view 함수는 2개
  - new / create

#### POST

- 사용자는 DJANGO에게 'html파일 줘!(GET)'가 아니라 '~한 레코드(글)을 생성해줘!(POST)'이기 때문에 http method POST를 사용해야 한다.
- 데이터는 URL에 직접 노출되서는 안된다.(우리가 URL에 접근하는 방식은 모두 GET 요청) / query의 형태를 통해 DB 구조(schema)를 유추할 수 있고 이는 보안적인 측면에서 매우 취야약하다.
- DB를 조작하는 친구는 GET이 아닌 POST
  - 중요한 요청이기 때문에 최소한의 신원 확인이 필요
  - csrf_token을 생성해 post방식으로 오류 없이 넘겨준다.

``` html
{% extends 'base.html' %}

{% block content %}
<h1>NEW</h1>
<form action="{% url 'articles:create' %}" method='POST'>
    {% csrf_token %}
    <input type="text" name="title"><br>
    <textarea name="content" cols="30" rows="10"></textarea><br>
    <button class="btn btn-primary">작 성</button>

</form>
{% endblock  %}
```



- 예를들어 게시글 작성 후에는 작성 완료 후 다시 목록 페이지를 보여주는 것이므로 render가 아닌 redirect를 사용한다. redirect를 사용할 때 url구조는 :를 활용한다

``` python
from django.shortcuts import render, redirect
from .models import Article

# Create your views here.
def index(request):
    articles = Article.objects.all()

    context = {
        'articles' : articles,
    }
    return render(request, 'articles/index.html', context)


def new(request):
    return render(request, 'articles/new.html')


def create(request):
    # 1. new에서 보낸 데이터 받기
    title = request.POST.get('title')
    content = request.POST.get('content')

    # 2. db에 저장
    # article = Article()
    # article.title = title
    # article.content = content
    # article.save()

    article = Article(title = title, content = content)
    article.save()

    #Article.objects.create(title = title, content = content)
    return redirect('articles:index')
```



#### READ(DETAIL) 상세페이지

- 일반적인 게시판에서 보듯이 클릭했을 경우 상세내용을 보는 것
- 프라이머리키로 링크를 걸어주면 된다.

``` python
def create(request):
    # 1. new에서 보낸 데이터 받기
    title = request.POST.get('title')
    content = request.POST.get('content')
    # 2. db에 저장
    # article = Article()
    # article.title = title
    # article.content = content
    # article.save()

    article = Article(title = title, content = content)
    article.save()

    #Article.objects.create(title = title, content = content)
    return redirect('articles:detail', article.pk)


def detail(request, pk):
    article = Article.objects.get(pk=pk)
    context = {
        'article' : article,
    }
    return render(request, 'articles/detail.html', context)
```

- 디테일 페이지 내부

``` html
{% extends 'base.html' %}

{% block content %}
    <h1>DETAIL</h1>
    {{ article.pk }} 번 글
    <hr>
    <p>제목 : {{article.title}}</p>
    <p>내용 : {{article.content}}</p>
    <p>작성 시각 : {{article.created_at}}</p>
    <p>수정 시각 : {{article.updated_at}}</p>
    <hr>
    <a href="{% url 'articles:index' %}">back</a>

{% endblock  %}
```

- 인덱스 페이지

``` html
{% extends 'base.html' %}

{% block content %}
    <h1 class="text-center">Articles</h1>
    <a href="{% url 'articles:new' %}">NEW</a>
    <hr>
    {% comment %} {% for article in articles %}
        <p>글 번호 : {{article.pk}}</p>
        <p>글 제목 : {{article.title}}</p>
        <p>글 내용 : {{article.content}}</p>
        <p>글 시간 : {{article.created_at}}</p>
        <hr>
    
    {% endfor %} {% endcomment %}
    <table>
    {% for article in articles %}
    <tr>
    <td>{{article.pk}}</td>
    <td><a href="{% url 'articles:detail' article.pk %}">{{article.title}}</a></td>
    {% comment %} <td>{{article.content}}</td> {% endcomment %}
    <td>{{article.created_at}}</td>
    </tr>
    {% endfor %}
    
    </table>

{% endblock  %}
```



#### Delete

- 삭제 역시 주소창에 남으면 DB변동이 마음대로 될 가능성이 있으므로 get방식이 아닌 post방식으로 진행해야 한다.
- 삭제하면 '삭제되었습니다'같은 페이지는 필요 없이 목록 페이지로 돌아가면 된다
- 또한 GET 방식일때 작동하지 않고 POST 방식일때만 작동하도록 하려면 if문을 써준다.

``` python
def delete(request, pk):
    article = Article.objects.get(pk=pk)
    if request.method == 'POST':
        article.delete()
        return redirect('articles:index')
    else:
        return redirect('articles:detail', article.pk)
```

- html에서도 csrf_token을 빼먹으면 오류가 뜬다.

```html
<form action="{% url 'articles:delete' article.pk %}" method="post">
        {% csrf_token %}
        <button>삭 제</button>
</form>
```



#### Update

- 수정을 작성하는 곳, 수정을 전달하는 페이지, 2개가 필요하다
- update 역시 프라이머리키 기준으로 진행하는것이 좋다.
- edit/update

``` python
    path('<int:pk>/edit/', views.edit, name='edit'),
    path('<int:pk>/update/', views.update, name='update'),
```

- views.py

``` python
def edit(request, pk):
    article = Article.objects.get(pk=pk)
    context = {
        'article' : article,
    }
    return render(request, 'articles/edit.html', context)


def update(request, pk):
    article = Article.objects.get(pk=pk)
    # 1. update는 edit에서 보내는 데이터 받기
    title = request.POST.get('title')
    content = request.POST.get('content')
    article.title = title
    article.content = content
    article.save()

    return redirect('articles:detail', article.pk)
```

- edit.html
  - 기존 값들을 받아와 출력한 뒤 update로 넘긴다.

``` html
{% extends 'base.html' %}

{% block content %}
<h1>EDIT</h1>
<form action="{% url 'articles:update' article.pk %}" method='POST'>
    {% csrf_token %}
    <input type="text" name="title" value="{{article.title}}"><br>
    <textarea name="content" cols="30" rows="10"> {{article.content}} </textarea><br>
    <button class="btn btn-primary">수 정</button>

</form>
{% endblock  %}
```

- 세부 내용에서의 수정 버튼

``` html
<a href="{% url 'articles:edit' article.pk %}">수 정</a>
```

### DJANGO form 클래스

- form 내 field들, field배치, widget, label 유효한 값 등을 정의하고 비유효한 field에 관련된 에러메세지를 결정한다.
- 우리가 직접 form 태그를 작성하는 것보다 유효한 데이터에 요구되는 여러 동작을 '올바르게'하기 위해서 제공하는 기능

#### ModelForm

- django가 해당하는 모델에서 양식에 필요한 모든 정보를 이미 정의한다.
- Meta정보를 통해 어떤 model을 정의하는지 이미 알고 있기 때문에 검증이 끝나면 바로 save()가 가능하다.



- 작업중인 어플리케이션에 forms.py 를 생성한다.
- DB에 있는 변수를 끌어다 쓰기 때문에 DB 클래스를 import한다
- foms.py에서 html작업도 가능하다.

``` python
from django import forms
from .models import Article

# class ArticleForm(forms.Form):
#     title = forms.CharField(max_length=20)
#     content = forms.CharField(widget=forms.Textarea)

class ArticleForm(forms.ModelForm):
    # 출력되는 값들을 지정해주기 위한 위젯
    title = forms.CharField(
        label='제목',       # 출력되는 값 지정
        widget=forms.TextInput(     # html에서 class명 등을 지정할 수 없기 때문에 이곳에서 지정한다.
            attrs={
                'class' : 'my-title',
                'placeholder' : 'Enter the title',
            }
        )
    )
    content = forms.CharField(
        label='내용',
        widget=forms.Textarea(
            attrs={
                'class' : 'my-content',
                'placeholder' : 'Enter the content',
                'cols' : 50,
                'rows' : 5,
            }
        )
    )
    #   Meta : ArticleForm 클래스에 대한 정보를 작성하는 곳
    class Meta:         # Meta는 정보에 대한 정보
        model = Article
        #fields = ['title', 'content', ]
        fields = '__all__'      # 이렇게 지정하면 모든 input을 출려개준다.
        # 단 이렇게 했을 경우 원치 않는 부분까지 출력될 수도 있다.
        # create와 update시간이 나오지 않는것은 input이 아니기 때문
        # exclude = ['title']
        # exclude를 통해 빼고싶은 부분만 뺄 수 있다.
        
```



- views.py에서는 기존의 방식과 다르게 하나의 함수 정의로 CREATE나 UPDATE 작업이 가능하다.
- POST방식에서는 유효성 검사가 필요하다.

```python
from django.shortcuts import render, redirect
from .models import Article
from .forms import ArticleForm

# Create your views here.
def index(request):
    articles = Article.objects.all()
    context = {
        'articles': articles,
    }
    return render(request, 'articles/index.html', context)


def create(request):

    if request.method == 'POST':
        form = ArticleForm(request.POST)
        # 유효성 검사를 통해 안전한 데이터면 저장하라
        if form.is_valid():
            article = form.save()     
            return redirect('articles:detail', article.pk)
    else:       # 넘어오는 값이 GET 뿐만 아니라 다른  method 전주
        form = ArticleForm()
    # form의 2가지 모습
    # 1. is_vaild()에서 통과하지 못한 form
    # 2. else 구문의 form
    # context 들여쓰기가 왜 이곳인지는 이론적으로 이해해야 한다
    ## 내부 if분이 아닌 외부 if문의 else의 값에 대한 것이다.
    context = {
        'form' : form
    }
    return render(request, 'articles/create.html' , context)
    


def detail(request, pk):
    article = Article.objects.get(pk=pk)
    context = {
        'article': article,
    }
    return render(request, 'articles/detail.html', context)


def update(request, pk):
    article = Article.objects.get(pk=pk)
    if request.method == 'POST':
        form = ArticleForm(request.POST, instance=article)
        if form.is_valid():
            form.save()
            return redirect('articles:detail', article.pk)
    else:
        form = ArticleForm(instance=article)
    context = {
        'form' : form,
    }
    return render(request, 'articles/update.html', context)


def delete(request, pk):
    article = Article.objects.get(pk=pk)
    if request.method == 'POST':
        article.delete()
        return redirect('articles:index')
    return redirect('articles:detail', article.pk)

```

- 자기 자신에 대한 action은 입력할 필요가 없다.

```html
{% extends 'base.html' %}

{% block content %}
<h1>NEW</h1>
<form action="{% url 'articles:create' %}" method="POST">
  {% csrf_token %}
  {{ form.as_p }}   
  {% comment %} p태그로 감싸겠다는 의미 {% endcomment %}
  {% comment %} form .as_p / .as_ul / .as_ul {% endcomment %}
  <button class="btn btn-primary">작성</button>
</form>
{% endblock %}
```

```html
{% extends 'base.html' %}

{% block content %}
<h1>UPDATE</h1>
<form action="" method="POST">
  {% csrf_token %}
  {{ form.as_p }}   
  {% comment %} p태그로 감싸겠다는 의미 {% endcomment %}
  {% comment %} form .as_p / .as_ul / .as_ul {% endcomment %}
  <button class="btn btn-primary">수정</button>
</form>
{% endblock %}
```



- 데코레이터 퐐용으로 기능성 향상 및 코드 간단하게 만들어보기
  - require을 import한 뒤 함수 위에 @를 통해 데코레이터 활용

```python
from django.shortcuts import render, redirect
from django.views.decorators.http import require_http_methods, require_POST
from .models import Article
from .forms import ArticleForm


@require_http_methods(["GET", "POST"])
def create(request):

    if request.method == 'POST':
        form = ArticleForm(request.POST)
        # 유효성 검사를 통해 안전한 데이터면 저장하라
        if form.is_valid():
            article = form.save()     
            return redirect('articles:detail', article.pk)
    else:       # 넘어오는 값이 GET 뿐만 아니라 다른  method 전주
        form = ArticleForm()
    # form의 2가지 모습
    # 1. is_vaild()에서 통과하지 못한 form
    # 2. else 구문의 form
    # context 들여쓰기가 왜 이곳인지는 이론적으로 이해해야 한다
    ## 내부 if분이 아닌 외부 if문의 else의 값에 대한 것이다.
    context = {
        'form' : form
    }
    return render(request, 'articles/create.html' , context)
    


def detail(request, pk):
    article = Article.objects.get(pk=pk)
    context = {
        'article': article,
    }
    return render(request, 'articles/detail.html', context)

@require_http_methods(["GET", "POST"])
def update(request, pk):
    article = Article.objects.get(pk=pk)
    if request.method == 'POST':
        form = ArticleForm(request.POST, instance=article)
        if form.is_valid():
            form.save()
            return redirect('articles:detail', article.pk)
    else:
        form = ArticleForm(instance=article)
    context = {
        'form' : form,
    }
    return render(request, 'articles/update.html', context)

@require_POST
def delete(request, pk):
    article = Article.objects.get(pk=pk)
    article.delete()
    return redirect('articles:detail', article.pk)

```



- 부트스트랩까지 적용한 Model Form의 코드

``` python
from django import forms
from .models import Article

class ArticleForm(forms.ModelForm):
    title = forms.CharField(
        label='제목',      
        widget=forms.TextInput(     
            attrs={
                'class' : 'my-title form-control',		# from-control 클래스 추가
                'placeholder' : 'Enter the title',
            }
        )
    )
    content = forms.CharField(
        label='내용',
        widget=forms.Textarea(
            attrs={
                'class' : 'my-content form-coltrol',
                'placeholder' : 'Enter the content',
                'cols' : 50,
                'rows' : 5,
            }
        )
    )
   
    class Meta:         
        model = Article
        #fields = ['title', 'content', ]
        fields = '__all__'  
```

- create.html

``` html
{% extends 'base.html' %}

{% block content %}
<h1>NEW</h1>
<form action="{% url 'articles:create' %}" method="POST">
  {% csrf_token %}
  <h3>V 1</h3>
  {{form.as_p}}
  <hr>

  <h3>V 3</h3>
  {% for field in form %}
  <div class="form-group">
    {{ field.label_tag }}
    {{ field }}
  </div>
  {% endfor %}

  <button class="btn btn-primary">작성</button>
</form>
{% endblock %}
```

- update.html

```html
{% extends 'base.html' %}
{% load bootstrap4 %}

{% block content %}
<h1>UPDATE</h1>
<form action="" method="POST">
  {% csrf_token %}
  {% bootstrap_form form %}
    {% buttons %}
      <button type="submit" class="btn btn-primary">
        Submit
      </button>
    {% endbuttons %}  
</form>
{% endblock %}
```











- alt + shift + 방향키를 누르면 같은 현재 위치의 커서 내용이 복사된다

http://picsum.photos/200/300.jpg

#### django import style guide

1. standard library

2. 3rd party library

3. django

4. local django

   

#### django 익스텐션 설치

- 익스텐션 설치 후 f1 -> json -> open settings 에 들어가 json 익스텐션 내 내용들을 복붙해준다.

- 이 설정을 하고 나면 익스텐션 설치한 후에도 !+tab이 가능하다.

#### GET

- HTTP method 중 GET 요청은 서버로부터 정보를 조회하는데 사용된다.
- 서버의 데이터나 상태를 변경시키지 않기 때문에 단순 조회(html)할 때 사용.
- 데이터를 전송할 때 http body가 아니라 쿼리스트링을 통해 전송.(쿼리스트링 : URL 뒤쪽에 붙는 내용들)

#### django bootstrap4 를 통해 느낌 내기

- 구글에서 django bootstrap4 검색해서 보면 된다.

- 쟝고에서의 부트스트랩 적용 관련 pip 설치

  `pip install django-bootstrap4`

- 설치 후 settings.py의 INSTALLED_APP 에 'bootstrap4', 를 추가해준다.
- base.html에 load bootstrap은 필수고 사용하려는 곳에도 load는 필수다.

`*{# Load the tag library #}*`

`{% *load* bootstrap4 %}`

``` html
{% extends 'base.html' %}
{% load bootstrap4 %}

{% block content %}
<h1>UPDATE</h1>
<form action="" method="POST">
  {% csrf_token %}
  {% bootstrap_form form %}
    {% buttons %}
      <button type="submit" class="btn btn-primary">
        Submit
      </button>
    {% endbuttons %}  
</form>
{% endblock %}
```



#### SQLite로 csv파일 import하기

- sqlite3 db.sqlite3

- .mode csv

  .import [data.csv] [sqlite DB이름]





| F&Q                       | https://docs.djangoproject.com/ko/3.0/faq/general/           |
| ------------------------- | :----------------------------------------------------------- |
| built in tags and filters | https://docs.djangoproject.com/ko/2.1/ref/templates/builtins/#built-in-template-tags-and-filters |
| style guide               | https://docs.djangoproject.com/ko/2.1/internals/contributing/writing-code/coding-style/ |
| 설계 철학                 | https://docs.djangoproject.com/ko/2.1/misc/design-philosophies/#design-philosophies |
| Template inheritance      | https://docs.djangoproject.com/ko/2.1/ref/templates/language/#template-inheritance |
| Managing static files     | https://docs.djangoproject.com/en/2.1/howto/static-files/#managing-static-files-e-g-images-javascript-css |
| 쿼리 만들기               | https://docs.djangoproject.com/ko/2.1/topics/db/queries/     |
| Queryset api reference    | https://docs.djangoproject.com/ko/2.1/ref/models/querysets/#queryset-api-reference |
| Admin site                | https://docs.djangoproject.com/ko/2.1/ref/contrib/admin/#module-django.contrib.admin |
| Model field reference     | https://docs.djangoproject.com/ko/2.1/ref/models/fields/#module-django.db.models.fields |
| ORM 요리책                | https://django-orm-cookbook-ko.readthedocs.io/en/latest/     |
| shortcut functions        | https://docs.djangoproject.com/ko/2.1/topics/http/shortcuts/#module-django.shortcuts |
| Form                      | https://docs.djangoproject.com/ko/2.1/topics/forms/#working-with-forms |
| ModelForm                 | https://docs.djangoproject.com/ko/2.1/topics/forms/modelforms/ |
| form fields               | https://docs.djangoproject.com/en/2.1/ref/forms/widgets/#django.forms.Widget.attrs |
| widgets                   | https://docs.djangoproject.com/en/2.1/ref/forms/widgets/#module-django.forms.widgets |
| view decorators           | https://docs.djangoproject.com/ko/2.1/topics/http/decorators/ |
|                           |                                                              |
|                           |                                                              |
|                           |                                                              |
| pythonic code             | https://access.redhat.com/blogs/766093/posts/2802001         |
| 20 tips for python        | https://www.blog.duomly.com/20-essential-python-tips-and-tricks-you-should-know/ |
| f-string                  | https://www.python.org/dev/peps/pep-0498/                    |
| f-string                  | http://zetcode.com/python/fstring/                           |
| class                     | https://docs.python.org/ko/3.7/tutorial/classes.html#classes |
| emmet cheat sheet         | https://docs.emmet.io/cheat-sheet/                           |
| sqlite 설치               | https://www.notion.so/sqlite3-for-window10-b91a677740674c4abfad55409de1265e |



