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

{MVC}: Model-View-Controller

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


**Tip** When use `source .bashrc` in the py virtualenv, `source deactivate`

`python manage.py runserver $IP:$PORT`  (at c9)

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


## VI. admin
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



## VII. Static files, which are like css, js, and, img.
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

**Points**
If you want to add additional file with different name in Django `static` directory search.

at `settings.py`

add `STATICFILES_DIRS`

```python
STATIC_URL = '/static/'

STATICFILES_DIRS = [
    "/home/special.polls.com/polls/static",
    "/projcet_name/static/",
    "/projcet_name/assets/",
    "/assets/c",
]
```

## VIII. with ipython & django_extensions

After generating project and app, add `django_extensions` to the INSTALLED_APPS
at settings.py

## IX. sub gate-keeper
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

## X. Super neutral templates

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

## XI. Commands

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




## XX. Django Tips
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


