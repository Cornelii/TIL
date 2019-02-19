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
```python
def backtrack(a,k,input_num):
    #### next candidate initializer
    c=[0]*(input_num+1)
    
    #### base
    if k == input_num:
        for i in range(1,k+1):
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
    in_perm = [False]*(input_num+5)
    
    for i in range(1,k):
        in_perm[a[i]] = True
        
    ncandidates = 0
    for i in range(1, input_num+1):
        if in_perm[i] == False:
            c[ncandidates] = i
            ncandidates += 1
    
    return ncandidates    

def nPn(n):
    backtrack(list(range(n+1)),0,n)    

# Generating 1-n permuation.
```