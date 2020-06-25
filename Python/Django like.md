pip install django-imagekit

font awesome



### 종합 코드

- Imagekit 설치한 뒤 사용하려면 settings.py의 installed에 설정 필요

``` python
INSTALLED_APPS = [
    'accounts',
    'posts',
    'bootstrap4',
    'imagekit',
    'django.contrib.admin',
    'django.contrib.auth',
    'django.contrib.contenttypes',
    'django.contrib.sessions',
    'django.contrib.messages',
    'django.contrib.staticfiles',
]
```

- user 관련된 부분들을 편하게 진행하기 위해 `AUTH_USER_MODEL = 'accounts.User'` 설정
- 업로드되는 이미지들의 저장공간과 URL설정

``` python
MEDIA_URL = '/media/'       # 사용자들에게 보여주기 위한 주소
MEDIA_ROOT = os.path.join(BASE_DIR, 'media')    # 실제 저장되는 주소
```

- 프로젝트의 urls.py 
  - 이미지와 같은 미디어 파일을 위한 설정 필요
  - user 관련 설정을 가져오기 위한 import

``` python
from django.contrib import admin
from django.urls import path, include
from django.conf.urls.static import static
from django.conf import settings

urlpatterns = [
    path('admin/', admin.site.urls),
    path('accounts/', include('accounts.urls')),
    path('posts/', include('posts.urls')),

]
# 보통 django에서는 아래와 같은 형식으로 추가하는 것을 권장한다.
urlpatterns += static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)
```



- models.py

``` python
from django.db import models
from django.conf import settings
from imagekit.models import ProcessedImageField
from imagekit.processors import ResizeToFill

# Create your models here.
#class User(models.Model):
    # post_set = FK => 어떤 유저가 작성한 글들
    # post_set = M2M(many to many)(like_posts) => 어떤 유저가 좋아요 버튼을 누른 글들
    # post_set이라는 같은 이름으로 충돌이 일어남.
#user.like_posts   
#post.like_user -> like_users를 의미함


class Post(models.Model):
    content = models.CharField(max_length=100)
    # 작성한 사람을 저장
    user = models.ForeignKey(settings.AUTH_USER_MODEL, on_delete=models.CASCADE)    # 글 쓴 사람에 대한 정보를 가져올 수 있음
    created_at = models.DateTimeField(auto_now_add=True)
    # image = models.ImageField()
    image = ProcessedImageField(upload_to='media',
                                           processors=[ResizeToFill(500, 500)],
                                           format='JPEG',
                                           options={'quality': 60})
    # 이미지 업로드 관련 설정들
    # resizetofill : 
    # resizetofit
    # smartresize
    # resizecanvas : 설정한 사이즈만큼의 액자를 만들어 그 액자 안에 이미지를 집어 넣는 형식

    # 좋아요 버튼을 누른사람들을 저장
    like_users = models.ManyToManyField(settings.AUTH_USER_MODEL, related_name='like_posts')       # ManyToManyField() : 
    class Meta:
        ordering = ['-id']      # 최신순으로 업데이트
```



- forms.py

``` python
from django import forms
from .models import Post

class PostForm(forms.ModelForm):

    class Meta:
        model = Post
        #fields : '__all__'
        exclude = ('user', 'like_users' )
```



- urls.py

``` python
from django.urls import path
from . import views

app_name = 'posts'

urlpatterns = [
    path('', views.index, name='index'),
    path('create/', views.create, name='create'),
    path('<int:post_pk>/like/', views.like, name='like'),
]
```



- views.py

- get_object_or_404 : 사용자가 URL을 알아내어 억지로 접속하고자 하는것을 위한 코드로

  사실상 Article.objects.all()과 같은 의미

``` python
from django.shortcuts import render, redirect, get_object_or_404
from .forms import PostForm
from .models import Post
from django.contrib.auth.decorators import login_required

# Create your views here.
def index(request):
    posts = Post.objects.all()
    context = {
        'posts' : posts
    }
    return render(request, 'posts/index.html', context)

@login_required
def create(request):
    if request.method == 'POST':
        form = PostForm(request.POST, request.FILES)
        if form.is_valid:
            post = form.save(commit= False)
            post.user = request.user
            post.save()
            return redirect('posts:index')
    else:
        form = PostForm()
    context = {
        'form' : form,
    }
    return render(request, 'posts/form.html', context)

@login_required
def like(request, post_pk):
    user = request.user
    post = get_object_or_404(Post, pk=post_pk)
    # user.like_posts => user가 좋아요 버튼을 누른 게시물들
    # post.like_users => post에 좋아요 버튼을 누른 유저들
    if post in user.like_posts.all():# 좋아요가 이미 눌러져있는 경우
        user.like_posts.remove(post)
    else:   # 좋아요 버튼을 아직 안누른 경우
        user.like_posts.add(post)

    return redirect('posts:index')

```



- index.html
- 코드를 깔끔하게 만들기 위해 반복되는 코드는 for문과 include를 통해 생성

``` html
{% extends 'base.html' %}
{% block content %}
<div class="row row-cols-2">
  {% for post in posts %}

    {% include 'posts/card.html' %}

  {% endfor %}
</div>
{% endblock %}

```





- form.html
  - enctype : 인코딩 타입 

``` python
{% extends 'base.html' %}
{% load bootstrap4 %}

{% block content %}
    <form action="" method="POST" enctype="multipart/form-data">
        {% csrf_token %}
        {% bootstrap_form form %}
        <button class="btn btn-success">저 장</button>
    </form>
{% endblock  %}
```



- card.html

```python
<div class="card col-5 m-3" >
  <h5 class="card-header">
    <img class="rounded-circle" src="https://gdimg.gmarket.co.kr/1653888935/still/600?ver=1588716436" width="50px", height="50px">
    {{ post.user.username }}
  </h5>
  <img src="{{ post.image.url }}" class="card-img-top" >
  <div class="card-body">
    {% if post in user.like_posts.all %}
      <a href="{% url 'posts:like' post.pk %}"><i class="fas fa-heart fa-2x" style="color : red"></i></a>
    {% else %}
      <a href="{% url 'posts:like' post.pk %}"><i class="far fa-heart fa-2x" style="color : black"></i></a>
    {% endif %}
    {% comment %} <h5 class="card-title">Card title</h5> {% endcomment %}
    <p class="card-text"> {{ post.content }}</p>
    <p class="card-text"> {{ post.created_at }}</p>
  </div>
</div>
```













- font awesome을 활용하려면

`<script src="https://kit.fontawesome.com/2ba5e51523.js" crossorigin="anonymous"></script>`

​	이것을 헤더에 넣어줘야 한다(script라고 body에 설정하는 실수 조심!)





