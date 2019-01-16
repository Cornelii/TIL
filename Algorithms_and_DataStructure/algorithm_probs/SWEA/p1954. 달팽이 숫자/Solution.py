"""
1954. 달팽이 숫자

달팽이는 1부터 N*N까지의 숫자가 시계방향으로 이루어져 있다.

다음과 같이 정수 N을 입력 받아 N크기의 달팽이를 출력하시오.


[예제]

N이 3일 경우,
 



N이 4일 경우,
 


[제약사항]

달팽이의 크기 N은 1 이상 10 이하의 정수이다. (1 ≤ N ≤ 10)


[입력]

가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.

각 테스트 케이스에는 N이 주어진다.


[출력]

각 줄은 '#t'로 시작하고, 다음 줄부터 빈칸을 사이에 두고 달팽이 숫자를 출력한다.

(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
입력
2    
3   
4             
 

출력
#1
1 2 3
8 9 4
7 6 5

#2
1 2 3 4
12 13 14 5
11 16 15 6
10 9 8 7
"""
import copy

T=int(input())

def line_processor(num):
    state1=[1,num]
    state=0
    result=[]
    a=[0]*num
    criterion=num**2

    for _ in range(num):
        result.append(copy.deepcopy(a))

    count=state1[0]
    #step1

    while state1[1]>=1:
        loc=state+state1[1]-1
        for nu in range(state1[1]):  ## 1st step
            result[state][state+nu]=str(count)
            count+=1
           
            if count>criterion:
                return result       

        for nu in range(1,state1[1]):  ## 2nd step
            result[state+nu][loc]=str(count)
            count+=1

            if count>criterion:
                return result  

        for nu in range(1,state1[1]):  ## 3rd step
            result[loc][loc-nu]=str(count)
            count+=1

            if count>criterion:
                return result 

        for nu in range(1,state1[1]-1): ## 4th step
            result[loc-nu][state]=str(count)
            count+=1

            if count>criterion:
                return result 
    

        state1=[count,state1[1]-2]
        state+=1

    return result



for case in range(1,T+1):
    num = int(input())
    result = line_processor(num)
    y=[]
    for row in result:
        y.append(" ".join(row))
    result2="\n".join(y)
    print("#{}\n{}".format(case,result2))
