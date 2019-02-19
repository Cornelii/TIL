# Django

## I. Framework
Framework is like Opening chain store to concentrate to offer service.

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
    path('url','function in view'),
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
2. `python manage.py makemigrations`

3. `python manage.py migrate`


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
> 


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


## VIII. files, which are like css, js, and, img, importing in c9
According to Django template Grammer!


1. make `static` directory on the app directory (static: default)
You can check this in settings.py

2. `load static` within django template grammer like jinja {%  %} on the top of the html.

3. `static "filepath"` within {%  %} in href, etc.


example

` load static ` within {%  %}


`<link rel="stylesheet" href=" ">`
{% static css/style.css %} in href



## X. Commands

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

