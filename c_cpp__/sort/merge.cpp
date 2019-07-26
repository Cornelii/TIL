#include "sort.h"

int* merge(int[], int[], int, int);

int* merge_sorted(int arr[], int n) {

	if (n <= 1)
		return arr;

	int mid = n / 2;
	int *arr1 = new int[mid];
	int *arr2 = new int[n - mid];

	for (int i = 0; i < n; i++) {
		if (i < mid) {
			arr1[i] = arr[i];
		}
		else {
			arr2[i-mid] = arr[i];
		}
	}

	int *left;
	int *right;
	left = merge_sorted(arr1, mid);
	right = merge_sorted(arr2, n-mid);

	int *result;
	result = merge(left, right, n, mid);

	delete left, right, arr1, arr2;
	return result;
}


int* merge(int arr1[], int arr2[], int n, int mid) {
	int *merged = new int[n];
	int left_len = mid;
	int right_len = n - mid;

	int pointer = 0;
	int left_pointer = 0;
	int right_pointer = 0;
	while ((left_len-left_pointer) && (right_len-right_pointer)) {
		if (arr1[left_pointer] < arr2[right_pointer]) {
			merged[pointer] = arr1[left_pointer];
			pointer++;
			left_pointer++;
		}
		else {
			merged[pointer] = arr2[right_pointer];
			pointer++;
			right_pointer++;
		}
	}

	while (left_len - left_pointer) {
		merged[pointer] = arr1[left_pointer];
		pointer++;
		left_pointer++;
	}
	while (right_len - right_pointer) {
		merged[pointer] = arr2[right_pointer];
		pointer++;
		right_pointer++;
	}
	return merged;
}



// pointer-based merge-sort
void merge_sort(int arr[], int tmp[], int l, int r) {
	if (l >= r) {
		return;
	}

	int mid = (l+r) / 2;
	
	merge_sort(arr, tmp, l, mid);
	merge_sort(arr, tmp, mid+1, r);

	// l < r
	// merging l ~ mid, mid+1 ~ r

	if (arr[mid] <= arr[mid + 1]) {
		return;
	}
	else {
		int pointer=0;
		int left_pointer = l;
		int right_pointer = mid + 1;

		while ((left_pointer <= mid) && (right_pointer <= r)) {
			if (arr[left_pointer] > arr[right_pointer]) {
				tmp[pointer] = arr[right_pointer];
				pointer++;
				right_pointer++;
			}
			else {
				tmp[pointer] = arr[left_pointer];
				pointer++;
				left_pointer++;
			}
		}

		while (left_pointer <= mid) {
			tmp[pointer] = arr[left_pointer];
			pointer++;
			left_pointer++;
		}
		while (right_pointer <= r) {
			tmp[pointer] = arr[right_pointer];
			pointer++;
			right_pointer++;
		}

		// tmp => arr allocation
		for (int k = r; k >= l; k--) {
			pointer--;
			arr[k] = tmp[pointer];
		}
	}

}

