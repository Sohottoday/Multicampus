from django.shortcuts import render, redirect
from .models import Article

# Create your views here.
def index(request):
    articles = Article.objects.all()

    context = {
        'articles' : articles,
    }
    return render(request, 'articles/index.html', context)


def new(request):
    return render(request, 'articles/new.html')


def create(request):
    # 1. new에서 보낸 데이터 받기
    title = request.POST.get('title')
    content = request.POST.get('content')
    # 2. db에 저장
    # article = Article()
    # article.title = title
    # article.content = content
    # article.save()

    article = Article(title = title, content = content)
    article.save()

    #Article.objects.create(title = title, content = content)
    return redirect('articles:detail', article.pk)


def detail(request, pk):
    article = Article.objects.get(pk=pk)
    context = {
        'article' : article,
    }
    return render(request, 'articles/detail.html', context)


def delete(request, pk):
    article = Article.objects.get(pk=pk)
    if request.method == 'POST':
        article.delete()
        return redirect('articles:index')
    else:
        return redirect('articles:detail', article.pk)

    
def edit(request, pk):
    article = Article.objects.get(pk=pk)
    context = {
        'article' : article,
    }
    return render(request, 'articles/edit.html', context)


def update(request, pk):
    # 1. 수정할 게시글 조회
    article = Article.objects.get(pk=pk)
    # 2. update는 edit에서 보내는 데이터 받기
    article.title = request.POST.get('title')
    article.content = request.POST.get('content')
    article.save()

    return redirect('articles:detail', article.pk)
