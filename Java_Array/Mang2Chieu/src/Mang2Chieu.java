import java.util.Scanner;

public class Mang2Chieu {
    public static void main(String[] args) {
        // B1:Mảng được tạo sẵn
//        int[][] arr = {
//                {1, 3, 4, 5},
//                {2, 5000, 5, 10},
//                {6, 8, 9, 2}
//        };
//        int max = arr[0][0];
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                if (max < arr[i][j]) max = arr[i][j];
//            }
//        }
//        System.out.println("Giá trị lớn nhất trong mảng 2 chiều là " + max);
        //B2:Mảng do người dùng quy định
        Scanner sc = new Scanner(System.in);
        System.out.println("Bạn hãy quy định số hàng cho ma trận");
        int row = sc.nextInt();
        System.out.println("Bạn hãy quy định số cột cho ma trận");
        int col = sc.nextInt();
        int[][] arr =new int[row][col];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("Nhập giá trị cho phần từ arr["+i+"]["+j+"]");
                arr[i][j]= sc.nextInt();
            }
        }
        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max < arr[i][j]) max = arr[i][j];
            }
        }
        System.out.println("Giá trị lớn nhất trong mảng 2 chiều là " + max);
    }
}
