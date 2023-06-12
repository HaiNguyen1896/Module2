package CreateTriangleFromShape;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter side 1");
        double side1 = sc.nextDouble();
        System.out.println("Enter side 2");
        double side2 = sc.nextDouble();
        System.out.println("Enter side 3");
        double side3 = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter triangle's color");
        String color = sc.nextLine();
        
        Triangle triangle = new Triangle(side1, side2, side3);
        triangle.setColor(color);
        triangle.setFilled(true);
        System.out.println(triangle);
    }
}