import java.util.Scanner;

public class TransferMoney {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tiền dollard");
        double dollard = sc.nextDouble();
        double rate = 23000;
        double Vnd = dollard * rate;
        System.out.println("Giá trị tiền chuyển từ USD sang VND là " + Vnd + " VND");
    }
}
