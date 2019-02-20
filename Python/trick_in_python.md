# Trick in Python

#### 1. merge two dictionaries
```python
x = {'a': 1, 'b': 2}
y = {'b': 3, 'c': 4}
z = {**x, **y}
# When 'key' is overlapped, last key-value survives
# In above case, 'c' of y will survive

```

#### 2. Sort Python dict by value

```python
xs = {'a': 4, 'b': 3, 'c': 2, 'd': 1}
sorted(xs.items(), key=lambda x: x[1])
```

#### 3. multiple flag check
```python
x, y, z = 0, 1, 0

if x == 1 or y == 1 or z == 1:
    print('passed')

if 1 in (x, y, z):
    print('passed')

# These only test for truthiness:
if x or y or z:
    print('passed')

if any((x, y, z)):
    print('passed')
```