package Codegym;

import java.util.EmptyStackException;

public class MyQueue {
    private int capacity;
    private int[] queueArr;
    private int head = 0;
    private int tail = -1;
    private int currentSize = 0;

    public MyQueue(int queueSize) {
        this.capacity = queueSize;
        queueArr = new int[this.capacity];
    }

    public boolean isQueueFull() {
        if (currentSize == capacity) {
            return true;
        }
        return false;
    }

    public boolean isQueueEmpty() {
        if (currentSize == 0) {
            return true;
        }
        return false;
    }

    public void enqueue(int item) {
        if (isQueueFull()) {
            System.out.println("Overflow ! Unable to add element:" + item);
        } else {
            tail++;
            if (this.tail == this.capacity -1) {
                tail = 0;
            }
            System.out.println("Gias tri tail khi nay"+this.tail);
            queueArr[tail] = item;
            currentSize++;
            System.out.println("Curren size" + this.currentSize);
            System.out.println("Element " + item + " is pushed to Queue !");
        }
    }

    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("underflow!unable to remove element from Queue!");
            ;
        } else {
            this.head++;
            if (this.head == capacity - 1) {
                System.out.println("Pop operation done ! removed: " + queueArr[head - 1]);
                this.head = 0;
            } else {
                System.out.println("Pop operation done ! removed: " + queueArr[head - 1]);
            }
        }
        currentSize--;
    }

    public void showall() {
        for (int i = 0; i < currentSize; i++) {
            System.out.println(queueArr[i]);
        }
    }

}
