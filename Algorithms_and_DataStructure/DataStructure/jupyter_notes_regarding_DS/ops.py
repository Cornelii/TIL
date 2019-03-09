class Node:
    def __init__(self, val=None):
        self.__val = val
        self.__next = None
        self.__prev = None
    
    def get_val(self):
        return self.__val
    
    def set_val(self, val):
        self.__val = val
        
    def get_next(self):
        return self.__next
    
    def set_next(self, node):
        self.__next = node
    
    def get_prev(self):
        return self.__prev
    
    def set_prev(self, node):
        self.__prev = node
        
        
class LinkedList(Node):
    def __init__(self):
        self.head = Node()
        self.tail = self.head
        
    def append(self, *args):
        for val in args:
            self.tail.set_next(Node(val))
            self.tail.get_next().set_prev(self.tail)
            
            self.tail = self.tail.get_next()
    
    def insert(self, idx, val):
        tmp = self.forward(idx-1)
        tmp2 = tmp.get_next()
        
        tmp.set_next(Node(val))
        tmp.get_next().set_prev(tmp)
        
        tmp.get_next().set_next(tmp2)
        tmp2.set_prev(tmp.get_next())
        
    def pop(self, idx = -1):
        if idx >= 0:
            tmp = self.forward(idx-1)
        else:
            tmp = self.backward(abs(idx+1)+1)
        if idx:
            target_node = tmp.get_next()
            if tmp.get_next().get_next():
                tmp.set_next(tmp.get_next().get_next())
                tmp.get_next().set_prev(tmp)
            else:
                self.tail = tmp
                tmp.set_next(None)

            return target_node.get_val()
        else:
            tmp_val = tmp.get_val()
            self.head = self.head.get_next()
            self.head.set_val(None)
            self.head.set_prev(None)
            return tmp_val
        
    def forward(self, idx):
        tmp = self.head.get_next()
        for _ in range(idx):
            tmp = tmp.get_next()
        return tmp
        
    def backward(self, idx):
        tmp = self.tail
        for _ in range(idx):
            tmp = tmp.get_prev()
        return tmp
    
    
    
class ModifiedLinkedList(LinkedList):
    def __init__(self):
        super().__init__()
        
    def forward(self, idx):
        if self.head is self.tail:
            raise "Out of IndexError"
        else:
            tmp = self.head.get_next()
        for _ in range(idx):
            if tmp == None:
                return tmp
            else:
                tmp = tmp.get_next()
        return tmp
        
    def backward(self, idx):
        if self.head is self.tail:
            raise "Out of IndexError"
        else:
            tmp = self.tail
        for _ in range(idx):
            if tmp is self.head:
                raise "Out of IndexError"
            else:
                tmp = tmp.get_prev()
        return tmp
    
    def __getitem__(self, key):
        if key >= 0:
            tmp = self.forward(key)
        else:
            tmp = self.backward(abs(key+1))
        return tmp.get_val()
    
    def __len__(self):
        tmp = self.head
        count = 0
        while not tmp is self.tail:
            tmp = tmp.get_next()
            count += 1
        return count