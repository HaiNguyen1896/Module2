package Codegym;

public class BST<E extends Comparable<E>> implements Tree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BST() {

    }

    public BST(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }

    @Override
    public boolean insert(E e) {
        if (root == null) {
            root = createTreeNode(e);
        } else {
            TreeNode<E> current = root;
            TreeNode<E> parent = null;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    return false;
                }

            }
            if (e.compareTo(parent.element) < 0) {
                parent.left = createTreeNode(e);
            } else {
                parent.right = createTreeNode(e);
            }
        }
        this.size++;
        return true;
    }

    public TreeNode<E> createTreeNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(TreeNode<E> root) {
        if (root == null) {
            return;
        }
        System.out.println(root.element);
        preOrder(root.left);
        preOrder(root.right);


    }
}
