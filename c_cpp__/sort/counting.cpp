#include "sort.h"

int max(int [], int);

void counting_sort(int arr[], int n) {
	int max_val = max(arr, n);

	int *c = new int[max_val+1]; // counting array
	*c = { 0 };

	for (int i = 0; i < n; i++) {
		c[arr[i]] += 1;
	}

	int pointer = 0;
	for (int i = 0; i < max_val + 1; i++) {
		if (c[i]) {
			for (int j = 0; j < c[i]; j++) {
				arr[pointer] = i;
				pointer++;
			}
		}
	}


	delete[]c;
}

int max(int arr[], int n) {
	int max_val = arr[0];
	
	for (int i = 1; i < n; i++) {
		if (max_val < arr[i]) {
			max_val = arr[i];
		}
	}
	return max_val;
}

