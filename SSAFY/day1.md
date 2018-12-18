



# Python Chatbot 1일차

1일차 키워드 기반 챗봇 만들기(파이썬) 

[챗봇 플랫폼_hphk](https://s1.py.hphk.io)

![](https://www.python.org/static/opengraph-icon-200x200.png)

## |. 기초 문법

### (1) 저장

#### 1.개념

 파이썬은 **Dynamic typing language** : 자료형 정의가 따로 필요 없음.

- 숫자
- 글자
- Boolean형
- list
- dictionary





#### 2.실습

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







# 개발 계명(Development Commandments)

### (1) Browser는 Chrome

### (2) 문서는 Markdown(.md)

### (3) 교과서는 공식문서 & 내가 정리한 마크다운이라 생각.

##### Markdown Syntax 정리(기초)

###### 1. Headers

'# (header1), ## (h2), ### (h3),...'

# h1

## h2

### h3



###### 2. Blockquotes

'> quotation1, >> quotation in quotation'

> quotation1
>
> > quotation in quotation



###### 3. Code Blocks

"~~~ or ```  "   

~~~python
def CodeBlocks_in_Python_style
~~~



###### 4. Inline Code Blocks

Statements between ``

`Inline Code Blocks`



###### 5. Emphasis

- italic

between '* or _'

*Italic*

_Italic_

* bold

between ' ** or __'

**bold**

__bold__



###### 6. Horizontal Line

'---'

---

'***'

***

'___'

___



###### 7. External Link

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



###### 8.Internal Link

`[링크](#id)`

[link](#id1)



###### 9. Lists

`number +. or *,+,-`



###### 10. Tables

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




###### 11. Images

`![text](image_addres,url...)`

`![Python_logo](https://www.python.org/static/opengraph-icon-200x200.png)`

![Python_logo](https://www.python.org/static/opengraph-icon-200x200.png)



##### 12. check box 

`- [x] (space bar)`

- [x] 1
- [ ] 2
- [ ] 3

- [x] 4



##### 13. emoji

`example :ribbon:`

:ribbon:

`check out url :https://github.com/ikatyang/emoji-cheat-sheet/blob/master/README.md `

[emoji_git](https://github.com/ikatyang/emoji-cheat-sheet/blob/master/README.md)


##### 14. Math

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

##### 15. Chemistry Expressions





##### Shortcuts
ctrl+/ : source code window mode




# Pythontutor

컴퓨터의 흐름을 알 수 있는 좋은 툴

[pythontutor](http://pythontutor.com/)

[pythontutor_edit](http://pythontutor.com/visualize.html#mode=edit)



# API

## Application Programmable Interface

서비스에 열려있는 통로를 프로그래밍적으로 연결하는 방식



# Web and Web API

## 웹의 이해

### Request and Response

#### `ex) URL_주소창(Request) & Json,XML,HTML.. (Response)`

URL을 통해 문서 한 장을 요청하게 되고, 문서 한 장을 받게 됨.

**Tip**: (data얻기 좋은 사이트) www.data.go.kr



# 개발환경 구성

#### 1. Typora_for_Markdown

#### 2. Git Bash (git for windows)

##### Git bash

pwd,ls,mkdir,rm. The commands of Git bash are like ones of Linux

#### 3. Visual Studio Code 



## 몸 풀기

### webbrowser

##### 1

~~~python
import webbrowser as wb
url="http://daum.net"
wb.open(url)
wb.open_new(url)
wb.open_new_tab(url)
~~~

##### 2

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

##### 3. Web 스크래핑

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



##### 4. file name change

os.chdir

os.listdir

os.rename

os.getcwd

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

