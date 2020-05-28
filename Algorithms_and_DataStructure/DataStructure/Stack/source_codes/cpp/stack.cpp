#include <iostream>

using namespace std;
// 1. Basic Stack

struct Node {

	int val;
	Node* prior;
	Node();
	Node (int val) {
		this->val = val;
	}
};

class Stack {
public:
	Node* top;
	int count;

	Stack();
	void push(int val);
	int pop();
	int peek();
	bool isEmpty();
};

Stack::Stack() {
	this->top = nullptr;
	this->count = 0;
}

void Stack::push(int val) {
	Node* newNode = new Node(val);
	newNode->prior = this->top;
	this->top = newNode;
	this->count += 1;
}

int Stack::pop() {
	if (this->isEmpty())
	{
		cout << "Stack is Empty" << endl;
		throw runtime_error{ "Stack is Empty" };
	}
	Node* tmpNode;
	int tmpVal = this->top->val;
	tmpNode = this->top;
	this->top = this->top->prior;
	this->count -= 1;

	delete [] tmpNode;

	return tmpVal;
}

int Stack::peek() {
	if (this->isEmpty())
	{
		cout << "Stack is Empty" << endl;
		throw runtime_error{ "Stack is Empty" };
	}
	return this->top->val;
}

bool Stack::isEmpty() {
	return this->count == 0;
}

// 2. Stack by Vector
#include <vector>
vector<int> stack;


int main() {
	

	cout << "#1 basic stack" << endl;
	Stack st;
	cout << st.count << endl;
	
	for (int i = 0; i < 5; i++)
	{
		st.push(i);
	}

	cout << "peek value : " << st.peek() << endl;
	cout << "Empty? : " << st.isEmpty() << endl;


	for (int i = 0; i < 5; i++)
	{
		cout << i + 1 << "th pop: " << st.pop() << endl;
	}
	cout << "Empty? : " << st.isEmpty() << endl;

	cout << "#2 Stack by vector" << endl;

	cout << stack.size() << endl;

	for (int i = 0; i < 5; i++)
	{
		stack.push_back(i);
	}

	cout << "peek value : " << stack.back() << endl;
	cout << "Empty? : " << stack.empty() << endl;

	int a;
	for (int i = 0; i < 5; i++)
	{
		a = stack.back();
		stack.pop_back();
		cout << i + 1 << "th pop: " << a << endl;
	}
	cout << "Empty? : " << stack.empty() << endl;


	return 0;
}