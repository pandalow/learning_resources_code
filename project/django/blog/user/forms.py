from django import forms
from django.contrib.auth.models import User
from .models import VerificationCode

class RegisterForm(forms.Form):
    username = forms.CharField(max_length=128,
                               min_length=2, 
                               error_messages={
                                   'required': 'Username is required', 
                                   'min_length': 'Username must be at least 2 characters long'}, 
                               widget=forms.TextInput(attrs={'class': 'form-control'})
                               )
    email = forms.EmailField(error_messages={
        'required': 'Email is required',
        'invalid': 'Invalid email address'
        }, widget=forms.EmailInput(attrs={'class': 'form-control'}))
    
    code = forms.CharField(max_length=4, min_length=4, error_messages={
        'required': 'Validation code is required',
        'min_length': 'Validation code must be 4 characters long'
        }, widget=forms.TextInput(attrs={'class': 'form-control'}))
    
    password = forms.CharField(max_length=20,min_length=8, error_messages={
        'required': 'Password is required',
        'min_length': 'Password must be at least 8 characters long'
        }, widget=forms.PasswordInput(attrs={'class': 'form-control'}))

    def clean_email(self):
        # 获取用户输入的 email 字段，在通过字段类型验证后（如 EmailField 验证邮箱格式），将其作为**“干净”数据**传给你自定义的 clean_email() 方法进行进一步的检查。
        email = self.cleaned_data.get('email')
        if User.objects.filter(email=email).exists():
            raise forms.ValidationError('Email already exists')
        return email
    
    def clean_code(self):
        code = self.cleaned_data.get('code')
        email = self.cleaned_data.get('email')
        code_obj = VerificationCode.objects.filter(code=code, email=email).first()
        if not code_obj:
            raise forms.ValidationError('Invalid validation code')
        code_obj.delete()
        return code


class LoginForm(forms.Form):
    email = forms.EmailField(error_messages={
        'required': 'Email is required',
        'invalid': 'Invalid email address'
        }, widget=forms.EmailInput(attrs={'class': 'form-control'}))

    password = forms.CharField(max_length=20,min_length=8, error_messages={
        'required': 'Password is required',
        'min_length': 'Password must be at least 8 characters long'
        }, widget=forms.PasswordInput(attrs={'class': 'form-control'}))

    remember = forms.BooleanField(required=False, widget=forms.CheckboxInput(attrs={'class': 'form-check-input'}))

    # def clean_email(self):
    #     email = self.cleaned_data.get('email')
    #     if not User.objects.filter(email=email).exists():
    #         raise forms.ValidationError('Email does not exist')
    #     return email
    
    # def clean_password(self):
    #     password = self.cleaned_data.get('password')
    #     email = self.cleaned_data.get('email')
    #     user = User.objects.filter(email=email).first()
    #     if not user.check_password(password):
    #         raise forms.ValidationError('Invalid password')
    #     return password
