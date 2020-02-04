package scratch;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
    public void LinkedListForEachTest() {
        LinkedList<String> list = new LinkedList<>();
        list.pushBack("Foo");
        list.pushBack("Bar");
        list.pushBack("Baz");

        ArrayList<String> expected = new ArrayList(Arrays.asList("Foo", "Bar", "Baz"));

        ArrayList<String> names = new ArrayList();
        for (String name : list) {
            names.add(name);
        }

        assertEquals(expected, names);
    }
}
