"""
2056. 연월일 달력


연월일 순으로 구성된 8자리의 날짜가 입력으로 주어진다.
 



해당 날짜의 유효성을 판단한 후, 날짜가 유효하다면

[그림1] 과 같이 ”YYYY/MM/DD”형식으로 출력하고,

날짜가 유효하지 않을 경우, -1 을 출력하는 프로그램을 작성하라.


연월일로 구성된 입력에서 월은 1~12 사이 값을 가져야 하며

일은 [표1] 과 같이, 1일 ~ 각각의 달에 해당하는 날짜까지의 값을 가질 수 있다.
 


※ 2월의 경우, 28일인 경우만 고려한다. (윤년은 고려하지 않는다.)


[입력]

입력은 첫 줄에 총 테스트 케이스의 개수 T가 온다.

다음 줄부터 각 테스트 케이스가 주어진다.


[출력]

테스트 케이스 t에 대한 결과는 “#t”을 찍고, 한 칸 띄고, 정답을 출력한다.

(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
입력
5
22220228
20150002
01010101
20140230
11111111
 

출력
#1 2222/02/28
#2 -1
#3 0101/01/01
#4 -1
#5 1111/11/11
"""
T=int(input())
month_list=[31,28,31,30,31,30,31,31,30,31,30,31]

def line_processor(word):
    word=[word[:4]]+[word[4:6]]+[word[6:8]]
    pword=list(map(int,word))
    if pword[1]>12 or pword[1]<1:
        return str(-1)
    elif pword[2]>month_list[pword[1]-1] or pword[2]<1:
        return str(-1)
    else:
        return "{:04d}/".format(pword[0])+"{:02d}/".format(pword[1])+"{:02d}".format(pword[2])

for jmi in range(1,T+1):
    word=input()
    line=line_processor(word)
    print("#{} {}".format(jmi,line))