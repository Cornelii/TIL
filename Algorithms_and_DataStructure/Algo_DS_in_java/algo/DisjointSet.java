package algo;

class DisjSet {
	int [] array;
	int size;
	
	public DisjSet(int size) {
		this.size = size;
		this.array = new int[size+1];
		
		for(int i = 0; i < size+1; i++) {
			this.array[i] = i;
		}
	}
	
	public int find_set(int member) {
		int head;
		if (array[member] == member) return member;
		else head = find_set(array[member]);
		
		if (member != head) array[member] = head;
		return head;
	}
	
	public void union_set(int subX, int superY) {
		array[find_set(subX)] = find_set(superY);
	}
}


public class DisjointSet {
	public static void main(String[] args) {
		
		int [] dSet = new int[10];
		init_set(dSet, 10);
		
		System.out.println("initial State");
		print(dSet, 10);
		
		union_set(dSet, 2, 5);
		union_set(dSet, 4, 2);
		union_set(dSet, 3, 6);
		union_set(dSet, 1, 4);
		print(dSet, 10);
		
		System.out.println(find_set(dSet, 3));
		System.out.println(find_set(dSet, 2));
		System.out.println(find_set(dSet, 7));
		union_set(dSet,5,6);
		print(dSet, 10);
		System.out.println(find_set(dSet, 3));
		System.out.println(find_set(dSet, 2));
		System.out.println(find_set(dSet, 7));

		
		DisjSet dSet2 = new DisjSet(10);
		
		System.out.println("Class DisjointSet");
		print(dSet2.array, 11);
		
		dSet2.union_set(2,  5);
		dSet2.union_set(4, 2);
		dSet2.union_set(3,  6);
		dSet2.union_set(1,  4);
		print(dSet2.array, 10);
		
		System.out.println(dSet2.find_set(3));
		System.out.println(dSet2.find_set(2));
		System.out.println(dSet2.find_set(7));
		dSet2.union_set(5, 6);
		print(dSet2.array, 11);
		System.out.println(dSet2.find_set(3));
		System.out.println(dSet2.find_set(2));
		System.out.println(dSet2.find_set(7));
		
	}
	
	public static void init_set(int[] arr, int n) {
		for(int i = 0; i < n; i++) arr[i] = i;
	}
	
	public static int find_set(int[] arr, int elem) {
		int head;
		if(arr[elem] == elem) return elem;
		else head = find_set(arr, arr[elem]);
		if (head != elem) arr[elem] = head;
		return head;
	}
	
	public static void union_set(int[] arr, int subSet, int superSet) {
		arr[find_set(arr, subSet)] = find_set(arr, superSet);
	}
	
	
	
	
	public static void print(int[] arr, int n) {
		for(int i: arr) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
}
