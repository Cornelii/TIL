#url=f"https://api.telegram.org/bot{}/getMe"

key="환경변수"

user_id="환경변수"



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