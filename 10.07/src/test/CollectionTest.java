package test;

import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

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

        Collection<BigInteger> x = new ArrayList<>();
        x.add(BigInteger.ZERO);
        x.add(BigInteger.ONE);
        x.add(BigInteger.TWO);

        int i = 0;
        for (BigInteger b : x) {
            assertEquals(BigInteger.valueOf(i++), b);
        }
    }
}
