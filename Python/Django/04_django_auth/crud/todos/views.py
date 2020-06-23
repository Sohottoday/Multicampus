from django.shortcuts import render, redirect
from django.contrib.auth.decorators import login_required
from django.views.decorators.http import require_POST
from .forms import TodoForm
from .models import Todo

# Create your views here.
@login_required
def index(request):
    form = TodoForm()
    context = {
        'form' : form,
    }
    return render(request, 'todos/index.html', context)

@login_required
def create(request):
    form = TodoForm(request.POST)
    if form.is_valid():
        todo = form.save(commit = False)    # commit = 아직 확정은 짓지 않겠다 라는 의미
        todo.user = request.user
        todo.save()
        return redirect('todos:index')

@login_required
@require_POST
def delete(request, content_pk):
    content = Todo.objects.get(pk=content_pk)
    content.delete()
    return redirect('todos:index')

    


