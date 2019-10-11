package scratch;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class ArrayListTest {
    public void populate(ArrayList<String> array) {
        array.add("John");
        array.add("Paul");
        array.add("George");
        array.add("Ringo");
    }

    @Test
    public void ArrayListInsertTest() {
        ArrayList<String> array = new ArrayList<>();
        this.populate(array);

        // Arrays.toString(array.toArray());
        assertEquals("John", array.get(0));
        assertEquals("Ringo", array.get(3));

        // add(index, value) inserts value at the index
        // and shifts all successive elements to the right O(n)
        array.add(0, "Amy");

        assertEquals("Amy", array.get(0));
        assertEquals("John", array.get(1));

        // add() works in the middle, too
        // all previous elements remain in place
        // successive elements are shifted to the right O(n)
        array.add(2, "Barry");
        assertEquals("Amy", array.get(0));
        assertEquals("John", array.get(1));
        assertEquals("Barry", array.get(2));
        assertEquals("Paul", array.get(3));
    }

    @Test
    public void ArrayListDeleteTest() {
        ArrayList<String> array = new ArrayList<>();
        this.populate(array);

        assertEquals("John", array.get(0));
        // remove(0) shifts all elements forward -1 index O(n)
        array.remove(0);
        assertEquals("Paul", array.get(0));

        // remove(index) from the middle shifts all successive elements forward O(n)
        array.remove(1);
        assertEquals("Paul", array.get(0));
        assertEquals("Ringo", array.get(1));

        // remove(size() - 1) from the end shifts nothing, always O(1)
        array.remove(array.size() - 1);
        assertEquals("Paul", array.get(0));
    }
}
