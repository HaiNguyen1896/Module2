package Codegym;

import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {

        int[] arr = {4, 3, 65, 7, 5, 3, 5, 8, 9, 22};
        System.out.println("Array at the beginning ");
        for (int ar : arr) {
            System.out.print(ar + " ");
        }
        System.out.println("\n");
        InsertionSort(arr);
    }

    public static void InsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int pos_Value = arr[i];
            int pos = i;
            while (pos > 0 && pos_Value < arr[pos - 1]) {
                arr[pos] = arr[pos - 1];
                pos--;
            }
            arr[pos] = pos_Value;
            for (int ar : arr) {
                System.out.print(ar + " ");
            }
            System.out.println("=========after each times============");

        }
        for (int ar : arr) {
            System.out.print(ar + " ");
        }
    }
}
