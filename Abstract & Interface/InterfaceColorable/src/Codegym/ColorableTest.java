package Geometric.Codegym;

public class ColorableTest {
    public static void main(String[] args) {
        Shape[]shapes=new Shape[5];
        shapes[0]=new Circle();
        shapes[1]=new Rectangle();
        shapes[2]=new Circle(4);
        shapes[3]=new Square();
        shapes[4]=new Rectangle(4,3);
        for(Shape shape:shapes){
            if(shape instanceof Square){
                Square square = (Square) shape;
                square.howtoColor();
            }else{
                System.out.println(shape.getArea());
            }
        }

    }

}
