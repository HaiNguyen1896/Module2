import java.util.Scanner;

public class GiaiPTBacNhat {
    public static void main(String[] args) {
        System.out.println("Giải phương trình tuyến tính");
        System.out.println("Giải phương trình a*x+b=c, hãy nhập vào hằng số");
        Scanner sc = new Scanner(System.in);
        System.out.println("a: ");
        double a = sc.nextDouble();
        System.out.println("b: ");
        double b = sc.nextDouble();
        System.out.println("c: ");
        double c = sc.nextDouble();
        if (a != 0) {
            double answer = (c - b) / a;
            System.out.printf("Giá trị của x=%f\n ", answer);
        } else {
            if (b == c) {
                System.out.println("x vô số nghiệm");
            } else {
                System.out.println("Vô nghiệm");
            }
        }
    }
}
