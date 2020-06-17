from django.shortcuts import render, redirect
from django.views.decorators.http import require_http_methods, require_POST
from .models import Article
from .forms import ArticleForm

# Create your views here.
def index(request):
    articles = Article.objects.all()
    context = {
        'articles': articles,
    }
    return render(request, 'articles/index.html', context)


@require_http_methods(["GET", "POST"])
def create(request):

    if request.method == 'POST':
        form = ArticleForm(request.POST)
        # 유효성 검사를 통해 안전한 데이터면 저장하라
        if form.is_valid():
            article = form.save()     
            return redirect('articles:detail', article.pk)
    else:       # 넘어오는 값이 GET 뿐만 아니라 다른  method 전주
        form = ArticleForm()
    # form의 2가지 모습
    # 1. is_vaild()에서 통과하지 못한 form
    # 2. else 구문의 form
    # context 들여쓰기가 왜 이곳인지는 이론적으로 이해해야 한다
    ## 내부 if분이 아닌 외부 if문의 else의 값에 대한 것이다.
    context = {
        'form' : form
    }
    return render(request, 'articles/create.html' , context)
    


def detail(request, pk):
    article = Article.objects.get(pk=pk)
    context = {
        'article': article,
    }
    return render(request, 'articles/detail.html', context)

@require_http_methods(["GET", "POST"])
def update(request, pk):
    article = Article.objects.get(pk=pk)
    if request.method == 'POST':
        form = ArticleForm(request.POST, instance=article)
        if form.is_valid():
            form.save()
            return redirect('articles:detail', article.pk)
    else:
        form = ArticleForm(instance=article)
    context = {
        'form' : form,
    }
    return render(request, 'articles/update.html', context)

@require_POST
def delete(request, pk):
    article = Article.objects.get(pk=pk)
    article.delete()
    return redirect('articles:detail', article.pk)
