import java.util.Scanner;

public class SumOfCollumn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bạn hãy quy định số hàng cho ma trận");
        int row = sc.nextInt();
        System.out.println("Bạn hãy quy định số cột cho ma trận");
        int col = sc.nextInt();
        double[][] arr =new double[row][col];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("Nhập giá trị cho phần từ arr["+i+"]["+j+"]");
                arr[i][j]= sc.nextDouble();
            }
        }
        System.out.println("Nhập vị trí cột bạn muốn tính tổng");
        int colSum = sc.nextInt();
            double sum=0;
            for (int j = 0; j < arr.length; j++) {
                sum+=arr[j][colSum];
            }
        System.out.println("Tổng của cột "+colSum+" là "+sum);
        }
    }

