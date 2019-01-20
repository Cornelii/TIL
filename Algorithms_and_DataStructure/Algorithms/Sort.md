# Sort

make data in ascending or descending order

There are many kinds of sorting methods. For example,
1. Bubble Sort
2. Counting Sort
3. Selection Sort
4. Quick Sort
5. Insertion Sort
6. Merge Sort


## 1. Bubble Sort
1. keep comparing adjacent two components moving one by one.
2. After a comparison, bigger one to latter generally, smaller one to former.
3. It seems like bubble comes up as big values go back again and again.

O(n^2)

**Code in python**
```python

L=[6,7,1,2,8,4,42,97,50] #test list

 for i in range(len(L)-1):                
     for j in range(len(L)-1-i):       # two for-loops => O(n^2)
         if L[j]>L[j+1]:
             L[j],L[j+1]=L[j+1],L[j] # Swap
```
**Be careful the  IndexError (ArrayIndexOutofRange error)**



## 2. Counting Sort
1. First, count how many each components are in given data
2. put the counted value to the list, which is indexed by the very number.
ex) Counted_list[the number]=how many
3. get accumulrative list from the couted list that has the counted value.
4. Get number from pristine data one by one, and get a position from the accumulrative list refered by the number.
5. minus 1 itself
6. and put the number to the newly generated list in the index of the value that is substracted by 1 from accumulative list

O(n+k), where k is maximum integer.

This method can be applied to only the case that has only integer knowing the maximum value in the data.


**Code in python**
```python
L=[6,7,1,2,8,4,42,97,50] # test list
max_val=max(L)           # max_value should be known
C=[0]*(max_val+1)       
# including 0 it should be multiplied by max_val+1 to get maximum index of max_val

# making count_list
for num in L:
    C[num]+=1

Accumul_C=[0]*(max_val+1)
# get accumulative_list
dummy=C[0]
for idx,num in enumerate(C):
    if num!=0:
        Accumul_C[idx]=num+dummy
        dummy+=num

result=[0]*(max_val+1)
# get sorted result
for num in reversed(L):
    idx=Accumul_C[num]-1
    result[idx]=num

```
**Remarks**
By this rigorous?! index mapping. We can sure tha we sort value keeping its order even in the same number!


## 3. Selection Algorithm
algorithm to find k-th big or smal entry. so does minimum, maximum, or middle

PseudoCode
```PseudoCode
FUNCTION select(L:list,key:key value)
    FOR i 0-> key-1
        


```
