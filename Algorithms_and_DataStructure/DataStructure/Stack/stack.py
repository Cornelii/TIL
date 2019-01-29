# 1. Basic Stack
class Node:
    def __init__(self, val = None):
        self.val = val
        self.prior = None

class Stack(Node):
    def __init__(self):
        self.top = None
        self.count = 0

    def push(self, val):
        tmp = self.top
        self.top = Node(val)
        if self.count:
            self.top.prior = tmp
        self.count += 1 

    def pop(self):
        if self.top == None:
            raise IndexError("Stack is Empty")
        
        tmp = self.top.val
        self.top = self.top.prior
        self.count -= 1
        return tmp

    def isEmpty(self):
        return self.count == 0

    def peek(self):
        if self.top == None:
            raise IndexError("Stack is Empty")
            return 0
        return self.top.val
