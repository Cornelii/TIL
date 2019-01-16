"""
6720. 성수의 에너지 전송 프로세스

오랜 연구의 결실로 무선 에너지 전송 기술이 얼마 전에 실용화 되었다.

이 기술로 비용적인 문제로 에너지가 잘 공급되지 못 했던 지역에도 거리와 상관 없이 에너지를 공급해줄 수 있게 되었다.

이 기술은 에너지가 간섭되는 위상의 문제를 아직 완벽히 해결하지 못해서,

어떤 위치에 에너지기지를 설치하면 정확히 동, 서, 남, 북, 북동, 북서, 남동, 남서의 여덟 방향으로만 에너지를 전송할 수 있다.

에너지를 전송하는 중간에 다른 물체(예를 들어 다른 에너지기지)가 있어도 상관없이 에너지를 전송할 수 있다.

문제를 조금 편하게 하기 위해 x축 양의 방향이 동쪽, y축 양의 방향이 북쪽이 되도록 차원 평면에 세계를 나타내도록 하자.

에너지기지의 근본적인 한계로 인해, 에너지를 공급할 수 없는 지점이 있다.

예를 들어 (0,0) 에서 (2,6) 으로는 에너지를 보낼 수 없다.

그렇기 때문에 중계 기지를 더 설치하여 원하는 지점에 에너지를 보낼 수 있도록 하고 싶다.

예를 들어 (2,2) 에 기지를 하나 더 설치하면 (2,6)에 에너지를 보낼 수 있을 것이다.

성수는 에너지 회사의 엔지니어로, 어떤 고객이 있는 장소에 에너지기지를 설치해 주어야 한다.

이미 설치된 2개의 에너지 기지가 있고, 이 둘은 안정적으로 에너지를 공급받고 있기 때문에 에너지가 끊길 걱정이 없다.

그러나 새로운 에너지기지를 설치하면 안정적으로 에너지를 공급해줄 수 없기 때문에,

에너지가 끊어지는 문제를 피하기 위해 이미 설치된 2개 이상의 에너지 기지에서

에너지를 공급받을 수 있는 위치에만 새로운 에너지기지를 설치해야 한다.

성수를 도와 최소 몇 개의 에너지기지를 더 설치해야

고객이 원하는 위치에 에너지기지가 설치되는지 구하는 프로그램을 작성하라.


[입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 여섯 개의 정수 x1, y1, x2, y2, X, Y 가 주어진다.

이는 이미 설치된 두 에너지기지의 좌표가 (x1,y1), (x2,y2) 이고,

고객이 원하는 에너지기지의 좌표가 (X,Y) 임을 나타낸다.

모든 좌표 값은 -109이상 109이하의 값이며, 이미 설치된 두 에너지기지의 위치는 다르다

 

[출력]
 

각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고 한 칸을 띄운 후, 

최소 몇 개의 에너지기지를 더 설치해야 하는지 출력한다.

입력
4
1 2 3 4 1 2
2 2 3 3 4 4
1 4 0 0 5 5
1 4 0 0 5 10 	

출력
#1 0
#2 1
#3 2
#4 3
"""
# all the 2d point are set on list [x,y]
# domain: points=> [dx,dy]
def scope_check(tx,ty,dx,dy):
    if tx==dx:
        return True
    elif ty==dy:
        return True
    elif abs(tx-dx)==abs(ty-dy):
        return True
    return False

def coincide_check(tx,ty,dx,dy):
    if (tx==dx) and (ty==dy):
        return True
    else:
        return False
# def point_generator(p1x,p1y,p2x,p2y):
#     new1=[p1x,p2y]
#     new2=[p1y,p2x]
#     b1=-p1x+p1y
#     b2=-p2x+p2y
#     a1=(b1-b2)/2
#     a2=(b1+b2)/2
#     new3=[a1,a2]
#     new4=[-a1,-a2]
#     return new1,new2,new3,new4

T=int(input())

def line_processor(line):
    num=list(map(int,line.split()))
    A=scope_check(num[4],num[5],num[0],num[1])
    B=scope_check(num[4],num[5],num[2],num[3])
    # 0case
    if coincide_check(num[4],num[5],num[0],num[1]) or coincide_check(num[4],num[5],num[2],num[3]):
        return 0
    elif A and B:
        return 1
    elif A or B:
        return 2
    else:
        return 3

for case in range(1,T+1):
    line=input()
    result=line_processor(line)

    print("#{} {}".format(case,result))


