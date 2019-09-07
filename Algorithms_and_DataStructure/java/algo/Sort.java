package algo;

public class Sort {
	
	
	public static void main(String []args) {
		int [] testArr = new int[] {1, 5, 7, 8, 9, 1, 50, 2, 3, 95};
		
		for(int i = 0; i < 10; i++)
			System.out.print(testArr[i]+" ");
		System.out.println();
		
		// Test Part
		mergeSort(testArr, 10);
		
		for(int i = 0; i < 10; i++)
			System.out.print(testArr[i]+" ");
		System.out.println();
		
	}
	
	
	// Bubble Sort
	public void bubbleSort(int[] arr, int n) {

		int tmp;
		for(int i = 0; i < n-1;i++ ) {
			for(int j = 0; j < n-1-i; j++) {
				if(arr[j] > arr[j+1]) {
					tmp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
	
	
	// CountingSort
	public void countingSort(int[] arr, int n) {
		// get max value
		int maxVal = getMax(arr, n);
		
		// Counting Array
		int [] C = new int[maxVal+1];
		
		for(int i = 0; i < n; i++) {
			C[arr[i]]++;
		}
		
		// Accumulative Array
		int [] A = new int[maxVal+1];
		int dum = 0;
		for(int i = 0; i < maxVal+1; i++) {
			if(C[i] > 0) {
				dum += C[i];
				A[i] = dum;
			}
		}
		
		// Make Result Array
		int pointer;
		for(int i = 0; i < maxVal+1; i++) {
			if (C[i] > 0) {
				for(int j = 0; j < C[i]; j++) {
					A[i]--;
					pointer = A[i];
					arr[pointer] = i;
				}
			}
		}
		
	}
	
	private int getMax(int[] arr, int n) {
		int maxVal = arr[0];
		for (int i = 1; i < n; i++) {
			if(maxVal < arr[i]) maxVal = arr[i];
		}
		return maxVal;
	}
	
	
	// MergeSort
	public static void mergeSort(int[] arr, int n) {
		int[] b = new int[n/2+1];
		mergeSortDC(arr, b, 0, n-1);
	}
	
	public static void mergeSortDC(int[] arr, int[] b, int l, int r) {
		if(l >= r) return;
		
		int middle = (l+r)/2;
		mergeSortDC(arr, b, l, middle);
		mergeSortDC(arr, b, middle+1, r);
		
		if (arr[middle] <= arr[middle+1]) return;
		merge(arr, b, l, middle, r);
	}
	
	public static void merge(int[] arr, int[] b, int l, int middle, int r) {
		int main_p, left_p, right_p;
		int dum = middle-l+1;
		// copy from l to middle of arr into b;
		for (int k = 0; k < dum; k++) b[k] = arr[l+k];
		
		// pointer initialization
		main_p = l;
		left_p = 0;
		right_p = middle+1;
		
		while (right_p <= r && left_p < dum) {
			if(b[left_p] <= arr[right_p]) {
				arr[main_p] = b[left_p];
				left_p++;
			}else if(b[left_p] > arr[right_p]) {
				arr[main_p] = arr[right_p];
				right_p++;				
			}
			main_p++;
		}
		
		while(left_p < dum) {
			arr[main_p] = b[left_p];
			left_p++;
			main_p++;
		}
	}
	
	
	// Selection Sort
	
	
	// Insertion Sort
	
	// Quick Sort
	
	// Radix Sort
}
