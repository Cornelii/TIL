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

## 2. Heap Permutation
