# day4

## I. Flask_jinja
### 1.개념
HTML 구문 내에서 파이썬 문법을 사용할 수 있다. (진자의 방식에 따라서)
**Tip** {brace}: 진자 구문 인식
**Tip** 진자 문법에서는 html안에 있더라도, {* *} 가 코멘트.
### 2.실습
#### 2.1 jinja grammer

##### 2.1.1 newyear.html

```HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>
        .christmas{
            font-size:500%;
            color:gold;
            background-color:royalblue;
        }
    </style>
</head>
<body style="text-align:center;">
    <h1>Is it new year's day?</h1>
    {%if mon==1 and day==1%}
    <p>Yes, right. Happy new year!</p>
    {%else %}
    <p>No you still have time in this yaer</p>
    {%endif%}
    
    {%if mon==12 and day==25%}
    <p class="christmas">Yes Christmas! What did you get in the morning? or not?!</p>
    {%else%}
    <p class="christmas">This is not Christmas yet.</p>
    <p style="font-size:200%">Have you done good job enough to get christmas gift? Bad Ass</p>
    {%endif%}
    <img src="http://www.quickmeme.com/img/09/09861b018cc2a7bcf96795aae7b53692589777d47cdb5a8f57c1ce110dabbd12.jpg",height="150",width="200">
    
</body>
</html>
```
##### 2.1.2 app.py(flask)
```python
from flask import Flask, send_file, render_template
import random
import requests as rq
from bs4 import BeautifulSoup as bs
from datetime import date

app = Flask(__name__)

@app.route("/")
def hello():
    return "Hello World!"

###datetime
@app.route("/newyear")
def newyear():
    a=date.today()
    mon=a.month
    day=a.day
    return render_template("newyear.html",mon=mon,day=day)
```

#### 2.2 Fake Search
##### 2.2.1 app.py(for fake search)

```python
from flask import Flask, render_template, request
import requests as rq

app=Flask(__name__)

@app.route("/fakesearch")
def fakesearch():
    return render_template("fakesearch.html")

```

##### 2.2.2 fakesearch.html

```HTML
<!DOCTYPE html>

<html>
    <head>
        <title>FakeSearch</title>
        <style>
            body{
                text-align:center;
            }
        </style>
    </head>
    <body>
        <h1>Fake Search</h1>
        <h2>Google Search</h2>
        <form action="https://www.google.com/search">
            <input type="text" name="q">
            <input type="submit">
        </form>
        <h2>Naver Search</h2>
        <form action="https://search.naver.com/search.naver">
            <input type="text" name=query>
            <input type="submit">
        </form>
        <h2>Daum Search</h2>
        <form action="https://search.daum.net/search">
            <input type="text" name="q">
            <input type="submit">
        </form>
        <h2>Google Scholar Search</h2>
        <form action="https://scholar.google.co.kr/scholar">
            <input type="text" name="q">
            <input type="submit">
        </form>
    </body>
</html>
```

**Tip**  루트 라우트는 보통 밑 함수를 index로 지정함.
**Tip**

## II. HTML-Form Tag
사용자와 상호작용을 하기 위해서 form tag를 사용할 수 있음..
### 1.개념
`<form></form> 태그는 안에 <input>태그를 활용할 수 있게 함.

### 2.실습
```html
<!DOCTYPE html>
<html>
    undefined<head>
        <title>FakeSearch</title>
        undefined<style>
            body{
                text-align:center;
            }
        </style>
    </head>
    <body>
        <h1>Fake Search</h1>
        <form action="https://www.google.com/search">
            <input type="text" name="q">
            <input type="submit">
        </form>
        
    </body>
</html>
```