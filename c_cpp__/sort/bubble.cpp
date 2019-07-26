#include "sort.h"

void bubble_sort(int arr[], int n) {
	if (n == 1)
		return;

	int dum;
	for (int i = n - 1; i > 0; i--) {
		for (int j = 0; j < i; j++) {
			if (arr[j] > arr[j + 1]) {
				dum = arr[j + 1];
				arr[j + 1] = arr[j];
				arr[j] = dum;
			}
		}
	}
}