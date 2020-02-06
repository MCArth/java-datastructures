public class DoublyLinkedListTestA {
    public static void main(String[] args) {
        DoublyLinkedList l = new DoublyLinkedList();
        System.out.println("Adding apple, pear, orange");
        l.addFirst("apple");
        l.addFirst("pear");
        l.addFirst("orange");
        System.out.println("Should be: front to back: orange pear apple -- and back to front: apple pear orange");
        l.print();
	}
}
