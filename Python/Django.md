

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
  - urls.py에 rulpatterns에 path를 먼저 등록한다.

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

