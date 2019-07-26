#include "ds.h"
#include <iostream>

using namespace std;

Node::Node() {
	next = nullptr;
	prev = nullptr;
}

Node::Node(int _val, Node* _prev, Node* _next) {
	val = _val;
	next = _next;
}

//Linked List

LinkedList::LinkedList() {
	tail = &head;
}

LinkedList::LinkedList(const LinkedList& A) {

}

void remove_forward(Node* curNode) {
	if (curNode->next) {
		remove_forward(curNode->next);
	}
	cout << "delete " << curNode->val << endl;
	delete curNode;
}

LinkedList::~LinkedList() {
	if (head.next) {
		remove_forward(head.next);
	}
}

Node* LinkedList::forward(int idx) {
	cursor = &head;
	for (int i = 0; i < idx; i++) {
		cursor = cursor -> next;
	}

	return cursor;
}

void LinkedList::append(int _val) {
	tail->val = _val;
	Node *new_node = new Node;
	tail -> next = new_node;
	tail = tail -> next;
}

void LinkedList::insert(int val, int idx) {
	Node *pos = forward(idx-1); // Have to deal with it idx =0 case
	Node *tmp = pos->next;
	Node *new_node = new Node(val);
	pos->next = new_node;
	new_node->next = tmp;
}

void LinkedList::insert(LinkedList& A, int idx) {

}

void LinkedList::remove(int idx, int count) {

}

void LinkedList::print() {
	cursor = &head;
	while (cursor->next) {
		cout << cursor->val << " ";
		cursor = cursor->next;
	}
	cout << endl;
}