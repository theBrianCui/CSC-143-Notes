package sorting;

import java.util.Iterator;
import java.util.LinkedList;

public class Sorting {
    public static ListNode<Integer> selectionSort(ListNode<Integer> list) {
        ListNode<Integer> sortedTail = list;

        while (sortedTail != null) {
            Integer min = sortedTail.payload;
            ListNode<Integer> minLocation = sortedTail;

            ListNode<Integer> unsortedStart = sortedTail;
            while (unsortedStart != null) {
                if (min == null || unsortedStart.payload < min) {
                    min = unsortedStart.payload;
                    minLocation = unsortedStart;
                }

                unsortedStart = unsortedStart.next;
            }

            ListNode.swap(sortedTail, minLocation);
            sortedTail = sortedTail.next;
        }

        return list;
    }
}
