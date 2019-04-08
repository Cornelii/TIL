# heapq

heapq is a built-in module of python



heapq is an implementation of priority queue or heap.



This is useful especially in implementing Dijkstra, Prim, Kruskal, and so on.



## 1. Use of heapq

heapq is used with list.

```python
import heapq as hq

heap = []  # empty list

hq.heappush(heap, 5)
hq.heappush(heap, 2)
hq.heappush(heap, 4)

w = hq.heappop(heap)
# 2
```

