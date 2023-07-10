package Codegym;

public class MainTest {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.insert(27);
        bst.insert(14);
        bst.insert(10);
        bst.insert(19);
        bst.insert(35);
        bst.insert(31);
        bst.insert(42);
        bst.preOrder();


    }
}
