#include <stdio.h>
#include <stdbool.h> // for the boolean type

#define NULL_INT -987654321

// # 1 Basic Stack
void init_stack(struct Stack* stack);
void push(struct Stack* stack, int value);
int pop(struct Stack* stack);
bool isEmpty(struct Stack* stack);
int peek(struct Stack* stack);

struct Node {
	int val;
	struct Node* prior;
};

struct Stack {
	struct Node * top;
	int count;
};

void init_stack(struct Stack* stack) {
	stack->count = 0;
}

void push(struct Stack* stack, int value) {
	struct Node* newNode = (struct Node*) malloc(1*sizeof(struct Node));

	stack->count += 1;
	newNode->val = value;
	newNode->prior = stack->top;

	stack->top = newNode;
}

int pop(struct Stack* stack) {
	if (isEmpty(stack))
	{
		printf("stack is empty!\n");
		return NULL_INT;
	};
	int tmpVal = stack->top->val;

	struct Node* tmpNode = stack->top;
	stack->top = stack->top->prior;
	stack->count -= 1;
	free(tmpNode);

	return tmpVal;
}

bool isEmpty(struct Stack* stack) {
	return stack->count == 0;
}

int peek(struct Stack* stack) {
	if (isEmpty(stack))
	{
		printf("stack is empty!\n");
		return NULL_INT;
	};
	return stack->top->val;
}


//# 2. Stack with Fixed size.
#define MAX_SIZE 10

int f_stack[MAX_SIZE];
int TOP;

void init_f_stack() {
	TOP = -1;
}

void f_push(int val) {
	if (TOP + 1 >= MAX_SIZE)
		printf("Stack is Full");

	TOP += 1;
	f_stack[TOP] = val;
}

bool f_isEmpty() {
	return TOP == -1;
}

int f_pop() {
	if (TOP == -1) {
		printf("Stack is Empty!");
		return NULL_INT;
	}
	TOP -= 1;
	return f_stack[TOP + 1];
}

int f_peek() {
	if (TOP == -1) {
		printf("Stack is Empty!");
		return NULL_INT;
	}
	return f_stack[TOP];
}


int main() {

	// use of #1 Stack
	struct Stack st;
	init_stack(&st);

	printf("----- #1 Stack -----\n\n");
	push(&st, 6);
	printf("%d\n", st.top->val);
	push(&st, 14);
	printf("%d\n", st.top->val);
	printf("%d\n", st.top->prior->val);

	printf("Empty? %d\n", isEmpty(&st));
	printf("peek %d\n", peek(&st));
	printf("first pop:%d\n", pop(&st));
	printf("second pop:%d\n", pop(&st));
	printf("Empty? %d\n", isEmpty(&st));

	printf("----- #2 Stack -----\n\n");
	// use of #2 Stack
	init_f_stack();
	f_push(6);
	printf("%d\n", f_stack[0]);
	f_push(14);
	printf("%d\n", f_stack[1]);
	printf("%d\n", f_stack[0]);

	printf("Empty? %d\n", f_isEmpty());
	printf("peek %d\n", f_peek());
	printf("first pop:%d\n", f_pop());
	printf("second pop:%d\n", f_pop());
	printf("Empty? %d\n", f_isEmpty());

	return 0;
}