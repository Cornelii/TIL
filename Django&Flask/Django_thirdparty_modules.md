# Django_third part modules

## I

## II

## III

## IV

## V

## VI.

## VII. django-debug-toolbar
`pip install django-debug-toolbar`

settings.py
```python
 #just under django.contrib.staticfiles
'debug_toolbar',

# middleware
'debug_toolbar.middleware.DebugToolbarMiddleware',

INTERNAL_IPS = ('127.0.0.1', )
```

urls.py
```python
if settings.DEBUG:
    import debug_toolbar
    urlpatterns = [
        path('__debug__/', include(debug_toolbar.urls)),
    ] + urlpatterns
```

