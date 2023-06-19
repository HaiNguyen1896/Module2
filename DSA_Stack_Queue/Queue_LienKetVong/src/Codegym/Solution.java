package Codegym;

public class Solution {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enQueue(5);
        queue.enQueue(7);
        queue.enQueue(6);
        queue.enQueue(9);
        queue.displayQueue();
        System.out.println("Remove:"+queue.deQueue().data);
        System.out.println("Remove:"+queue.deQueue().data);
        queue.displayQueue();
    }
}
