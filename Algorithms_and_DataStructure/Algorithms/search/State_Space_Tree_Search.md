# State-Space Tree

It contains all the nodes on procedure to solve problem.



## I. BackTracking

Nothing but **DFS** with prunning.



This is usually not an efficient way.









## III. A* algorithm

This is commonly used to get shortest path in a graph



Dijkstra algorithm does not have objective point. There could be some wastes although we can set ending condition to that.



#### A* Algorithm = Best-first search + using estimate to its destination.



#### 1. Best-first search

Best-first search uses attractive function **g(x)** to choose which node is more attractive to search first

**A* uses g(x) and h(x)** h(x): estimated remaining distance.

**Remarks**: h(x) must be less than real minimal distance from static node x to the destination!







