package Codegym;

public class SelectionSort_BaiTap {
    public static void main(String[] args) {
        int[] arr = {7, 2, 33, 84, 3, 2, 9, 4, 1, 43, 76};
        Selection_Sort(arr);
    }

    public static void Selection_Sort(int[] arr) {
        boolean check = true;
        for (int i = 0; i < arr.length && check; i++) {
            int min_position = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min_position] > arr[j]) {
                    min_position = j;
                    check = true;
                }
            }
            int temp = arr[min_position];
            arr[min_position] = arr[i];
            arr[i] = temp;
            for (int ar : arr) {
                System.out.print(ar + " ");
            }
            System.out.println("\n--------------AFTER EACH TIME------------");

        }
        for (int ar : arr) {
            System.out.print(ar + " ");
        }
    }
}
