package Codegym;

import java.util.Scanner;
import java.util.Stack;

public class CheckSymbol {
    public boolean checkSymbol(String string) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') {
                stack.push(string.charAt(i));
            } else if (string.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char left = stack.pop();
                    if (left == '(' && string.charAt(i) != ')') {
                        return false;
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
