## How to construct binary search tree

class Node:
    def __init__(self, val=None):
        self.val = val
        self.next = None


class Queue(Node):
    def __init__(self):
        self.front = Node()
        self.rear = self.front
        self.count = 0

    def enqueue(self, val):
        self.rear.next = Node(val)
        self.rear = self.rear.next
        self.count += 1

    def dequeue(self):
        if self.is_empty():
            raise "Empty Queue"
        else:
            tmp_val = self.front.next.val
            self.front = self.front.next
            self.count -= 1
            return tmp_val

    def is_empty(self):
        return self.front == self.rear


class TreeNode:
    def __init__(self, val=None):
        self.val = val
        self.left = None
        self.right = None
        self.array = []

class BST(TreeNode):
    def __init__(self, num_nodes):
        self.root = TreeNode()
        self.num_nodes = num_nodes

    def init_tree(self):
        q = Queue()
        q.enqueue(self.root)

        i = 1 # root
        while i <= self.num_nodes-1:
            cur_node = q.dequeue()

            cur_node.left = TreeNode()
            i += 1
            q.enqueue(cur_node.left)
            if self.num_nodes - i > 0:
                cur_node.right = TreeNode()
                i += 1
                q.enqueue(cur_node.right)

    def inorder(self, cur_node, arr):

        if cur_node.left:
            if not cur_node.left.val:
                self.inorder(cur_node.left, arr)
        cur_node.val = arr.pop(0)
        if cur_node.right:
            if not cur_node.right.val:
                self.inorder(cur_node.right, arr)


    def bfs(self):
        self.array = []
        q = Queue()
        q.enqueue(self.root)

        while not q.is_empty():
            cur_node = q.dequeue()

            if cur_node.left:
                q.enqueue(cur_node.left)
            if cur_node.right:
                q.enqueue(cur_node.right)

            self.array.append(cur_node.val)

T = int(input())

for case in range(1, T+1):
    n = int(input())
    arr = list(range(1,n+1))
    bst = BST(n)
    bst.init_tree()
    bst.inorder(bst.root, arr)
    bst.bfs()
    result = bst.array
    m = n//2-1

    print(f"#{case} {result[0]} {result[m]}")