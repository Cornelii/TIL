# Tree
* 1: n relationship between element.
* Hierarchical structure
* 

## I. Components
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



## II. Binary Tree
* All nodes have two subTrees
* All nodes have two children node in maximum

* maximum number of sibiling nodes in level i => $2^i$
* binary tree, which have height h, can have (h+1) nodes at least and ($2^{h+1}-1$) at most.

It's an efficient data structure to do search work.
When it comes to key?!  left key < root key < right key  in amount.

inorder_travserse of binary search tree gives ascending-order sorted keys.


#### Kinds of binary tree
1. Full binary Tree
   Tree in which number of nodes is $2^{h+1}-1$

2. Complete binary Tree
    Tree in which number of nodes *n* is between $s^h <= n <= s^{h+1}-1$, and no empty room from node number 1 to n in terms of number order of full binary tree.

3. Skewed binary Tree


#### Traversal
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

#### Binary Tree by List
##### numbering each nodes
root node = 1
nodes at level *n*: from left to right from $2n$ to $2^{n+1}-1$

**Node number property is specified according to numbering system.**
In this case, node number i 's parent node=> i//2
left child of i th node: 2*i
right child of i th node: 2*i+1
**Remarks** This is for complete binary tree!


##### shortcoming of implementation by List.
1. Waste of uncharged memory : solution - use of linked list
2. Since binary list has two degreee, a node of linked list, which has two link to left and right, can make binary Tree


##### Searching Operation.
1. start from root
2. comparing the desired key with key of root node
3. If found, succeed. if less go to left subtree, if more go to right subtree, and iterate from 1.


## III. Tree Abstract Data Type (Abstract Base Class)

T.root() : Return position of the root of tree T, or None if T is empty

T.is_root(p) : Return True if p is the root of T

T.parent(p) : Return the position of parent of p, or none if p is the root.

T.num_children(p) : Return the number of children of position p

T.children(p) : Genrete an iteration of the children of p

T.is_leaf(p) : Return True if position p does not have any children

len(T) : Return the number of nodes

iter(T): Gernerate an iteration of all elements within T

```python
class Tree:
    
    # ------------------------------------------------------- Nested Class
    class Position:
        ''' Abstraction representing the location of a single element.'''
        def element(self):
            ''' Return the element stored at this Position.'''
            raise NotImplementedError('must be implemented by subclass')
            
        def __eq__(self,other):
            '''Return True if other Position represents the same location'''
            raise NotImplementedError('must be implemented by subclass')
            
        def __ne__(self,other):
            '''Return True if other does not represent the same location'''
            return not (self == other)
    # ---------------- abstract methods that concrete subclass must support
    def root(self):
        '''Return Position representing the tree's root (or None if empty)'''
        raise NotImplementedError('must be implemented by subclass')
        
    def parent(self,p):
        '''Return Position representing p's parent (or None if p is root)'''
        raise NotImplementedError('must be implemented by subclass')
        
    def num_children(self,p):
        '''Return the number of children that p has'''
        raise NotImplementedError('must be implemented by subclass')
        
    def children(self,p):
        '''Generate an iteration of p representing children of p'''
        raise NotImplementedError('must be implemented by subclass')
        
    def __len__(self):
        '''Return the totla number of elements in the tree'''
        raise NotImplementedError('must be implemented by subclass')
        
    def is_root(self,p):
        '''Return True if p represents the root of the tree'''
        return self.root() == p
    
    def is_leaf(self,p):
        '''Return True if p does not have any children'''
        return self.num_children(p) == 0
    
    def is_empty(self):
        '''Return True if the tree is empty'''
        return len(self) == 0      
        
    def depth(self, p):
        '''Return the number of levels separating position p from the root'''
        if self.is_root(p):
            return 0
        else:
            return 1 + self.depth(self.parent(p))
        
    def _height2(self, p):
        if self.is_leaf(p):
            return 0
        else:
            return 1 + max(self._height2(c) for c in self.children(p))
        
    def height(self,p=None):
        if p is None:
            p = self.root()
        return self._height2(p)      
```


### My own Binary Tree (on going)

```python
class Node:
    def __init__(self, val=None):
        self.__val = val
        self.next = None
        self.prior = None
        
    def get_val(self):
        return self.__val
    
    def set_val(self, val):
        self.__val = val
        
class Queue:
    def __init__(self, val = None):
        self.head = Node(val)
        self.tail = self.head
        self.count = 0
        
    def enqueue(self, *args):
        
        for val in args:
            self.tail.next = Node(val)
            self.tail = self.tail.next
            self.count += 1
        
    def dequeue(self):
        if self.is_empty():
            print("Queue is empty!")
            return
        else:
            tmp_val = self.head.next.get_val()
            self.head = self.head.next
            self.count -= 1
        
        return tmp_val
    
    def is_empty(self):
        return self.count == 0

class Stack:
    def __init__(self, val = None):
        self.top = Node(val)
        self.count = 0
        
    def push(self, *args):
        
        for val in args:
            tmp = self.top
            self.top = Node(val)
            if self.count:
                self.top.prior = tmp
            self.count += 1
    
    def pop(self):
        if self.is_empty():
            print("Stack is empty!")
        else:
            tmp_val = self.top.get_val()
            self.top = self.top.prior
            self.count -= 1
            
            return tmp_val
    
    def peek(self):
        return self.top.get_val()
    
    def is_empty(self):
        return self.count == 0


class TreeNode:
    def __init__(self, val=None):
        self.__val = val
        self.__parent = None
        self.__left = None
        self.__right = None
        
    def get_val(self):
        return self.__val
    
    def set_val(self, val):
        self.__val = val
    
    def get_left(self):
        return self.__left
    
    def set_left(self, left):
        self.__left = left
    
    def get_right(self):
        return self.__right
    
    def set_right(self, right):
        self.__right = right
    
    def get_parent(self):
        return self.__parent
    
    def get_child(self):
        return self.__left, self.__right
    

class BinaryTree(TreeNode):
    def __init__(self):
        self.root = TreeNode()
        self.point = self.root
        self.count = 0
        
    def init_data(self, *args):
        tmpQ = Queue()
        tmpQ.enqueue(self.point)
        for val in args:
            point = tmpQ.dequeue()
            if point.get_left() == None:
                point.set_left(TreeNode())
                point.set_right(TreeNode())
                
            tmpQ.enqueue(*point.get_child())
            
            point.set_val(val)
            self.count += 1
            
    def BFS(self):
        tmpQ = Queue()
        tmpQ.enqueue(self.root)
        result = []
        while tmpQ.count > 0:
            tmp_node = tmpQ.dequeue()
            
            if tmp_node.get_val() == None:
                return result
                break
            
            print(f"{tmp_node.get_val()} ",end="")
            result.append(tmp_node.get_val())
            
            tmpQ.enqueue(*tmp_node.get_child())
                
    def _dfs(self, tmp_node = None, result=[]):
        
        if tmp_node.get_left().get_val() != None:
            result = self._dfs(tmp_node.get_left(),result)
            
        result.append(tmp_node.get_val())
        print(f"{tmp_node.get_val()} ",end="")
        
        if tmp_node.get_right().get_val() != None:
            result = self._dfs(tmp_node.get_right(),result)
        
        return result
            
        
    def DFS(self):
        p = self.root
        return self._dfs(p)
        


a = BinaryTree()
a.init_data(*[5,1,6,7,8,15,63,61,15,14,17,38,100])
a.BFS()
a.DFS()
```

Binary Tree for Problem Solving?!

```python
class Node:
    def __init__(self, val=None):
        self.val = val
        self.next = None
        
class Queue:
    def __init__(self):
        self.front = Node()
        self.rear = self.front
        self.count = 0
        
    def enqueue(self, val):
        self.rear.next = Node(val)
        self.rear = self.rear.next
        self.count += 1
    
    def dequeue(self):
        if self.is_empty():
            raise "Queue is empty!"
        else:
            tmp = self.front.next.val
            self.front = self.front.next
        self.count -= 1
        return tmp
        
    def is_empty(self):
        return self.front == self.rear
    
    
class TreeNode:
    def __init__(self, val = None):
        self.val = val
        self.left = None
        self.right = None

    
class BinaryTree:
    def __init__(self):
        self.root = TreeNode()
        self.pointer = self.root
        
    def construct_tree(self, *arr):
        q = Queue()
        q.enqueue(self.pointer)
        
        for val in arr:
            current_node = q.dequeue()
            current_node.val = val
            current_node.left = TreeNode()
            current_node.right = TreeNode()
            
            q.enqueue(current_node.left)
            q.enqueue(current_node.right)
                
        
    def bfs(self):
        q = Queue()
        q.enqueue(self.root)
        
        while not q.is_empty():
            current_node = q.dequeue()
            print(current_node.val, end=" ")
            
            if current_node.left:
                if current_node.left.val:
                    q.enqueue(current_node.left)
            if current_node.right:
                if current_node.right.val:
                    q.enqueue(current_node.right)
```