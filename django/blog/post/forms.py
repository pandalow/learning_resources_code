from django import forms

class PostForm(forms.Form):
    title = forms.CharField(max_length=200, min_length=2)
    content = forms.CharField(
        min_length=2,
        widget=forms.Textarea,  # ✅ 使用 Textarea 是更符合内容编辑器的形式
        strip=False             # ✅ 禁用自动去除 HTML 空格内容
    )
    category = forms.IntegerField()
