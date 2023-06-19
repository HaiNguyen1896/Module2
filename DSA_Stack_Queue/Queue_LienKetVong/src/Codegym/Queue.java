package Codegym;

public class Queue {
    private Node front;
    private Node rear;
    private int numNodes;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    public void enQueue(int data) {
        Node node = new Node(data);
        if (this.front == null) {
            this.front = this.rear = node;
            System.out.println("front " + this.front+" "+this.rear);
            System.out.println("front " + this.front.link);
        } else {
            this.rear.link = node;
            System.out.println("rear link trỏ đến 1 "+this.rear.link);
            System.out.println("front link trỏ đến 1 "+this.front.link);
            this.rear = node;
//            System.out.println(this.front.link);
//            System.out.println(this.rear.link);
        }

//        System.out.println("rear link lần 1 "+this.rear.link);
//        System.out.println("front link lần 1 "+this.front.link);
        this.rear.link = this.front;
        System.out.println("rear link trỏ đến 2 "+this.rear.link);
        System.out.println("front trỏ đến "+this.front);
        System.out.println("front link trỏ đến 2 "+this.front.link);
        numNodes++;
    }

    public Node deQueue() {
        Node node;
        if (this.front == null) {
            return null;
        } else if (this.front == this.rear) {
            node = this.front;
            this.front = this.rear = null;
        } else {
            node = this.front;
            System.out.println("front trc khi xoá "+this.front);
            System.out.println("Front link trc khi xoá: "+this.front.link);
            this.front = this.front.link;
            System.out.println("front sau khi xoá "+this.front);
            System.out.println("Front link sau khi xoá: "+this.front.link);
            this.rear.link = this.front;
        }
        numNodes--;
        return node;
    }

    public void displayQueue() {
        Node temp = this.front;
        System.out.println("Circular Queue");
        for (int i = 0; i < numNodes; i++) {
            System.out.println(temp.data);
            temp = temp.link;
        }
    }

}
