package test;

import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class CollectionTest {

    // The array construct is a primitive type and NOT a child of Object
    // ArrayList behaves much like an array, but is a class
    // Therefore it has methods, and can be used where Objects can be used
    @Test
    public void ArrayListTest() {
        ArrayList<String> x = new ArrayList<>();
        x.add("Brian");
        x.add("John");

        assertEquals(2, x.size());
        assertEquals("Brian", x.get(0));

        x.set(0, "Paul");
        assertEquals("Paul", x.get(0));
    }

    // An ArrayList is a kind of Collection, an interface representing
    // a group of objects. Collection implements Iterable,
    // which we've all seen in Project 0!
    @Test
    public void CollectionsTest() {
        // Polymorphism and Generics in action
        // I can assign an ArrayList<BigInteger> to a Collection<BigInteger>,
        // because ArrayList implements Collection

        Collection<BigInteger> x = new ArrayList<BigInteger>();
        x.add(BigInteger.ZERO);
        x.add(BigInteger.ONE);
        x.add(BigInteger.TWO);

        int i = 0;
        for (BigInteger b : x) {
            assertEquals(BigInteger.valueOf(i++), b);
        }
    }

    @Test
    public void ArrayTest() {
        int[] numbers = new int[5];

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

    @Test
    public void ArrayListLengthTest() {
        ArrayList<Integer> numbers = new ArrayList<>(5);

        for (int i = 0; i < numbers.size(); ++i) {
            numbers.set(i, Integer.valueOf(i));
        }

        // 0 1 2 3 4
        for (int i = 0; i < numbers.size(); ++i) {
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
