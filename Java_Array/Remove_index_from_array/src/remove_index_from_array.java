import java.util.Arrays;
import java.util.Scanner;

public class remove_index_from_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arrValue = {10, 4, 6, 7, 8, 6};
        System.out.print("\nMảng arrValue ban đầu: " + Arrays.toString(arrValue));
        System.out.print("\nNhập giá trị phần tử muốn xóa\n");
        int x = sc.nextInt();
        int index_del = checkIn(x, arrValue);
        int[] newValue = del_index_array(arrValue, index_del);
        System.out.print("Mảng mới sau khi xóa phần tử newValue= " + Arrays.toString(newValue));
    }

    public static int checkIn(int number, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (number == arr[i]) {
                System.out.println(number + " có trong mảng, nằm trong phần tử thứ " + i);
                return i;
            }
        }
        System.out.println("Không có giá trị " + number + " trong mảng");
        System.exit(1);
        return -1;
    }

    public static int[] del_index_array(int[] arr, int index) {
        int[] newValue = new int[arr.length - 1];
        for (int i = 0; i < newValue.length; i++) {
            if (i < index) {
                newValue[i] = arr[i];
            } else {
                newValue[i] = arr[i + 1];
            }
        }
        return newValue;
    }
}
