import java.util.Random;

public class SkipList {
    private SkipListNode head;
    private int n = 0; // list size
	private int skipLHeight = 0;

    public SkipList() {
        head = new SkipListNode(null, null, null);
		head = new SkipListNode(null, null, head);
		head = new SkipListNode(null, null, head);
		head = new SkipListNode(null, null, head);
		head = new SkipListNode(null, null, head);

		skipLHeight = 5;
    }

    public void createTestList() {


		SkipListNode Anne1 = new SkipListNode("Anne", null, null);
		SkipListNode Ben1 = new SkipListNode("Ben", null, null);
		SkipListNode Charlie1 = new SkipListNode("Charlie", null, null);
		SkipListNode Don1 = new SkipListNode("Don", null, null);
		SkipListNode Ernie1 = new SkipListNode("Ernie", null, null);

		SkipListNode Anne2 = new SkipListNode("Anne", null, null);
		SkipListNode Charlie2 = new SkipListNode("Charlie", null, null);
		SkipListNode Ernie2 = new SkipListNode("Ernie", null, null);

		SkipListNode Anne3 = new SkipListNode("Anne", null, null);
		SkipListNode Ernie3 = new SkipListNode("Ernie", null, null);

		SkipListNode node = head.down.down;
		node.next = Anne3;
		node.down.next = Anne2;
		node.down.down.next = Anne1;

		Anne1.next = Ben1;
		Ben1.next = Charlie1;
		Charlie1.next = Don1;
		Don1.next = Ernie1;

		Anne2.down = Anne1;
		Anne2.next = Charlie2;
		Charlie2.down = Charlie1;
		Charlie2.next = Ernie2;
		Ernie2.down = Ernie1;

		Anne3.down = Anne2;
		Anne3.next = Ernie3;
		Ernie3.down = Ernie2;
    }

    public void print() {
    	SkipListNode node = head;
    	SkipListNode start = head;
    	boolean emptyRow = true;
		while(start != null) {
			boolean first = true;
			node = start;
			if(node.next != null) {
				emptyRow = false;
			}
			while(node.next != null) {
				if(!first) {
					System.out.print(",");
				}
				node = node.next;
				System.out.print(node.element);
				first = false;
			}
			if(!emptyRow) {
				System.out.println();
			}
			emptyRow = true;
			start = start.down;
		}
    }

    public boolean inList(String o) {
        SkipListNode obj = head;
        while(!(obj.next == null && obj.down == null)) {
        	while(obj.next != null && obj.next.element.compareTo(o) <= 0) {
				obj = obj.next;
				if(obj.element.equals(o)) {
					return true;
				}
			}
			obj = obj.down;
		}
        return false;
    }

    public void insert(String o) {

		Random ran = new Random();
		int eleHeight = 1;
		double r = ran.nextInt(2);

		while(r == 1) {
			eleHeight++;
			r = ran.nextInt(2);
		}

		int currHeight = skipLHeight;
		SkipListNode prevUpNode = null;

		SkipListNode obj = head;

		while(true) {

			while(obj.next != null && obj.next.element.compareTo(o) <= 0) {
				obj = obj.next;
			}

			if(currHeight <= eleHeight) {
				obj.next = new SkipListNode(o, obj.next, null);
				if(prevUpNode != null) {
					prevUpNode.down = obj.next;
				}
				prevUpNode = obj.next;

				if(currHeight == 1) {
					break;
				}
			}

			obj = obj.down;
			currHeight--;

		}
    }
}
