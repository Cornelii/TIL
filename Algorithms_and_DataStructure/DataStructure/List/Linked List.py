class Node:
    def __init__(self, val=None):
        self.val = val
        self.next = None

class LList(Node):
    def __init__(self):
        self.head = Node()
        self.tail = self.head
        self.count = 0

    def append(self, val):
        self.tail.next = Node(val)
        self.tail = self.tail.next
        self.count += 1

    def insert(self, idx, val):
        tmp = self.forward(idx-1)
        a = tmp.next
        tmp.next = Node(val)
        tmp.next.next = a

    def forward(self, idx):
        tmp = self.head.next
        for _ in range(idx):
            tmp = tmp.next
        return tmp