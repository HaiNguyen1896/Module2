package Codegym_Exercise;

public class Cyclinder extends Circle {
    private double height = 1;

    public Cyclinder() {
    }

    public Cyclinder(double height, double radius, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return super.getArea() * this.height;
    }

    @Override
    public String toString() {
        return " Cyclinder{" +
                "radius=" + super.getRadius() +
                ", color='" + super.getColor() + '\'' +
                ", height= " + this.getHeight() + '\'' +
                ", Volume='" + this.getVolume() + '\'' +
                "Which is a subclass of " + super.toString() +
                '}';
    }
}
