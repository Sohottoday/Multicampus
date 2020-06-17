from django import forms
from .models import Books

class BooksForm(forms.ModelForm):
    name = forms.CharField(
        label='책 이 름',
        widget=forms.Textarea(
            attrs ={
                'placeholder' : 'Enter the book name',
            }
        )
    )
    author = forms.CharField(
        label ='저 자',
        widget=forms.Textarea(
            attrs = {
                'placeholder' : 'Enter the book author',
            }
        )
    )
    page = forms.IntegerField(
        label = '페이지 수',
        
    )
    
    class Meta:
        model = Books
        fields = '__all__'