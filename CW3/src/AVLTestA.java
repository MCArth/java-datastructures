public class AVLTestA{
    public static void main(String[] args) {
        AVLTree t = new AVLTree();
	t.createTestTree();
	t.print();
	t.insert("1.5");
	t.print();
	t.insert("7.5");
	t.insert("8.5");
	t.print();
    }
}
