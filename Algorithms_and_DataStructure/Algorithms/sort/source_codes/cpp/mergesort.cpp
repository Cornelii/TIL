#include<iostream>

using namespace std;
int arr[1000001], b[500001], N;

void merge(int a[], int l, int r, int m);

void mergeSort(int a[], int l, int r) {
	if (l >= r) return;
	int m = (l + r) / 2;

	mergeSort(a, l, m);
	mergeSort(a, m + 1, r);
	
	merge(a, l, r, m);
}

void merge(int a[], int l, int r, int m) {
	int pt = 0;
	for (int i = l; i <= m; i++) b[pt++] = a[i];

	int xl, xr; xl = 0; xr = m+1;
	int rpt = l;
	while (xl < pt && xr <= r) {
		if (b[xl] > a[xr]) a[rpt++] = a[xr++];
		else a[rpt++] = b[xl++];
	}

	while (xl < pt)
		a[rpt++] = b[xl++];
	while (xr <= r)
		a[rpt++] = a[xr++];
}

int main() {
	ios_base::sync_with_stdio(0); cin.tie(0);
	cin >> N;

	for (int i = 0; i < N; i++) cin >> arr[i];
	mergeSort(arr, 0, N - 1);

	for (int i = 0; i < N; i++) cout << arr[i] << '\n';

	return 0;
}include<iostream>

using namespace std;
int arr[1000001], b[500001], N;

void merge(int a[], int l, int r, int m);

void mergeSort(int a[], int l, int r) {
	if (l >= r) return;
	int m = (l + r) / 2;

	mergeSort(a, l, m);
	mergeSort(a, m + 1, r);
	
	merge(a, l, r, m);
}

void merge(int a[], int l, int r, int m) {
	int pt = 0;
	for (int i = l; i <= m; i++) b[pt++] = a[i];

	int xl, xr; xl = 0; xr = m+1;
	int rpt = l;
	while (xl < pt && xr <= r) {
		if (b[xl] > a[xr]) a[rpt++] = a[xr++];
		else a[rpt++] = b[xl++];
	}

	while (xl < pt)
		a[rpt++] = b[xl++];
	while (xr <= r)
		a[rpt++] = a[xr++];
}

int main() {
	ios_base::sync_with_stdio(0); cin.tie(0);
	cin >> N;

	for (int i = 0; i < N; i++) cin >> arr[i];
	mergeSort(arr, 0, N - 1);

	for (int i = 0; i < N; i++) cout << arr[i] << '\n';

	return 0;
}
