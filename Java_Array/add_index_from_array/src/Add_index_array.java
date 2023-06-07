import java.util.Arrays;
import java.util.Scanner;

public class Add_index_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {10, 4, 6, 7, 8, 6, 4, 5, 2, 9};
        System.out.println("Mảng arrValue ban đầu: " + Arrays.toString(arr));
        System.out.println("Nhập giá trị phần tử muốn thêm vào mảng");
        int x = sc.nextInt();
        int index = 1;
        do {
            System.out.println("Nhập vị trí phần tử muốn thêm vào mảng");
            index = sc.nextInt();
            if (index > arr.length - 1 || index < 0) {
                System.out.println("Không thể chèn vào mảng, cần nhập lại");
            }
        } while (index < 0 || index > arr.length);
        System.out.print("Mảng mới sau khi thêm phần tử newValue= " + Arrays.toString(addValue(arr, index, x)));
    }

    public static int[] addValue(int[] arr, int index, int x) {
        int[] newValue = new int[arr.length + 1];
        for (int i = 0; i < newValue.length; i++) {
            if (i < index) {
                newValue[i] = arr[i];
            } else if (i == index) {
                newValue[i] = x;
            } else {
                newValue[i] = arr[i - 1];
            }
        }
        return newValue;
    }
}