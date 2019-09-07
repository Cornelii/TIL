package algo;

public class Queue<T> {
	
	private static class QNode<T> extends Node<T>{
		QNode<T> next = null;
		
		protected QNode() {}
		protected QNode(T _val) {
			this.val = _val;
		}
	}
	
	QNode<T> head;
	QNode<T> tail;
	
	public Queue() {
		head = new QNode<T>();
		tail = new QNode<T>();
		head = tail;
	}
	
	public void enqueue(T _val) {
		QNode<T> new_node = new QNode<T>(_val);
		tail.next = new_node;
		tail = new_node;
	}
	
	public T dequeue() throws Exception {
		if (this.isEmpty()) throw new Exception("No element");
		head = head.next;
		return head.val;
	}
	
	public boolean isEmpty() {
		return head == tail;
	}
	
	public T peek() throws Exception{
		if(this.isEmpty()) throw new Exception("No element");
		return head.next.val;
	}
}
