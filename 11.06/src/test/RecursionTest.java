package test;

import org.junit.Test;
import scratch.BinaryTreeNode;
import scratch.ListNode;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.*;

public class RecursionTest {
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

        Integer current = root.payload;
        Integer sumOfRest = getSumOfList(root.next);

        Integer runningTotal = current + sumOfRest;
        return runningTotal;
    }

    @Test
    public void listSumTest() {
        ListNode<Integer> list = new ListNode<>(5);
        list.next = new ListNode<>(10);
        list.next.next = new ListNode<>(15);
        list.next.next.next = new ListNode<>(25);
        list.next.next.next.next = new ListNode<>(50);
        // [5 10 10 25 50]

        assertEquals(Integer.valueOf(105), getSumOfList(list));
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

        boolean inLeft = containsTree(root.left, value);
        boolean inRight = containsTree(root.right, value);

        return inLeft || inRight;
    }

    @Test
    public void containsTreeTest() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(0);

        root.left = new BinaryTreeNode<>(1);
        root.right = new BinaryTreeNode<>(2);

        root.right.left = new BinaryTreeNode<>(3);
        root.right.right = new BinaryTreeNode<>(4);

        assertTrue(containsTree(root, 4));
        assertFalse(containsTree(root, 5));
    }
}
