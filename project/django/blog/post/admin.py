from django.contrib import admin
from .models import BlogCategory, Blog, Comment
# Register your models here.
class BlogCategoryAdmin(admin.ModelAdmin):
    list_display = ('name', 'created_at', 'updated_at')
    list_filter = ('created_at', 'updated_at')
    search_fields = ('name',)
    list_per_page = 10
    
    
class BlogAdmin(admin.ModelAdmin):
    list_display = ('title', 'category', 'author', 'created_at', 'updated_at')
    list_filter = ('created_at', 'updated_at')
    search_fields = ('title',)
    list_per_page = 10
    
class CommentAdmin(admin.ModelAdmin):
    list_display = ('content', 'blog', 'author', 'created_at')
    list_filter = ('created_at',)
    search_fields = ('content',)
    list_per_page = 10
    
admin.site.register(BlogCategory, BlogCategoryAdmin)
admin.site.register(Blog, BlogAdmin)
admin.site.register(Comment, CommentAdmin)
    
