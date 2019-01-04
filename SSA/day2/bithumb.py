import requests as rq
from bs4 import BeautifulSoup as BS

target_url="https://www.bithumb.com/"
response=rq.get(target_url)

doc=BS(response.text,"html.parser")

coin_list=["#assetRealBTC","#assetRealXRP","#assetRealETH","#assetRealEOS","#assetRealXLM"]

with open('bithumb.txt','w') as f:
    for key in coin_list:
        rtv=doc.select(key)
        s="{}:  {}".format(key,rtv[0].text)
        print(s)
        f.write(s+'\n')

#lecturer

res=doc.select(".coin_list")
coin=[]
for coin in res:
    branch=coin.select('strong')
    for name in branch:
        coin.append(name.text)
coin_names=coin[::5]
#coin_value=coin[::5]
print(coin_names)
