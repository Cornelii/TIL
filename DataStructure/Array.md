# Array

## Zero. Algorithm?!
Methods in procedure to solve problems

**Express algorithms**
1. Pseudo Code
2. Flow chart

**Good algorithm**
1. Accuracy
2. Working Amount
3. Use of memory
4. Simplicity
5. Optimized

**Performance Measurement is neccesary**

**Time Complexity**
Big O notation!
O(1),O(logN),O(N),O(NlogN),O(N^2),O(2^N),(N!)

**Hand Coding**
Quite Good method

## I. Array
1. Many in one box

* Boundary Check
* Gravity Prob

* Exaustive Search
  * Brute-Force or Generate-and-test
  * take every cases


## II. Greedy Algorithm
1. narrow-perspective Method to get Optimized Solution.
2. Greedy neccesarily needs validation!
3. very Naive implementation
4. Larger First, next smaller

**Procedure of Greedy Algorithm**
1. get optimzied solution in the current state
2. If it does not work, choose next
3. If it work, check if it works in all the domain => Solution
4. If not, start from 1.

## III. Sort
make data, which has more than two, ascending or descending in order.
1. Bubble Sort      N**2
    * Comparing and Switching adjacent two entries from first to last
    * After 1step, Biggest entry go to the last
    * It's like bubble comes up on the surface of watter => bubble sort
    * Time complexity => O(N**2)

```python
def BubbleSort(a):
    for i in range(len(a)-1,0,-1):
        for ii in range(0,i):
            if a[ii]>a[ii+1]:
                a[ii],a[ii+1]=a[ii+1],a[ii]

```

2. Counting Sort
Count how many member each entry has (not for continous value, only discrete)
```python
def Counting_Sort(A,k)
#A[1***n] input array(1to k)
#B[1***n] Sorted Array
#C[1***k] count array
C=[0]*k
for i in range(0,len(A)):
    C[A[i]]+=1
for i in range(1,len(C)):
    C[i]+=C[i-1]

for i in range(len(A)-1,-1,-1):
    B[C[A[i]]-1]=A[i]
    C[A[i]]-=1
    # sort by order of coming out
```
3. Selection Sort   N**2

```python


```
4. Selection Sort
5. Quick Sort       NlogN
6. Insertion Sort
7. Merge Sort
   

