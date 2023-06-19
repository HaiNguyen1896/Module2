package Codegym;

public class TestMyLinkedList {
    public static void main(String[] args) {
        System.out.println("------------Test---------------");
        MyLinkedList t1 = new MyLinkedList(10);
        t1.addFirst(12);
        t1.addFirst(13);
        t1.addFirst(14);
        t1.add(4, 25);
        t1.printList();
        t1.add(4, 300);
        t1.printList();
    }
}
