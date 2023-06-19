package Codegym;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Stack<Integer>stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số cần chuyển đổi");
        int number = sc.nextInt();
        int surplus;
        while(number>0){
            surplus = number%2;
            number=number/2;
            stack.push(surplus);
        }
        stack.showall();
    }

}
