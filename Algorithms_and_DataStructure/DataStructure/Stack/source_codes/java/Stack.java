package algo;


public class Stack<T> {
	
	private static class SNode<T> extends Node<T>{
		SNode<T> prev = null;
		
		public SNode() {}
		public SNode(T _val){
			this.val = _val;
		}
	}
	
	SNode<T> head;
	SNode<T> top;
	
	public Stack() {
		head = new SNode<T>();
		top = new SNode<T>();
		top = head;
		}
	
	public void push(T _val) {
		SNode<T> newNode = new SNode<T>(_val);
		newNode.prev = top;
		top = newNode;
	}
	
	public T pop() throws Exception{
		if (this.isEmpty()) throw new Exception("No element");
		T tmp;
		tmp = top.val;
		top = top.prev;
		return tmp;
	}
	
	public T peek() throws Exception{
		if (this.isEmpty()) throw new Exception("No element");
		return top.val;
	}
	
	public boolean isEmpty() {
		return head == top;
	}
	
}
