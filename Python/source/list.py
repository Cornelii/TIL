class Node:
    def __init__(self, val=None):
        self.val = val
        self.next = None
        self.prior = None

    def append(self,val):
        self.next=Node(val)
        self.next.prior=self
    def setVal(self,val):
        self.val = val
        
class List(Node):
    def __init__(self, basic_list=[]):
        self.head = Node()
        a = self.head
        count = 0

        for val in basic_list:
            a.append(val)
            a = a.next
            count += 1

        self.end=a
        self.count = count
        self.c=0 # for __next__
        

        if basic_list:
            self.head = self.head.next    
        self.next = self.head

    def forward(self, node ,n_times):
        tmp=node
        for _ in range(n_times):
            tmp=tmp.next
        return tmp

    def backward(self, node ,n_times):
        tmp=node
        for _ in range(n_times):
            tmp=tmp.prior
        return tmp

    def __str__(self):
        a = self.head
        print("[",end="")
        for _ in range(self.count-1):
            print(a.val,end=", ")
            a = a.next
        print(a.val,end="")
        return "]"

    def __getitem__(self,key):
        if isinstance(key,slice):
            tmp=List()
            start,stop,step = self.decode_slicing(key.start,key.stop,key.step)
            if step>0:
                a=self.forward(self.head,start)
                tmp.append(a.val)
                idx=start
                while idx < stop:
                    a = self.forward(a,step)
                    tmp.append(a.val)
                    idx += step
                return tmp
            else:
                a=self.backward(self.end,self.count-1-start)
                idx=start
                tmp.append(a.val)
                while idx > stop:
                    a = self.backward(a,step*-1)
                    tmp.append(a.val)
                    idx += step
                return tmp

        elif isinstance(key,int):
            if key < 0:
                key += self.count
            if key >= self.count:
                raise KeyError

            a = self.head
            for _ in range(key):
                a = a.next
            return a.val
        else:
            raise TypeError("index should be Integer")

    def __setitem__(self,key,value):
        if type(key) != int:
            raise TypeError
        if key < 0:
            key+=self.count
        if key >= self.count:
            raise KeyError
        a = self.head
        for _ in range(key):
            a = a.next
        a.setVal(value)

    def append(self,val):
        self.end.append(val)
        self.count += 1
        self.end.prior=self.end
        self.end = self.end.next
        if self.count == 1:
            self.head=self.head.next
            
    def sort(self):
        pass

    def pop(self,idx=-1):
        if idx == 0:
            tmp = self.head.val
            self.head = self.head.next
            self.count -= 1
            return tmp
        else:
            if idx < 0:
                idx = self.count+idx
            if idx >= self.count:
                raise IndexError("OutofIndexBoundary")

            tmp = forwarding(self,idx)
            tmp_val=tmp.next.val
            tmp.next = tmp.next.next
            
            self.count -= 1
            
            return tmp_val

            
    def index_abs(self,key):
        if key > 0:
            return key
        else: 
            return self.count-key

    def decode_slicing(self,start,stop,step):
        if step:
            if step > 0:
                start = self.index_abs(start) if start else 0
                stop = self.index_abs(stop) if stop else self.count-1
                return start, stop, step
            elif step <0:
                start = self.index_abs(start) if start else self.count-1
                stop = self.index_abs(stop) if stop else 0 
                return start, stop, step
            else:
                raise ValueError("slice step cannot be zero")
        else:# step == None
            start = self.index_abs(start) if start else 0
            stop = self.index_abs(stop) if stop else self.count-1
            step = 1
            return start, stop, step

    def __iter__(self):
       return self
    
    def __next__(self):
        if self.c < self.count:
            self.c += 1
            tmp=self.head
            if self.c > 1:
                tmp = self.forward(tmp, self.c-1)
            return tmp.val
        else:
            raise StopIteration

    def __add__(self,B):
        tmp = List()
        a=self.head
        for _ in range(self.count):
            tmp.append(a.val)
            a=a.next

        b=B.head
        for _ in range(B.count):
            tmp.append(b.val)
            b=b.next
            
        tmp.count=self.count+B.count
        return tmp

    def copy(self):
        tmp =List()
        a=self.head
        for _ in range(self.count):
            tmp.append(a.val)
            a=a.next
        return tmp

    def __mul__(self,a):
        tmp = List()
        for _ in range(a):
            a=self.head
            for _ in range(self.count):
                tmp.append(a.val)
                a = a.next
        return tmp

    def index(self):
        pass

    def clear(self):
        self.__init__()

    def remove(self):
        pass

    def reverse(self):
        pass

    def insert(self):
        pass

    def extend(self,A):
        self = self.__add__(A)

    def search(self,target):
        pass

#### control from outside
def forwarding(node,i):
    if i < 0:
        return node
    return forwarding(node.next,i-1)
def backwarding(node,i):
    if i < 0:
        return node
    return backwarding(node.prior,i-1)

def abs(value):
    if value >= 0:
        return value
    else: 
        return -1*value

def len(myList):
    return myList.count

def max(myList):
    pass

def min(myList):
    pass

def sorted(myList):
    pass
