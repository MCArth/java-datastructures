public class LinkedList {
	// Any header stuff

	private ListNode head = null;
	private ListNode tail = null;
	//private int n = 0; // list size


	public void addFirst(Object o) {
		head = new ListNode(o, head);
		if(head.next == null) {
			tail = head;
		}
	}

	public Object get(int i) {
		ListNode obj = head;
		for(int j = 0; j < i; j++) {
			obj = obj.next;
		}
		return obj.element;
	}

	public void insert(Object o, int i) {
		ListNode obj = head;
		if (i==0) {
			addFirst(o);
			return;
		}

		for(int j = 0; j < i-1; j++) {
			obj = obj.next;
		}
		obj.next = new ListNode(o, obj.next);
		if(obj == tail) {
			tail = obj.next;
		}
	}

	public void remove(int i) {

		if (i==0) {
			head = head.next;
			return;
		}

		ListNode obj = head;
		for(int j = 0; j < i-1; j++) {
			obj = obj.next;
		}

		if(obj.next == tail) {
			tail = obj;
		}
		obj.next = obj.next.next;
	}

	public void add(Object o) {
		ListNode toAdd = new ListNode(o, null);
		if(head != null) {
			tail.next = toAdd;
		}
		else {
			head = toAdd;
		}
		tail = toAdd;
	}
}
