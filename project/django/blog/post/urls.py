from django.urls import path
from . import views
app_name = 'post'

urlpatterns = [
    path('', views.index, name='index'),
    path('detail/<int:id>',views.blog_detail,name='blog_detail'),
    path('post/',views.post,name='post_blog'),
    path('post/comment',views.create_comment,name='comment')

]