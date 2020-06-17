from django.db import models

# Create your models here.
class Books(models.Model):
    author = models.TextField()
    name = models.TextField()
    page = models.IntegerField()
    update_at = models.DateTimeField(auto_now_add=True)