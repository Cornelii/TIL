import os
import requests as rq
from bs4 import BeautifulSoup as bs
from datetime import datetime as dt
from pprint import pprint as pp

token=os.getenv("TELEGRAM_TOKEN")

def getID(token):
    send_url=f"https://api.telegram.org/bot{token}/getUpdates"
    dum=rq.get(send_url)
    #pp(a.json()) # rq get객체의 json() =>json.loads()  json을 python dictionary로
    updates_dict=dum.json()
    chat_id=updates_dict["result"][0]["message"]["chat"]["id"]
    return chat_id

def sendMessage(token,chat_id,text,response=False):
    send_url=f"https://api.telegram.org/bot{token}/sendMessage?chat_id={chat_id}&text={text}"
    rq.get(send_url)
    if response==True:
        return f"{text}를 {chat_id}님에게 보내었습니다."

## 이시각 주요뉴스 시간과 함께 주요메일 보내주기.
naver_news_url="https://news.naver.com/"

naver_news_html=rq.get(naver_news_url)
naver_news_doc=bs(naver_news_html.text,"html.parser")

a=naver_news_doc.select(".newsnow_tx_inner")
ab=dt.now()
#a.year,a.month,a.day,a.hour,a.minute,a.second

for jmi in a:
    print(jmi.text)
