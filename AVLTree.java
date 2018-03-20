import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
	private int value;
	private AVLTree left;
	private AVLTree right;
	
	public AVLTree(int value) {
		this.value = value;
		right = null;
		left = null;
	}
	
	// Recursive functions
	private int recursiveNumbel(AVLTree obj) {
		if (obj == null) return 0;
		return 1 + recursiveNumbel(obj.left) + recursiveNumbel(obj.right);
	}
	
	private AVLTree recursiveInclude(AVLTree obj, int value) {
		if (obj == null) {
			return new AVLTree(value);
		}
		
		if (value < obj.value) {
			obj.left = recursiveInclude(obj.left, value);
		} else if (value > obj.value) {
			obj.right = recursiveInclude(obj.right, value);
		} else {
			return obj;
		}
		
		return obj;
	}
	
	private boolean recursiveFind(AVLTree obj, int value) {
		if(obj == null) {
			return false;
		}
		
		if (obj.value == value) { 
			return true;
		}
		
		return value < obj.value ? recursiveFind(obj.left, value) : recursiveFind(obj.right, value);
	}
	
	private AVLTree recursiveExclude(AVLTree obj, int value) {
		if (obj == null) {
			return null;
		}
		
		if (value == obj.value) {
			if (obj.left == null && obj.right == null) {
			    return null;
			}
			
			if (obj.right == null) {
			    return obj.left;
			}
			 
			if (obj.left == null) {
			    return obj.right;
			}
			
			int smallestValue = findSmallestValue(obj.right);
			obj.value = smallestValue;
			obj.right = recursiveExclude(obj.right, smallestValue);
		}
		
		if (value < obj.value) { 
			obj.left = recursiveExclude(obj.left, value);
			return obj;
		}
		
		obj.right = recursiveExclude(obj.right, value);		
		return obj;
	}
	
	private int findSmallestValue(AVLTree obj) {
		return obj.left == null ? obj.value : findSmallestValue(obj.left);
	}
	
	private void recursivePop(AVLTree obj) {
		if (obj != null) {
			recursivePop(obj.left);
			recursivePop(obj.right);
			System.out.print(obj.value + " ");
		}
	}
	
	private long recursiveAccumulate(AVLTree obj, char operation) {
		if (obj == null) {
			System.out.println("Tree is empty");
			return -1;
		}
		Queue<AVLTree> queue = new LinkedList<AVLTree>();
		queue.offer(obj);
		if (operation == '+') {
			long totalSum = 0;
			while (!queue.isEmpty()) {
				AVLTree node = queue.poll();
				totalSum += node.value;
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			return totalSum;
		} else if (operation == '*') {
			long totalMultiplication = 1;
			while (!queue.isEmpty()) {
				AVLTree node = queue.poll();
				totalMultiplication *= node.value;
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			return totalMultiplication;
		}
		
		return 0;
	}
	
	// Public methods
	/**
	 * lkjcfblkjcg.kjglkjb
	 * 
	 * @param value
	 */
	public void include(int value) {
		recursiveInclude(this, value);
	}
	
	/**
	 * jdvkjdvkjdfjldflkdf
	 * 
	 * @param operation
	 * @return 
	 */
	public long accumulate(char operation) {
		return recursiveAccumulate(this, operation);
	}
	
	public int numbel() {
		return recursiveNumbel(this);
	}
	
	public boolean empty() { 
		 return (recursiveNumbel(this) - 1) == 0 ;
	}
	
	public boolean find(int value) { 
		return recursiveFind(this, value);
	}
	
	public void exclude(int value) {
		recursiveExclude(this, value);
	}
	
	public void pop() { 
		recursivePop(this);
	}
	
	public void printData() {
		if (left != null) {
			left.printData();
		}
		
		System.out.print(value + " ");
		
		if (right != null) {
			right.printData();
		}
	}	
}
