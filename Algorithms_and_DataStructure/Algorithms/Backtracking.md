# Back Tracking
1. When being blocked during finding solution.
2. Return and find again.
3. This is for Optimization and Decision problems.
**Decision problems:** Yes or no according to whther solution exists or not
like, n-Queen, Subset sum, Map coloring, Maze

It is like DFS. but difference as follows in table.
|backtracking|DFS|
|---|---|
|if it cannot turn out to be solution no more following -> prunning|Track all the path|
|early stop|for the N! almost impossible|
|for the N! maybe possible but difficult in time|screening every candidate|

* Backtracking come back to parent node ahead child node if some node is not promising.
**promising**: can a node be on the path to solution!
**Pruning**: no more search on non-promising node.

#### General procedure using backtracking algorithm
1. Make up state space tree
2. Check each node is promising or not
3. If a node is not promising, go back to parent and keep searching to another way


**self-realization**: When conducting backtracking, it is important to find pruning condition in the specific problem.