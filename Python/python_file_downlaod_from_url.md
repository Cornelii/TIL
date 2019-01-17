# Python file download from url

## 1. wget
```python
import wget

print('Beginning file download with wget module')

url = 'http://i3.ytimg.com/vi/J---aiyznGQ/mqdefault.jpg'  
wget.download(url, '/Users/scott/Downloads/cat4.jpg') 

```

## 2. requests.session()??!
```python
# import requests
  
# # 세션으로 get 요청을 보내면 다운로드 할 데이터가 반환된다. 
# res = requests.get(url)
# # 
# with open('./download_file.jpg', 'wb') as f:
#     f.write(res.content)

```

## 3. urlopen
```python
from urllib.request import urlopen

with urlopen(url) as res:
    res_data = res.read()

    with open('./download_file.jpg', 'wb') as f:
        f.write(res_data)


```