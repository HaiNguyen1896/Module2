package Geometric;

public class SquareTest {
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square);
        square = new Square(10.5);
        System.out.println(square);
        square = new Square(12.5,"red",false);
        System.out.println(square);
    }
}
