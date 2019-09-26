# Divide & Conquer algorithm

1. **Divide** problem to smaller one
2. **Conquer** the reduced each problems
3. **Combine** needed one to solve pristine problem

## Ex.1 Divide and Conquer-based exponentiation
### Intuitive exponentiation

```python
def power(base,exponent):
    if base == 0:
        return 1
    for i in range(exponent):
        result *= base
    return result

n times muliplication => O(n)
```
O(n)

### D & C applied exponentiation
```python
def power(base,exponent):
    if exponent == 0 or base == 0:
        return 1
    if exponent % 2 == 0:
        newbase = power(base, exponent/2)
        return newbase*newbase
    else:
        newbase = power(base,(exponent-1)/2)
        return (newbase*newbase)*base

O(log2n)
```
## Ex.2 Quick sort
```python
def quickSort(a,begin,end):
    if begin < end:
        p=partition(a,begin,end)
        quickSort(a,begin,p-1)
        quickSort(a,p+1,end)

# pivot algorithm
def partition(a,begin,end):
    pivot=(begin+end)//2
    L=begin
    R=end
    while L < R:
        while (a[L] < a[pivot] and L < R):
            L += 1
        while (a[R] >= a[pivot] and L < R):
            R -= 1
        if L < R:
            if L == pivot:
                pivot = R
            a[L], a[R] = a[R], a[L]
    a[pivot], a[R] = a[R], a[pivot]
    return R

```
Worst case O(n^2), but average O(n logn)

