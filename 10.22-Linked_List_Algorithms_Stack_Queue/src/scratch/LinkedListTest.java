package scratch;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static junit.framework.TestCase.*;

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

    @Test
    public void LinkedListJoinTest() {
        LinkedList<String> A = new LinkedList<>(Arrays.asList("one", "two", "three"));
        LinkedList<String> B = new LinkedList<>(Arrays.asList("four", "five", "six"));

        A.join(B);

        assertEquals(6, A.size());
        assertEquals(0, B.size());

        Iterator<String> i = A.iterator();
        assertEquals("one", i.next());
        assertEquals("two", i.next());
        assertEquals("three", i.next());
        assertEquals("four", i.next());
        assertEquals("five", i.next());
        assertEquals("six", i.next());

        assertFalse(i.hasNext());
    }

    @Test
    public void LinkedListReverseTest() {
        LinkedList<String> A = new LinkedList<>(Arrays.asList("one", "two", "three"));
        A.reverse();

        Iterator<String> i = A.iterator();
        assertEquals("three", i.next());
        assertEquals("two", i.next());
        assertEquals("one", i.next());

        assertFalse(i.hasNext());
    }
read
    @Test
    public void LinkedListInsertTest() {
        LinkedList<String> A = new LinkedList<>(Arrays.asList("one", "two", "three"));

        A.insert(0, "zero");

        Iterator<String> i = A.iterator();
        assertEquals("zero", i.next());
        assertEquals("one", i.next());
        assertEquals("two", i.next());
        assertEquals("three", i.next());
        assertEquals(4, A.size());
        assertFalse(i.hasNext());

        A.insert(4, "four");

        i = A.iterator();
        assertEquals("zero", i.next());
        assertEquals("one", i.next());
        assertEquals("two", i.next());
        assertEquals("three", i.next());
        assertEquals("four", i.next());
        assertFalse(i.hasNext());

        A.insert(2, "one point five");

        i = A.iterator();
        assertEquals("zero", i.next());
        assertEquals("one", i.next());
        assertEquals("one point five", i.next());
        assertEquals("two", i.next());
        assertEquals("three", i.next());
        assertEquals("four", i.next());
        assertFalse(i.hasNext());

        try {
            A.insert(99, "should throw");
            fail();
        } catch (IndexOutOfBoundsException e) {
        }
    }
}
