# Depth-first search

## 1. Using Stack
1. From departure point to one way, go until obastacle that means no where to go. 
2. Then, go back to the latest forked road and again from 1

This procedure is good in stack


## 2. DFS Algorithm

1. Decide starting node v, and visit
2. Among adjacent nodes to v. if there exists w, which is not yet visited, push v to the stack and go to w.
3. let w v, go back to pop, and repeat until stack become empty state.

**DFS recursive form for Tree**
![dfs_recursive](../../img/DFS_recursive_basic_form.png)


![DFS](../../img/DFS_outline.png)


## DFS python sample code
```python
## These works in Tree. not graph (known root, no cycle)!!!!!!!
### simplified DFS ## using adjacency table!!!

### iterative way with stack
def DFS_iter(s):
    S = Stack()
    
    visit_table[s-1] = True
    print("visit {}th Node".format(s))
    
    while not all(visit_table):
        flag = 0
        for vertex in range(len(graph_table)):
            if graph_table[s-1][vertex] and not visit_table[vertex]:
                
                visit_table[vertex] = True
                print("visit {}th Node".format(vertex+1))
                S.push(s)
                s = vertex+1
                flag = 1
                break
                
        if flag:
            pass
        else:
            if S.is_empty():
                return 0
            else:
                s = S.pop()

    return 1

## Basic DFS using graph_table (not return value)
def DFS(s): 
    if all(visit_table):
        return

    visit_table[s-1] = True
    print("visit {}th Node".format(s))

    for vertex in range(len(graph_table)):
        if graph_table[s-1][vertex] and not visit_table[vertex]:
            dfs(vertex+1)

    # if all(visit_table):
    #     return 1

if __name__ == '__main__':
    graph_table = [[0,1,1,0,0],[0,0,0,1,0],[0,0,0,0,1],[0,0,0,0,0],[0,0,0,0,0]]
    visit_table = [0]*5
    stack = Stack()

### Stack
class Node:
    def __init__(self, val):
        self.val = val
        self.prior = None


class Stack(Node):
    def __init__(self):
        self.top = None
        self.count = 0

    def push(self, val):
        tmp = self.top
        self.top = Node(val)
        self.top.prior = tmp
        self.count += 1

    def pop(self):
        if self.top:
            tmp = self.top.val
            self.top = self.top.prior
            self.count -= 1
            return tmp
        else:
            print("Stack is empty")

    def isEmpty(self):
        return self.top == None

    def peek(self):
        return self.top.val

    def clear(self):
        self.top = None

```