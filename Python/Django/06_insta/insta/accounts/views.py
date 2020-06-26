from django.shortcuts import render, redirect, get_object_or_404
from django.contrib.auth.forms import UserCreationForm, AuthenticationForm
from .forms import CustomUserCreationForm
from django.contrib.auth import login as auth_login
from django.contrib.auth import logout as auth_logout
from django.contrib.auth import get_user_model      # User모델을 직접 건드리기 부담스러우므로 사용, 말 그대로 모델 클래스를 알려주는 역할만 한다.
from django.contrib.auth.decorators import login_required

# Create your views here.
def signup(request):
    if request.user.is_authenticated:
        return redirect('posts:index')

    if request.method == 'POST':
        form = CustomUserCreationForm(request.POST, request.FILES)
        if form.is_valid():
            user = form.save()
            auth_login(request, user)
            return redirect('posts:index')
    else:
        form = CustomUserCreationForm()
    context = {
        'form': form
    }
    return render(request, 'accounts/form.html', context)


def login(request):
    if request.user.is_authenticated:       # 로그인 한 상태라면 다시 인덱스 페이지로 돌아가라는 의미
        return redirect('posts:index')
        
    if request.method == 'POST':
        form = AuthenticationForm(request, request.POST)
        if form.is_valid():
            user = form.get_user()
            auth_login(request, user)
            return redirect('posts:index')

    else:
        form = AuthenticationForm()
    context = {
        'form': form
    }
    return render(request, 'accounts/form.html', context)


def logout(request):
    auth_logout(request)
    return redirect('accounts:login')


def profile(request, username):
    user_profile = get_object_or_404(get_user_model(), username = username)    # get은 id값을 기준으로 가져오지만 filter를 통해 다른 값으로도 정보를 불러올 수 있다
    context = {
        'user_profile' : user_profile
    }
    return render(request, 'accounts/profile.html', context)
    
@login_required
def follow(request, user_pk):
    me = request.user
    you = get_object_or_404(get_user_model(), pk=user_pk)

    if me == you:
        return redirect('posts:index')

    if me in you.follower.all():
        # 이미 팔로우 하고 있었음
        #you.follower.remove(me)
        me.follow.remove(you)
    else:
        # 아직 팔로우 안함
        #you.follower.add(me)
        me.follow.add(you)
    return redirect('accounts:profile', you.username)