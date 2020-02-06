public class DoublyLinkedListTestB {
    public static void main(String[] args) {
        DoublyLinkedList l = new DoublyLinkedList();

        System.out.println("Inserting 'orange'");
        l.insert("orange", 0);
        System.out.println("Should be: front to back: orange -- and back to front: orange");
        l.print();
        System.out.println();

        System.out.println("Inserting 'apple' at 1");
        l.insert("apple", 1);
        System.out.println("Should be: front to back: orange apple -- and back to front: apple orange");
        l.print();
        System.out.println();

        System.out.println("Inserting 'pear' at 1");
        l.insert("pear", 1);
        System.out.println("Should be: front to back: orange pear apple -- and back to front: apple pear orange");
        l.print();
        System.out.println();

        System.out.println("Inserting 'kiwifruit' at 3");
        l.insert("kiwifruit", 3);
        System.out.println("Should be: front to back: orange pear apple kiwifruit -- and back to front: kiwifruit apple pear orange");
        l.print();
        System.out.println();

        System.out.println("Inserting 'banana' at 2");
        l.insert("banana", 2);
        l.print();
        System.out.println("Should be: front to back: orange pear banana apple kiwifruit -- and back to front: kiwifruit apple banana pear orange");
        System.out.println();
    }
}
