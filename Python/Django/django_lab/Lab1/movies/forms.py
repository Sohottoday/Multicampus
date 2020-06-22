from django import forms
from .models import Movie, Comment

class MovieForm(forms.ModelForm):
    title = forms.CharField(
        label='',
        widget=forms.TextInput(
            attrs = {
                'placeholder' : '영화명'
            }
        )
    )
    title_en = forms.CharField(
        label='영화명(영문)',
        widget=forms.TextInput(
            attrs= {
                'placeholder' : '영화명(영문)'
            }
        )
    )
    audience = forms.IntegerField(
        label = '누적 관객수'
    )
    open_date = forms.DateInput(
        
    )
    genre = forms.CharField(
        label='장르',
        widget=forms.TextInput(
            attrs= {
                'placeholder' : '장르'
            }
        )
    )
    watch_grade = forms.CharField(
        label='관람등급',
        widget=forms.TextInput(
            attrs={
                'placeholder' : '관람등급'
            }
        )
    )
    score = forms.FloatField(
        label='평점'
        
    )
    poster_url = forms.CharField(
        label='포스터 이미지 URL',
        widget=forms.Textarea(
            attrs={
                'placeholder' : '포스터 이미지 URL'
            }
        )
    )
    description = forms.CharField(
        label='영화 소개',
        widget=forms.Textarea(
            attrs={
                'placeholder' : '영화 소개'
            }
        )
    )

    class Meta:
        model = Movie
        fields = '__all__'


class CommentForm(forms.ModelForm):
    content = forms.CharField(
        label='댓 글',
        widget=forms.Textarea(
            attrs={
                'cols':80,
                'rows':3,
            }
        )
    )
    class Meta:
        model = Comment
        fields = '__all__'
        exclude = ['movie', ]
