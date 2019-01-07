# Python Chatbot 1 day

1일차 키워드 기반 챗봇 만들기(파이썬) 

[챗봇 플랫폼_hphk](https://s1.py.hphk.io)

![](https://www.python.org/static/opengraph-icon-200x200.png)

## I. 기초 문법 
### 1. 개념
컴퓨터는 저장과 계산에 뛰어남.
코딩언어는 크게 저장, 반복, 조건으로 이루어짐.

 파이썬은 **Dynamic typing language** : 자료형 정의가 따로 필요 없음.

- 숫자
- 글자
- Boolean형
- list
- dictionary

### 2.실습

~~~python
#Hello 5번 출력하기
s='Hello\n'
print(s*5)
~~~

~~~python
#lotto 번호 뽑기
import random
num=list(range(1,46))
lotto_num=random.sample(num,6)
print(sorted(lotto_num))
~~~

~~~python
# 미세먼지 정보 긁어오기
import requests
from bs4 import BeautifulSoup

url = 'http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?ServiceKey={}&sidoName=서울&pageNo=3'.format(key)
response = requests.get(url).text
soup = BeautifulSoup(response, 'xml')
gn = soup('item')[7]
location = gn.stationName.text
time = gn.dataTime.text
dust = int(gn.pm10Value.text)

print('{0} 기준: 서울시 {1}의 미세먼지 농도는 {2} 입니다.'.format(time, location, dust))

if dust<=30:
  print( ' 미세먼지 농도가 좋음입니다.')
elif dust<=80:
  print('미세먼지 농도가 보통입니다.')
elif dust<=150:
  print('미세먼지 농도가 나쁨입니다.')
else:
  print('미세먼지 농도가 매우나쁨입니다.')
~~~



## II. 개발 계명(Development Commandments)
1. Browser는 Chrome

2. 문서는 Markdown(.md)

3. 교과서는 공식문서 & 내가 정리한 마크다운이라 생각.

### III. Markdown Syntax 정리(기초)

#### 1. Headers

'# (header1), ## (h2), ### (h3),...'

# h1

## h2

### h3



#### 2. Blockquotes

'> quotation1, >> quotation in quotation'

> quotation1
>
> > quotation in quotation



#### 3. Code Blocks

"~~~ or ```  "   

~~~python
def CodeBlocks_in_Python_style
~~~



#### 4. Inline Code Blocks

Statements between ``

`Inline Code Blocks`



#### 5. Emphasis

- italic

between '* or _'

*Italic*

_Italic_

* bold

between ' ** or __'

**bold**

__bold__



#### 6. Horizontal Line

'---'

---

'***'

***

'___'

___



#### 7. External Link

- inline link

`[링크]( address "link title")`

[google](https://google.com)

[google](https://google.com "Google")

- reference link

`[링크1][1]   [1]:address "link title1"`

[google][1]     [1]:https://google.com/ " google1"

- url link

`<example.com>    <url address> ` 

<https://google.com>



#### 8.Internal Link

`[링크](#id)`

[link](#id1)



#### 9. Lists

`number +. or *,+,-`



#### 10. Tables

`|part1|part2|`

| part1 | part2 |
| ----- | ----- |
|       |       |

`|num|Header|Header1|Header2|
|:---:|---|---|---|
|1|first|1st|one|`

|num|Header|Header1|Header2|
|:---:|---|---|---|
|1|first|1st|one|




#### 11. Images

`![text](image_addres,url...)`

`![Python_logo](https://www.python.org/static/opengraph-icon-200x200.png)`

![Python_logo](https://www.python.org/static/opengraph-icon-200x200.png)



#### 12. check box 

`- [x] (space bar)`

- [x] 1
- [ ] 2
- [ ] 3

- [x] 4



#### 13. emoji

`example :ribbon:`

:ribbon:

`check out url :https://github.com/ikatyang/emoji-cheat-sheet/blob/master/README.md `

[emoji_git](https://github.com/ikatyang/emoji-cheat-sheet/blob/master/README.md)


#### 14. Math

$$
\begin{align*}
y=y(x,t)&=A e^{u\theta}\\
&= A (\cos \theta + i \sin \theta) \\
&= A (\cos(kx - \omega t) + i \sin(kx - \omega t)) \\
&= A\cos(kx - \omega t) + i A\sin(kx - \omega t)  \\
&= A\cos \Big(\frac{2\pi}{\lambda}x - \frac{2\pi v}{\lambda} t \Big) + i A\sin \Big(\frac{2\pi}{\lambda}x - \frac{2\pi v}{\lambda} t \Big)  \\
&= A\cos \frac{2\pi}{\lambda} (x - v t) + i A\sin \frac{2\pi}{\lambda} (x - v t)
\end{align*}
$$

#### 15. Chemistry Expressions





#### Shortcuts
ctrl+/ : source code window mode




**Tip** *Pythontutor*: 컴퓨터의 흐름을 알 수 있는 좋은 툴

[pythontutor](http://pythontutor.com/)

[pythontutor_edit](http://pythontutor.com/visualize.html#mode=edit)



## III.  API
Application Programmable Interface
서비스에 열려있는 통로를 프로그래밍적으로 연결하는 방식

## IV. 웹의 이해

### 1. Request and Response
웹은 현실의 거의 모든 서비스와 흡사하게 요청과 응답으로 이루어진다.

* **request**:  URL_주소창
* **response**:  Json,XML,HTML
URL을 통해 문서 한 장을 요청하게 되고, 문서 한 장을 받게 됨.

**Tip**: (data얻기 좋은 사이트) www.data.go.kr

## V. 개발환경 구성

### 1. Typora_for_Markdown

### 2. Git Bash (git for windows)
* basic commanders: pwd,ls,mkdir,rm.
* The commands of Git bash are like ones of Linux

### 3. Visual Studio Code 


## VI. 몸 풀기

### webbrowser

#### 1.실습
##### 1.1
~~~python
import webbrowser as wb
url="http://daum.net"
wb.open(url)
wb.open_new(url)
wb.open_new_tab(url)
~~~

##### 1.2

~~~python
import webbrowser as wb
'''
url="https://scholar.google.co.kr/scholar?hl=ko&as_sdt=0%2C5&q="
#wb.open(url)
#wb.open_new(url)
search_list=['GAN','SuperResol','RNN']
for key in search_list:
    wb.open_new(url+key)
'''
#1 Mission 1
# Webbrowser, "ssafy", 'samsung','sw','coding'

url='https://www.google.com/search?hl=ko&source=hp&ei=00QXXOnFM4qp8QWRw4KgBA&q='
search_list=['ssafy','samsung','sw','coding']
for key in search_list:
    wb.open_new(url+key)
~~~

#### 1.3 Web 스크래핑

__Tip__: status 200 : Success, 404 : page not found

~~~python
# kospi 정보 스크랩
import webbrowser as wb
import requests as rq
import bs4 # python이 문서를 읽기 쉽도록 만들어 줌(HTML,XML,json 등)
'''
url="http://finance.daum.net/"
response=rq.get(url)

doc=bs4.BeautifulSoup(response.text,'html.parser')

result=doc.select_one('#boxIndexTabs > span > h4') ### 웹 검사 copy-> selector


print(result.text)
'''


#### https://finance.naver.com/sise/ 에서 코스피지수 받아오기
url='https://finance.naver.com/sise/'
response=rq.get(url)

doc=bs4.BeautifulSoup(response.text,'html.parser')

result=doc.select_one('#KOSPI_now')

print(result.text)
~~~

#### 1.4 file name change

os.chdir

os.listdir

os.rename

os.getcwd

os.mkdir

~~~python
import os
#zzu.li/file
os.chdir('./list/SSAFY/')
#os.chdir(r'c:\Users\student\chatbot\day1\list\SSAFY\')
current_path=os.getcwd()

file_list=os.listdir('.')

prefix='ssafy_'

for jmi in file_list:
    os.rename(jmi,prefix+jmi)
~~~


# Day2

##  I. Git

### 1. Concepts

git (분산) 버젼 관리 시스템 developed by Linus Torvalds
**Tip**: git linus torvalds google in youtube (clip)

버젼 관리 시스템의 필요성: 관리가 힘들다. 특히, 코드의 경우. 특히, 여러사람이 작업할 경우

여러 git 기반 시스템 git != github

1. Github
2. GitKraken
3. Gitlab
4. Bitbucket

Jira, Atlassian 참고

### 2. practice
git은 디렉토리(폴더) 중심으로 관리가 이루어진다.
@ Git Bash 내에서

1. 관리하는 폴더를 만들고 그 폴더로 이동. (mkdir, cd, ls)
2. git init    (ls -al 해보면 .git 이 생김)
3. git status (상태 묻기)
4. 내부에 code . 으로 visual code 실행 후 README.md 생성
5. git status 확인
6. git add README.md (git status로 다시확인해보기 초록색으로 바뀜)
7. git commit -m "first commit"  (스냅샷 찍기)
8. 처음에는 사용자 정보 요청이 들어옴. 양식에 맞게 등록
9. git commit -m "first commit"  (이제는 커밋이 됨)
10. git log   (기록 확인)
11. README.md에 몇 줄 추가하기
12. git status (다시 수정한 파일 이름이 빨간색)
13. git diff (디테일한 수정 정보확인가능)
14. git add README.md
15. git status
16. git remote add origin https://github.com/Cornelii/TIL.git  (깃허브 주소)
17. git push -u origin master

**Tip** 스냅샷들 사이에서 시간이동을 할 수 있다.
**Tip** git remote -v 로 현재 git 연결상태 확인 가능
**Tip** 주소 수정법 git remote remove origin  (origin은 주소이름 git remote -v에서 확인)

> **git의 작업 흐름**
>
> > 1. add  (스냅샷) 	
> > 2. commit  ()
> > 3. push  ()

​	

## II. Web Scraping

### 1. practice by examples
#### 1.1
```python
#1. requests를 통해 naver.com에 요청보내고
#2. 응답 받은 문서 저장
#3. BeutifulSoup로 정보를 찾기 좋게 만듦
#4. 우리가 원하는 정보 뽑아오기.
#5. webbrowser를 통해 실시간 1위 검색어를 검색한 페이지를 열어주는 코드

import bs4
import requests
import webbrowser

target_url="https://www.naver.com/"
response=requests.get(target_url)

filtered_text=bs4.BeautifulSoup(response.text,'html.parser')

result=filtered_text.select_one(".ah_k")

search_url="https://search.naver.com/search.naver?query="
webbrowser.open_new_tab(search_url+result.text)
```

**Tip**: 요소검사 html에서 id가 있을 경우 #을 클래스일 경우 .을 붙혀줌. (select_one에서)

#### 1.2

```python
import bs4
import requests
import webbrowser

target_url="https://www.naver.com/"
response=requests.get(target_url)

filtered_text=bs4.BeautifulSoup(response.text,'html.parser')

result=filtered_text.select(".ah_k")

search_url="https://search.naver.com/search.naver?query="

for jmi in range(3):
    
    webbrowser.open_new_tab(search_url+result[jmi].text)
```

**Tip**: select 를 사용할 시 해당  id또는 클래스 (span)에 속한 것들을 전부 배열형태로 반환함.

**Tip**: ctrl + / 다중주석처리

**Tip**: dir(): 쓸 수 있는 method 및 속성들 보여줌.

**Tip**: type(), dir()를 통해 확인하며 공부하면 좋음.



**Tip**   *String  3 가지 조작방법*

1. **Concatenation**: 글자 합체 ex) "happy" + "hacking"
2. **Interpolation?!** :  글자 삽입 ex) 

str1="happy"

str2="hacking"

Interpolation="{}  {}".format(str1,str2)

1. **Slicing**: 글자 자르기

#### 1.3 naver 실시간 검색서 scraping

```python
#1. requests를 통해 naver.com에 요청보내고
#2. 응답 받은 문서 저장
#3. BeutifulSoup로 정보를 찾기 좋게 만듦
#4. 우리가 원하는 정보 뽑아오기.
#5. webbrowser를 통해 실시간 1위 검색어를 검색한 페이지를 열어주는 코드
'''
import bs4
import requests
import webbrowser

target_url="https://www.naver.com/"
response=requests.get(target_url)

filtered_text=bs4.BeautifulSoup(response.text,'html.parser')

result=filtered_text.select_one(".ah_k")

search_url="https://search.naver.com/search.naver?query="
webbrowser.open_new_tab(search_url+result.text)
'''
import bs4
import requests
import webbrowser

target_url="https://www.naver.com/"
response=requests.get(target_url)

filtered_text=bs4.BeautifulSoup(response.text,'html.parser')

result=filtered_text.select(".ah_k")

search_url="https://search.naver.com/search.naver?query="

for jmi in range(3):
    
    webbrowser.open_new_tab(search_url+result[jmi].text)

print(type(filtered_text),type(result))

```

#### 1.4 Scraping from Naver mobile website

```python
# scrap naver webtoon tuesday 
import requests as rq
from bs4 import BeautifulSoup as BS

target_url="https://m.comic.naver.com/webtoon/weekday.nhn?week=tue"
response=rq.get(target_url)

souped_doc=BS(response.text,"html.parser")
# Toon names
names=souped_doc.select(".toon_name")

names_list=[]
with open('toon_name.txt','w') as f:
    for name in names:
        print(name.text)
        f.write(name.text+'\n')
        names_list.append(name.text)
images_list=[]

# images
imgs=souped_doc.select(".im_br")
for elem in imgs:
    print(elem.select_one("img")["src"])
    images_list.append(elem.select_one("img")["src"])
# elem.select_one("img") => bs4.element.Tag 
# => key-value seraching available

toon_d={}
for key,value in zip(names_list,images_list):
    toon_d[key]=value
```

#### 1.5 Scrap from bithumb

```python
# scrap naver webtoon tuesday 
import requests as rq
from bs4 import BeautifulSoup as BS

target_url="https://m.comic.naver.com/webtoon/weekday.nhn?week=tue"
response=rq.get(target_url)

souped_doc=BS(response.text,"html.parser")
# Toon names
names=souped_doc.select(".toon_name")

names_list=[]
with open('toon_name.txt','w') as f:
    for name in names:
        print(name.text)
        f.write(name.text+'\n')
        names_list.append(name.text)
images_list=[]

# images
imgs=souped_doc.select(".im_br")
for elem in imgs:
    print(elem.select_one("img")["src"])
    images_list.append(elem.select_one("img")["src"])
# elem.select_one("img") => bs4.element.Tag 
# => key-value seraching available

toon_d={}
for key,value in zip(names_list,images_list):
    toon_d[key]=value
```

#### 1.6 lottery number check

```python
# 나눔로또 API통해 우승번호 가져오기
# random으로 생성된 번호와 비교해서 등수 정하기.
# 1등: 6개, 2등: 5개+1보너스, 3등: 5개, 4등: 4개, 5등: 3개 ?!
import random
import json
import requests as rq
import copy

# json file은 python의 dictionary와 같은데 단지 문서이다.
recom=random.sample(list(range(1,46)),6)

lotto_API_url="https://www.nlotto.co.kr/common.do?method=getLottoNumber&drwNo="

# 요청보내서 json읽어오기
info=rq.get(lotto_API_url+'837', verify=False)

# json-> python dict
dict_info=json.loads(info.text)
keys=["drwtNo1","drwtNo2","drwtNo3","drwtNo4","drwtNo5","drwtNo6","bnusNo"]
keys=[]
for jmi in range(6):
    keys.append("{}{}".format("drwtNo",jmi+1))
keys.append('bnusNo')
#### lecturer
# list.append(dict[f"~~~~{jmi}"])

# 당첨번호 리스트 구성
rwd_list=[]
for key in keys:
    rwd_list.append(dict_info[key])

# 일치하는 숫자 갯수
rwd_count=0
for num in recom:
    if (num in rwd_list[:-1]):
        rwd_count+=1
#### lecturer ##################################################
winner=copy.copy(rwd_list)
picked=copy.copy(sorted(recom))

S_winner=set(winner)
S_picked=set(picked)
matched=len(S_winner & S_picked)

################################################################
# 보너스 번호
if (rwd_list in recom):
    bonus=True
else:
    bonus=False

comment=0
if rwd_count==6:
    comment="1등"
elif rwd_count==5:
    if bonus:
        comment="2등"
    elif bonus:
        comment="3등"
elif rwd_count==4:
    comment="4등"
elif rwd_count==3:
    comment="5등"
else:
    comment="꽝"

print("당신의 번호는 {}입니다.".format(sorted(recom)))
print("당첨 번호는 {}입니다.".format(rwd_list[:-1]))
print("보너스 번호는 {}입니다.".format(rwd_list[-1]))
conum=rwd_count
if bonus: 
    conum=rwd_count+1 
print("일치하는 숫자는 {}입니다.".format(conum))
print("해당 결과는 {}입니다.".format(comment))

iter_num=100

iter_num=int(input("몇번 시뮬 돌려보실래유?!"))

def check(iter_num,rwd_list):
    count=[0,0,0,0,0]
    
    for jmi in range(iter_num):
        recom=random.sample(list(range(1,46)),6)
        rwd_count=0
        for num in recom:
            if (num in rwd_list[:-1]):
                rwd_count+=1
        
        # 보너스 번호
        if (rwd_list in recom):
            bonus=True
        else:
            bonus=False

        if rwd_count==6:
            count[0]+=1
        elif rwd_count==5:
            if bonus:
                count[1]+=1
            elif bonus:
                count[2]+=1
        elif rwd_count==4:
            count[3]+=1
        elif rwd_count==3:
            count[4]+=1
        else:
            pass
    return count

count=check(iter_num,rwd_list)

print("{}번 중에 {}이네 로또 하지마라 ㅋ".format(iter_num,count))
```

## III. Massenger API -> *telegram* Good~~~!!!

telegram을 통해 chatbot만들기.

[telegram API](https://core.telegram.org/bots/api)

1. Web app으로 들어가서 bot father을 검색
2. /newbot을 통해 새로운 bot 생성.(tocken)을 받을 수 있음.
3. Web url을 통해 method  requests할 수 있음.
4. Python에서 Requests를 이용해서 봇 활용 가능.

| methods     | description           |
| ----------- | --------------------- |
| getMe       | Get user info         |
| getUpdates  | Get status of chat    |
| sendMessage | Send message from bot |

### 3.1 Telegram example

```python
#url=f"https://api.telegram.org/bot{}/getMe"

key="환경변수에서"

user_id="환경변수에서"

# send message
#https://api.telegram.org/bot{}}/sendMessage?chat_id={}&text=message_from_chatbot

# user Info
#https://api.telegram.org/bot{}/getMe

# status of chat 
#https://api.telegram.org/bot{}/getUpdates

import requests as rq
from bs4 import BeautifulSoup as BS
import time
msg=("Coin")

send_url=f"https://api.telegram.org/bot{key}/sendMessage?chat_id={user_id}&text={msg}"

rq.get(send_url)

### chatbot code
# bithumb  상위 다섯개 코인 보내주기

target_url="https://www.bithumb.com/"
response=rq.get(target_url)

doc=BS(response.text,"html.parser")

rtv=doc.select("#assetRealBTC")
s="{}:  {}\n".format("BitCoin",rtv[0].text)
print(s)
msg=s
send_url=f"https://api.telegram.org/bot{key}/sendMessage?chat_id={user_id}&text={msg}"
rq.get(send_url)
```

## IV 기타
영화진흥위원회 API 데이터 뽑아내서 이것 저것 해보기.
IFTTT  참고

# day3

## I.AWS_c9/io

### 1. Concepts

**Tip**: 네이버 서버주소 확인방법 ctrl+shift+I => inspector
website 다시 들어가고, Headers->  " remote Address" 서비스제공자( server)의 주소
**Tip** DNS (domain name service):  ip -> "이름"으로

## II. Flask

경량화 웹 어플리케이션 프레임워크 good~!

![URL structure](https://neilpatel.com/wp-content/uploads/2017/08/image5.png)
**Tip**  url : 누구에게 보낼지 요청 받는 사람의 주소
**Tip** / : 가장 기본(root)가 되는 페이지를 요청
**Tip** /XXX : 무엇을 받을지
**Tip**  ?XX :  이런 정보를 담아 보낼게(parameter)
ex) ?chat_id=123456&text=hello
 ex) https://search.naver.com/search.naver?query=multicam

1. /search.naver : 네이버야 검색해줘
2. ?query=multicam : multicam 이란 단어를 담아 보낼게
3. /search.naver?query=multicam == multicam을 검색해줘

## III. HTML (hyper text markup language)

*HTML's like skeleton, +CSS -> nice-looking web*

**Tip**. SEO (검색엔진최적화)

HTML이 엔진에 들어갔을 때 예쁘게 잘 나오도록 하는 것.

기본적으로 html에서 h1 등의 태그를 조심히 써야 함.

이때의 원칙들이 존재. 

1. h1 태그는 무조건 한 번 쓴다.
2. id는 유일하게 하나씩 부여할 것.

## IV. Jinja for Dynamic Web in Flask

### 1. practice by examples

#### 1.1  Flask

```python
from flask import Flask
import copy
app = Flask(__name__)

@app.route("/")
def hello():
    return "Hello World!"
    
@app.route("/cornel")
def cornel():
    return "My Korean name is JiMyeong Son"
    
# /hi/john => "hello john"
# /hi/ashley => "hello ashley"
@app.route("/hi/<name>")
def hi(name):
    return "Hello "+name
    
# /cube/2 ==> 8
# /cube/3 ==> 27
@app.route("/cube/<int:num>")
def cube(num):
    return "{}".format(num**3)
#*Tip: 문자로 넘겨 받고, 문자로 넘겨줘야 함.

# /reverse/hello => olleh
@app.route("/reverse/<name>")
def reverse(name):
    a=list(name)
    a.reverse()
    result="".join(a)
    return result
    
## lecturer
# @app.route("/reverse/<param>")
# def reverse(param):
#     return param[::-1]
    
# /palindrome/racecar ==> true
# /palindrome/hello   ==> false
@app.route("/palindrome/<param>")
def palindrome(param):
    return str(param==param[::-1])
```

**Tip**  *헤로쿠* 참고

#### 1.2 HTML

#### 1.2.1

```HTML
<!DOCTYPE html> 

<html>
    <head>
        <!--머리: 상대적으로 덜 중요한 부분 (문서에 대한 정보) -->
        <title>HTML 테스트</title>
        <meta charset="utf-8">
        <!-- 위를 추가해야 익스 또는 FireFox는 위 라인을 넣어야 함. -->
    </head>
    <body>
        <!--몸통: 중요한 부분 (주요 내용들이 들어감) -->
        
        <h1>ssdfHTML 테스트</h1>
        <!-- h1 means # in markdown_가장 중요한 내용 -->
        <h2>부제목</h2>
        <!-- h2 is like ## in markdown_부제목 -->
        <p>안녕하세요.</p>
        <p>Hyper text markup language</p>
        <!-- Hypertest-> link function -->
        
        <a href="http://www.naver.com">이거는 네이버로 가는 링크</a>
        <img src="https://image-cdn.hypb.st/https%3A%2F%2Fkr.hypebeast.com%2Ffiles%2F2018%2F10%2Fkakao-talk-2018-1.jpeg?q=75&w=800&cbr=1&fit=max" width="300" height="200" alt="image can not be shown">
        
        <iframe width="560" height="315" src="https://www.youtube.com/embed/vhkCBOsOoYY" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

        <button>Click me</button>    
        <!--  -->

        <ul>
            <li>Coffee</li>
            <li>Tea</li>
            <li>Milk</li>
        </ul>
        <!-- HTML List -->
        <p style="color:red">This is a paragraph with a style attribute</p>

        <p title="I'm a tooltip">Tooltip attribute title in p tag put mouse on me for a while</p>
        <hr>
        <!-- Horizontal Rules -->
    </body>
</html>

</br>
```

#### 1.2.2

```HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Cornel, Son</title>
    <style>
        .text{
            color:darkgoldenrod
        }
        body{
            background-color:silver
        }
        #header{
            color:greenyellow
        }
        table{
            background-color:hotpink
        }

    </style>
    <!-- General style on tag over html documnet -->
    <!-- Tag grouping is so useful -->
    <!-- . for class, # for id -->
</head>
<body>
    <h1 id="header" style="font-size:200%;">My first HTML page</h1>
    <p, style="color:red;font-size:150%;">I'm mechamist!</p>
    <p, style="color:black;font-size:75%;"><i>My major is Mechanical Engineering+Electochemical Engineering</i></p>
    <p class="text">As you see, mechamist means a combination of them</p>

    <div class="text"> div tag offers smaller spacing between lines</div>
    <div class="text"> div tag takes smaller space on the html doc than p tag</div>

    <hr> 
    <!-- This is a horizontal rule -->

    <table>
        <tr>
            <td>Age</td>
            <td>29</td>
        </tr>    
        <tr>
            <td>Major</td>
            <td>Mech+ElectroChem</td>
        </tr>
        <tr>
            <td>Blood type</td>
            <td>A</td>
        </tr>
    </table>

    <hr>
    <!-- table>tr*3>td*2 -->

    <ul>
        <li>요건</li>
        <li>HTML 리스트여</li>
        <li>리스트여</li>
    </ul>
    <br>
    <br>
    <br>
    <br>
    <img src="image url">
    <!--  -->


    <hr>
    <br>
    <br>
    <br>
    <div id="title" class='text' title='div_prac1'>id&class defined1</div>
    <div id="con1" class='text' title='div_prac2'>id&class defined2</div>
    <div id="con2" class='text' title='div_prac3'>id&class defined3</div>
    <!-- id is unique, class is like a common feature -->
    <!--  -->

    <a href="https://www.google.com">구글 링크</a>

    <pre>
        This is a pre tag.

        It is useful to give several lines together. 
    </pre>

</body>
</html>
```

지금까지 static web

Dynamic web을 위해서는 다른 framework이 필요.ex) *Django, Flask etc.*

**Tip** *Viewjs* for front-end

### 1.3 Dynamic Web with Jinja in flask

#### 1.3.1 flask in python at Cloud9 server (based on linux)

template => It looks like html but, it can operate other language (like python)

```python
from flask import Flask, send_file, render_template
import random
import requests as rq
from bs4 import BeautifulSoup as bs

app = Flask(__name__)

@app.route("/")
def hello():
    return "Hello World!"
    
@app.route("/cornel")
def cornel():
    return "My Korean name is JiMyeong Son"

# /hi/john => "hello john"
# /hi/ashley => "hello ashley"
@app.route("/hi/<name>")
def hi(name):
    return "Hello "+name
    
# /cube/2 ==> 8
# /cube/3 ==> 27
@app.route("/cube/<int:num>")
def cube(num):
    return "{}".format(num**3)
#*Tip: 문자로 넘겨 받고, 문자로 넘겨줘야 함.

# /reverse/hello => olleh
@app.route("/reverse/<name>")
def reverse(name):
    a=list(name)
    a.reverse()
    result="".join(a)
    return result
    
## lecturer
# @app.route("/reverse/<param>")
# def reverse(param):
#     return param[::-1]
    
# /palindrome/racecar ==> true
# /palindrome/hello   ==> false
@app.route("/palindrome/<param>")
def palindrome(param):
    return str(param==param[::-1])

@app.route("/profile")
def profile():
    return send_file('profile.html')

## 웹으로 로또 번호 추첨해서 보여주기
@app.route("/lotto")
def lotto():
    name="Jimyeong Son"
    num=random.sample(list(range(1,46)),6)
    result=str(sorted(num))
    return render_template("lotto.html",result_lotto=result,name=name)
    
## 코스피 지수 뽑아서 웹으로 넣어주기
url="https://finance.naver.com/sise/"
@app.route("/kospi")
def kospi():
    res=rq.get(url)
    doc=bs(res.text,"html.parser")
    result=doc.select_one("#KOSPI_now")
    
    return render_template("kospi.html",kospi=result.text)

## google에 spiderman new universe 검색하면 나오는 검색 수 긁어서 보내주기
target_url="https://www.google.com/search?q=spiderman+new+universe"
@app.route("/spiderman")
def spiderman():
    res=rq.get(target_url)
    doc=bs(res.text,"html.parser")
    result=doc.select_one("#resultStats").text
    
    return render_template("attempts.html",search_num=result)
```



#### 1.3.2 related html

**Important notice**

Flask의 render_template의 사용방법에 따라, 정확히 templates라는 이름의 디렉토리안에 html파일들이 있어야 한다.

#### 1.3.3 lotto.html

```HTML
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <h1>로또 번호 </h1>
    <h2>{{result_lotto}}</h2>
    <h3>이름</h3>
    <h4>{{name}}</h4>
</body>
</html>
```

#### 1.3.4 kospi.html

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
    <h1>KOSPI 지수 보여주기</h1>
    <h2>{{kospi}}</h2>
</body>
</html>
```

#### 1.3.5 attempts.html 

```HTML
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>This is first step for full-stack</title>
        <style>
            .info{
                color:blue
            }
        </style>
        
    </head>
    
    <body>
        <h1 style="color:red; font-size=200%;">Infor about Movie Spider man new universe</h1>
        <iframe width="560" height="315" src="https://www.youtube.com/embed/vhkCBOsOoYY" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
        
        <h2 class="info">{{search_num}}</h2>
    </body>
</html>
```



## V 기타

1. Back to the basic: 공식문서 자주 보고 구현해보기~!
2. *Coursera, Edx*                         //     *cs50*
3. *udacity* _ Good good good. machine learning, and statistics @@!!!!!!!!!! Thumbs up.
4. W3School 참고

1. Visual Code에서 ctrl+/ 문서형식에 맡는 주석
2. Visual Code에서 !+tab -> 기본 코드 완성
3. html양식에서 태그형태+tab 자동 태그완성
4. jekyll, bootstrap templage, git page,css flex 참고

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
1. 기본 페이지 구성
2. ("/job") 사용자에게 랜덤으로 생성된 직업 추천해주는 웹페이지 구성 (python faker 모듈 사용)
3. 사용자가 같은 이름을 입력할 시에는 같은 직업을 추천하도록 구성
4. ("/dic") 저장된 목록을 볼 수 있도록 함

1. ("/compati") 사용자에게 본인의 이름과 상대방의 이름을 입력받는 웹페이지 구성
2. ("/match") 궁합을 퍼센트로 알려주고, 그 두 이름을 Pair로써 저장하기(외부 파일로)
3. ("/admin") 저장한 정보를 한번에 확인할 수 있도록 구성
