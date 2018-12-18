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