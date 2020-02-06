public class AVLTreeNode {
	AVLTreeNode left, right;
	int height;
	String value;

	public AVLTreeNode(AVLTreeNode left, AVLTreeNode right, String value) {
		this.left = left;
		this.right = right;
		this.value = value;
		height = 1;
	}
}
