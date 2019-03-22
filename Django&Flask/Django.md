# Django

## I. Framework
Framework is like Opening chain store to concentrate only offering service.

If you do not use framework, do following yourself...
URL parsing
DB setting
ORM
Security
Template
Caching 
Content Management
Web server setting... No way.


Framework makes developer to focus on service!


Kinds of framework
1. Express JS
2. Ruby on Rails
3. Python Django
4. PHP Laravel
5. Java Spring

## II. Why do we use Django?!
[](https://www.hotframeworks.com)


## III. Architecture of Django

1. M: model (manage data)
2. V: View (intermediate manager) (controller between M and T most important)
3. T: Template (on user)


## IV. Construct Environment!

python environment! pyenv.
And, we will use Django v2. !!!

```bash
git clone https://github.com/pyenv/pyenv.git ~/.pyenv
echo 'export PYENV_ROOT="$HOME/.pyenv"' >> ~/.bashrc
echo 'export PATH="$PYENV_ROOT/bin:$PATH"' >> ~/.bashrc
echo -e 'if command -v pyenv 1>/dev/null 2>&1; then\n  eval "$(pyenv init -)"\nfi' >> ~/.bashrc
exec "$SHELL"

git clone https://github.com/pyenv/pyenv-virtualenv.git $(pyenv root)/plugins/pyenv-virtualenv
echo 'eval "$(pyenv virtualenv-init -)"' >> ~/.bashrc
exec "$SHELL"
```

```bash
pyenv install 3.6.7

pyenv global 3.6.7
```

> mkdir PRACTICE
> cd PRACTICE
> pyenv virtualenv 3.6.7 practice-venv
> pyenv local practice-venv
> pip install django    
> django-admin startproject test .

at settings.py,
add 'address' to ALLOWED_HOSTS
**remarks** 
1. ommit `https://`
2. ommit `/` at the tail.

**Tip** When use `source .bashrc` in the py virtualenv, `source deactivate`

`python manage.py runserver $IP:$PORT`

**Tip** Sementic Versioning.
* v3.6.7 
3: Breaking - Breaking change, incompatible API changes.
6: Feature - new feature, add backwards-compatible functionality.
7: Fix - bug fix, make backwards-compatible bug fix.

**Tip**: Django Project is a collection of applications.

## V. Views
After `python manage.py startapp <app_name>`
In `INSTALLED_APPS` in settings.py,
add the `<app_name>`. (trailing comma.)

**Tips**: Use of trailing comma in collection is convention in Django.

#### 1. Making basic web from views.py

##### views.py in application directory
```python
from django.shortcuts import render
# function-based
def index(request):
    context = {"msg":"hello","name":"JM"}
    return render(request, 'index.html', context)
```
making directory name of "templates" in the app directory.
And, put html documents in it.
**Router?! url route is in urls.py**

##### urls.py in Django project directory

```python
from django.contrib import admin
from django.urls import path

from <app_name> import views

urlpatterns = [
    path('admin/', admin.site.urls),
    path("", views.index), # root url
    path('url/','function in view'),
]

```

#### 2. Variable Routing
views.py
```python
def cube(request,number):
    d = number**3
    return render(request,'cube.html',{"cubic":d})
```
urls.py
```python
from django.contrib import admin
from django.urls import path
from pages import views

urlpatterns = [
    path('admin/', admin.site.urls),
    path("", views.index),
    path("isval/",views.isval),
    path("cube/<int:number>",veiews.cube),### cube and <int:number> the same as flask
]
```

#### 3. GET
```python
def func(request):
    data = request.GET.get("name")
    return render(request,'target.html',{'data':data})
```

#### 4. POST
```python
def create(request):
    title = request.POST.get("title") ## POST type.
    content = request.POST.get('content')
    
    article = Article(title = title, content = content)
    article.save()
    
    return redirect('/articles')
```

```html
<h2>게시글 작성</h2>
<form action="/articles/create/" method="POST">
    제목: <input type="text" name="title"/>
    내용: <input type="text" name="content"/>
    <input type="submit" value="Submit"/>
    {% csrf_token %} 
    <!-- Token Django makes -->
</form>
```

#### 5. url generation by aliasing and naming in urls.py
**Refer the X sub-gatekeeper below**
<a href="#X">go to X</a>

example
`urls.py` at application directory in this below case.
```python
from django.urls import path
from . import views

urlpatterns = [
    path('', views.index, name="index"),
    path('new/',views.new, name="new"),
    path('create/',views.create, name="create"),
    path('<int:article_id>/',views.detail, name="detail"),
    path('<int:article_id>/edit/',views.edit, name="edit"),
    path('<int:article_id>/update/',views.update, name="update"),
    path('<int:article_id>/delete/',views.delete, name="delete"),
]
```

index.html
```html
<h2>게시판 입니다.</h2>
<a href="{% url 'new' %}">새글쓰기</a>
<!--  this url aliasing according to Django template syntax-->

<table>
    <tr>
        <th>Index</th>
        <th>Title</th>
    </tr>
    {% for d in data %}
    <tr>
        <td>{{ d.id }}</td>
        <td><a href="/articles/{{d.id}}/">{{ d.title }}</a></td>
    </tr>
    {% endfor %}
</table>
```
* This url aliasing is also available in views.py python script for redirect(). 
* For these case, use just name.
* If it requires variable routing, just add the variable with comma.

example

```python
def create(request):
    title = request.POST.get("title")
    content = request.POST.get('content')
    
    article = Article(title = title, content = content)
    article.save()
    
    return redirect('detail', article.id)   
```


#### 6. url aliasing with variable routing
example

urls.py at application directory in this below case.
```python
from django.urls import path
from . import views

urlpatterns = [
    path('', views.index, name="index"),
    path('new/',views.new, name="new"),
    path('create/',views.create, name="create"),
    path('<int:article_id>/',views.detail, name="detail"),
    path('<int:article_id>/edit/',views.edit, name="edit"),
    path('<int:article_id>/update/',views.update, name="update"),
    path('<int:article_id>/delete/',views.delete, name="delete"),
]
```

index.html

```html
<h2>게시판 입니다.</h2>
<a href="{% url 'new' %}">새글쓰기</a>


<table>
    <tr>
        <th>Index</th>
        <th>Title</th>
    </tr>
    {% for d in data %}
    <tr>
        <td>{{ d.id }}</td>
        <td><a href="{% url 'detail' d.id %}">{{ d.title }}</a></td>
        <!-- this format just add the variable in order with a space -->
    </tr>
    {% endfor %}
</table>

```


## VI. models

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


#### 3.



## VII. admin
at admin.py

example
```python
from django.contrib import admin
from .models import Student

# Register your models here.

admin.site.register(Student)
```
#### 1. display setting in admin page
example

```python
from django.contrib import admin
from .models import Student

# Register your models here.

class StudentAdmin(admin.ModelAdmin):
    list_display = ('name', 'age')


admin.site.register(Student, StudentAdmin)
```

example2

```python
from django.contrib import admin
from .models import Posting, Comment
# Register your models here.


class PostingModelAdmin(admin.ModelAdmin):
    readonly_fields = ('created_at', 'updated_at')  # 레코드 개별화면 확인
    list_display = ('id', 'content', 'created_at', 'updated_at')  # 리스트에서 표시
    list_display_links = ('id', 'content')  # Clickable


admin.site.register(Posting, PostingModelAdmin)


class CommentModelAdmin(admin.ModelAdmin):
    readonly_fields = ('created_at', 'updated_at')
    list_display = ('id', 'posting', 'content', 'created_at', 'updated_at')
    list_display_links = ('id', 'content')


admin.site.register(Comment, CommentModelAdmin)
```


## VIII. files, which are like css, js, and, img, importing in c9
According to Django template Grammer!


1. make `static` directory on the app directory (static: default)
You can check this in settings.py

2. `load static` within django template grammer like jinja `curly-brace with percent` on the top of the html.

3. `static "filepath"` within `curly-brace with percent` in href, etc.


example

```html
{% load static %}

<link rel=stylesheet href="{% static 'css/style.css' %}">

<!-- laod static cannot be included by inheritance?! -->
```


## IX. with ipython & django_extensions

After generating project and app, add `django_extensions` to the INSTALLED_APPS
at settings.py

## X. sub gate-keeper
<a id="X"></a>
1. generate urls.py in app. This is not the one in project directory

exmaple
urls.py in project
```python
from django.contrib import admin
from django.urls import path, include
from articles import views

urlpatterns = [
    path('admin/', admin.site.urls),
    path('articles/', include('articles.urls')),
    path('', views.index),
]
```
urls.py in app
```python
from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('new/',views.new),
    path('create/',views.create)
    
]
```

## XI. Super neutral templates

just make directory of templates just under project directory where settings.py is (This is a common convention!)
this has first priority.

Then,
Add the information into the `'DIRS'` of `TEMPLATES` in `settings.py`

```python
TEMPLATES = [
    {
        'BACKEND': 'django.template.backends.django.DjangoTemplates',
        'DIRS': [os.path.join(BASE_DIR, 'board','templates'),], 
        ### Add the line into the DIRS
        'APP_DIRS': True,
        'OPTIONS': {
            'context_processors': [
                'django.template.context_processors.debug',
                'django.template.context_processors.request',
                'django.contrib.auth.context_processors.auth',
                'django.contrib.messages.context_processors.messages',
            ],
        },
    },
]

```


## XII. Database relationship & Foreign Key

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


## XIX. Django auth
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


#### 2. Django model class & Modelform
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




## XX. Commands

1. `python manage.py runserver $IP`
* At C9: `python manage.py runserver $IP:$PORT`

2. `python manage.py startapp <app_name>`
generate needed directory and files.
(view.py, models.py, admin.py, etc)


3. `python manage.py makemigrations`

4. `python manage.py migrate`

5. `python manage.py shell`

6. `python manage.py sqlmigrate articles 0001`

7. `python manage.py createsuperuser`

8. `python manage.py dbshell`

9. `python manage.py shell_plus`




## XXI. Django Tips
#### 1. app_name
at urls.py, app_name!
```python
from django.urls import path
from . import views

app_name = 'board'

urlpatterns = [
    path('', views.article_list, name="list"),  # /board
    path('<int:article_id>/', views.article_detail, name="detail"),  # /board/1
    path('new/', views.new_article, name="new"),
    path('create/', views.create, name="create"),
]
```

**app_name:name_in_urls**
```html
<a href="{% url 'board:new' %}">
        <button>New Article</button>
    </a>
```

#### 2. get_object_or_404
at views.py

```python
from django.shortcuts import render, redirect, get_object_or_404

def article_detail(request, article_id):
    article = get_object_or_404(Article, id=article_id)

    return render(request, 'board/detail.html', {
        'article': article,
    })
```


#### 3. POST in delete
at views
```python
def delete(request, article_id):
    if request.method == 'POST':
        article = get_object_or_404(Article, id=article_id)
        article.delete()
    return redirect('board:list')
```

#### 4. Using embed in IPython for debugging
```python
from IPython import embed


embed()
```
#### 5. autofocus
in input tag => attribute => autofocus

#### 6. onclick confirm at delete
```html
<button type="submit" onclick="return confirm('레알 삭제?!')">[x]</button>
```

#### 7. Django-imagekit
`pip install django_imagekit pillow `

settings.py
```python
INSTALLED_APPS = [
    'imagekit',
    'django_extensions',
    'django.contrib.admin',
    'django.contrib.auth',
    'django.contrib.contenttypes',
    'django.contrib.sessions',
    'django.contrib.messages',
    'django.contrib.staticfiles',
    'sns',
]
```

##### media file address
```python
STATIC_URL = '/static/'

MEDIA_URL = '/media/'

MEDIA_ROOT = os.path.join(BASE_DIR, 'media')
```

##### setup for file-uploading in urls.py
```python
from django.contrib import admin
from django.urls import path, include

#upload setting
from django.conf.urls.static import static
from django.conf import settings

urlpatterns = [
    path('admin/', admin.site.urls),
    path('sns', include('sns.urls'))  # . not /
]

# Dev Only (개발 서버에서 media/ 파일들을 서빙 미지원)
# DEBUG = False 되면, 자동으로 static(...) => return []
urlpatterns += static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)
```

models.py
```python
from django.db import models

#  ImageKit
from imagekit.models import ImageSpecField, ProcessedImageField
from imagekit.processors import ResizeToFit

class Posting(models.Model):
    content = models.TextField(default='')
    icon = models.CharField(max_length=20, default='fas fa-question')

    # save as origin
    # image = models.ImageField(blank=True, upload_to='posting/origin/%Y%m%d')

    # resize
    image = ProcessedImageField(
        blank=True,
        upload_to='posting/resize/%Y%m%d',
        processors=[ResizeToFit(width=580, upscale=False)],
        format='JPEG',
    )

    # thumbnail
    image_thumbnail = ImageSpecField(
        blank=True
        source='image',
        processors=[ResizeToFit(width=320, upscale=False)],
        format='JPEG',
        options={'quality':60},
    )

    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    def __str__(self):
        return f"{self.id}: {self.content[:20]}"

    def __repr__(self):
        return self.__str__()


class Comment(models.Model):
    posting = models.ForeignKey(Posting, on_delete=models.CASCADE)
    content = models.CharField(max_length=100)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    def __str__(self):
        return f"{self.posting.content[:10]}: {self.content[:20]}"

    def __repr__(self):
        return self.__str__()
```


##### TIP Standard CRUD

**R**
/app_name/            list page
/app_name/1           `detail`
**C**
/app_name/new         `new`
/app_name/create      `create`
**U**
/app_name/1/edit      `edit`
/app_name/1/update    `update`
**D**
/app_name/1/delete    `delete`

This is not actually fit to RESTful definitely

* refer `RESTful API`


