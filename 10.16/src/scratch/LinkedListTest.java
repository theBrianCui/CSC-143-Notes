package scratch;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Iterator;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

public class LinkedListTest {
    @Test
    public void LinkedListPushBackTest() {
        LinkedList<String> list = new LinkedList<>();
        list.pushBack("Foo");
        list.pushBack("Bar");
        list.pushBack("Baz");
        assertEquals(3, list.size());

        Iterator<String> i = list.iterator();
        assertEquals("Foo", i.next());
        assertEquals("Bar", i.next());
        assertEquals("Baz", i.next());

        assertFalse(i.hasNext());
    }

    @Test
    public void LinkedListPushFrontTest() {
        LinkedList<String> list = new LinkedList<>();

        list.pushFront("Baz");
        list.pushFront("Bar");
        list.pushFront("Foo");
        assertEquals(3, list.size());

        Iterator<String> i = list.iterator();
        assertEquals("Foo", i.next());
        assertEquals("Bar", i.next());
        assertEquals("Baz", i.next());

        assertFalse(i.hasNext());
    }

    @Test
    public void LinkedListEqualsTest() {
        LinkedList<String> A = new LinkedList<>();
        LinkedList<String> B = new LinkedList<>();
        String C = "";

        assertEquals(A, A);
        assertEquals(A, B);
        assertFalse(A.equals(C));

        A.pushFront("a");
        B.pushFront("b");
        assertFalse(A.equals(B));

        A.pushBack("b");
        B.pushFront("a");
        assertEquals(A, B);

        A.pushBack("c");
        assertFalse(A.equals(B));

        B.pushBack("c");
        assertEquals(A, B);
    }
}
