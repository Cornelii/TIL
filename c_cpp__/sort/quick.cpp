#include "sort.h"

int partition(int[], int, int);

void quick_sort(int arr[], int l, int r) {
	if (l < r) {
		int s = partition(arr, l, r);
		quick_sort(arr, l, s - 1);
		quick_sort(arr, s + 1, r);
	}
}

int partition(int arr[], int l, int r) {
	int pivot = arr[l];
	int i = l;
	int j = r;
	int tmp;
	while (i < j) {
		while (arr[i] <= pivot) {
			if (i >= r) {
				break;
			}
			i++;
		}

		while (arr[j] >= pivot) {
			if (j <= l) {
				break;
			}
			j--;
		}
		if (i < j) {
			tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}
	}
	tmp = arr[l];
	arr[l] = arr[j];
	arr[j] = tmp;

	return j;
}