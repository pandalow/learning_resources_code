from django.shortcuts import render
from django.http import HttpResponse, JsonResponse
from django.views.decorators.http import require_http_methods
import string
import random
from django.core.mail import send_mail
from django.conf import settings
from .models import VerificationCode
from .forms import RegisterForm, LoginForm
from django.contrib.auth.models import User
from django.shortcuts import redirect
from django.urls import reverse
from django.contrib.auth import authenticate, login, logout

# Create your views here.
@require_http_methods(["GET","POST"])
def register(request):
    if request.method == 'GET':
        return render(request,'register.html')
    else:
        form = RegisterForm(request.POST)
        if form.is_valid():
            email = form.cleaned_data['email']
            username = form.cleaned_data['username']
            password = form.cleaned_data['password']
            
            user = User.objects.create_user(username=username, email=email, password=password)
            user.save()
            return redirect(reverse('user:login'))
        else:
            print(form.errors)
            return render(request,'register.html',context={'form': form})
            

@require_http_methods(["GET","POST"])
def self_login(request):
    if request.method == 'GET':
        return render(request, 'login.html', context={})
    else:
        form = LoginForm(request.POST)
        if form.is_valid():
            email = form.cleaned_data.get('email')
            password = form.cleaned_data.get('password')
            remember = form.cleaned_data.get('remember')
            
            user = User.objects.filter(email=email).first()
            if user and user.check_password(password):
                login(request, user)
                if not remember:
                    request.session.set_expiry(0)
                return redirect(reverse('post:index'))
            else:
                form.add_error('password', 'Invalid email or password')
                return render(request, 'login.html', context={'form': form})
            
        return render(request, 'login.html', context={'form': form})
            
                    
                    
                    
@require_http_methods(["GET"])
def send_email(request):
    
    email = request.GET.get('email')

    if not email:
        return JsonResponse({'error': 'Email is required'}, status=400)

    code = ''.join(random.sample(string.digits,4))
    
    VerificationCode.objects.update_or_create(email=email, defaults={'code': code})
    

    send_mail(
        subject='Verification Code',
        message=f'Your verification code is {code}',
        from_email=settings.DEFAULT_FROM_EMAIL,
        recipient_list=[email],
        fail_silently=False
    )
    
    return JsonResponse({'message': 'Email sent successfully'}, status=200)


@require_http_methods(["GET"])
def user_logout(request):
    logout(request)
    return redirect(reverse('post:index'))
