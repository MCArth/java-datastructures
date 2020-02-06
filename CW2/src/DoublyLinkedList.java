class DoublyLinkedList {
	private ListNode2 head = null;

	/**
	 * Prints out the elements in the list from the first to the last (front to back) and then from the last to the first
	 * (back to front). This is useful to test whether the list nodes are connected correctly with next and prev references.
	 */
	public void print() {
		// no elements to print for empty list
		if (head == null) {
			System.out.println("list empty.");
			return;
		}

		// follow next references to list elements from the front to the back of the list
		System.out.print("front to back: ");
		ListNode2 node = head;
		System.out.print(node.element + " ");
		while (node.next != null) {
			node = node.next;
			System.out.print(node.element + " ");
		}

		// follow prev references to list elements from the back to the front of the list
		System.out.print("-- and back to front: ");
		while (node != null) {
			System.out.print(node.element + " ");
			node = node.prev;
		}
		System.out.println();
	}

	public void addFirst(Object o) {
		head = new ListNode2(o, null, head);

		if (head.next != null) {
			head.next.prev = head;
		}
	}

	public Object get(int i) {
		ListNode2 obj = head;
		for(int j = 0; j < i; j++) {
			obj = obj.next;
		}
		return obj.element;
	}

	public void insert(Object o, int i) {
		ListNode2 obj = head;
		if (i==0) {
			addFirst(o);
			return;
		}

		for(int j = 0; j < i-1; j++) {
			obj = obj.next;
		}

		obj.next = new ListNode2(o, obj, obj.next);

		if(obj.next.next != null) {
			obj.next.next.prev = obj.next;
		}
	}

	public void remove(int i) {

		if (i==0) {
			head = head.next;
			if(head != null) {
				head.prev = null;
			}
			return;
		}

		ListNode2 obj = head;
		for(int j = 0; j < i-1; j++) {
			obj = obj.next;
		}

		obj.next = obj.next.next;
		if(obj.next != null) {
			obj.next.prev = obj;
		}
	}
}
