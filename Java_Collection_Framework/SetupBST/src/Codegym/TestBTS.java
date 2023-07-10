package Codegym;

public class TestBTS {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.insert(50);
        tree.insert(40);
        tree.insert(30);
        tree.insert(60);
        tree.insert(1000);
        tree.insert(2);
        tree.insert(1);
        System.out.println("Inorder(sorted): ");
        tree.inorder();
        System.out.println("Number of nodes is " + tree.getSize());
    }
}
