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

