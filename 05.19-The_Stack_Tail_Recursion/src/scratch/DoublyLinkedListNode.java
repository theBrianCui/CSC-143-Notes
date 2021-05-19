package scratch;

import java.util.LinkedList;

public class DoublyLinkedListNode<T> {
    public T payload;
    public DoublyLinkedListNode<T> next;
    public DoublyLinkedListNode<T> prev;

    public DoublyLinkedListNode(T payload) {
        this.payload = payload;
    }

    public DoublyLinkedListNode(T payload,
                                DoublyLinkedListNode<T> next,
                                DoublyLinkedListNode<T> prev) {
        this.payload = payload;
        this.next = next;
        this.prev = prev;
    }
}
