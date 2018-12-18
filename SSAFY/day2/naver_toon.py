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

