package test;

import org.junit.Test;
import scratch.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class BinaryTreeTest {
    public enum Direction {
        left,   // 0
        right,  // 1
    }

    public <T> T getValueAtPath(BinaryTreeNode<T> root, List<Direction> path) {
        for (Direction d : path) {
            if (d.equals(Direction.left)) {
                root = root.left;
            } else {
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
