package scratch;

import org.junit.Test;

import static junit.framework.TestCase.*;

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
        assertEquals("Paul", tail.payload);
        // tail -> [Paul] -next> [George]


        tail = tail.next;
        assertEquals("George", tail.payload);
        // tail -> [George]


        tail = tail.next;
        assertTrue(tail == null);

        try {
            assertEquals("should throw NullPointer exception", tail.payload);
            fail();
        } catch (NullPointerException e) { }


        // head still exists, and still points to John
        // head -> [John] -> [Paul] -> [George]

        assertEquals("John", head.payload);
        // we could walk the list once more
        // all elements are still referenced, so none get garbage collected
    }

    @Test
    public void ThreeNodeAppendFrontTest() {
        Node<String> head = new Node<>("John");
        // head -> [John]

        head = new Node("Paul", head);
        // head -> [Paul] -> [John]

        head = new Node("George", head);
        // head -> [George] -> [Paul] -> [John]

        // Observe: "Pushing" to the front causes the names to appear reversed

        assertEquals("George", head.payload);
        head = head.next;
        assertEquals("Paul", head.payload);
        head = head.next;
        assertEquals("John", head.payload);
        head = head.next;
        assertEquals(null, head);

        // Observe: head is null, and points to nothing
        // there is NO WAY to get back to any of those list elements
        // In effect, [George] [Paul] [John] have been removed ("popped") from the front

        // As there is no way to reference [George] [Paul] [John],
        // [George] [Paul] [John] will all be garbage collected!
    }
}
