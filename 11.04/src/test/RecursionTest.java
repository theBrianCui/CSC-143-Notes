package test;

import org.junit.Test;
import scratch.BinaryTreeNode;
import scratch.ListNode;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.*;

public class RecursionTest {
    /**
     * Add all the numbers from zero to i.
     * @param i
     * @return The sum of the numbers ranging from 0 to i.
     */
    public int getRangeSum(int i) {
        if (i == 0) {
            return 0;
        }

        return i + getRangeSum(i - 1);
    }

    @Test
    public void rangeSumTest() {
        assertEquals(0, getRangeSum(0));
        assertEquals(1, getRangeSum(1));
        assertEquals(15, getRangeSum(5));
    }

    /**
     * Compute the ith fibonacci number.
     * @param i
     * @return The ith fibonacci number.
     */
    public int fib(int i) {
        if (i == 0) {
            return 0;
        }

        if (i == 1) {
            return 1;
        }

        return fib(i - 1) + fib(i - 2);
    }

    @Test
    public void fibTest() {
        assertEquals(0, fib(0));
        assertEquals(1, fib(1));
        assertEquals(1, fib(2));
        assertEquals(2, fib(3));
        assertEquals(3, fib(4));
        assertEquals(5, fib(5));

        /*
            Fibonacci is naturally recursive,
            but is also O(2^n) which is bad.
         */
    }

    /**
     * Determines if a list contains a value.
     * @param root Root of the tree.
     * @param value Value to search for.
     * @param <T> Type of the values contained in the list, and the value to search for.
     * @return True or false depending on if the list contains the value.
     */
    public <T> boolean listContains(ListNode<T> root, T value) {
        if (root == null) {
            return false;
        }

        if (root.next == null) {
            return root.payload.equals(value);
        }

        if (root.payload.equals(value)) {
            return true;
        }

        return listContains(root.next, value);
    }

    @Test
    public void listContainsTest() {
        assertFalse(listContains(null, 999));

        ListNode<Integer> list = new ListNode<>(0);
        assertFalse(listContains(list, 999));
        assertTrue(listContains(list, 0));

        list.next = new ListNode<>(1);
        list.next.next = new ListNode<>(2);
        list.next.next.next = new ListNode<>(3);
        // [0, 1, 2, 3]

        assertTrue(listContains(list, 3));
        assertFalse(listContains(list, 4));
    }

    /**
     * Gets the sum of a list of Integers.
     * @param root Root of the list.
     * @return The sum of the Integers in the list, or zero if the list is null.
     */
    public Integer getSumOfList(ListNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        if (root.next == null) {
            return root.payload;
        }

        return root.payload + getSumOfList(root.next);
    }

    @Test
    public void listSumTest() {
        assertEquals(Integer.valueOf(0), getSumOfList(null));
        assertEquals(Integer.valueOf(0), getSumOfList(new ListNode<>(0)));
        assertEquals(Integer.valueOf(999), getSumOfList(new ListNode<>(999)));

        ListNode<Integer> list = new ListNode<>(5);
        list.next = new ListNode<>(10);
        list.next.next = new ListNode<>(10);
        list.next.next.next = new ListNode<>(25);
        list.next.next.next.next = new ListNode<>(50);

        assertEquals(Integer.valueOf(100), getSumOfList(list));
    }

    /**
     * Gets the maximum Integer in the list.
     * @param root Root of the list.
     * @return The maximum Integer in the list, or null if the list is empty.
     */
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

    /**
     * Determines if a binary tree contains a value.
     * @param root Root of the tree.
     * @param value The value to search for.
     * @param <T> The type of value stored in the tree.
     * @return True or false depending on whether the tree contained the value.
     */
    public <T> boolean containsTree(BinaryTreeNode<T> root, T value) {
        if (root == null) {
            return false;
        }

        if (root.payload.equals(value)) {
            return true;
        }

        return containsTree(root.right, value) ||
                containsTree(root.left, value);
    }

    @Test
    public void containsTreeTest() {
        assertFalse(containsTree(null, 5));

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(0);

        root.left = new BinaryTreeNode<>(1);
        root.right = new BinaryTreeNode<>(2);

        root.right.left = new BinaryTreeNode<>(3);
        root.right.right = new BinaryTreeNode<>(4);

        assertTrue(containsTree(root, 0));
        assertTrue(containsTree(root, 2));
        assertTrue(containsTree(root, 4));
        assertFalse(containsTree(root, 5));

        assertTrue(containsTree(root.right, 4));
    }
}
