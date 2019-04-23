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


#### 7. FieldFile
FieldFile is an instance when you access a FileField!

methods
1. .name
2. .size
3. url
4. open(mode) 'rb', etc
5. close()
6. save(name, content)


#### 8. ImageField
ImageField basically inherits FiledField. In addition to this, it has height and width!

For the additional optional arguments, There are height_field, width_field that is auto-populated in size when image is saved.

#### 9. IntegerField
value from -2147483648 to 2147483647.

This uses MinValueValidator and MaxValueValidator.


#### 10. TextField
It is often used.


#### 11. URLField
CharFiled for a URL, validated by URLValidator.


#### 12. ForeignKey  !!
1:N relationship.
This requires two arguments: `class to be related`, `on_delete`

##### i. Arguments
`ForeignKey.on_delete`
from django.db import models

models.CASCADE : delete together
models.PROTECT : ProtectedError when deleting referenced object
models.SET_NULL: if null is True, Set ull to ForeignKey
models.SET_DEFAULT: default value
models.SET(): CALLBACK fcn

SET example
```python
from django.conf import settings
from django.contrib.auth import get_user_model
from django.db import models

def get_sentinel_user():
    return get_user_model().objects.get_or_create(username='deleted')[0]

class MyModel(models.Model):
    user = models.ForeignKey(
        settings.AUTH_USER_MODEL,
        on_delete=models.SET(get_sentinel_user),
    )
```

models.DO_NOTHING: Be carefull the integrityError.

`ForeignKey.limit_choices_to`
make limitation on making reference!
example
```python
staff_member = models.ForeignKey(
    User,
    on_delete=models.CASCADE,
    limit_choices_to={'is_staff': True},
)

## Callback fcn
def limit_pub_date_choices():
    return {'pub_date__lte': datetime.date.utcnow()}

limit_choices_to = limit_pub_date_choices
```

**Remarks** Callable is prefered to be avoided. Because, it may be invoked multiple times. (instanitation, validation, ec)


`ForeignKey.related_name`
Relational name(backward relation),
default => "{class_name.lower_case()}_set"
"+" makes no backward relation





#### 13. ManyToManyField   !!



#### 14. OneToOneField    !!



#### 15. Field APIs



#### 16. Field attributes




#### etc.
* FloatField
* FilePathField
* GenericIPAddressField
* PositiveIntegerField (0 to 2147483647)
* SmallIntegerField
* PositiveSmallIntegerField (0 to 32767)
* 
