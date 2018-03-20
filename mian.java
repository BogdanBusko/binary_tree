
public class mian {

	public static void main(String[] args) {
		AVLTree tree = new AVLTree(10);
		int countOfElements = (int)(Math.random() * 30) + 1;
		
		System.out.println("Empty: " + tree.empty());
		
		for (int i = 0; i < countOfElements; i++) {
			int data = (int)(Math.random() * 10) + 1;
			System.out.println(data + " ");
			tree.include(data);
		}
		
		System.out.println("Find: " + tree.find(10));
		System.out.println("Empty: " + tree.empty());
		
		tree.printData();
		System.out.println();
		System.out.println("Count of nodes: " + tree.numbel());
		
		tree.printData();
		System.out.println();
		tree.pop();
		System.out.println();		
		System.out.println("Sum:" + tree.accumulate('+'));
		System.out.println("Multiplication:" + tree.accumulate('*'));
		
		tree.include(100);
		tree.printData();
		
		System.out.println();
		
		tree.exclude(100);
		tree.printData();
		
		
	}

}
