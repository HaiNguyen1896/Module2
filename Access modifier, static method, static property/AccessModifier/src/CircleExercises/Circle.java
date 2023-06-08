package CircleExercises;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double r) {
        this.radius = r;
    }
    //Khi chuyển public -> private : không truy cập được từ class testCircle
    public double getRadius() {
        return this.radius;
    }
    //Khi chuyển public -> private : không truy cập được từ class testCircle
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
