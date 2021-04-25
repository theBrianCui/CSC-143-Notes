package test;

import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class ArraysTest {
    // Arrays are a fixed length at instantiation
    // Attempts to add to the array throw an exception
    @Test
    public void ArrayTest() {
        int[] numbers = new int[5];
        assertEquals(5, numbers.length);

        numbers[0] = 0;
        numbers[1] = 4;
        numbers[2] = 9;

        for (int i = 0; i < numbers.length; ++i) {
            numbers[i] = i;
        }
        // 0 1 2 3 4
        for (int i = 0; i < numbers.length; ++i) {
            assertEquals(i, numbers[i]);
        }

        try {
            int j = numbers[99];
            fail();
        } catch (ArrayIndexOutOfBoundsException e) { }
    }

    // ArrayLists are not limited in length. How?
    @Test
    public void ArrayListLengthTest() {
        ArrayList<Integer> numbers = new ArrayList<>();
        assertEquals(0, numbers.size());

        for (int i = 0; i < 5; ++i) {
            numbers.add(i);
        }

        assertEquals(5, numbers.size());

        // 0 1 2 3 4
        for (int i = 0; i < 5; ++i) {
            assertEquals(Integer.valueOf(i), numbers.get(i));
        }

        // ArrayList can be appended to, regardless of starting length
        numbers.add(Integer.valueOf(99));
        // 0 1 2 3 4 99
        assertEquals(Integer.valueOf(99), numbers.get(numbers.size() - 1));

        // However, ArrayList still won't let you assign arbitrary indices
        // You must manually append until you reach the index you want
        try {
            numbers.set(123, Integer.valueOf(321));
            fail();
        } catch (IndexOutOfBoundsException e) { }
    }
}
