from django.urls import path
from . import views

app_name = 'user'

urlpatterns = [
    path('login/',views.self_login,name='login'),
    path('register/',views.register,name='register'),
    path('send_email/',views.send_email,name='send_email'),
    path('logout/',views.user_logout,name='logout'),
]
