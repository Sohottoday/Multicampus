from django.shortcuts import render, redirect, get_object_or_404
from .forms import PostForm
from .models import Post
from django.contrib.auth.decorators import login_required
from django.http import JsonResponse

# get_object_or_404 : 사용자가 URL을 알아내어 억지로 접속하고자 하는것을 위한 코드로
# 사실상 Article.objects.all()과 같은 의미
# Create your views here.
def index(request):
    posts = Post.objects.all()
    context = {
        'posts' : posts
    }
    return render(request, 'posts/index.html', context)

@login_required
def create(request):
    if request.method == 'POST':
        form = PostForm(request.POST, request.FILES)
        if form.is_valid:
            post = form.save(commit= False)
            post.user = request.user
            post.save()
            return redirect('posts:index')
    else:
        form = PostForm()
    context = {
        'form' : form,
    }
    return render(request, 'posts/form.html', context)

@login_required
def like(request, post_pk):
    user = request.user
    post = get_object_or_404(Post, pk=post_pk)
    # user.like_posts => user가 좋아요 버튼을 누른 게시물들
    # post.like_users => post에 좋아요 버튼을 누른 유저들
    if post in user.like_posts.all():# 좋아요가 이미 눌러져있는 경우
        user.like_posts.remove(post)
        # json을 사용할 때
        liked = False
    else:   # 좋아요 버튼을 아직 안누른 경우
        user.like_posts.add(post)
        # json을 사용할 때
        liked = True
    # return redirect('posts:index')
    # json을 사용할 때
    context = {
        'msg' : '좋아요 기능이 동작',
        'liked' : liked
    }
    return JsonResponse(context)
