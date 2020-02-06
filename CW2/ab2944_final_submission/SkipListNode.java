public class SkipListNode {
	public String element;
	public SkipListNode next;
	public SkipListNode down;
	public SkipListNode(String e, SkipListNode next, SkipListNode down) {
		element = e;
		this.next = next;
		this.down = down;
	}
}