# Django modules
To check query: User attribute `.query`

## I. django.db

#### 1. models
models is used to define your model class making it inherit this.


#### 2. backends.postgresql, backends.mysql, backends.oracle.
set database. (default: SQLite)

example
settings.py
```python
DATABASES = {
    'default': {
        'ENGINE': 'django.db.backends.postgresql',
        'NAME': os.path.join(BASE_DIR, 'db.postgresql?!'),
    }
}
```
**Remarks** 
For databases other than SQLite

If you’re using a database besides SQLite, make sure you’ve created a database by this point. Do that with “CREATE DATABASE database_name;” within your database’s interactive prompt.

Also make sure that the database user provided in mysite/settings.py has “create database” privileges. This allows automatic creation of a test database which will be needed in a later tutorial.

If you’re using SQLite, you don’t need to create anything beforehand - the database file will be created automatically when it is needed.

<hr>

## II. django.contrib

#### 1. admin

##### i. site.register() 
To make model represent at admin site
```python
admin.site.register(models.Article)
```

#### 2. auth.decorators

##### i. login_required
```python
@login_required
def index(request):
    return render(request, 'posts/index.html')
```





#### 10. staticfiles


<hr>

## III. django.conf

#### 1. settings



#### 2. urls.static

##### i. static
This is neeeded in urls.py to upload files
```python
from django.conf.urls.static import static
from django.conf import settings

urlpatterns += static(settings.MEDIA_URL, document_root = settings.MEDIA_ROOT)
```


<hr>

## IV. django.urls
This contains a simple mapping between URL and Python callback functions

#### 1. path
To add url-call back function mapping in the urlpatterns list.
```python
urlpatterns = [
    path('url', views.method, name='alias_name'),
]
```

<hr>

## V. django.shortcuts

#### 1. render()
Basic method to load a template, and return an HttpResponse object
```python
def index(request):
    context = {
        'a' :1
    }
    return render(request,'board/index.html', context)
```
#### 2. get_object_or_404()
This is used to get model object. If this work is failed, it gives user 404 page.

~ `get_list_or_404()` : list using `filter()`

#### 3. redirect
redirection

## VI. django.views

#### 1. generic (ListView & DetailView here)
model should be given to class!
##### ListView: dispaly a list of objects


##### DetailView: display a detail page for a particular type of object



## V. django.test


