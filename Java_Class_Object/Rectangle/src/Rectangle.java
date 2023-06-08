import java.util.Scanner;

public class Rectangle {
    double width, height;
    public Rectangle(){
    }
    public Rectangle(double width, double height){
        this.width=width;
        this.height=height;
    }
    public double getArea(){
        return this.width*this.height;
    }
    public double getPerimeter(){
        return (this.width+this.height)*2;
    }
    public String display(){
        return "Rectangle{"+"width="+this.width+",height="+this.height+"}";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập bề rộng HCN");
        double width = sc.nextDouble();
        System.out.println("Nhập chiều cao HCN");
        double height = sc.nextDouble();
        Rectangle rectangle = new Rectangle(width,height);
        System.out.println("Kích thước hình chữ nhật: "+rectangle.display());
        System.out.println("Diện tích hình chữ nhật "+rectangle.getArea());
        System.out.println("Chu vi hình chữ nhật "+rectangle.getPerimeter());
    }
}
