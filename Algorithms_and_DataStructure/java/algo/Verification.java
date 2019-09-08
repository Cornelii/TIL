package algo;

public class Verification {
	
	public static void main(String[] args) throws Exception {
		Stack<String> stack = new Stack<String>();
		
		stack.push("No way");
		stack.push("Yes way");
		
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
		
		
		System.out.println();
		System.out.println("Queue Test");
		
		Queue<Double> queue = new Queue<Double>();
		System.out.println(queue.isEmpty());
		
		queue.enqueue(5.4);
		queue.enqueue(new Double(7.5));
		
		System.out.println(queue.peek());
		System.out.println(queue.dequeue());
		System.out.println(queue.isEmpty());
		System.out.println(queue.dequeue());
		System.out.println(queue.isEmpty());
		
		System.out.println("LinkedList Test");
		
		LinkedList myList = new LinkedList();
		myList.append(5);
		myList.append(7.7);
		System.out.println(myList.elementAt(0));
		System.out.println(myList.elementAt(1));
		
		myList.insert("Hello World", 0);
		System.out.println(myList.elementAt(0));
		
		System.out.println(myList.elementAt(-1));
	}
}
