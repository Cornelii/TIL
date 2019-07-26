#include "ds.h"

Stack::Stack() {
	top = nullptr;
}

void Stack::push(int _val) {
	Node *tmp = top;
	top = new Node(_val);
	top->prev = tmp;
}

int Stack::pop() {
	int res = top->val;
	Node *tmp;
	tmp = top;
	top = top->prev;
	delete tmp;
	return res;
}

int Stack::peek() {
	return top->val;
}

bool Stack::is_empty() {
	return top == nullptr;
}