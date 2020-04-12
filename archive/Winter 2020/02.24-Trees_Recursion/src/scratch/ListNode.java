package scratch;

public class ListNode<T> {
    public T payload;
    public ListNode<T> next;

    public ListNode(T payload) {
        this.payload = payload;
    }
}