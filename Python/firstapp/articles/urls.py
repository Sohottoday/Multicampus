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
