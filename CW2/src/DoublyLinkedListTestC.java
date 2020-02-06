public class DoublyLinkedListTestC {
    public static void main(String[] args) {
        DoublyLinkedList l = new DoublyLinkedList();

        System.out.println("Adding kiwifruit, pear, apple, orange");
        l.addFirst("kiwifruit");
        l.addFirst("pear");
        l.addFirst("apple");
        l.addFirst("orange");

        System.out.println("Removing item 0");
        l.remove(0);
        System.out.println("Should be: front to back: apple pear kiwifruit -- and back to front: kiwifruit pear apple");
        l.print();
        System.out.println();

        System.out.println("Removing item 1");
        l.remove(1);
        System.out.println("Should be: front to back: apple kiwifruit -- and back to front: kiwifruit apple");
        l.print();
        System.out.println();

        System.out.println("Removing item 1");
        l.remove(1);
        System.out.println("Should be: front to back: apple -- and back to front: apple");
        l.print();
        System.out.println();

        System.out.println("Removing item 0");
        l.remove(0);
        System.out.println("Adding 'orange'");
        l.addFirst("orange");
        System.out.println("Should be: front to back: orange -- and back to front: orange");
        l.print();
    }
}
