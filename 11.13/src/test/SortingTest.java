package test;

import org.junit.Test;
import sorting.ListNode;
import sorting.Sorting;

import static junit.framework.TestCase.assertEquals;

public class SortingTest {
    @Test
    public void SelectionSortTest() {
        ListNode<Integer> list = new ListNode<>(5);
        ListNode<Integer> head = list;

        list.next = new ListNode<>(4);
        list = list.next;

        list.next = new ListNode<>(3);
        list = list.next;

        list.next = new ListNode<>(2);
        list = list.next;

        list.next = new ListNode<>(1);
        list = list.next;

        list.next = new ListNode<>(0);
        list = list.next;
        // [5 4 3 2 1 0]

        Sorting.selectionSort(head);

        for (int i = 0; i <= 5; ++i) {
            assertEquals(Integer.valueOf(i), head.payload);
            head = head.next;
        }
    }
}
