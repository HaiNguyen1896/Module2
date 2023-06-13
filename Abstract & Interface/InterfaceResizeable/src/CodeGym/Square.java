package CodeGym;

import CodeGym.Shape;

public class Square extends Shape {
    private double side=1;
    public Square(){
    }
    public Square(double side){
        this.side=side;
    }
    public Square(double side,String color,boolean filled){
        this.side= side;
        this.color = color;
        this.filled=filled;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public void resizeable(double percent) {
        this.side*=(1+percent/100);
    }


    @Override
    public String toString(){
        return "A Square with side= "+getSide()+ " which is a subclass of "+super.toString();
    }
}
