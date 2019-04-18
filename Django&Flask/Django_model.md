# Django_model
model among MTV(Model Template View) <=> MVC(Model View Controller)

model in Django is a class that inherit Models to be designed for ORM.
DB-Work.


## I. Django Model

##### Database relationship & Foreign Key

* 1:1
* 1:N
* M:N
![DR](./img/database_relationship.png)

Foreign Key: Primary Key in another table!

models.py
```python
from django.db import models

# Create your models here.
class Article(models.Model):
    title = models.TextField()
    content = models.TextField()
    
    def __repr__(self):
        return f"<{self.id}: {self.title}-{self.content}>"
        
    def __str__(self):
        return self.__repr__()
        

class Comment(models.Model):
    content = models.TextField()
    article = models.ForeignKey(Article, on_delete=models.CASCADE, related_name="comments")
    # DO_NOTHING, etc...
    # related_name is for 1 to N getting objects.
```

Query in shell_plus in this case.
# N -> 1
> a = Article.objects.get(pk=2)
> Comment.objects.filter(article=a)

# 1 -> N
> Comment.objects.filter(article_id = {id in Article}).all()
or
> Article.objects.get(pk={id in Article}).comments.all() 

**Remarks**: If you want to use .comments.all() in the html document by django template syntax,
you must ommit () parenthesis


#### 1. Django ORM
example
```python
from django.db import models

# Create your models here.
1.
class Article(models.Model):
    title = models.TextField()
    content = models.TextField()
```
1. `python manage.py makemigrations`

2. `python manage.py migrate`


##### runtime CRUD
`python manage.py shell`


example
> from articles.models import Article
> a = Article(title="FAST PIE", content="FAST TF S")
> a.save()

> Article.objects.create(title="FAST PIE2", content="yeah")

* SELECT ALL (in terms of list)
> Article.objects.all()

* SELECT the thing
> Article.objects.filter(title = "FAST PIE").all()
> Article.objects.filter(title = "FAST PIE").first()
> Article.objects.filter(title = "FAST PIE").count()
> Article.objects.get(id=2)
> Article.objects.get(pk=2)
> 

* UPDATE
> a = Article.objects.get(id=3)
> a.content = "anything"
> a.save()


* DELETE
> a = Article.objects.get(id=3)
> a.delete()


* order by
> Article.object.order_by('id')      #  ascending order
> Article.object.order_by('-id')      #  descending order


**Tip** representation conversion at the shell
Define method of __repr__ at class, models.py

#### 2. Fields

1. AutoField
2. BooleanField
3. CharField
4. TextField
5. DateField
6. FileField
7. FloatField
8. ImageField
9. IntegerField
......


[field_and_its_option](https://docs.djangoproject.com/en/2.1/ref/models/fields/)


## II. ModelForm
ModelForm make implementation of `form` work related to DB so easy~! Awesome!
forms.py
```python
from django import forms
from .models import Post


# PostModelForm to manipulate Post model

class PostModelForm(forms.ModelForm):
    # 1. What input fields this form have.
    content = forms.CharField(label="content", widget=forms.Textarea(attrs={
        "placeholder":"What's Up~!"
    }))
    
    
    # 2. To set propertiesof corresponding inputs.
    class Meta:
        model = Post
        fields = ["content", 'image']

```

#### 4. User-Model 1:N link
models.py
```python
from django.db import models
#from django.contrib.auth.models import User 직접 접근
from django.conf import settings
# django.conf~~!!!!


# Create your models here.
class Post(models.Model):
    content = models.CharField(max_length=220)
    image = models.ImageField(blank=True)
    # user = models.ForeignKey(User, on_delete=models.CASCADE)
    user = models.ForeignKey(settings.AUTH_USER_MODEL, on_delete=models.CASCADE)
    
    
    def __str__(self):
        return f"{self.id}: {self.content}"

```

#### 5. M:N model (MantToManyField)


models.py
```python
from django.db import models
from faker import Faker
import random
# Create your models here.

fake = Faker()

class Student(models.Model):
    name = models.CharField(max_length=30)
    student_id = models.IntegerField()
    
    # 더미 데이터를 자동으로 넣어주는 클래스 메소드
    @classmethod
    def dummy(cls, n):
        for i in range(n):
            cls.objects.create(name=fake.name(), student_id=random.randint(2000,2015))
        
    def __str__(self):
        return f"{self.student_id}: {self.name}"
    
    
class Lecture(models.Model):
    title = models.CharField(max_length=100)
    def __str__(self):
        
        return f"title: {self.title}"
    
    
class Enrollment(models.Model):
    lecture = models.ForeignKey(Lecture, on_delete=models.CASCADE)
    student = models.ForeignKey(Student, on_delete=models.CASCADE)
    
    def __str__(self):
        return f"{self.student.name}님이 {self.lecture.title} 과목을 수강중입니다."
        

### M : N
class Client(models.Model):
    name = models.CharField(max_length=30)
    age = models.IntegerField()
    # metadata: data에 대한 data: metadata.
    class Meta:
        # 정렬 기준
        ordering = ('name',)
    @classmethod
    def dummy(cls, n):
        for i in range(n):
            cls.objects.create(name=fake.name())   
            
    def __str__(self):
        return f"{self.name}"
        

class Resort(models.Model):
    name = models.CharField(max_length=30)
    ### M:N Field, 어떤 필드에 속해도 상관 없음.
    clients = models.ManyToManyField(Client, related_name='resorts') # resort_set
    # resort = Resort.objects.get(id=##)
    # resort.clients.add()
    # resort.clients.all()
    # {clientObj}.resort_set.all()
    
    @classmethod
    def dummy(cls, n):
        for i in range(n):
            cls.objects.create(name=fake.company())
            
    def __str__(self):
        return f"{self.name}"

```


## II. Form and ModelForm
#### 1. Django model class & Modelform
forms.py

```python
# Form Class?!

from django import forms
from .models import Shout

# shoutform : Shout 모델에 기반하여 Django가 만들어주는 Form
class ShoutForm(forms.Form):
    title = forms.CharField()
    content = forms.CharField()
    
# ModelForm Class?!
class ShoutModelForm(forms.ModelForm):
    
    class Meta:
    
        model = Shout
        fields = ['title', 'content']
        widgets = {
            
            'title': forms.TextInput(
                attrs = {
            'class': 'form-control',
            'placeholder': '제목을 입력해주세요'
                }
            ),
            'content':forms.TextInput(
                attrs = {
                    'class': 'form-control',
                    'placeholder':'내용을 입력해주세요',
                }
            )
        }
```

views.py

```python
from django.shortcuts import render, redirect
from .models import Shout
from .forms import ShoutForm, ShoutModelForm

def create(request):
    # Django form
    
    if request.method == "POST":
        # DB저장
        # 1. DB유효성 검증
        ### (1) Form class
        # form = ShoutForm(request.POST)
        # if form.is_valid():
        #     title = form.cleaned_data.get('title')
        #     content = form.cleaned_data.get('content')
        #     Shout.objects.create(title=title, content=content)
        #     return redirect('shouts:home')
        
        ### (2) Modelform
        form = ShoutModelForm(request.POST)
        if form.is_valid():
            form.save()
            return redirect('shouts:home')
    else:
        # form을 보여주는 페이지
        form = ShoutModelForm()
        return render(request,'shouts/create.html', {
            'form':form
        })
        
def update(request, id):
    shout = Shout.objects.get(pk=id)
    if request.method == "POST":
        # 수정사항을 DB에 실제 반영
        form = ShoutModelForm(request.POST, instance=shout)
        if form.is_valid():
            form.save()
            return redirect('shouts:home')
        
    else:
        # edit 페이지
        form = ShoutModelForm(instance=shout)
        return render(request, 'shouts/update.html', {
            'form':form
        })        
```

create.html

```html
{% extends 'todos/base.html' %}


{% block body %}

    <form action="{% url 'shouts:create' %}" method="POST">
        {% csrf_token %}
        {{ form.as_table }}
        <input type="submit"/>
    </form>

{% endblock %}
```

update.html
```html
{% extends 'todos/base.html' %}

{% block body %}
    <form action="{% url 'shouts:update' form.instance.id %}" method="POST">
        {% csrf_token %}
        {{ form.as_p }}    
        <input type="submit" name=""/>
    </form>
    
{% endblock %}

```

save using modelform.
`form = User_defined_model_form_at_forms_py(request.POST)`
`form.is_valid()`
`form.save()`

User에 대한 ModelForm은
Django.contrib.auth.forms 의 UserCreationForm이다.
아래와 같이 사용 가능.

```python
from django.shortcuts import render, redirect
from django.contrib.auth import authenticate, login, logout
from django.contrib.auth.forms import UserCreationForm
from django.contrib import messages

def register(request):
    if request.method == "POST":
        form = UserCreationForm(request.POST)
        if form.is_valid():
            form.save()
            login(request, form.instance)
            messages.success(request, '성공적으로 회원가입이 되었습니다. ' + form.instance.username)
            return redirect('todos:todos_home')
    else:
        form = UserCreationForm()
        return render(request, 'users/register.html',{
            'form':form
        })
```

html
```html
{% extends 'todos/base.html' %}


{% block body %}
    <h2>회원가입</h2>
    
    <form action="{% url 'users:register' %}" method="POST">
        {% csrf_token %}
        {{form.as_p}}    
        <input type="submit" name=""/>
    </form>
    
{% endblock %}
```


#### 2. Use of FormModel in view, POST_decorator, and, use of foreign key related to the User (views.py at myInstagram)
views.py
```python

from django.shortcuts import render, redirect, get_object_or_404
from django.views.decorators.http import require_POST

from .forms import PostModelForm
from .models import Post
# Create your views here.


def create(request):
    if request.method == "POST":
        # post를 DB에 적용.
        form = PostModelForm(request.POST, request.FILES)
        if form.is_valid():
            form.save()
            return redirect('posts:list')
        else:
            # error handling
            pass
    else:
        form = PostModelForm()
        return render(request,'posts/create.html',{
            "form":form
        })

def list(request):
    # Show all the posts.
    posts = Post.objects.all()
    context = {
        'posts':posts
    }
    return render(request,'posts/list.html',context)
    
@require_POST
def delete(request, post_id):
    post = get_object_or_404(Post, id=post_id)
    
    if post.user != request.user:
        return redirect('posts:list')
    post.delete()
    return redirect('posts:list')
        
def update(request, post_id):
    post = Post.objects.get(id=post_id)
    
    if post.user != request.user:
        return redirect('posts:list')
    
    
    if request.method == "POST":
        
        form = PostModelForm(request.POST, instance=post)
        if form.is_valid():
            form.save()
            return redirect('posts:list')
        else:
            # error handling
            pass
    else:
        
        form = PostModelForm(instance=post)
        return render(request, 'posts/create.html', {
            'form':form
        })
```
urls.py
```python
    
from django.contrib import admin
from django.urls import path, include

#upload setting
from django.conf.urls.static import static
from django.conf import settings

urlpatterns = [
    path('admin/', admin.site.urls),
    path('posts/', include('posts.urls')),
]


# Dev only
# static(통과하고자 하는 url, 실제 저장 장소)
urlpatterns += static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)
```
settings.py
```python
MEDIA_URL = '/media/'
MEDIA_ROOT = os.path.join(BASE_DIR,'media')
```
templates (myInstagram)
create.html
```html
{% extends 'base.html' %}

{% load bootstrap4 %}

{% block body %}
<form method="POST", enctype="multipart/form-data">
  <!-- 파일을 보낼 땐, enctype = "multipart/form-data" 추가해야 함.-->
  {% csrf_token %}
  <!--model form-->
  <!--{{ form }}-->
  {%  bootstrap_form form %}
  <button type="submit" class='btn btn-primary'>upload</button>
</form>
{% endblock %}
```
list.html
```html
{% extends 'base.html' %}

{% block body %}
  <div class="row justify-content-center">
  
    {% for post in posts %}
          <div class="card" style="width: 15rem;">
              <div class="card-header">
                <span>{{ post.user.username }}</span>
              </div>
              
              {% if post.image %}
                <img src="{{post.image.url}}" class="card-img-top" alt="...">
              {% else %}
                <img src="https://picsum.photos/200/200/?random" class="card-img-top" alt="...">
              {% endif %}

            
            <div class="card-body">
              <p class="card-text">{{post.content}}</p>
              
              <!-- 작성자만 수정/삭제 가능  -->
              {% if post.user == request.user  %}
                <form method="POST" action = "{% url 'posts:delete' post.id %}" class="d-inline-block">
                  {% csrf_token %}
                  <button class="btn btn-danger">삭제</button>
                </form>
                <a href="{% url 'posts:update' post.id %}" class="btn btn-success">수정</a>
              {% endif%}
              
            </div>
          </div>
    {% endfor %}
  
  </div>  
{% endblock %}
```

## III. User model Django generates.

#### 1. Django가 생성해 준 auth의 user 모델 사용하기.

models.py
```python
from django.db import models
from django.contrib.auth.models import User


class TodoList(models.Model):
    content = models.TextField(default='')
    completed = models.BooleanField(default=False)
    user = models.ForeignKey(User, on_delete=models.CASCADE, related_name='todolists')
    
    
    def __str__(self):
        return f"{self.id}- {self.content[:20]} / {self.completed}"
        
    def __repr__(self):
        return f"{self.id}- {self.content[:20]} / {self.completed}"
```
**django.contrib.auth.models의 User를 사용하면 된다.**


views.py
```python
from django.shortcuts import render, redirect
from django.contrib.auth.models import User
from .models import TodoList


def todos_home(request):
    if request.method == "POST":
        # To do 작성
        content = request.POST.get('content')
        a = TodoList(content=content, user=request.user)
        a.save()
        return redirect('todos:todos_home')
    else:
        return render(request, 'todos/home.html')


def check(request, todolist_id):
    todo = TodoList.objects.get(pk=todolist_id)
    todo.completed = not todo.completed
    todo.save()
    return redirect('todos:todos_home')
```
**request가 user를 담고 있다.**


#### 2. Django Auth
views.py

```python
from django.shortcuts import render, redirect
from django.contrib.auth import authenticate, login, logout
from django.contrib import messages

# users/login/
def users_login(request):
    if request.method == "GET":
        return render(request, 'users/login.html')
    else:
        username = request.POST.get('username')
        password = request.POST.get('password')
        user = authenticate(request, username=username, password=password)
        
        # login\
        if user is not None:
            
            login(request, user)
            # 로그인이 되었다고 알려줌
            messages.success(request, '성공~!')
            return redirect('todos:todos_home')
        else:
            # 로그인이 안되었다 알려줌.
            messages.success(request,'로그인 실패~!')
            return redirect('users:users_login')
        
        
        
        # user authentication db check.
        # session in server, data whcich tar
        
def users_logout(request):
    # 세션에서 유저를 지운다.
    logout(request)
    messages.success(request, '로그아웃 되었습니다.')
    return redirect('todos:todos_home')
    
def users_profile(request):
    return render(request, 'users/profile.html')

```
```html
{% if user.is_authenticated %}
```
settings.py
```python
MESSAGE_STORAGE = 'django.contrib.messages.storage.session.SessionStorage'
```

