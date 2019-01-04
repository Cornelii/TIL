# Agenda of this file
# 복잡하게 json파일이 풀려있을 때 쉽게 원하는 값을 얻을 수 있도록 하는 기능
    # 고려 상황
        # 1. json 파일에 여러개의 {}가 담길 수 있음.really?!
        # 2. list, tuple, str, dict의 중첩요소를 생각해야 함.
        # 3. dict의 경우 같은 이름의 키가 각각의 다른 dict에 존재 가능.
    # Abstraction
        # fcn1: json 파일을 str로 불러오기. 또는 불러와 있는 상태의 변수를 가져오기
        # fcn2: 접근하기 원하는 str을 받아오기
                # i. str의 정의가 유일하지 않거나, 명확하지 않을경우, str이 아닐 경우
        # fcn3: 경로명 생성 
            # wanted str 값의 위치 저장
            # wanted str에 가기까지 {,[,(의 갯수, 순서, 및 위치 저장
            # wanted str에 가기까지

import json
from pprint import pprint as pp
#Dictionary object for test
D={'a':1,'b':{'a':1,'b':2,'c':[{'a':1,'b':2,'c':3},2,'c']},'c':[1,2,3,'d']}

pp(D)

with open("test.json","w",encoding="utf-8") as f:
    a=json.dumps(D, indent=4)
    f.write(a)
#
s=""
# load json file as text 
with open("test.json","r",encoding="utf-8") as f:
    s=f.read()

print(s.count("{"),s.count("["))

