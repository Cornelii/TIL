# Sort

make data in ascending or descending order

There are many kinds of sorting methods. For example,
1. Bubble Sort
2. Counting Sort
3. Selection Sort
4. Quick Sort
5. Insertion Sort
6. Merge Sort


## I. Bubble Sort
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



## II. Counting Sort
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


## III. Selection Algorithm
algorithm to find k-th big or smal entry. so does minimum, maximum, or middle

PseudoCode
```PseudoCode
FUNCTION select(L:list,key:key value)
    FOR i 0-> key-1
        


```


## IV. Merge Sort

Divide & Conquer.
divide them to each peace.
and, Again, Merging with sorting~!

* At merging step.

From the first element in both (the smallest in each piece), compare left piece and right piece elementwisely. 
1. smaller one in left. => go first
2. left one go next until finding smaller one in right. 


Merge sort has the identical time complexity in best, worst, and average cases.
$O(N*log(N))$

**Timsort** => Presort, then sort! and it takes O(N) time.


```python
def merge_sort(items):
  if len(items) <= 1:
    return items

  middle_index = len(items) // 2
  left_split = items[:middle_index]
  right_split = items[middle_index:]

  left_sorted = merge_sort(left_split)
  right_sorted = merge_sort(right_split)

  return merge(left_sorted, right_sorted)

def merge(left, right):
  result = []

  while (left and right):
    if left[0] < right[0]:
      result.append(left[0])
      left.pop(0)
    else:
      result.append(right[0])
      right.pop(0)

  if left:
    result += left
  if right:
    result += right

  return result
```

## V. Quick Sort
This also a type of Divide-and-Conquer.

Partitioning to three groups
1. A sub-array of elements <span style="color:red">smaller than</span> the pivot
2. The pivot itself
3. A sub-array of elements <span style="color:red">greater than</span> the pivot


time complexity
bast case: $O(N^2)$
worst case: $ O(N*log(N)) $ 

* Worst case: pick the pivot as the extreme value.
* To alleviate effects of worst case:
    1. Random pivot selection
    2. Median pivot selection, etc

Sub arrays are recombined. Or, swap is performed in original array (mutable way)

```python
from random import randrange, shuffle 


def quicksort(list, start, end):
  # this portion of listay has been sorted
  if start >= end:
    return

  # select random element to be pivot
  pivot_idx = randrange(start, end + 1)
  pivot_element = list[pivot_idx]

  # swap random element with last element in sub-listay
  list[end], list[pivot_idx] = list[pivot_idx], list[end]

  # tracks all elements which should be to left (lesser than) pivot
  less_than_pointer = start
  
  for i in range(start, end):
    # we found an element out of place
    if list[i] < pivot_element:
      # swap element to the right-most portion of lesser elements
      list[i], list[less_than_pointer] = list[less_than_pointer], list[i]
      # tally that we have one more lesser element
      less_than_pointer += 1
  # move pivot element to the right-most portion of lesser elements
  list[end], list[less_than_pointer] = list[less_than_pointer], list[end]
  
  # Call quicksort on the "left" and "right" sub-lists
  left = quicksort(list, start, less_than_pointer-1)
  right = quicksort(list, less_than_pointer+1, end)
  

unsorted_list = [3,7,12,24,36,42]
shuffle(unsorted_list)
print(unsorted_list)
# use quicksort to sort the list, then print it out!
quicksort(unsorted_list,0,len(unsorted_list)-1)
print(unsorted_list)

```

procedure of above code.
1. Mutable in-place method using pointers.
2. base case => when len of array, which is indexed by start and end, is less than one.
3. random pivot selection followed by swapping with element at end.
4. assign start to the lesser_than_pointer. 
5. then iteratively increasing start checking the element at the pointer is smaller than pivot. if so, swapping to the one at lesser_than_pointer. And, increment of lesser_than_pointer.
6. After all search from start to end-1 (pivot in end), swapping the pivot in end and element located at lesser_than_pointer => divided three array=> recursive call of quicksort function for each sub array excluding pivot.

#### 2. Hoare Partition Algorithm

#### 3. Lomuto Partition Algorithm


## VI. Radix Sort

radix => number of alphabet in numbering system.
ex) radix of binary number system: 2 (0 and 1)

* Sorting by Radix
There are two kinds of radix sort generally.
1. Least significant digit (LSD)
2. Most significant digit (MSD)

example LSD
126 133 25 35 23

> 3bucket: (133, 23),  5bucket: (25, 35),   6bucket: (126)
> 2bucket: (23, 25, 126), 3bucket: (133,35)
> 0bucket: (23, 25, 35), 1bucket: (126, 133)
 **Remakrs** Radix sort is noncomparising sort.

 time complexity: O(wn)
 where w = average number of characters of numbers.

 if n >> w => O(n)


For implementation of radix sort, modular arithmetic is useful.

```python

def radix_sort(to_be_sorted):
  maximum_value = max(to_be_sorted)
  max_exponent = len(str(maximum_value))
  being_sorted = to_be_sorted[:]

  for exponent in range(max_exponent):
    position = exponent + 1
    index = -position

    digits = [[] for i in range(10)]

    for number in being_sorted:
      number_as_a_string = str(number)
      try:
        digit = number_as_a_string[index]
        digit = int(digit)
      except IndexError:
        digit = 0

      digits[digit].append(number)

    being_sorted = []
    for numeral in digits:
      being_sorted.extend(numeral)

  return being_sorted

unsorted_list = [830, 921, 163, 373, 961, 559, 89, 199, 535, 959, 40, 641, 355, 689, 621, 183, 182, 524, 1]
a=radix_sort(unsorted_list)
print(a)

```

## VII. Insert Sort

This is like enqueue procedure in priority Queue.