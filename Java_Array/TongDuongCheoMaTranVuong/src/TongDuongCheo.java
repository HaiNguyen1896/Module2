import java.util.Scanner;

public class TongDuongCheo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bạn hãy quy định số hàng cho ma trận vuông");
        int row = sc.nextInt();
        int col = row;
        double[][] arr = new double[row][col];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("Nhập giá trị cho phần từ arr[" + i + "][" + j + "]");
                arr[i][j] = sc.nextDouble();
            }
        }
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
            sum += arr[i][col - i - 1];
        }
        System.out.println(sum);
    }
}
