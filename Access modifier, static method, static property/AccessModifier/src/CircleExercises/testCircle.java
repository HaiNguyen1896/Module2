package CircleExercises;

public class testCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle(7.5);
        Circle c2 = new Circle();
        System.out.println("circle c1's radius= " + c1.getRadius());
        System.out.println("circle c1's area= " + Math.round(c1.getArea() * 100.0) / 100.0);
        System.out.println("circle c1's radius= " + c2.getRadius());
        System.out.println("circle c1's area= " + Math.round(c2.getArea() * 100.0) / 100.0);
    }


}
