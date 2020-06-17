from django.shortcuts import render, redirect
from .models import Books
from django.views.decorators.http import require_http_methods, require_POST
from .forms import BooksForm

# Create your views here.
def index(request):
    books = Books.objects.all()
    context = {
        'books' : books
    }
    return render(request, 'books/index.html', context)


def detail(request, pk):
    book = Books.objects.get(pk=pk)
    context = {
        'book' : book
    }
    return render(request, 'books/detail.html', context)

@require_http_methods(['GET', 'POST'])
def create(request):
    if request.method == 'POST':
        form = BooksForm(request.POST)
        if form.is_valid():
            books = form.save()
            print(books.page)
            return redirect('books:detail', books.pk)
    else:
        form = BooksForm()
    context = {
        'form' : form
    }
    return render(request, 'books/create.html', context)

@require_POST
def delete(request, pk):
    books = Books.objects.get(pk=pk)
    books.delete()
    return redirect('books:index')


def update(request, pk):
    book = Books.objects.get(pk=pk)
    if request.method == 'POST':
        form = BooksForm(request.POST, instance=book)
        if form.is_valid():
            form.save()
            return redirect('books:detail', book.pk)
    else:
        form = BooksForm(instance=book)
    context = {
        'form' : form
    }
    return render(request, 'books/update.html', context)


