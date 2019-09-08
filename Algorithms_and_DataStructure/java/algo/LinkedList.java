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
	
	public void append(Object e) {
		LLNode newNode = new LLNode(e);
		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
	}
	
	public void append(LinkedList arr) {
		tail.next = arr.head.next;
		arr.head.next.prev = tail;
		tail = arr.tail;
		arr.head.next = null;
	}
	
	public Object pop() throws Exception{
		if(isEmpty()) throw new Exception("No Element");
		tail = tail.prev;
		tail.next.prev = null;
		return tail.next.val;
	}
	
	public boolean isEmpty() {
		return head == tail;
	}
	
	public LLNode forward(int idx) throws Exception {
		LLNode nodePointer;
		if(isEmpty()) throw new Exception("No Element");
		
		if(idx < 0) {
			nodePointer = backward(-(idx+1));
			return nodePointer;
		}
		
		nodePointer = head.next;
		for(int i = 0; i < idx; i++) {
			try {
				nodePointer = nodePointer.next;
			}catch (Exception e){
				throw e;
			}
		}
		return nodePointer;
	}
	
	public LLNode backward(int idx) throws Exception {
		LLNode nodePointer;
		if(idx < 0) {
			nodePointer = forward(-(idx+1));
			return nodePointer;
		}
		
		nodePointer = tail;
		for(int i = 0; i < idx; i++) {
			try {
				nodePointer = nodePointer.prev;
			}catch (Exception e){
				throw e;
			}
		}
		return nodePointer;
	}
	
	public void insert(Object o, int idx) throws Exception {
		LLNode NodePointer = forward(idx);
		LLNode newNode = new LLNode(o);
		NodePointer = NodePointer.prev;
		
		newNode.prev = NodePointer;
		newNode.next = NodePointer.next;
		NodePointer.next.prev = newNode;
		NodePointer.next = newNode;
	}
	
	public void insert(LinkedList arr, int idx) throws Exception {
		LLNode NodePointer = forward(idx);
		NodePointer = NodePointer.prev;
		
		arr.head.next.prev = NodePointer;
		arr.tail.next = NodePointer.next;
		NodePointer.next.prev = arr.tail;
		NodePointer.next = arr.head.next;
	}
	
	public void remove(int idx) throws Exception{
		LLNode NodePointer = forward(idx);
		NodePointer = NodePointer.prev;
		
		NodePointer.next.next.prev = NodePointer;
		NodePointer.next = NodePointer.next.next;
	}
	
	public int find(Object e) throws Exception {
		int idx = 0;
		LLNode NodePointer;
		if(isEmpty()) throw new Exception("No Element");
		NodePointer = head.next;
		while(NodePointer != tail) {
			if(NodePointer.val == e) return idx;
			NodePointer = NodePointer.next;
			idx++;
		}
		return -1;		
	}
	
	public Object elementAt(int idx) throws Exception{
		LLNode NodePointer = forward(idx);
		return NodePointer.val;
	}
}
