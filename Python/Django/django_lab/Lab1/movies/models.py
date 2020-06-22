from django.db import models

# Create your models here.
class Movie(models.Model):
    title = models.CharField(max_length=40) # 영화명
    title_en = models.CharField(max_length=40)  # 영화명(영문)
    audience = models.IntegerField()    # 누적 관객수
    open_date = models.DateField()  # 개봉일
    genre = models.CharField(max_length=20) # 장르
    watch_grade = models.CharField(max_length=20)   # 관람등급
    score = models.FloatField() # 평점
    poster_url = models.TextField() # 포스터 이미지 URL
    description = models.TextField()    # 영화 소개


class Comment(models.Model):
    content = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    movie = models.ForeignKey(Movie, on_delete=models.CASCADE)