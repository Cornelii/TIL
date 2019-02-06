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
B.set_link_node(C) ## A -> B-> C

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

  # Define your remove_node method below:
  def remove_node(self, value_to_remove):
    current_node = self.head_node
    while current_node:
      if current_node.get_value() == value_to_remove:
        self.head_node = current_node.get_next_node()
        current_node = None
        break
      else:
        current_node = current_node.get_next_node()
        
```

## III. Stacks
LIFO

**common operations**
  1. Push
  2. Pop
  3. Peek

```python
from node import Node

class Stack:
  def __init__(self, limit=1000):
    self.top_item = None
    self.size = 0
    self.limit = limit
  
  def push(self, value):
    if self.has_space():
      item = Node(value)
      item.set_next_node(self.top_item)
      self.top_item = item
      self.size += 1
      # Increment stack size by 1 here:
    
  def pop(self):
    if self.size > 0:
      item_to_remove = self.top_item
      self.top_item = item_to_remove.get_next_node()
      self.size -= 1
      return item_to_remove.get_value()
    else:
      print("This stack is totally empty.")
  
  def peek(self):
    if self.size > 0:
	    return self.top_item.get_value()
    else:
      print("Nothing to see here!")
      
  # Define has_space() and is_empty() below:
  def has_space(self):
    return self.limit > self.size
  
  def is_empty(self):
    return self.size == 0

```

## IV. Queues
FIFO

**common operations**
  1. Enqueue
  2. Dequeue
  3. Peek


```python

from node import Node

class Queue:
  def __init__(self, max_size=None):
    self.head = None
    self.tail = None
    self.max_size = max_size
    self.size = 0
    
  def enqueue(self, value):
    if self.has_space():
      item_to_add = Node(value)
      print("Adding " + str(item_to_add.get_value()) + " to the queue!")
      if self.is_empty():
        self.head = item_to_add
        self.tail = item_to_add
      else:
        self.tail.set_next_node(item_to_add)
        self.tail = item_to_add
      self.size += 1
    else:
      print("Sorry, no more room!")
         
  def dequeue(self):
    if self.get_size() > 0:
      item_to_remove = self.head
      print(str(item_to_remove.get_value()) + " is served!")
      if self.get_size() == 1:
        self.head = None
        self.tail = None
      else:
        self.head = self.head.get_next_node()
      self.size -= 1
      return item_to_remove.get_value()
    else:
      print("The queue is totally empty!")
  
  def peek(self):
    if self.size > 0:
      return self.head.get_value()
    else:
      print("No orders waiting!")
  
  def get_size(self):
    return self.size
  
  def has_space(self):
    if self.max_size == None:
      return True
    else:
      return self.max_size > self.get_size()
    
  def is_empty(self):
    return self.size == 0

```
