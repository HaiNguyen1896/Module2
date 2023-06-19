package Codegym;

public class MyQueueMain {
    public static void main(String[] args) {
        MyQueue myQueue=new MyQueue(5);

        myQueue.enqueue(4);
        myQueue.dequeue();
        myQueue.enqueue(5);
        myQueue.enqueue(77);
        myQueue.enqueue(88);
        myQueue.dequeue();
        myQueue.enqueue(399);

        myQueue.enqueue(399);
        myQueue.enqueue(399);
        myQueue.showall();


    }
}
