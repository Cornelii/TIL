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
[](hotframeworks.com)


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

> python manage.py runserver $IP:$PORT

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


## X. Commands

1. `python manage.py runserver $IP`
* At C9: `python manage.py runserver $IP:$PORT`

2. `python manage.py startapp <app_name>`
generate needed directory and files.
(view.py, models.py, admin.py, etc)




