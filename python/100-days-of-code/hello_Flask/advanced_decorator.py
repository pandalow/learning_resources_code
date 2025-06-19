
class User:

    def __init__(self,name):
        self.username = name
        self.is_logged_in = False


# Decorator with args and kwargs
def is_authenticated(function):
    def wrapper(*args,**kwargs):
        if kwargs['user'].is_logged_in == True:
            function(kwargs['user'])
    return wrapper
@is_authenticated
def post_blog(user):
    print(f"{user.username} is posted a blog")


john = User('john')
john.is_logged_in = True
post_blog(user=john)