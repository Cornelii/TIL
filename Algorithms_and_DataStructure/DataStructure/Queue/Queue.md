# Queue

FIFO: First In First Out structure


Front: first element front will be acheived 
Rear: last element rear will be last.

* Basic operation of Queue
    1. enQueue (insert)
    2. deQueue (deletion)
    3. isEmpty()
    4. isFull()
    5. Qpeek() : get front without removal
    6. createQueue()

## Procedure of basic Queue operation

1. createQueue()
=> empty Queue. in this step. front =-1, real =-1
2. enQueue()
=> insert elements into Queue real+=1 as each element is added.
3. deQueue()
=> front+=1 get and remove element in the front index  (for the first 0 (front=-1))
1. Queue Reach isEmpty() it means front=rear. place front and rear to -1

## Kinds of Queue
### 1. Linear Queue
It can be implmented by using 1-d list.
    * size of list = size of queue
    * front index
    * rear index
    * expression of state
      * initial : front=rear=-1
      * empty : front=rear
      * full : rear=n-1 (n: size of list)

#### code example
1. createQueue() : list
2. enQueue(item)
```python
def enQueue(item):
    global rear
    if isFull(): print("Queue_Full")
    else:
        rear +=1 
        Q[rear] = item
```
3. deQueue()
```python
def deQueue():
    global front
    if isEmpty(): print("queue_empty")
    else:
        front += 1
        return Q[front]
```
4. isEmpty() & isFull()
```python
def isEmpty():
    return front == rear

def isFull():
    return rear == len(Q) - 1 
```
5. Qppek() 
```python
def Qpeek():
    if isEmpty():print("Queue-Empty")
    else: reutnr Q[front+1]
```

#### Problem of linear queue
1. Wroing recognition about full-state:
    * maybe in front part there will be room empty.
    * And, size of list should be pre-defined
    * memory problem. => use of circular Queue 

### 2. Circular Queue
link front and end

    * size of list = size of queue
    * front index
    * rear index
    * expression of state
      * initial : front=rear=0
      * front,rear => n-1. then after. to the 0 by remainder operator %
      * **In this case, do not use the place of front**
        |table index|insert|deletion|
        |---|---|---|
        |linear Queue|rear += 1|front += 1|
        |circular Queue|rear = (rear+1)%n|front = (front+1)%n|

      * empty : front=rear
      * full : (rear+1)%n = front


```python
class CircularQueue:
    def __init__(self, size = 10):
        self.size = size
        self.front = 0
        self.rear = 0
        self.array = [None]*(size+1)
        self.count = 0
        
    def enqueue(self, *args):
        for val in args:
            if self.is_full():
                raise "Queue is full"
            else:
                self.rear = (self.rear+1)%(self.size+1)
                self.array[self.rear] = val
                self.count += 1
    
    def dequeue(self):
        if self.is_empty():
            raise "Queue is empty"
        else:
            self.front = (self.front+1)%(self.size+1)
            self.count -= 1
            
            return self.array[self.front]
    
    def is_empty(self):
        return self.front == self.rear
    
    def is_full(self):
        return self.count >= self.size

```



### 3. Linked Queue
    jsut use of linked-list

     * initial or empty: front = rear = None
     * no full state ion Linked Queue Cause linked list can increase its size.

#### Operation of linked queue example
1. createLinkedQueue() 
front = None
rear = None

2. add A
front and rear => address of A

3. add B
front stay and A link and rear => address of B

4. deQueue 
front => address B

5. add C
B link and rear => address of C

6. deQueue
front => address of C

7. deQueue
front,rear = None

example of python code
```python
class Node:
    def __init__(self, val = None):
        self.val = val
        self.next = None

class Queue(Node):
    def __init__(self, size = 1000):
        self.size = size
        self.front = Node()
        self.rear = self.front
        self.count = 0
        
    def enqueue(self, *args):
        
        for val in args:
            if self.is_full():
                raise "Queue is full!"
            else:
                self.rear.next = Node(val)
                self.rear = self.rear.next
                self.count += 1
        
    def dequeue(self):
        if self.is_empty():
            raise "Queue is empty"
        else:
            tmp_val = self.front.next.val
            if self.front.next == self.rear:
                self.front = self.rear
            else:
                self.front.next = self.front.next.next
            self.count -= 1
            return tmp_val
        
        
    def is_empty(self):
        return self.front == self.rear
    
    def is_full(self):
        return self.count >= self.size

```

* There is queue module in python
queue.Queue
queue.LifoQueue   (stack)
queue.PriorityQueue

these 3 class have same methods as follow
1. qsize()
2. put(item)
3. get(item)
4. empty()
5. full()

ex) use of Queue
```python
import queue

q = queue.Queue() ## FIFO
q.put('A')
q.put('B')
q.put('C')

while not q.empty():
    print(q.get())
```

## Application of Queue
1. Priority queue
not FIFO. according to priority

It can be applied in simulation, netword traffic control, buffer, and task schedule in OS.



2. Buffer