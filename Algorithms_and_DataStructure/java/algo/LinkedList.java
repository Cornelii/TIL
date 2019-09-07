package algo;

public class LinkedList {
	
	private static class LLNode{
		Object val = null;
		LLNode prev = null;
		LLNode next = null;
		
		public LLNode() {}
		public LLNode(Object e) {
			this.val = e;
		}
	}
	
	LLNode head;
	LLNode tail;
	
	public LinkedList() {
		head = new LLNode();
		tail = head;
	}
	
	public void append(Object e) {}
	
	public void append(LinkedList arr) {}
	
	public Object pop() {}
	
	public Object peek(int idx) {}
	
	public void insert(Object e, int idx) {}
	
	public void insert(LinkedList arr, int idx) {}
	
	public void remove(int idx) {}
	
	public int find(Object e) {}
	
	public LLNode forward(int idx) {}
	
	public LLNode backward(int idx) {}
}
