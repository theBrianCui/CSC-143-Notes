package scratch;

public class DoubleNode<T> extends Node<T> {
    Node<T> prev;

    public DoubleNode(T payload) {
        super(payload);
    }

    public DoubleNode(T payload, Node<T> next) {
        super(payload, next);
    }

    public DoubleNode(T payload, Node<T> next, Node<T> prev) {
        super(payload, next);
        this.prev = prev;
    }
}
