public class AVLTreeTest {
	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		System.out.println(tree.inTree("5"));
		System.out.println(tree.inTree("1"));
		tree.createTestTree();
		tree.print();
		System.out.println(tree.inTree("5"));
		System.out.println(tree.inTree("1"));
		System.out.println(tree.inTree("10"));
		tree.insert("9");
		tree.insert("a");
		tree.insert("b");
		System.out.println();
		tree.print();

		System.out.println(tree.inTree("arthur"));


	}
}
