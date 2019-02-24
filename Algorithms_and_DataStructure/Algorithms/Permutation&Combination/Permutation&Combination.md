# Permutation
nPr

## 1. Basic permutation code in python for the {1,2,3}
```python

for a1 in range(1,4):
    for a2 in range(1,4):
        if a2!=a1:
            for a3 in range(1,4):
                if a3!=a1 and a3!=a2:
                    print(a1,a2,a3)
```
**It has for-repetition loops as many as components of given set.**
with if-statements to avoid the case repetitive components in the result.

Intuitive, but inefficient.


## 2. Heap's Algorithm Permutation

* This generates all possible permutation of a set in which it has `n` element.

* Suppose we should get a permutation of `n` different elements.

* It basically generate `(n-1)!` permutations. And, go further.

* Basic concept
    1. If n is odd, switch first and the last one.
    2. If n is even, swithch i th and last one.
    3. increase i th index by 1 and repeat.


### Recursive way

```pseudocode

PROCEDURE generate(n : integer, A : array of any):
    IF n == 1 TEHN
        RETURN A
    ELSE
        FOR i=0 -> N-1
            CALL generate(n-1, A)
            IF n IS EVEN THEN
                CALL swap(A[i],A[n-1])
            ELSE
                CALL swap(A[0],A[n-1])
            END IF
        END FOR
        generate(n-1,A)
    END IF
```
```python
# recursive way
def generate(n,A):
    if n==1:
        return A
    else:
        for idx in range(0,n-1):
            generate(n-1,A)
            if n%2:
                A[0],A[n-1]=A[n-1],A[0]
            else:
                A[idx],A[n-1]=A[n-1],A[idx]
        generate(n-1,A)
```

### Non-Recursive way

```pseudocode
PROCEDURE generate(n : integer, A : array of any):
    C = int array, same size with A, filled with 0

    RETURN A

    i = 0
    WHILE i < n
        IF C[i] < i THEN
            IF i is EVEN THEN
                CALL swap(A[0],A[i])
            ELSE
                CALL swap(A[C[i]],A[i])
            END IF
            RETURN A
            C[i] +=1
            i=0
        ELSE
            C[i]=0
            i+=1
        ENDIF
    ENDWHILE
```
```python
# non-recursive way
def generate(n,A):
    C=[0]*len(A)
    print(A)
    i=0
    while i < n:
        if C[i] < i:
            if i%2:
                A[C[i]],A[i]=A[i],A[C[i]]
            else:
                A[0],A[i]=A[i],A[0]
            print(A)
            C[i]+=1
            i=0
        else:
            C[i]=0
            i+=1
```

example)
>{1,2,3} initially
>n=3
>   321(1) -> 312(2) -> 213(3)

  >>321(1)
  >>n=2
  >>   123 -> 132

    >>> 123
    >>> n=1
     >>> return 123 !!!!!!!!!!!!!!!!!
       
     >>>    132
     >>>    n=1
     >>>   return 132 !!!!!!!!!!!!!!!!!

  >>312(2)
  >>n=2
  >>   213 -> 231

    >>>     213
    >>>     n=1
    >>>   return 213 !!!!!!!!!!!!!!!!!
       
    >>>     231
    >>>     n=1
    >>>   return 231 !!!!!!!!!!!!!!!!!

  >> 213(3)
  >>n=2
  >>   312 -> 321

    >>>     312
    >>>     n=1
    >>>   return 312 !!!!!!!!!!!!!!!!!
       
    >>>  321
    >>>     n=1
    >>>   return 321 !!!!!!!!!!!!!!!!!


## III. Back tracking

example
#### 1. nPn permutation

```python
def backtrack(a,k=-1,input_num=3):
    #### next candidate initializer
    c=[0]*(input_num)
    
    #### base
    if k == input_num-1:
        for i in range(k+1):
            print(f"{a[i]} ",end="")
        print()
    else:  #### next-state which towards base, and, recursion.
        k += 1
        C = new_candidate(a,k,input_num,c)
        for i in range(C):
            a[k] = c[i]
            backtrack(a,k,input_num)
            

def new_candidate(a, k, input_num, c):
    ####  
    in_perm = [False]*(input_num)
    
    for i in range(k):
        in_perm[a[i]] = True
        
    ncandidates = 0
    for i in range(input_num):
        if in_perm[i] == False:
            c[ncandidates] = i
            ncandidates += 1
    
    return ncandidates    

def nPn(n):
    backtrack([0]*10,-1,n)    

nPn(5)
```
#### 2. nPr permutation
```python
def backtrack(a,k=-1,input_num=3, depth=2):
    #### next candidate initializer
    c=[0]*(input_num)
    
    #### base
    if k == depth-1:
        for i in range(k+1):
            print(f"{a[i]} ",end="")
        print()
    else:  #### next-state which towards base, and, recursion.
        k += 1
        C = new_candidate(a,k,input_num,c)
        for i in range(C):
            a[k] = c[i]
            backtrack(a,k,input_num,depth)
            

def new_candidate(a, k, input_num, c):
    ####  
    in_perm = [False]*(input_num)
    
    for i in range(k):
        in_perm[a[i]] = True
        
    ncandidates = 0
    for i in range(input_num):
        if in_perm[i] == False:
            c[ncandidates] = i
            ncandidates += 1
    
    return ncandidates    

def nPr(n, r):
    backtrack([0]*10,-1,n,r)    

nPr(5,3)
```

#### 3. Repetitive nPr permutation
```python
def backtrack(a,k=-1,input_num=3, depth=2):
    #### next candidate initializer
    c=list(range(input_num))
    
    #### base
    if k == depth-1:
        for i in range(k+1):
            print(f"{a[i]} ",end="")
        print()
    else:  #### next-state which towards base, and, recursion.
        k += 1
        for i in range(input_num):
            a[k] = c[i]
            backtrack(a,k,input_num,depth)
            
def RnPr(n, r):
    backtrack([0]*10,-1,n,r)    

RnPr(5,3)
```
#### 4. PowerSet
```python
def backtrack(a,k=-1,input_num=3):
    #### next candidate initializer
    c=[0]*input_num
    
    #### base
    if k == input_num-1:
        for i in range(k+1):
            print(f"{a[i]} ",end="")
        print()
    
    else:  #### next-state which towards base, and, recursion.
        k += 1
        C = construct_candidates(a, k, input_num, c)
        for i in range(C):
            a[k] = c[i]
            backtrack(a,k,input_num)
            
            
def construct_candidates(a, k, input_num, c):
    c[0] = True
    c[1] = False
    return 2

a=[0]*10
backtrack(a,-1,3)
```

#### 5. nCr combination
```python
def backtrack(a,k=-1,input_num=3, depth=2):
    global cnt
    
    c = [0]*10
    #### base
    if k == depth-1:
        for i in range(k+1):
            print(f"{a[i]} ",end="")
        print()
        cnt += 1
    else:  #### next-state which towards base, and, recursion.
        k += 1
        C = new_candidate(a,k,input_num,c)
        for i in range(C):
            a[k] = c[i]
            backtrack(a,k,input_num,depth)
            

def new_candidate(a, k, input_num, c):
    ####  
    global in_perm
    
    for i in range(k):
        in_perm[a[i]] = True
        
    ncandidates = 0
    for i in range(input_num):
        if in_perm[i] == False:
            c[ncandidates] = i
            ncandidates += 1
    
    return ncandidates    

a = [0]*10
in_perm = [False]*(10)

def nCr(n, r):
    backtrack(a,-1,n,r)    

```

#### 6. Repetitive nHr permutation

```python
def backtrack(a, k, depth, start, num_input): # start
    
    if k == depth-1: ## base
        for i in range(depth):
            print(a[i], end=" ")
        print()
    else:
        k += 1
        for i in range(start,num_input): # start
            a[k] = i
            backtrack(a,k,depth,i,num_input)

def nHr(n,r):
    a =[0]*10
    backtrack(a,-1,r,0,n)
```