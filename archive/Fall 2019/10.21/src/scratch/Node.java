package scratch;

public class Node<T> {
    T payload;
    Node<T> next;

    public Node(T payload) {
        this.payload = payload;
    }

    public Node(T payload, Node<T> next) {
        this.payload = payload;
        this.next = next;
    }
}
