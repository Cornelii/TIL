# Linear Data Structure.

## I. Node
Node is a fundamental unit for varios data structures.

Node store data in it, and have link (pointer) to point other node.

Basic code for a node
```python
class Node:
  def __init__(self, value, link_node=None):
    self.value = value
    self.link_node = link_node

    #getter
    def get_value(self):
        return self.value

    def get_link_node(self):
        return self.link_node
   
    #setter
    def set_link_node(self,link_node):              
        self.link_node = link_node

A = node('a')
B = node('b')
C = node('c')

A.set_link_node(B)
B.set_link_node(C)

B_data = A.get_link_node().get_value() ## Approach with get_link_node() method.
```

## II. Linked List

A series of nodes.
The link of tail node is set to null

**common operations**
    1. adding nodes
    2. removing nodes
    3. finding a node
    4. traverse


Linked List in python
```python

class LinkedList:
  def __init__(self, value=None):
    self.head_node = Node(value)
  
  def get_head_node(self):
    return self.head_node
  
  # Add your insert_beginning and stringify_list methods below:
  
  def insert_beginning(self, new_value):
    new_node = Node(new_value)
    new_node.set_next_node(self.head_node)
    self.head_node = new_node
    
  def stringify_list(self):
    string_list = ""
    current_node = self.get_head_node()
    while current_node:
      if current_node.get_value() != None:
        string_list += str(current_node.get_value()) + "\n"
      current_node = current_node.get_next_node()
    return string_list
```