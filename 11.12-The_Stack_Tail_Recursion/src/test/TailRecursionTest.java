package test;

import org.junit.Test;
import scratch.ListNode;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class TailRecursionTest {
    /**
     * Compute the sum of the numbers 0 .. limit, inclusive.
     * @param limit
     * @return The sum of the numbers in range [0, limit].
     */
    public int rangeSum(int limit) {
        return rangeSumTailRecursive(limit, 0);
    }

    private int rangeSumTailRecursive(
            int limit, int solution) {

        if (limit == 0) {
            return solution;
        }

        return rangeSumTailRecursive(
            limit - 1, solution + limit);
    }

    public int rangeSumRecursive(int limit) {
        if (limit == 0) {
            return 0;
        }

        return limit +
                rangeSumRecursive(limit - 1);
    }

    @Test
    public void rangeSumTest() {
        assertEquals(0, rangeSum(0));
        assertEquals(1, rangeSum(1));
        assertEquals(6, rangeSum(3));
        assertEquals(15, rangeSum(5));
    }

    /**
     * Gets the maximum Integer in the list.
     * @param root Root of the list.
     * @return The maximum Integer in the list, or null if the list is empty.
     */
    public Integer getMaxOfList(ListNode<Integer> root) {
        return getMaxOfListTailRecursive(
                root, null);
    }

    public Integer getMaxOfListTailRecursive(ListNode<Integer> root, Integer currentMax) {
        if (root == null) {
            return currentMax;
        }

        if (currentMax == null
            || root.payload.compareTo(currentMax) > 0) {
            currentMax = root.payload;
        }

        return getMaxOfListTailRecursive(
                root.next, currentMax);
    }

    /*
    public Integer getMaxOfList(ListNode<Integer> root) {
        if (root == null) {
            return null;
        }

        if (root.next == null) {
            return root.payload;
        }

        Integer current = root.payload;
        Integer nextMax = getMaxOfList(root.next);

        if (nextMax == null || current.compareTo(nextMax) > 0) {
            return current;
        }

        return nextMax;
    }
     */

    @Test
    public void listMaxTest() {
        assertEquals(null, getMaxOfList(null));

        ListNode<Integer> list = new ListNode<>(0);
        assertEquals(Integer.valueOf(0), getMaxOfList(list));

        list.next = new ListNode<>(1);
        list.next.next = new ListNode<>(2);
        list.next.next.next = new ListNode<>(3);
        // [0, 1, 2, 3]

        assertEquals(Integer.valueOf(3), getMaxOfList(list));

        ListNode<Integer> front = new ListNode<>(9);
        front.next = list;
        list = front;
        // [9, 0, 1, 2, 3]

        assertEquals(Integer.valueOf(9), getMaxOfList(list));

        list.next.next.payload = 555;
        // [9, 0, 555, 2, 3]
        assertEquals(Integer.valueOf(555), getMaxOfList(list));
    }
}
