package algo;

public abstract class Tree {
	
	private static abstract class TNode {};
	
	public abstract void preOrderTraveling();
	
	public abstract void inOrderTraveling();
	
	public abstract void postOrderTraveling();
	
	public abstract void insert(Object e);
}
