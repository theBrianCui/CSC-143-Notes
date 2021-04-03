package test;

import org.junit.Test;
import scratch.ListNode;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class LinkedListTest {
    public <T> int indexOf(ListNode<T> root, T value) {
        int i = 0;
        while (root != null) {
            if (root.payload.equals(value)) {
                return i;
            }

            root = root.next;
            ++i;
        }

        return -1;
    }

    public <T> boolean contains(ListNode<T> root, T value) {
        return indexOf(root, value) != -1;
    }

    @Test
    public void searchTest() {
        ListNode<Integer> head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        // [1, 2, 3]

        assertEquals(0, indexOf(head, 1));
        assertEquals(2, indexOf(head, 3));
        assertEquals(-1, indexOf(head, 999));

        assertTrue(contains(head, 2));
    }
}
