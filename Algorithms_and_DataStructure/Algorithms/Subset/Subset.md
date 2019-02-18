# SubSet
$2^n$ subsets exist including empty set.

## I. Basic Methods
Pseudo code
``` pseudo code
mask=[0,0,0,0] //n=4

FOR i 0 -> 1 
    mask[0] = i
    FOR ii 0 -> 1
        mask[1] = ii
        FOR iii 0 -> 1 
            mask[2] = iii
            FOR iv 0 -> 1
                mask[3] = iv
                PRINT mask
            ENDFOR
        ENDFOR
    ENDFOR
ENDFOR
```
considering all the case whether the element exists or not by mask.
Inefficient!

## II. Subset by BIT operator
&,|,<<, >>
1. the number of case of all the subsets : $1 << n :  2^n$
2. returning at i th case, Is j bit 1 or not : i & (1<< j ): 1

**Tips** 1<<N means, dd N zeros to the right of $1_{(2)}$

Pseudo code
```pseudo code
A=[3,6,7,1,5,4]
N=len(A)

FOR i 0-> (1<<N) -1
    FOR j 0-> N-1
        IF i & (1 << j) THEN
            PRINT(A[j]) KEEPING LINE
        ENDIF
    ENDFOR
    PRINT("")
ENDFOR
```
**python code**
```python
A=[3,6,7,1,5,4]
N=len(A)

for i in range(1<<N):
    for j in range(N):
        if i & (1<<j): ### If only one coincides, it return True!!
            print(A[j],end=",")
    print()
```
> At i, We can think number is in the form of binary number. => exist elements are represented 1, others as 0
> And, 1<< j, as j increase one by one, They are located at the same position that mean  the very point of existing!


## III. Powerset by Backtrack

```python
cnt = 0
A=[0,1,4,8,64,5,3,2,8,31,10]
a=[0]*11
def backtrack(a, k, num_input):
    global cnt
    global A
    c = [0] * 11
    
    if k == num_input:
        for i in range(k+1):
            if a[i]:
                print(f"{A[i]} ", end="")
        print()
        cnt += 1
    else:
        k += 1
        ncandidates = construct_candidates(a, k, num_input, c)
        for i in range(ncandidates):
            a[k] = c[i]
            backtrack(a,k,num_input)
            
def construct_candidates(a, k, num_input, c):
    c[0] = True
    c[1] = False
    return 2 

backtrack(a,0,10)
```

