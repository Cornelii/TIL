package algo;

public class PenwickTree {
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {6, 4, 13, 2, 0, -5, 13};
		int[] penwickTree = new int[20];
		
		for(int i = 1; i <= arr.length; i++) {
			update(penwickTree, arr[i-1], i, arr.length+1);
		}
		
		for(int i = 0; i < 20; i++) {
			System.out.print(penwickTree[i]+" ");
		}
		System.out.println();
		
		System.out.println(query(penwickTree, 1));
		System.out.println(partSum(penwickTree, 2, 6));
	}
	
	public static void update(int[] pT, int val, int n, int N) {
		while(n <= N) {
			pT[n] += val;
			n += n&(-n);
		}
	}
	
	public static int query(int[] pT, int n) {
		int Sum = 0;
		while(n > 0) {
			Sum += pT[n];
			n -= n&-n;
		}
		return Sum;
	}
	
	public static int partSum(int[] pT, int left, int right) {
		return query(pT, right) - query(pT, left-1);
	}
	
}
