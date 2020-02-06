class AVLTree {
	AVLTreeNode root;
	// Note: you may define other variables here

	public AVLTree() {
		root = null;
	}

	public void createTestTree() {
		insertBalanced("1");
		insertBalanced("2");
		insertBalanced("3");
		insertBalanced("4");
		insertBalanced("5");
		insertBalanced("6");
		insertBalanced("7");
	}

	public void print() {
		recursivePrint(root, 0);
	}

	private void recursivePrint(AVLTreeNode node, int h) {
		if(node == null) {
			return;
		}

		for(int i = 0; i < h; i++) {
			System.out.print(" ");
		}
		System.out.println(node.value);
		recursivePrint(node.left, h+1);
		recursivePrint(node.right, h+1);

	}

	public boolean inTree(String e) {
		AVLTreeNode node = root;
		while(node != null) {
			if(e.compareTo(node.value) < 0) {
				node = node.left;
			}
			else if(e.compareTo(node.value) > 0) {
				node = node.right;
			}
			else if(e.compareTo(node.value) == 0) {
				return true;
			}
		}
		return false;
	}

	public void insert(String e) {
		if(root == null) {
			root = new AVLTreeNode(null, null, e);
			return;
		}

		AVLTreeNode node = root;

		while(node != null) {
			if(e.compareTo(node.value) < 0) {
				if(node.left == null) {
					node.left = new AVLTreeNode(null, null, e);
					return;
				}
				node = node.left;
			}
			else if(e.compareTo(node.value) > 0) {
				if(node.right == null) {
					node.right = new AVLTreeNode(null, null, e);
					return;
				}
				node = node.right;
			}
			else
				return;
		}
	}

	public void insertBalanced(String e) {
		AVLTreeNode node = root;

		root = insertRecursive(root, e);

	}

	private int balance(AVLTreeNode node) {
		return getHeight(node.right) - getHeight(node.left);
	}

	private int getHeight(AVLTreeNode node) {
		return node != null ? node.height : 0;
	}

	private int max(int l, int r) {
		return l>r ? l:r;
	}

	private AVLTreeNode rotateLeft(AVLTreeNode node) {
		AVLTreeNode node2 = node.right;
		AVLTreeNode rightleft = node2.left;

		node.right = rightleft;
		node2.left = node;

		node.height = max(getHeight(node.left), getHeight(node.right)) + 1;
		node2.height = max(getHeight(node2.left), getHeight(node2.right)) + 1;

		return node2;
	}

	private AVLTreeNode rotateRight(AVLTreeNode node) {
		AVLTreeNode node2 = node.left;
		AVLTreeNode leftright = node2.right;

		node.left = leftright;
		node2.right = node;

		node.height = max(getHeight(node.left), getHeight(node.right)) + 1;
		node2.height = max(getHeight(node2.left), getHeight(node2.right)) + 1;

		return node2;
	}

	public AVLTreeNode insertRecursive(AVLTreeNode node, String value) {
		if(node == null) {
			return new AVLTreeNode(null, null, value);
		}
		else if(value.compareTo(node.value) < 0) {
			node.left = insertRecursive(node.left, value);
		}
		else if(value.compareTo(node.value) > 0) {
			node.right = insertRecursive(node.right, value);
		}
		else {
			return node;
		}

		node.height = max(getHeight(node.left), getHeight(node.right)) + 1;

		int balance = balance(node);

		if(balance > 1) {
			if(node.right != null && value.compareTo(node.right.value) < 0) {
				node.right = rotateRight(node.right);
			}
			return rotateLeft(node);
		}
		if(balance < -1) {
			if(node.left != null && value.compareTo(node.left.value) > 0) {
				node.left = rotateLeft(node.left);
			}
			return rotateRight(node);
		}

		return node;
	}
}