# Django_ Heroku Production


## 1.  
`pip install django_heroku` (heroku는 기본적으로 postgresql 사용함.)

## 2.
settings.py
```python
import django_heroku
#...




django_heroku.settings(locals())
```

## 3. 
`pip install gunicorn`
WSGI => Web Server Gateway Interface

gunicorn: python WSGI HTTp server for Unix.


(`whitenoise`): Static file management settings.
## 4.
In the Project root directory

runtime.txt
```
python-3.5.7
```

Write in python version

requirements.txt
`pip freeze >> requirements.txt`

Procfile (file name is so important)
```
web: gunicorn {app_name}.wsgi
```

## 5.
At the console
`heroku --version`
`heroku login`
email & password

`heroku create`
Just above command generate randomly named - URL

`heroku create {url name}`

`git push heroku master`

## 6. 
If you want to make command into the Heroku
`heroku run {command}`

1. `heroku run python manage.py migrate`
2. `heroku run python manage.py createsuperuser`

## 7. 
If you have domain.
`heroku domains:add {}`
