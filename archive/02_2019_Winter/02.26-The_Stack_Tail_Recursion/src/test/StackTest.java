package test;

import org.junit.Test;

import java.util.Stack;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class StackTest {
    @Test
    public void stackTest() {
        Stack<Integer> stack = new Stack<>();
        assertTrue(stack.empty());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        // bottom [1 2 3] top

        assertEquals(3, stack.size());
        assertEquals(Integer.valueOf(3), stack.peek());

        assertEquals(Integer.valueOf(3), stack.pop());
        assertEquals(Integer.valueOf(2), stack.pop());
        assertEquals(Integer.valueOf(1), stack.pop());

        assertTrue(stack.empty());
    }
}
