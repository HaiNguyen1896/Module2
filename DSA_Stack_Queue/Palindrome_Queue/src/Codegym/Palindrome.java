package Codegym;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập từ cần kiểm tra");
        String str = scanner.nextLine();
        str=str.toLowerCase();
        Stack<Character> stack1 = new Stack<>();
        Queue<Character> queue1= new LinkedList<>();
        boolean isPalindrome=true;
        for (int i =0;i<str.length();i++){
            stack1.push(str.charAt(i));
            queue1.add(str.charAt(i));
        }
        while(!stack1.empty()){
            if(stack1.pop()!=queue1.remove()){
                isPalindrome = false;
                break;
            }
        }
        if (!isPalindrome){
            System.out.println("Not a palindrome");
        }else{
            System.out.println("Is a palindrome");
        }
    }

}
