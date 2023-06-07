import java.util.Scanner;

public class findMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập độ dài mảng");
        int arrlength = sc.nextInt();
        int[] arr = new int[arrlength];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Nhập giá trị phần tử arr[" + i + "]");
            arr[i] = sc.nextInt();
        }
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) min = arr[i];
        }
        System.out.println("Giá trị nhỏ nhất trong mảng " + min);
    }
}
