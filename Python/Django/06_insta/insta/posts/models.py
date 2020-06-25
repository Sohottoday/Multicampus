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

