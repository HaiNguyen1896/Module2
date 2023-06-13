package Geometric.Codegym;

public class Square extends Shape implements Colorable  {
    private double side = 1;

    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public Square(double side, String color, boolean filled) {
        this.side = side;
        this.color = color;
        this.filled = filled;
    }

    public double getSide() {
        return this.side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return this.side*this.side;
    }

    public void howtoColor() {
        System.out.println("Color all four sides");
    }

    @Override
    public String toString() {
        return "A Square with side= " + getSide() + " which is a subclass of " + super.toString();
    }

}
