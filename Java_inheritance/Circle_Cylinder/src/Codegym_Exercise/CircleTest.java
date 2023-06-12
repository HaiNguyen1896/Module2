package Codegym_Exercise;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
        circle = new Circle(10.5, "Pink");
        System.out.println(circle);
        circle.setRadius(20.5);
        System.out.println(circle);
    }
}
