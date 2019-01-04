# 나눔로또 API통해 우승번호 가져오기
# random으로 생성된 번호와 비교해서 등수 정하기.
# 1등: 6개, 2등: 5개+1보너스, 3등: 5개, 4등: 4개, 5등: 3개 ?!
import random
import json
import requests as rq
import copy

# json file은 python의 dictionary와 같은데 단지 문서이다.
recom=random.sample(list(range(1,46)),6)

lotto_API_url="https://www.nlotto.co.kr/common.do?method=getLottoNumber&drwNo="

# 요청보내서 json읽어오기
info=rq.get(lotto_API_url+'837', verify=False)

# json-> python dict
dict_info=json.loads(info.text)
keys=["drwtNo1","drwtNo2","drwtNo3","drwtNo4","drwtNo5","drwtNo6","bnusNo"]
keys=[]
for jmi in range(6):
    keys.append("{}{}".format("drwtNo",jmi+1))
keys.append('bnusNo')
#### lecturer
# list.append(dict[f"~~~~{jmi}"])

# 당첨번호 리스트 구성
rwd_list=[]
for key in keys:
    rwd_list.append(dict_info[key])

# 일치하는 숫자 갯수
rwd_count=0
for num in recom:
    if (num in rwd_list[:-1]):
        rwd_count+=1
#### lecturer ##################################################
winner=copy.copy(rwd_list)
picked=copy.copy(sorted(recom))

S_winner=set(winner)
S_picked=set(picked)
matched=len(S_winner & S_picked)

################################################################
# 보너스 번호
if (rwd_list in recom):
    bonus=True
else:
    bonus=False

comment=0
if rwd_count==6:
    comment="1등"
elif rwd_count==5:
    if bonus:
        comment="2등"
    elif bonus:
        comment="3등"
elif rwd_count==4:
    comment="4등"
elif rwd_count==3:
    comment="5등"
else:
    comment="꽝"

print("당신의 번호는 {}입니다.".format(sorted(recom)))
print("당첨 번호는 {}입니다.".format(rwd_list[:-1]))
print("보너스 번호는 {}입니다.".format(rwd_list[-1]))
conum=rwd_count
if bonus: 
    conum=rwd_count+1 
print("일치하는 숫자는 {}입니다.".format(conum))
print("해당 결과는 {}입니다.".format(comment))

iter_num=100

iter_num=int(input("몇번 시뮬 돌려보실래유?!"))

def check(iter_num,rwd_list):
    count=[0,0,0,0,0]
    
    for jmi in range(iter_num):
        recom=random.sample(list(range(1,46)),6)
        rwd_count=0
        for num in recom:
            if (num in rwd_list[:-1]):
                rwd_count+=1
        
        # 보너스 번호
        if (rwd_list in recom):
            bonus=True
        else:
            bonus=False

        if rwd_count==6:
            count[0]+=1
        elif rwd_count==5:
            if bonus:
                count[1]+=1
            elif bonus:
                count[2]+=1
        elif rwd_count==4:
            count[3]+=1
        elif rwd_count==3:
            count[4]+=1
        else:
            pass
    return count

count=check(iter_num,rwd_list)

print("{}번 중에 {}이네 로또 하지마라 ㅋ".format(iter_num,count))