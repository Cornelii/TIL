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
### 1. 개념
`<form></form> 태그는 안에 <input>태그를 활용할 수 있게 함.

### 2. 실습
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



**Tip:** Webhook 참고.

**Tip**: faker python 참고.

#### 2.1 Newyear and Christmas
##### 2.1.1 python
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
##### 2.1.2 HTML
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

#### 2.2 FakeSearch
##### 2.2.1 python
```python
from flask import Flask, render_template, request
import requests as rq

app=Flask(__name__)

#Telegram
key="환경변수에서"

my_id="환경변수에서"
send_url="https://api.telegram.org/" # Origin address
hphk_url="https://api.hphk.io/telegram/" ### hphk 우회 주소.
send_url2="bot{}/sendMessage?chat_id={}&text={}"

#
@app.route("/")
def index():
    return render_template("index.html")

@app.route("/sendmsg")
def sendmsg():
    msg=request.args.get("msg") #보낸 박스의 이름
    #telegram에 메세지 보내기
    # 1. chatbot의 key값을 받아서 저장한다.
    # 2. key/token 값을 통해서 /getMe (나(봇)에 대한 정보) /getUpdates (봇에 대한 상태 정보)
    # 3. 
    url=hphk_url+send_url2.format(key,my_id,msg)
    rq.get(url)
    return render_template("sendmsg.html",msg=msg)
# 
@app.route("/fakesearch")
def fakesearch():
    return render_template("fakesearch.html")

```
##### 2.2.2 HTML
###### 2.2.2.1 index.html
```HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <h1>Telegram messenger</h1>
    <form action="/sendmsg">
        <input type="text" name="msg">
        <input type="submit">
    </form>
</body>
</html>
```
###### 2.2.2.2 sendmsg.html
```HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <h1>I just received</h1>
    
    <p>I got {{msg}}</p>
    <p>turn back</p>
    <form action="https://flask--onelifefirebat.c9users.io/">
        <input type="submit" autofocus>
    </form>
    
    <form>
        <input type=button>
        <input type=checkbox>
        <input type=color>
        <input type=date>
        <input type=datetime-local>
        <p>from e-mail</p>
        <input type=email>
        <input type=file>
        <input type=hidden>
        <input type=image>
        <input type=month>
        <input type=number>
        <input type=password>
        <input type=radio>
        <p>from range</p>
        <input type=range>
        <input type=reset>
        <input type=search>
        <input type=tel>
        <input type=text>
        <input type=time>
        <input type=url>
        <input type=week>

    </form>
    
    
</body>
</html>
```
###### 2.2.2.2 fakesearch.html
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
#### 2.3 vonvon
##### 2.3.1 python
```python
from flask import Flask,render_template, request
import faker
import random
import csv

app=Flask(__name__)
a=faker.Faker()

D={}# name matching

# '/':사용자의 이름을 입력 받습니다.
@app.route("/")
def index():
    return render_template("index_job_rec.html")

# '/job': 사용자에게 랜덤으로 생성된 직업 추천.
@app.route("/job")
def job():
    name=request.args.get("name")
    name_list=list(D.keys())
    if name in name_list:
        pass
    else:
        D[name]=a.job()
    return render_template("job.html",job=D[name])



@app.route("/dic")
def dic():
    dic=D
    return render_template("dic.html",dic=D)

@app.route("/compati")
def compati():
    return render_template("index.html")

@app.route("/match")
def match():
    # 1. fake 궁합을 알려주고,
    babo=request.args.get("babo")
    victim=request.args.get("victim")
    # 2. 우리만 알 수 있게 저장한다.
    # 3. fish 리스트에 append를 통해 저장한다.
    couple=[babo,victim]
    
    # xx님과 yy의 궁합은 88%입니다.
    if str(couple) in D:
        num=D[str(couple)]
    else:
        num=random.choice(range(10,100))
        D[str(couple)]=num
        with open("fish_list.csv","a",encoding="utf-8") as csvfile:
            writer=csv.writer(csvfile,delimiter=",")
            writer.writerow(couple)
            
    return render_template("match.html",babo=babo,victim=victim,num=num)

@app.route("/admin")
def admin():
    # 낚인 사람들의 명단
    # template에서 반복(for)을 써서, fish에 들어가 있는 데이터를 모두 보여준다.
    with open("fish_list.csv","r",encoding="utf-8") as csvfile:
        reader=csv.reader(csvfile,delimiter=",")
    
        return render_template("admin.html",fish=reader)
    
    
```
##### 2.3.2 HTML
###### 2.3.2.1 index.html
```HTML

```
###### 2.3.2.2 job..html
```HTML

```
