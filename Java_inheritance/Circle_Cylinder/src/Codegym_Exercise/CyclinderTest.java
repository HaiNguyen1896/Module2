package Codegym_Exercise;

public class CyclinderTest {
    public static void main(String[] args) {
        Cyclinder cyclinder = new Cyclinder();
        System.out.println(cyclinder);
        cyclinder = new Cyclinder(10, 12.5, "Purple");
        System.out.println(cyclinder);
        cyclinder.setHeight(15);
        System.out.println(cyclinder);

    }
}
