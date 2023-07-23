package Codegym;

import java.util.Scanner;

public class AlgorithmComplexityTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string");
        String inputString = scanner.nextLine();
        int[] frequentChar = new int[255];
        for (int i = 0; i < inputString.length(); i++) {
            int ascii = (int) inputString.charAt(i);
            frequentChar[ascii] += 1;
        }
        int max = 0;
        char character = (char) 255;
        for (int i = 0; i < frequentChar.length; i++) {
            if (max < frequentChar[i]) {
                max = frequentChar[i];
                character = (char) i;
            }
        }
        System.out.println("The most character in String is " + character + " , it showing " + max+" times");
    }
}
