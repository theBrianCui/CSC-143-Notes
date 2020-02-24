package scratch;

public class BinaryTreeNode<T> {
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;
    public T payload;

    public BinaryTreeNode(T payload) {
        this.payload = payload;
    }

    public BinaryTreeNode(T payload, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.payload = payload;
        this.left = left;
        this.right = right;
    }
}
