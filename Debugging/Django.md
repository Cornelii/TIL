# Django

#### 1. CORS policy
Access to XMLHttpRequest at 'http://vuefinal-firebattt.c9users.io/api/v1/memos/' from origin 'http://127.0.0.1:5500' has been blocked by CORS policy: No 'Access-Control-Allow-Origin' header is present on the requested resource.

CORS: cross-origin resource sharing

=> ServerSide solution

console
```console
pip install django-cors-headers
```

settings.py
```python
INSTALLED_APPS = (
    #...
    'corsheaders',
    #...
)

MIDDLEWARE_CLASSES = (
    #...
    'corsheaders.middleware.CorsMiddleware',
    'django.middleware.common.CommonMiddleware', # already exists.
    #...
)

CORS_ORIGIN_ALLOW_ALL = True
```

