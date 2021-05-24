package sorting;

import java.util.Iterator;
import java.util.LinkedList;

public class Sorting {
    public static ListNode<Integer> selectionSort(ListNode<Integer> list) {

        // All Nodes preceding the unsortedHead
        // are in the sorted partition.
        ListNode<Integer> unsortedHead = list;

        while (unsortedHead != null) {
            Integer min = unsortedHead.payload;
            ListNode<Integer> minLocation = unsortedHead;

            ListNode<Integer> unsortedStart = unsortedHead;
            while (unsortedStart != null) {
                if (min == null || unsortedStart.payload < min) {
                    min = unsortedStart.payload;
                    minLocation = unsortedStart;
                }

                unsortedStart = unsortedStart.next;
            }

            ListNode.swap(unsortedHead, minLocation);
            unsortedHead = unsortedHead.next;
        }

        return list;
    }
}
