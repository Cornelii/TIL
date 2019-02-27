# List
array and list
array: impossible to change size (It can store only one type data)
list: possible to change size

## linked list
  
### main methods
1. addtoFirst()
2. addtoLast()
3. add()
4. delete()
5. get()

### Node and Head
1. Node
    * data field: where stored data is
    * link field: indication to next node's address

2. Head
    * Reference for first node of list.


### Linked List in lecture
kind of Value-based linked list?!
```python
class Node:
    def __init__(self, val=None):
        self.val = val
        self.next = None

class LList(Node):
    
    def __init__(self):
        self.head = Node()
        self.tail = self.head
        self.count = 0

    def append(self, *args):
        for val in args:
            self.tail.next = Node(val)
            self.tail = self.tail.next
            self.count += 1

    def addtoFirst(self, val):
        self.insert(0, val)

    def insert(self, idx, val):
        if idx:
            tmp = self.forward(idx-1)
            a = tmp.next
            tmp.next = Node(val)
            tmp.next.next = a
        else:
            tmp = self.head.next
            self.head.next = Node(val)
            self.head.next.next = tmp
        self.count += 1

    def forward(self, idx):
        tmp = self.head.next
        if idx >= self.count:
            raise IndexError("Out of Index")
        for _ in range(idx):
            tmp = tmp.next
        return tmp
        
    ### additional things
    def __getitem__(self, key):
        tmp_node = self.forward(key)
        return tmp_node.val
```