import os
import requests as rq
from pprint import pprint as pp

# Agenda: send telegram message
## I. chat_id받아오기
### 1. 환경변수를 불러와서
### 2. id를 받아오기 위한 url 구성
### 3. getUpdates
### 4. chat_id 얻기

## II. message 보내기
### 1. message를 위한 url 구성 
### 2. send message 

token=os.getenv('TELEGRAM_TOKEN')

def getID(token):
    send_url=f"https://api.telegram.org/bot{token}/getUpdates"
    dum=rq.get(send_url)
    #pp(a.json()) # rq get객체의 json() =>json.loads()  json을 python dictionary로
    updates_dict=dum.json()
    chat_id=updates_dict["result"][0]["message"]["chat"]["id"]
    return chat_id

def sendMessage(token,chat_id,text):
    send_url=f"https://api.telegram.org/bot{token}/sendMessage?chat_id={chat_id}&text={text}"
    rq.get(send_url)
    return f"{text}를 {chat_id}님에게 보내었습니다."

class Message:
    def __init__(self,token,chat_id):
        self.token=token
        self.chat_id=chat_id

    def send(self,text):
        print(sendMessage(self.token,self.chat_id,text))
##
#f"{}"를 사용하면 그냥 문자열로 넣어주고 선언하는 역할-> 이 구문 이후론 그냥 str

chat_id=getID(token)
sendMessage(token,chat_id,"Hello~ How are you?")

M=Message(token,chat_id)
M.send("This came from Class")


a=input()
M.send(a)

