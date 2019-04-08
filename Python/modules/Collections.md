# Collections module

Collections is built-in module in python



## 1. deque

deque is a doubly linked list. For the task using many times of append and pop of list, deque is a one of good choices.



This is also useful for the implementation queue or stack as well.

print(cnt['c']) #  default 

```python
from collections import deque


# For the queue
q = deque()

q.append(6)
q.extend([7,2,6,8])

example_deque_to_list = list(q)

w = q.popleft() # pop from left

# For the stack
stack = deque()

stack.append(6)
stack.extend([7,2,6,8])

w = stack.pop() # pop from right

# other methods deque has
len(q)
b=q*3 #  this is like concatenation of itself by multiplication like list and string
q.appendleft(5)  # append to left
q.extendleft([5,2,77])  #  extend to left
q.rotate()  # reverse  (This method changes itself.)
q.rotate(3)  # this is like rotational(circular) reordering from entry at index 3

```



## 2. Counter

Counter is a subset object of dict.

hashable.



```python
from collections import Counter

cnt = Counter()
cnt['a'] = 5  
cnt['b'] = 7

print(cnt)
print(cnt['c']) #  default 0
cnt.pop('a')

# other methods of counter
cnt.elements()  # this return list with string as many as its counting per each keys.
```



## 3. defaultdict



## 4.namedtuple()

