package Codegym;

public class MyListTest {
    public static void main(String[] args) {
        MyList mylist = new MyList();
        mylist.add(14);
        mylist.add(15);
        mylist.add(55);
        System.out.println("Giá trị ban đầu của Mảng:");
        mylist.printall();
        System.out.println("Giá trị sau khi loại bỏ phần tử:");
        mylist.remove(1);
        mylist.printall();
        System.out.println("Số lượng phần tử trong mảng:");
        System.out.println(mylist.size());
        System.out.println("Kiểm tra có chứa phần tử:");
        System.out.println(mylist.contains(14));
        System.out.println("Trả về chỉ số phần tử:");
        System.out.println(mylist.indexOf(55));
        System.out.println("Chèn phần tử vào cuối mảng");
        System.out.println(mylist.add(500));
        System.out.println("Mảng sau khi chèn phần tử vào cuối");
        mylist.printall();
        System.out.println("Lấy giá trị phần tử");
        System.out.println(mylist.get(1));
        System.out.println("Copy mảng");
        MyList cloneList = mylist.clone();
        cloneList.printall();
        mylist.remove(1);



    }

}
