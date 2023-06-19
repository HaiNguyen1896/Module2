package Codegym;

public class MyStack {
    private int[] arr;
    private int size;
    private int index;

    public MyStack(int size) {
        arr = new int[size];
        this.size = size;
    }

    public boolean isFull() {
        if (index == size) {
            return true;
        }
        return false;
    }

    public void push(int element) {
        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }
        arr[index] = element;
        index++;
    }

    public boolean isEmpty() {
        if (index == 0) {
            return true;
        }
        return false;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is null");
        }
        return arr[--index];
    }

    public int size() {
        return index;
    }


}
