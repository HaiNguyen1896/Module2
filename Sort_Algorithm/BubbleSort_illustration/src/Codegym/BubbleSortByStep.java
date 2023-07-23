package Codegym;

import java.util.Scanner;

public class BubbleSortByStep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the list size");
        int size = sc.nextInt();
        int[] list = new int[size];
        for (int i = 0; i < list.length; i++) {
            System.out.println("Enter the list[" + i + "]");
            list[i] = sc.nextInt();
        }
        System.out.println("Your input list: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        bubbleSortByStep(list);

    }

    static void bubbleSortByStep(int[] arr) {
        boolean needNextPass = true;
        for (int i = 1; i < arr.length && needNextPass; i++) {
            needNextPass = false;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    System.out.println("\nSwap " + arr[j] + " with " + arr[j + 1]);
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    needNextPass = true;
                    System.out.println("sort done, list after sort");
                    for (int k = 0; k < arr.length; k++) {
                        System.out.print(arr[k] + " ");
                    }
                    System.out.println("\n============================");
                }
            }
            if (!needNextPass) {
                System.out.println("\nArray may be sorted and next pass not needed");
                break;
            }
        }
        System.out.println("List after sorted");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
