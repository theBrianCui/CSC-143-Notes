package scratch;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() { };

    public LinkedList(Iterable<T> iterable) {
        for (T value : iterable) {
            if (head == null && tail == null) {
                head = new Node<T>(value);
                tail = head;

            } else {
                tail.next = new Node<T>(value);
                tail = tail.next;
            }

            ++size;
        }
    }

    public void pushFront(T value) {
        if (head == null && tail == null) {
            head = new Node<T>(value);
            tail = head;

        } else if (head == tail) {
            head = new Node<T>(value);
            head.next = tail;

        } else {
            Node<T> front = new Node<T>(value);
            front.next = head;
            head = front;
        }

        ++size;
    }

    public void pushBack(T value) {
        if (head == null && tail == null) {
            head = new Node<T>(value);
            tail = head;

        } else if (head == tail) {
            tail = new Node<T>(value);
            head.next = tail;

        } else {
            Node<T> back = new Node<T>(value);
            tail.next = back;
            tail = back;
        }

        ++size;
    }

    public int size() {
        return this.size;
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> head;
        public LinkedListIterator(Node<T> head) {
            this.head = head;
        }

        @Override
        public boolean hasNext() {
            return head != null;
        }

        @Override
        public T next() {
            T value = head.payload;
            head = head.next;
            return value;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator(head);
    }
}
