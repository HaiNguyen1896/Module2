package Codegym;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> inputArr = new ArrayList<>();
        int input;
        int i = 0;
        do {
            System.out.println("Nhập phần tử Arr[" + i + "]");
            input = sc.nextInt();
            if (input == -1) break;
            inputArr.add(input);
            i++;
        } while (input != -1);
        Collections.sort(inputArr);
        System.out.println("Mảng sau khi sắp xếp tăng dần");
        for (int j = 0; j < inputArr.size(); j++) {
            System.out.print(inputArr.get(j) + " ");
        }
        int index = BinarySearch(inputArr, 0, inputArr.size() - 1, 20);
        check(index, inputArr);
        int index1 = BinarySearch(inputArr, 0, inputArr.size() - 1, 80);
        check(index1, inputArr);
        int index2 = BinarySearch(inputArr, 0, inputArr.size() - 1, 200);
        check(index2, inputArr);
    }

    public static void check(int index, ArrayList<Integer> inputArr) {
        if (index != -1) {
            System.out.println("\nPhần tử nằm ở vị trí thứ " + index + " giá trị là " + inputArr.get(index));
        } else {
            System.out.println("\nKhông có giá trị cần tìm trong mảng");
        }
    }

    public static int BinarySearch(ArrayList<Integer> arr, int left, int right, int value) {
        while (right >= left) {
            int middle = (right + left) / 2;
            if (arr.get(middle) == value) {
                return middle;
            } else if (arr.get(middle) > value) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
