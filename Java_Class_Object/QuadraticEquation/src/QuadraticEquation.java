import java.util.Scanner;

public class QuadraticEquation {
    private double a, b, c;

    QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    double geta() {
        return a;
    }

    double getb() {
        return b;
    }

    double getc() {
        return c;
    }

    double getDiscriminant() {
        return Math.pow(this.b, 2) - 4 * this.a * this.c;
    }

    double getRoot1() {
        return (-b + Math.sqrt(Math.pow(this.b, 2) - 4 * this.a * this.c)) / 2 * this.a;
    }

    double getRoot2() {
        return (-b - Math.sqrt(Math.pow(this.b, 2) - 4 * this.a * this.c)) / 2 * this.a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the constant a");
        double a = sc.nextDouble();
        System.out.println("Enter the constant b");
        double b = sc.nextDouble();
        System.out.println("Enter the constant c");
        double c = sc.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        double delta = quadraticEquation.getDiscriminant();
        if (delta < 0) {
            System.out.println("The equation has no roots");
        } else if (delta == 0) {
            double x1 = -quadraticEquation.getb() / (2 * quadraticEquation.geta());
            x1 = Math.round(x1 * 100.0) / 100.0;
            System.out.println("The equation has the same roots value x1=x2= " + x1);
        } else {
            double x1 = quadraticEquation.getRoot1();
            double x2 = quadraticEquation.getRoot2();
            x1 = Math.round(x1 * 100.0) / 100.0;
            x2 = Math.round(x2 * 100.0) / 100.0;
            System.out.println("The equation has 2 roots: x1=" + x1 + " and x2=" + x2);
        }
    }
}
