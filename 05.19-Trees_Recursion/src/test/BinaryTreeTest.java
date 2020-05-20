package test;

import org.junit.Test;
import scratch.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class BinaryTreeTest {
    @Test
    public void ConstructTest() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(0);

        root.left = new BinaryTreeNode<>(1);
        root.right = new BinaryTreeNode<>(2);

        assertEquals(Integer.valueOf(0), root.payload);
        assertEquals(Integer.valueOf(1), root.left.payload);
        assertEquals(Integer.valueOf(2), root.right.payload);
    }

    @Test
    public void ConstructDeepTest() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(0);

        root.left = new BinaryTreeNode<>(1);
        root.right = new BinaryTreeNode<>(2);

        root.right.left = new BinaryTreeNode<>(3);
        root.right.right = new BinaryTreeNode<>(4);

        assertEquals(Integer.valueOf(3), root.right.left.payload);
        assertEquals(Integer.valueOf(4), root.right.right.payload);
    }

    /**
     * Retrieves the Integer at the end of a path described by an ArrayList.
     * @param root The root of the Binary Tree of Integers.
     * @param path An ArrayList of Strings containing "right" or "left" directions from the root node.
     * @return The value at the end of the path.
     */
    public Integer getIntegerAtPath(BinaryTreeNode<Integer> root, ArrayList<String> path) {
        for (String d : path) {
            if (d.equals("left")) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return root.payload;
    }

    @Test
    public void IntegerPathTest() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(0);

        root.left = new BinaryTreeNode<>(1);
        root.right = new BinaryTreeNode<>(2);

        root.right.left = new BinaryTreeNode<>(3);
        root.right.right = new BinaryTreeNode<>(4);

        ArrayList<String> emptyPath = new ArrayList<>();
        assertEquals(Integer.valueOf(0), getIntegerAtPath(root, emptyPath));

        ArrayList<String> oneStepPath = new ArrayList<>(Arrays.asList(
                "left"
        ));
        assertEquals(Integer.valueOf(1), getIntegerAtPath(root, oneStepPath));

        ArrayList<String> twoStepPath = new ArrayList<>(Arrays.asList(
                "right",
                "left"
        ));
        assertEquals(Integer.valueOf(3), getIntegerAtPath(root, twoStepPath));
    }

    /*
       An enum is like an integer with a name.

       An enum is a programming-only construct that lets us use labels
       disguised as integers, where the underlying integer doesn't matter
       as much as the label itself.

       We could have just used 0 and 1 for left and right.

       This is what the compiler turns enums into, which are more efficient
       and less error prone than using raw strings.
     */
    public enum Direction {
        left,   // 0
        right,  // 1
    }

    public <T> T getValueAtPath(BinaryTreeNode<T> root, List<Direction> path) {
        for (Direction d : path) {
            if (d.equals(Direction.left)) {
                root = root.left;
            } else if (d.equals(Direction.right)) {
                root = root.right;
            }
        }

        return root.payload;
    }

    @Test
    public void PathTest() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(0);

        root.left = new BinaryTreeNode<>(1);
        root.right = new BinaryTreeNode<>(2);

        root.right.left = new BinaryTreeNode<>(3);
        root.right.right = new BinaryTreeNode<>(4);

        ArrayList<Direction> emptyPath = new ArrayList<>();
        assertEquals(Integer.valueOf(0), getValueAtPath(root, emptyPath));

        ArrayList<Direction> oneStepPath = new ArrayList<>(Arrays.asList(
                Direction.left
        ));
        assertEquals(Integer.valueOf(1), getValueAtPath(root, oneStepPath));

        ArrayList<Direction> twoStepPath = new ArrayList<>(Arrays.asList(
                Direction.right,
                Direction.left
        ));
        assertEquals(Integer.valueOf(3), getValueAtPath(root, twoStepPath));
    }
}
