"""
6693. 수환이의 궁금증 

수학을 좋아하는 수환이는 갑자기 궁금증이 생겼다!

이상 이하의 모든 정수에 대해 정수 가 나오는 횟수가 무엇일까?’

예를 들어 333에 33은 두 번, 334에 33은 한 번 나오는 것이다. 그러므로 일 때 답은 3이다.

수환이의 궁금증을 해결해 줄 수 있는 프로그램을 작성해보자.


[입력]

첫 번째 줄에 테스트 케이스의 수 가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 세 정수 이 공백으로 구분되어 주어진다.

모든 정수의 앞에는 그 정수를 나타내는 데 필요 없는 0이 붙지 않는다.


[출력]

각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고 한 칸을 띄운 후,

A이상 B이하의 모든 정수에 대해 정수 C가 나오는 횟수를 출력한다.

이 수는 매우 클 수 있으므로, 로 나눈 나머지를 출력해야 한다.

입력
2
333 334 33
0 10 0	

출력
#1 3
#2 2	
"""

A=1546156
B=5263

def solve(A,C):
    N=len(A)
    M=len(C)
    flag=0
    for idx,char in enumerate(C):
        if int(char)>int(A[idx]):
            flag=0
            break
        elif int(char)<int(A[idx]):
            flag=1
            break
        else: pass
    if N==M and A==C:
        return 1
    elif A[M]==C[-1]:
        return ((int(A[0])*(N-M)+10)*pow(10,N-M-1)+int(A[M:]))%1000000007
        


        return int(A[0])*(N-M)*pow(10,N-M-1)%1000000007+1
    if flag:
        return (int(A[0])*(N-M)+10)*pow(10,N-M-1)%1000000007
    else:
        return int(A[0])*(N-M)*pow(10,N-M-1)%1000000007


def line_processor(A,B,C):
    L=solve(B,C)
    print(L)
    M=solve(A,C)
    print(M)
    return (L-M)

    
T=int(input())

for case in range(1,T+1):
    line=input()
    A,B,C=line.split()
    result=line_processor(A,B,C)
    print("#{} {}".format(case,result))


