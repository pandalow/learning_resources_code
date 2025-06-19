from django.shortcuts import render, redirect, reverse
from django.urls import reverse_lazy
from django.http import HttpResponse, JsonResponse
from django.views.decorators.http import require_http_methods, require_POST, require_GET
from django.contrib.auth.decorators import login_required
from .models import BlogCategory, Blog, Comment
from .forms import PostForm
from django.db.models import Q
# Create your views here.
@require_http_methods(["GET"])
def index(request):
    return render(request, 'index.html', context={})

def blog_detail(request, id):
    try:
        blog= Blog.objects.get(pk=id)
    except Exception as e:
        print(e)
        return HttpResponse(status=404)
    
    return render(request, 'detail.html',context={'blog':blog})

# @login_required(login_url=reverse_lazy('user:login'))

@require_http_methods(["GET", "POST"])
@login_required
def post(request):
    if request.method == "GET":
        categories = BlogCategory.objects.all()
        return render(request, 'post.html', context={'categories':categories})
    else:
        form = PostForm(request.POST)
        if form.is_valid():
            title = form.cleaned_data.get('title')
            category_id = form.cleaned_data.get('category')
            content = form.cleaned_data.get('content')
            Blog.objects.create(title=title, category_id=category_id, content=content, author=request.user)
                
            return JsonResponse({'message':'Post created successfully'}, status=200)
        else:
            print(form.errors)
            return JsonResponse({'message':'Post creation failed'}, status=400)

@require_POST
@login_required
def create_comment(request, id):
    blog_id = request.POST.get('blog_id')
    content = request.POST.get('content')
    Comment.objects.create(content=content, blog_id=blog_id, author=request.user)
    return redirect(reverse('post:blog_detail', args=[blog_id]))


@require_GET
def search(request):
    query = request.GET.get('q')
    
    blogs = Blog.objects.filter(Q(title__icontains=query) | Q(content__icontains=query))
    
    return render(request, 'index.html', context={'blogs':blogs})