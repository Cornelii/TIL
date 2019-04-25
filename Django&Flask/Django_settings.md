# Django Settings

## I. Static Files
To django find static files with my specific assets directory!

settings.py
```python
STATICFILES_DIRS = [
    os.path.join(BASE_DIR, "assets"),
]
```
#### 1. STATIC_ROOT

#### 2. STATIC_URL

#### 3. STATICFILES_DIRS

#### 4. STATICFILES_STORAGE

#### 5. STATICFILES_FINDERS


#### 6. MEDIA_ROOT & MEDIA_URL
MEDIA_ROOT and MEDIA_URL need to be set to deal with files. and, models.FileField


To use FileField or ImageField.

##### i. Add MEDIA_ROOT & MEDIA_URL

settings.py
```python

MEDIA_ROOT = os.path.join(BASE_DIR,'media')
# Full path to a directory where 
# you'd like Djnago to store uploaded data

MEDIA_URL = 'media'
# base public url of that directory
# just make sure that this directory is writable 
# by the web server's user account
```

##### ii. Add FileField or ImageField to your model
set upload_to option to specify a subdirectory of MEDIA_ROOT
example `img/%Y/%m/%d`

##### iii. use of attributes `url`, `name`, `size`

**Remarks**
Validate all uploaded files to prevent PHP script, etc.


