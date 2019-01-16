"""
p.1961. 숫자 배열 회전

N x N 행렬이 주어질 때,

시계 방향으로 90도, 180도, 270도 회전한 모양을 출력하라.


[제약 사항]

N은 3 이상 7 이하이다.

[입력]

가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.

각 테스트 케이스의 첫 번째 줄에 N이 주어지고,

다음 N 줄에는 N x N 행렬이 주어진다.

[출력]

출력의 첫 줄은 '#t'로 시작하고,

다음 N줄에 걸쳐서 90도, 180도, 270도 회전한 모양을 출력한다.

입력과는 달리 출력에서는 회전한 모양 사이에만 공백이 존재함에 유의하라.

(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
"""
import copy


def rotate90CW(A,N):
    B=copy.deepcopy(A)
    for idx1,row in enumerate(A):
        for idx2,entry in enumerate(row):
            B[idx2][N-1-idx1]=str(entry)
    return B

T=int(input())

def line_processor(line,N):
    A90=rotate90CW(line,N)
    A180=rotate90CW(A90,N)
    A270=rotate90CW(A180,N)

    for i9,i18,i27 in zip(A90,A180,A270):
        s="{} {} {}".format("".join(i9),"".join(i18),"".join(i27))
        print(s)
    return 0


for case in range(1,T+1):
    N=int(input())
    lines=[]
    for _ in range(N):
        lines.append(list(map(int,input().split())))
    print("#{}".format(case))
    result=line_processor(lines,N)

    

