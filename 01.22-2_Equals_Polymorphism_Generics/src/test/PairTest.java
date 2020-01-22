package test;

import lib.Pair;
import lib.Triple;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

public class PairTest {
    @Test
    public void PairEqualsTest() {
        Pair<String, BigInteger> p1 = new Pair<String, BigInteger>("one", BigInteger.ONE);
        Pair<String, BigInteger> p2 = Pair.createPair("one", BigInteger.ONE);

        assertEquals(p1, p2);

        // Java can automatically infer types vv using the shorthand <>
        Pair<String, BigDecimal> p3 = new Pair<>("zero", BigDecimal.ZERO);
        Pair<String, String> p4 = Pair.createPair("north", "seattle");

        assertFalse(p3.equals(p4));
    }

    @Test
    public void TripleTest() {
        Triple<String, BigInteger, BigDecimal> t1 = new Triple<>("one", BigInteger.ONE, BigDecimal.ONE);
        Triple<String, BigInteger, BigDecimal> t2 = new Triple<>("one", BigInteger.ONE, BigDecimal.ONE);
        Triple<String, String, String> t3 = Triple.createTriple("I'll", "Be", "Back");

        assertEquals(t1, t2);
        assertFalse(t1.equals(t3));

        // Triple is a child, so Triple is polymorphic
        Pair<String, BigInteger> p1 = t1;
        Pair<String, BigInteger> p2 = t2;

        assertEquals(t1, t2);

        // However, our use of .classOf() when checking equality prevents types from mixing
        Pair<String, BigInteger> p3 = new Pair<>("one", BigInteger.ONE);

        assertFalse(p3.equals(p1));

    }
}
