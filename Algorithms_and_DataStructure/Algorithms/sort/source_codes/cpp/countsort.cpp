#include<iostream>
#include<cstring>

#define MAX_N 1000001

using namespace std;

int N, C[MAX_N];
//int arr[MAX_N], C[MAX_N], N;
//int ACM[MAX_N];

//void counting_sort_with_order(int a[]) {
//	memset(C, 0, sizeof(C));
//	memset(ACM, 0, sizeof(ACM));
//
//	for (int i = 0; i < N; i++) C[a[i]]++;
//
//	int tmp = 0;
//	for (int i = 0; i < MAX_N; i++) {
//		if (C[i]) {
//			tmp += C[i];
//			ACM[i] = tmp;
//		}
//	}
//
//	for(int i = 0; i < MAX_N; i++) {
//		if (C[i])
//			for (int j = 0; j < C[i]; j++) a[--ACM[i]] = i;
//	}
//}

//void counting_sort(int a[]) {
//	memset(C, 0, sizeof(C));
//
//	for (int i = 0; i < N; i++) C[a[i]]++;
//	int pt = 0;
//	for (int i = 0; i < MAX_N; i++) {
//		if (C[i])
//			for (int j = 0; j < C[i]; j++) a[pt++] = i;
//	}
//}


int main() {
	ios_base::sync_with_stdio(0); cin.tie(0);
	cin >> N;

	int dum;
	for (int i = 0; i < N; i++) {
		cin >> dum;
		C[dum]++;
	}
	for (int i = 0; i < MAX_N; i++) {
		if (C[i])
			for (int j = 0; j < C[i]; j++) cout << i << '\n';
	}
	
	return 0;
}
