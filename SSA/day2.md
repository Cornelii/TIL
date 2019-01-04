# Day2
## I 개념
### Git
git (분산) 버젼 관리 시스템 developed by Linus Torvalds
**Tip**: git linus torvalds google in youtube (clip)

버젼 관리 시스템의 필요성: 관리가 힘들다. 특히, 코드의 경우. 특히, 여러사람이 작업할 경우

여러 git 기반 시스템 git != github
1. Github
2. GitKraken
3. Gitlab
4. Bitbucket

Jira, Atlassian 참고


## II 실습
### 1. Git 활용
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

### 2. Web Scraping
#### 2.1
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
#### 2.2
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

3. **Slicing**: 글자 자르기

#### 2.3 naver 실시간 검색서 scraping
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
#### 2.4 Scraping from Naver mobile website
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
#### 2.5 Scrap from bithumb
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
#### 2.6 lottery number check
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


### 3. Massenger API -> *telegram* Good~~~!!!

telegram을 통해 chatbot만들기.

[telegram API](https://core.telegram.org/bots/api)

1. Web app으로 들어가서 bot father을 검색
2. /newbot을 통해 새로운 bot 생성.(tocken)을 받을 수 있음.
3. Web url을 통해 method  requests할 수 있음.
4. Python에서 Requests를 이용해서 봇 활용 가능.

|methods|description|
|-------|-------|
|getMe|Get user info|
|getUpdates|Get status of chat|
|sendMessage|Send message from bot|
#### 3.1 Telegram example
```python
#url=f"https://api.telegram.org/bot{}/getMe"

key="787362316:AAF5414FfY0MOKaxVxkkJ-_wKjDJXlCGbfg"

user_id="635296478"

# send message
#https://api.telegram.org/bot787362316:AAF5414FfY0MOKaxVxkkJ-_wKjDJXlCGbfg/sendMessage?chat_id=635296478&text=message_from_chatbot

# user Info
#https://api.telegram.org/bot787362316:AAF5414FfY0MOKaxVxkkJ-_wKjDJXlCGbfg/getMe

# status of chat 
#https://api.telegram.org/bot787362316:AAF5414FfY0MOKaxVxkkJ-_wKjDJXlCGbfg/getUpdates

import requests as rq
from bs4 import BeautifulSoup as BS
import time
msg=("Coin")

send_url=f"https://api.telegram.org/bot787362316:AAF5414FfY0MOKaxVxkkJ-_wKjDJXlCGbfg/sendMessage?chat_id={user_id}&text={msg}"

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
send_url=f"https://api.telegram.org/bot787362316:AAF5414FfY0MOKaxVxkkJ-_wKjDJXlCGbfg/sendMessage?chat_id={user_id}&text={msg}"
rq.get(send_url)
```

## III 기타

## HW
영화진흥위원회 API 데이터 뽑아내서 이것 저것 해보기.
IFTTT  참고
