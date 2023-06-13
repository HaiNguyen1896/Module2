package CodeGym;

public class Circle extends Shape {
    private double radius = 1.0;
    public Circle() {
    }
    public Circle(double radius){
        this.radius=radius;
    }
    public Circle(double radius, String color, boolean filled){
        super(color,filled);
        this.radius=radius;
    }
    public double getRadius(){
        return this.radius;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public double getArea(){
        return Math.PI*Math.pow(this.radius,2);
    }
    public double getPerimeter(){
        return 2*Math.PI*this.radius;
    }

    @Override
    public void resizeable(double percent) {
        this.radius *= (1+percent/100);
    }

    @Override
    public String toString() {
        return "a Circle with radius= "+getRadius()+" which is a subclass of "+ super.toString();
    }

}
