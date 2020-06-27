## django pagination

- views.py에 

  `*from* django.core.paginator *import* Paginator`

  `from .models import [자신의 클래스 이름]`

``` python
Paginator(articles, 5) 
```



django bootstrap4 공식문서

bootstrap_pagination

usage 내 코드 사용

`{% bootstrap_pagination [불러오는 인자 이름] %}`





## django dumpdata

#### dump

`python manage.py dumpdata [앱이름].[모델 클래스명]`

`python manage.py dumpdata articles.Article`



- articles.json 형식으로 변환하여 저장

`python manage.py dumpdata articles.Article > articles.json`

정렬하여 저장하고 싶을때에는

`python manage.py dumpdata --indent=2  articles.Article > articles.json `

들여쓰기 2칸씩 하겠다는 의미

이러한 것을 fixtures 라고 한다.

이러한 json 파일은 어플리케이션 안의 fixtures 폴더를 생성해 보관한다.

의도치 않은 DB를 날려야 할 때 사용한다.



#### dump 불러오기

` python manage.py loaddata articles.json`





ctrl+ D : 같은 문자 다중 선택



