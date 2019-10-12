package scratch;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class NodeTest {
    @Test
    public void OneNodeTest() {
        Node<String> list = new Node<>("John");

        assertEquals("John", list.payload);
    }

    @Test
    public void ThreeNodeChainTest() {
        Node<String> head = new Node<>("John",
                                new Node<>("Paul",
                                    new Node<>("George")));

        // head -> [John] -> [Paul] -> [George]
        assertEquals("John", head.payload);

        Node<String> tail = head.next;
        // tail -> [Paul] -next> [George]

        assertEquals("Paul", tail.payload);

        tail = tail.next;
        // tail -> [George]

        assertEquals("George", tail.payload);

        tail = tail.next;
        // tail is null

        try {
            assertEquals("should throw NullPointer exception", tail.payload);
            fail();
        } catch (NullPointerException e) { }
    }
}
