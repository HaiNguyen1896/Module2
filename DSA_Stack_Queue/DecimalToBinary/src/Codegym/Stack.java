package Codegym;

import java.util.LinkedList;

public class Stack<T>{
    private LinkedList<T>stack;
    public Stack(){
        stack=new LinkedList<>();
    }
    void push(T element){
        stack.addFirst(element);
    }
    void showall(){
        for(T stack : stack){
            System.out.print(stack+" ");
        }
    }
}
