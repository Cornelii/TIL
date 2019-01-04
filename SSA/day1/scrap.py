# kospi 정보 스크랩
import webbrowser as wb
import requests as rq
import bs4 # python이 읽기 쉽도록 만들어 줌(HTML 등)
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