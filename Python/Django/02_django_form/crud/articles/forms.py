from django import forms
from .models import Article

# class ArticleForm(forms.Form):
#     title = forms.CharField(max_length=20)
#     content = forms.CharField(widget=forms.Textarea)

class ArticleForm(forms.ModelForm):
    # 출력되는 값들을 지정해주기 위한 위젯
    title = forms.CharField(
        label='제목',       # 출력되는 값 지정
        widget=forms.TextInput(     # html에서 class명 등을 지정할 수 없기 때문에 이곳에서 지정한다.
            attrs={
                'class' : 'my-title form-control',
                'placeholder' : 'Enter the title',
            }
        )
    )
    content = forms.CharField(
        label='내용',
        widget=forms.Textarea(
            attrs={
                'class' : 'my-content form-coltrol',
                'placeholder' : 'Enter the content',
                'cols' : 50,
                'rows' : 5,
            }
        )
    )
    #   Meta : ArticleForm 클래스에 대한 정보를 작성하는 곳
    class Meta:         # Meta는 정보에 대한 정보
        model = Article
        #fields = ['title', 'content', ]
        fields = '__all__'      # 이렇게 지정하면 모든 input을 출려개준다.
        # 단 이렇게 했을 경우 원치 않는 부분까지 출력될 수도 있다.
        # create와 update시간이 나오지 않는것은 input이 아니기 때문
        # exclude = ['title']
        # exclude를 통해 빼고싶은 부분만 뺄 수 있다.
        