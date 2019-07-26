#include <iostream>
#include "sort.h"
#include "ds.h"

using namespace std;

int main() {
	//***************Sorting test***************

	int x[9] = { 7, 1, 7, 54, 8, 5, 156, 0, 75 };
	int n = sizeof(x) / sizeof(int);
	
	for (unsigned int i = 0; i < n; i++) {
		cout << x[i] << " ";
	}
	cout << endl;


	//bubble_sort(x, n);
	//counting_sort(x, n);
	//quick_sort(x, 0, n-1);
	//int *y;
	//y = merge_sorted(x, n);
	
	int *tmp = new int[n];
	merge_sort(x, tmp, 0, n - 1);

	for (unsigned int i = 0; i < n; i++) {
		//cout << y[i] << " ";
		cout << x[i] << " ";
	}
	cout << endl;

	//delete[]y;
	delete[]tmp;



	//***************Data Structure test***************
	LinkedList *myList = new LinkedList;
	myList->append(6);
	myList->append(8);
	myList->append(457);
	myList->insert(54, 1);
	myList->print();

	delete myList;


	cout << "what is the prob?!" << endl;

	cout << (int)("12460"[4]) << endl; // '0'=> 48, '1'=> 49, ...


	Stack mystack;
	cout << mystack.is_empty() << endl;

	mystack.push(6);
	mystack.push(3);
	cout << mystack.is_empty() << endl;

	cout << mystack.peek() << endl;
	cout << mystack.pop() << endl;
	cout << mystack.is_empty() << endl;
	cout << mystack.pop() << endl;
	cout << mystack.is_empty() << endl;

	system("pause");
	return 0;
}