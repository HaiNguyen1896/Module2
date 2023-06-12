package Geometric;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);
        rectangle = new Rectangle(10,10);
        System.out.println(rectangle);
        rectangle = new Rectangle(10,20,"red",false);
        System.out.println(rectangle);
    }
}
