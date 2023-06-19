package Codegym;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addFirst(10);
        list.addLast(20);

        list.add(1, 300);
        list.add(1, 200);
        list.showall();
        System.out.println("Lấy phần tử ở vị trí thứ 1");
        System.out.println(list.get(1));
        System.out.println("Xóa phần tử ở vị trí thứ 2");
        list.remove(2);
        list.showall();
//        System.out.println("Tìm index");
//        System.out.println(list.indexOf(10));
//        System.out.println("Kiểm tra");
//        System.out.println(list.contain(20));
//        System.out.println(list.contain(300));
//        System.out.println("Clone");
//        MyLinkedList copyLinked = list.clone();
//        copyLinked.showall();
    }
}
