# Search Algorithms

1. Sequential Search
2. Binary Search
3. Indexing


## 1. Sequential Search
1. check one by one in order
2. If key is found, stop and return index
3. If not found, return searching failure

PseudoCode
```PseudoCode
FUNCTION sequential_search(A:Array,key:key value)
    FOR i =0 -> len(A)-1 
        IF A[i]==key THEN
            RETURN i
        ENDIF
    ENDFOR
    RETURN false
```
time complexity: O(n)


## 2. Sequential Search at the sorted state
1.  Guess Ascending order, just the same as non-sorted case but,
2.  If we start to find value bigger than key. Stop and return searching failue

PseudoCode
```PseudoCode
FUNCTION sorted_sequential_search(A:Array,key: key value)
    i=0
    WHILE i < len(A) and A[i] < key
        i = i+1
        IF A[i]==key THEN
            RETURN i
        ENDIF
    ENDWHILE
    RETURN false
```
time complexity: O(n)

## 3. Binary Search
**This is Available for only sorted case.**
1. Efficient than Sequential Search at the sorted state
2. Compare key with value in the middle
3. if less, middle in the former half. if more, middle in the latter half
(It is nothing but bisection method?!)

PseudoCode
```PseudoCode
FUNCTION binary_search(A:Array,key:key value)
    lower_bound=0
    upper_bound=len(A)-1
    
    WHILE upper_bound == lower_bound
        i = (upper_bound-lower_bound) // 2 #quotient
        IF A[i]==key THEN
            RETURN i
        ELSEIF A[i] > key THEN
            lower_bound = i+1
        ELSE
            upper_bound = i-1
        
    RETURN false 
```

### Binary Searching in Recursive way
PseudoCode
```PseudoCode
FUNCTION binary_search_recursive(A, key,low,high)
    IF low > high THEN
        RETURN false
    ELSE
        middle=(low + high) // 2 #quotient
    ENDIF
    IF key == A[middle] THEN
        RETURN true
    ELSEIF key < A[middle] THEN
        RETURN binary_search_recursive(A,key,low,middle-1)
    ELSEIF key > A[middle] THEN
        RETURN binary_search_recursive(A,key,middle+1,high)

```

## 4. Indexing
This is stem from Database
Use of index by List
























## Exhaustive Search a.k.a (Brute-Force or Generate-and-Test)
* Simply do test every cases to solve problem
* Useful, generally, when the number of cases is small
* It has disadvantages in speed, but it may definitely go through every cases. 


