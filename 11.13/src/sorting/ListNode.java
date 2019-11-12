package sorting;

public class ListNode<T> {
    public T payload;
    public ListNode<T> next;

    public ListNode(T payload) {
        this.payload = payload;
        this.next = null;
    }

    public ListNode(T payload, ListNode<T> next) {
        this.payload = payload;
        this.next = next;
    }

    public static <T> void swap(ListNode<T> left, ListNode<T> right) {
        T temp = left.payload;
        left.payload = right.payload;
        right.payload = temp;
    }
}

