from django import forms
from .models import Todo

class TodoForm(forms.ModelForm):
    due_date = forms.CharField(
        label= '',
        widget=forms.TextInput(
            attrs={
                'type' : 'date',
                'margin' : '20px'
            }
        )
    )
    content = forms.CharField(
        label='',
        widget=forms.TextInput(
            attrs={
                'class' : 'form-control form-control-lg',
                'placeholder' : '오늘의 할 일을 적어봅세',
                'margin' : '10px',
            }
        )
        
    )

    class Meta:
        model  = Todo
        fields = ('content', 'due_date')

