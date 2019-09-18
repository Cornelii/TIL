# Graph & Tree

## 1. LCA(Least Common Ancestor)

#### i. LCA itself
DP is used to reduce jump iteration

#### ii. LCA + Spanning Tree
When adding a edge to spanning tree, there must be a cycle in it.

The cycle is composed edges to the minimum common ancestor from two selected edges.

If getting rid of one edge from the cycle, the graph becomes spanning tree again.


## 2. Graph

#### i. Shortest Path
Dijkstra, Bellman-Ford, Floyd-Warshall

#### ii. Kth shortest Path
Dijkstra + DP
distance[] => distance[][K];

#### iii. Negative Cycle
Bellman-Ford
1 edges-update again after V-1 edges-update.

#### iv. Networking flow
Min-cut Max-flow
repetitive dfs or bfs
(reverse flow consideration keeping changing connection info of graph)

#### v. Cut node

#### vi. Cut edge

#### v. Topological Sorting

