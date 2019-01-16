"""
4834. [파이썬 S/W 문제해결 기본] 1일차 - 숫자 카드

0에서 9까지 숫자가 적힌 N장의 카드가 주어진다.

가장 많은 카드에 적힌 숫자와 카드가 몇 장인지 출력하는 프로그램을 만드시오. 카드 장수가 같을 때는 적힌 숫자가 큰 쪽을 출력한다.


 

[입력]
 

첫 줄에 테스트 케이스 개수 T가 주어진다.  ( 1 ≤ T ≤ 50 )

다음 줄부터 테스트케이스의 첫 줄에 카드 장수 N이 주어진다. ( 5 ≤ N ≤ 100 )

다음 줄에 N개의 숫자 ai가 여백없이 주어진다. (0으로 시작할 수도 있다.)  ( 0 ≤ ai ≤ 9 ) 

 

[출력]
 

각 줄마다 "#T" (T는 테스트 케이스 번호)를 출력한 뒤, 가장 많은 카드의 숫자와 장 수를 차례로 출력한다.

입력
3
5
49679
5
08271
10
7797946543	 

출력
#1 9 2
#2 8 1
#3 7 3

"""
T=int(input())


def counting_sort(nums,N):
    C = [0]*10
    result = [0]*N
    for num in nums:
        C[num] += 1

    max_count = max(C)
    the_num = C.index(max_count)

    if C.count(max_count)>1:
        for idx,count in enumerate(C):
            if count==max_count:
                the_num=idx


    dum=0
    for i in range(10):
        if C[i]:
            C[i]+=dum
            dum=C[i]
        else:
            continue
 
    for num in nums:
        C[num]-=1
        idx=C[num]
        result[idx]=num

    return the_num,max_count


def line_processor(line,N):
    nums = list(map(int,line))
    the_num,max_count = counting_sort(nums,N)

    return the_num, max_count

for case in range(1,T+1):
    N = int(input())
    line = input()

    result = line_processor(line,N)
    print("#{} {} {}".format(case,result[0],result[1]))