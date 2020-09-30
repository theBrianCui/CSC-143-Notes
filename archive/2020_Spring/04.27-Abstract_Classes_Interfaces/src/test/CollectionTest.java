package test;

import lib.Pair;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class CollectionTest {
    
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

    // A HashSet is another kind of Collection.
    // HashSets are a bag of unique items without duplicates,
    // according to their .equals() method.
    // HashSet -> Collection -> Iterable
    // however, HashSet has no guarantee of ordering like List
    @Test
    public void HashSetTest() {
        Collection<Pair<String, Integer>> x = new HashSet<>();

        Pair<String, Integer> hello = new Pair<>("Hello", 1);
        Pair<String, Integer> world = new Pair<>("World", 2);

        x.add(hello);
        x.add(world);
        assertEquals(2, x.size());

        // size is unchanged by duplicate add
        x.add(hello);
        assertEquals(2, x.size());

        Pair<String, Integer> otherHello = new Pair<>("Hello", 1);
        assertTrue(hello != otherHello);
        assertEquals(hello, otherHello);

        // size is unchanged by adding an item
        // that is .equals() to an existing item
        x.add(otherHello);
        assertEquals(2, x.size());

        int count = 0;
        for (Pair<String, Integer> p : x) {
            // iteration over HashSet
            // order not guaranteed
            count++;
        }

        assertEquals(2, count);
    }
}
