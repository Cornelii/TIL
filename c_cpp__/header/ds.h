// int linkedlist example
// Template prototype and implementation cannot be separated!

class Node {
public:
	int val;
	Node * next;
	Node * prev;
	Node();
	Node(int, Node* =nullptr, Node* =nullptr);
};


class LinkedList {
public:
	Node head;
	Node *tail;
	Node *cursor;
	LinkedList();
	LinkedList(const LinkedList&);//copy constructor
	~LinkedList();
	Node* forward(int);
	void append(int);
	void insert(int, int);
	void insert(LinkedList&, int);
	void remove(int, int=1);
	void print();
};


class Stack {
public:
	Node *top;

	Stack();
	void push(int);
	int pop();
	int peek();
	bool is_empty();
};