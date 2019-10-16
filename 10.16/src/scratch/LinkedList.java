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

    // Want to copy the current linked list?
    // We can take advantage of our existing Linked List(Iterable) constructor
    // once we implement the Iterable interface!

    public LinkedList<T> copy(LinkedList<T> other) {
        return new LinkedList<T>(other);
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

    /*
        Interesting Linked List Algorithms
        Try these at home!
     */

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (this.getClass() != o.getClass()) {
            return false;
        }

        LinkedList<T> other = (LinkedList<T>) o;
        if (this.size() != other.size()) {
            return false;
        }

        // Iterator<T> i = this.iterator();
        Iterator<T> j = other.iterator();

        for (T value : this) {
            if (!(j.next()).equals(value)) {
                return false;
            }
        }

        return true;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;

        // Remark: three-line solution is only possible by garbage collection
        // O(1) as implemented, but O(n) in practice, the garbage collector
        // must individually free all ListNode elements in the heap, O(n)
    }

    /*
    Join two linked lists together.
    This destroys the list passed as an argument.
     */
    public void join(LinkedList<T> o) {
        if (o.size() == 0) {
            return;
        }

        if (this.size() == 0) {
            this.head = o.head;
            this.tail = o.tail;
            this.size = o.size;
            o.clear();
            return;
        }

        this.tail.next = o.head;
        this.tail = o.tail;
        this.size += o.size();
        o.clear();
    }

    public void reverse() {
        if (this.size() <= 1) {
            return;
        }

        Node<T> prev = this.head;
        Node<T> current = this.head.next;
        Node<T> next = this.head.next.next;
        prev.next = null;

        this.tail = this.head;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        this.head = prev;
    }

    public void insert(int index, T value) {
        Node<T> insert = new Node<T>(value);

        if (index == 0) {
            insert.next = this.head;
            this.head = insert;

            ++size;
            return;
        }

        if (index == size) {
            this.tail.next = insert;
            this.tail = insert;

            ++size;
            return;
        }

        Node<T> prev = this.head;
        Node<T> current = this.head.next;
        int i = 1;
        while (i != index) {
            prev = current;
            current = current.next;
            ++i;
        }

        prev.next = insert;
        insert.next = current;

        ++size;
        return;
    }
}
