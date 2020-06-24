from django.db import models
from django.contrib.auth.models import AbstractUser

# Create your models here.
class User(AbstractUser):       # django에서는 이 부분을 처음에 정의하기를 추천한다.
    phone = models.CharField(max_length=20)