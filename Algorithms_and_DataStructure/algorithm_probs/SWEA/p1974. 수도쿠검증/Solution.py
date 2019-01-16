"""
1974. 스도쿠 검증

스도쿠는 숫자퍼즐로, 가로 9칸 세로 9칸으로 이루어져 있는 표에 1 부터 9 까지의 숫자를 채워넣는 퍼즐이다.
 



같은 줄에 1 에서 9 까지의 숫자를 한번씩만 넣고, 3 x 3 크기의 작은 격자 또한, 1 에서 9 까지의 숫자가 겹치지 않아야 한다.
 


입력으로 9 X 9 크기의 스도쿠 퍼즐의 숫자들이 주어졌을 때, 위와 같이 겹치는 숫자가 없을 경우, 1을 정답으로 출력하고 그렇지 않을 경우 0 을 출력한다.


[제약 사항]

1. 퍼즐은 모두 숫자로 채워진 상태로 주어진다.

2. 입력으로 주어지는 퍼즐의 모든 숫자는 1 이상 9 이하의 정수이다.


[입력]

입력은 첫 줄에 총 테스트 케이스의 개수 T가 온다.

다음 줄부터 각 테스트 케이스가 주어진다.

테스트 케이스는 9 x 9 크기의 퍼즐의 데이터이다.


[출력]

테스트 케이스 t에 대한 결과는 “#t”을 찍고, 한 칸 띄고, 정답을 출력한다.

(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
입력
10
7 3 6 4 2 9 5 8 1
5 8 9 1 6 7 3 2 4
2 1 4 5 8 3 6 9 7
8 4 7 9 3 6 1 5 2
1 5 3 8 4 2 9 7 6
9 6 2 7 5 1 8 4 3
4 2 1 3 9 8 7 6 5
3 9 5 6 7 4 2 1 8
6 7 8 2 1 5 4 3 9
…
 
출력
#1 1
"""

T=int(input())

def row_sum(row_A):
    result=0
    for num in row_A:
        result+=num
    return result

def col_sum(A,col_idx):
    result=0
    for row in A:
        result+=row[col_idx]
    return result

def  rectangle_check(A):
    for row in range(0,9,3):
        for col in range(0,9,3):
            result=0
            for idx in range(3):
                result+=sum(A[row+idx][col:col+3])
            if  result!=45:
                return 0
    return 1

def case_processor(A):
    #row check
    for row in A:
        val=row_sum(row)
        if val!=45:
            return 0

    for idx in range(9):
        val=col_sum(A,idx)
        if val!=45:
            return 0

    result=rectangle_check(A)
        
    return result


for case in range(1,T+1):
    A=[]
    for _ in range(9):
       A.append(list(map(int,input().split()))) 

    result=case_processor(A)
    print("#{} {}".format(case,result))