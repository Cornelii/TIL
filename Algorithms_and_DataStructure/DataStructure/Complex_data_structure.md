# Complex Data Structures


## I. Hash Map Methodology
Data is stored in terms of table.
And, Index is used to access them.

And, Hash function : {things} => {the index}

**Components of hash**
1. Associated data
2. An array of a fixed size
3. Hash function.

#### 1. There can be various types of hash function.
The simpler, the better. Because hash calculation is done every moment to access data in hash bucket.

The output of hash function must not be larger than size of array that includes indices and data. For this reason. `mod` is often used.

General flow to get index from hash function (hash map): data(key)-> hash code -> mod operation to get index
#### 2. Hash Collision
Hash function is kind of compressing function.
The situation of same hash for two different keys is called hash collision.
(Separate chaining, Open addressing are common ways to overcome this.)

#### 3. Separate Chaining (with Linked list at each index-pointed position.)
Just link the data in terms of linked list at the index.

#### 4. To get values in separated chaining. Save Key.
another key is saved to access in linked list
1. data(key) => [hash function => hashcode => manipulation] (hash map) => index
2. At the index. it find wanted value iteratively using other key in the linked list.


#### 5. Open Addressing
There are also several means in open addressing like probing.
Probing: Continue to find empty index.

To acheive data from probing.
First find by hash. If <span style="color:blue">data(key)</span> does not coincide, go on in index matching key until it finds the same key.

#### 6. Clustering and Quadratic Probing
One probing to avoid hash collosion causes other hash collision. => Clustering
Sometimes a probing itself triggers numerous hash collision.
Quadratic Probing : rather than 1index jump, 4index a step.

#### 7. Hash in python 
Hash function is implemented as module in python. Actually, this is not a exact hash.
hash use succesively arranged memory as a list.
Just refer this for deep understanding.


example. **not strictly hashtable!**
```python
class HashMap:
  def __init__(self, array_size):
    self.array_size = array_size
    self.array = [None for item in range(array_size)]

  def hash(self, key, count_collisions=0):
    key_bytes = key.encode()
    hash_code = sum(key_bytes)
    return hash_code + count_collisions

  def compressor(self, hash_code):
    return hash_code % self.array_size

  def assign(self, key, value):
    array_index = self.compressor(self.hash(key))
    current_array_value = self.array[array_index]

    if current_array_value is None:
      self.array[array_index] = [key, value]
      return

    if current_array_value[0] == key:
      self.array[array_index] = [key, value]
      return

    # Collision!

    number_collisions = 1

    while(current_array_value[0] != key):
      new_hash_code = self.hash(key, number_collisions)
      new_array_index = self.compressor(new_hash_code)
      current_array_value = self.array[new_array_index]

      if current_array_value is None:
        self.array[new_array_index] = [key, value]
        return

      if current_array_value[0] == key:
        self.array[new_array_index] = [key, value]
        return

      number_collisions += 1

    return

  def retrieve(self, key):
    array_index = self.compressor(self.hash(key))
    possible_return_value = self.array[array_index]

    if possible_return_value is None:
      return None

    if possible_return_value[0] == key:
      return possible_return_value[1]

    retrieval_collisions = 1

    while (possible_return_value[0] != key):
      new_hash_code = self.hash(key, retrieval_collisions)
      retrieving_array_index = self.compressor(new_hash_code)
      possible_return_value = self.array[retrieving_array_index]

      if possible_return_value is None:
        return None

      if possible_return_value[0] == key:
        return possible_return_value[1]

      number_collisions += 1

    return
```

#### 8. My own?! Hash
```python
class HashMap:
  def __init__(self,array_size):
    self.array_size = array_size
    self.array = [None]*array_size
    
  def hash(self,key):
    return sum(key.encode())
  
  def compress(self,hash_code):
    return hash_code % self.array_size
  
  def assign(self,key,value):
    hash_code = hash(key)
    idx = compress(hash_code)
    
    current_value = self.array[idx]
    if current_value:
      if current_value[0] == key:
        self.array[idx][1] = value
      else:
        collision_factor = 1
        while current_value[0] != key:
          new_idx = self.compress(hash_code+collision_factor)
          current_value = self.array[new_idx]
          
          if current_value:
            if current_value[0] == key:
              self.array[new_idx][1] = value
              break
            else:
              collision_factor += 1
              if collision_factor > self.array_size-1:
                print("No room for data")
                return
          else:
            self.array[new_idx] = [key,value]
            break
    else:
      self.array[idx] = [key, value]
    
  
  def retrieve(self,key):
    hash_code = self.hash(key)
    idx = self.compress(hash_code)
    
    current_value = self.array[idx]
    if current_value:
      if current_value[0] == key:
        return current_value[1]
      else:
        collision_factor = 1
        while current_value[0] != key:
          new_idx = self.compress(hash_code+coliision_factor)
          current_value = self.array(new_idx)
          if current_value:
            if current_value[0] == key:
              return current_value[1]
            else:
              collision_factor += 1
              if collision_factor > self.array_size:
                print("No matching value")
                return
          else:
            return None
    else:
      return None
    
```
#### 9. Chaining

```python

from linked_list import Node, LinkedList

class HashMap:
  def __init__(self,array_size):
    self.array_size = array_size
    self.array = [LinkedList() for i in range(array_size)]
    
  def hash(self,key):
    return sum(key.encode())
  
  def compress(self,hash_code):
    return hash_code % self.array_size
  
  def assign(self,key,value):
    hash_code = self.hash(key)
    array_index = self.compress(hash_code)
    
    payload = Node([key, value])
    
    list_at_array = self.array[array_index]
    for data in list_at_array:
      
      if data[0] == key:
        data[1] = value
        return
    list_at_array.insert(payload)
    
  def retrieve(self,key):
    hash_code = self.hash(key)
    array_index = self.compress(hash_code)
    
    list_at_index = self.array[array_index]
    
    for data in list_at_index:
      print(data)
      if data[0] == key:
        return data[1]
    print("Not found matching key")
    return None
    
from blossom_lib import flower_definitions

blossom = HashMap(len(flower_definitions))

for flower in flower_definitions:
  blossom.assign(flower[0],flower[1])

print(blossom.retrieve('daisy'))

```

LinkedList
```python
class Node:
  def __init__(self, value):
    self.value = value
    self.next_node = None
    
  def get_value(self):
    return self.value
  
  def get_next_node(self):
    return self.next_node
  
  def set_next_node(self, next_node):
    self.next_node = next_node

class LinkedList:
  def __init__(self, head_node=None):
    self.head_node = head_node
  
  def insert(self, new_node):
    current_node = self.head_node

    if not current_node:
      self.head_node = new_node

    while(current_node):
      next_node = current_node.get_next_node()
      if not next_node:
        current_node.set_next_node(new_node)
      current_node = next_node

  def __iter__(self):
    current_node = self.head_node
    while(current_node):
      yield current_node.get_value()
      current_node = current_node.get_next_node()
```


## II. Trees
Every nodes have at most one parent node!

#### 1. Binary Search Tree
* Binary tree => at most two children for one node.
* Left child value is  lesser than their parent
* Right child value is greater than their parent.

#### 3. Tree in Python

```python
class TreeNode:
    pass
```

## III. Heaps
Heaps are used to maintain minimum or maximum value in dataset (even for the non-numeric).

#### 1. Heaps as binary tree
fill in the tree in order retaining complete binary tree.

Nice feature of binary tree as list index.

1. data is sorted. (ASC order for min-heap, DESC order for max-heap)
2. left child of n'th index: (n*2)+1
3. rigth child of n'th index: (n*2)+2
4. parent of n'th index: (n)//2

Constructing Heap
1. Locate incoming element to the next indexed node.
2. Heapify Up.

Finding Min or Max value
1. Take first one.
2. Locate last indexed node to the first
3. Heapify Down.


#### 2. Min-Heaps in Python
Heaps enable solutions for complex problems such as finding the shortest path(Dijkstra's Algorithm) or efficiently sorting a dataset(heap sort).

example in python
```python

class MinHeap:
  def __init__(self):
    self.heap_list = [None]
    self.count = 0

  def parent_idx(self, idx):
    return idx // 2

  def left_child_idx(self, idx):
    return idx * 2

  def right_child_idx(self, idx):
    return idx * 2 + 1

  def child_present(self, idx):
    return self.left_child_idx(idx) <= self.count
  
  def retrieve_min(self):
    if self.count == 0:
      print("No items in heap")
      return None
    
    min = self.heap_list[1]
    self.heap_list[1] = self.heap_list[self.count]
    self.count -= 1
    self.heap_list.pop()
    self.heapify_down()
    return min

  def add(self, element):
    self.count += 1
    self.heap_list.append(element)
    self.heapify_up()


  def get_smaller_child_idx(self, idx):
    if self.right_child_idx(idx) > self.count:
      return self.left_child_idx(idx)
    else:
      left_child = self.heap_list[self.left_child_idx(idx)]
      right_child = self.heap_list[self.right_child_idx(idx)]
      if left_child < right_child:
        return self.left_child_idx(idx)
      else:
        return self.right_child_idx(idx)
    
  def heapify_up(self):
    idx = self.count
    swap_count = 0
    while self.parent_idx(idx) > 0:
      if self.heap_list[self.parent_idx(idx)] > self.heap_list[idx]:
        swap_count += 1
        tmp = self.heap_list[self.parent_idx(idx)]
        self.heap_list[self.parent_idx(idx)] = self.heap_list[idx]
        self.heap_list[idx] = tmp
      idx = self.parent_idx(idx)

    element_count = len(self.heap_list)
    if element_count > 10000:
      print("Heap of {0} elements restored with {1} swaps"
            .format(element_count, swap_count))
      print("")    
      
  def heapify_down(self):
    idx = 1
    # starts at 1 because we swapped first and last elements
    swap_count = 1
    while self.child_present(idx):
      smaller_child_idx = self.get_smaller_child_idx(idx)
      if self.heap_list[idx] > self.heap_list[smaller_child_idx]:
        swap_count += 1
        tmp = self.heap_list[smaller_child_idx]
        self.heap_list[smaller_child_idx] = self.heap_list[idx]
        self.heap_list[idx] = tmp
      idx = smaller_child_idx

    element_count = len(self.heap_list)
    if element_count >= 10000:
      print("Heap of {0} elements restored with {1} swaps"
            .format(element_count, swap_count))
      print("")  

```

test of heap
```python
# import random number generator
from random import randrange
# import heap class
from min_heap import MinHeap 

# make an instance of MinHeap
min_heap = MinHeap()

# populate min_heap with descending numbers
descending_nums = [n for n in range(10001, 1, -1)]
print("ADDING!")
for el in descending_nums:
  min_heap.add(el)

print("REMOVING!")
# remove minimum until min_heap is empty
min_heap.retrieve_min()

```


## IV. Graph

Node(vertex) and Edge!

**Path**: Any path from a node to a node as long as they are somewhat connected by edge.

**Weighted Path**: Each edge has number.(weight or cost)

**Remarks**: In a weighted graph, the shortest path is not always the least expensive.

**Directed Graph**: not bidirectional edge, one-directional edge!

**Cycle**: If a path, which starts from a node, finally ends from the very node, it is called *cycle*

#### 1. Representing Graphs
1. By adjacency Matrix
2. By adjacency List

example in python

vertex.py
```python
class Vertex:
  def __init__(self, value):
    self.value = value
    self.edges = {}

  def add_edge(self, vertex, weight = 0):
    self.edges[vertex] = weight

  def get_edges(self):
    return list(self.edges.keys())

```

graph.py
```python
class Graph:
  def __init__(self, directed = False):
    self.graph_dict = {}
    self.directed = directed

  def add_vertex(self, vertex):
    self.graph_dict[vertex.value] = vertex

  def add_edge(self, from_vertex, to_vertex, weight = 0):
    self.graph_dict[from_vertex.value].add_edge(to_vertex.value, weight)
    if not self.directed:
      self.graph_dict[to_vertex.value].add_edge(from_vertex.value, weight)

  def find_path(self, start_vertex, end_vertex):
    start = [start_vertex]
    seen = {}
    while len(start) > 0:
      current_vertex = start.pop(0)
      seen[current_vertex] = True
      print("Visiting " + current_vertex)
      if current_vertex == end_vertex:
        return True
      else:
        vertices_to_visit = set(self.graph_dict[current_vertex].edges.keys())
        start += [vertex for vertex in vertices_to_visit if vertex not in seen]
    return False

```
constructing of graph
```python
from random import randrange
from graph import Graph
from vertex import Vertex

def print_graph(graph):
  for vertex in graph.graph_dict:
    print("")
    print(vertex + " connected to")
    vertex_neighbors = graph.graph_dict[vertex].edges
    if len(vertex_neighbors) == 0:
      print("No edges!")
    for adjacent_vertex in vertex_neighbors:
      print("=> " + adjacent_vertex)


def build_graph(directed):
  g = Graph(directed)
  vertices = []
  for val in ['a', 'b', 'c', 'd', 'e', 'f', 'g']:
    vertex = Vertex(val)
    vertices.append(vertex)
    g.add_vertex(vertex)

  for v in range(len(vertices)):
    v_idx = randrange(0, len(vertices) - 1)
    v1 = vertices[v_idx]
    v_idx = randrange(0, len(vertices) - 1)
    v2 = vertices[v_idx]
    g.add_edge(v1, v2, randrange(1, 10))

  print_graph(g)

build_graph(False)


```