# Tree
* 1: n relationship between element.
* Hierarchical structure
* 

## Components
* **Node**
  * **Root**: start of Tree
  * **Sibling**: in the same height (level).
  * **Ancestor**: nodes where bump into from a node to Root along with edge
  * **SubTree**: generated tree when spliting edge
  * **Descendent**: all nodes under a node, stretched out from the root of subTree.'
  * **Degree**: number of directly linked leaves
  * **Degree of a Tree**: degrees of nodes in the Tree, the largest value.
  * **leaf node**: nodes where degree is zero, and no have child.
  * **Height of a node (level)**: number of edges required to reach from root to the node.
  * **Height of a Tree**: largest height of nodes within the Tree
* **Edge**



## Binary Tree
* All nodes have two subTrees
* All nodes have two children node in maximum

* maximum number of sibiling nodes in level i => $2^i$
* binary tree, which have height h, can have (h+1) nodes at least and ($2^{h+1}-1$) at most.

### Kinds of binary tree
1. Full binary Tree
   Tree in which number of nodes is $2^{h+1}-1$

2. Complete binary Tree
    Tree in which number of nodes *n* is between $s^h <= n <= s^{h+1}-1$, and no empty room from node number 1 to n in terms of number order of full binary tree.

3. Skewed binary Tree


### Traversal
Visit all nodes in Tree without repetition.
    **( V: root node, L: left descendent, R: right descendent)**
    * Preorder traversal: VLR 
example python code
```python
def preorder_traverse(T):
    if T: # root of subTree value is not None.
        visit(T)
        preorder_traverse(T.left)
        preorder_traverse(T.right)
```
    * Inorder traversal: LVR
example python code
```python
def inorder_traverse(T):
    if T:
        inorder_traverse(T.left)
        visit(T)
        inodrder_traverse(T.right)
```
    * Postorder traversal: LRV
example python code
```python
def postorder_traverse(T):
    if T:
        postorder_traverse(T.left)
        postorder_traverse(T.right)
        visit(T)
```

### Binary Tree by List
#### numbering each nodes
root node = 1
nodes at level *n*: from left to right from $2n$ to $2^{n+1}-1$

**Node number property is specified according to numbering system.**
In this case, node number i 's parent node=> i//2
left child of i th node: 2*i
right child of i th node: 2*i+1
**Remarks** This is for complete binary tree!


#### shortcoming of implementation by List.
1. Waste of uncharged memory : solution - use of linked list
2. Since binary list has two degreee, a node of linked list, which has two link to left and right, can make binary Tree


## Binary Search Tree
It's an efficient data structure to do search work.
When it comes to key?!  left key < root key < right key  in amount.

inorder_travserse of binary search tree gives ascending-order sorted keys.

### Searching Operation.
1. start from root
2. comparing the desired key with key of root node
3. If found, succeed. if less go to left subtree, if more go to right subtree, and iterate from 1.



