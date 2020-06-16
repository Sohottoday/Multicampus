from django.db import models

# Create your models here.
class Article(models.Model):
    title = models.CharField(max_length=20)     # CharField는 글자수 제한이 있는 클래스변수
    content = models.TextField()        # TextFired는 글자수 제한 없음
    created_at = models.DateTimeField(auto_now_add=True)    # auto_now_add : 데이터가 최초 생성된 시각
    updated_at = models.DateTimeField(auto_now=True)
