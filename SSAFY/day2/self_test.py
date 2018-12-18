import requests as rq
from bs4 import BeautifulSoup as BS
import webbrowser as wb


resp=rq.get("https://www.naver.com")

# HTML source
resp_html=resp.text

# HTTP header 

resp_header=resp.headers

# HTTP Status

resp_status=resp.status_code

# HTTP operation boolean 
resp_ok=resp.ok


souped_resp=BS(resp_html,'html.parser')# python built-in html.parser
