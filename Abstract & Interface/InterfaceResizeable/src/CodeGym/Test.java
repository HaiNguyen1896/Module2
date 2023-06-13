package CodeGym;

public class Test {
    public static void main(String[] args) {
        Test main = new Test();
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3);
        shapes[1] = new Rectangle(1, 3);
        shapes[2] = new Square(5);

        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                System.out.println("Circle");
            } else if (shape instanceof Rectangle) {
                System.out.println("Rectangle");
            } else {
                System.out.println("Square");
            }
            System.out.println("Before increasing");
            System.out.println(main.getArea(shape));
            double percent = Math.random() * 100;
            System.out.println("Percent= " + percent);
            shape.resizeable(percent);
            System.out.println("After Increasing");
            System.out.println(main.getArea(shape));
            System.out.println("---------------------------------------");
        }
    }

    public double getArea(Resizeable shape) {
        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            return Math.PI * circle.getRadius() * circle.getRadius();
        } else if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            return rectangle.getLength() * rectangle.getWidth();
        } else {
            Square square = (Square) shape;
            return square.getSide() * square.getSide();
        }
    }
}
