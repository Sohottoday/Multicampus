from django.db import models
from django.contrib.auth.models import AbstractUser
from django.conf import settings
from imagekit.models import ProcessedImageField
from imagekit.processors import ResizeToFill

# Create your models here.
class User(AbstractUser):
    follow = models.ManyToManyField(settings.AUTH_USER_MODEL, related_name='follower')
    # follower가 자동 생성됨
    image = ProcessedImageField(processors=[ResizeToFill(500, 500)],
                                format='JPEG',
                                options={'quality': 60},
                                default='xxx.jpg',  # 전체 카테고리의 media 폴더 안의 파일을 불러온다.
                                # 중간에 사진을 바꾼다면 바꾸기 전의 데이터들은 기존의 파일이름으로 설정된 파일만을 바라보기 때문에
                                # 새로운 사진을 넣어준 뒤 이름을 기존의 파일 이름과 똑같이 해야한다.
                                )

