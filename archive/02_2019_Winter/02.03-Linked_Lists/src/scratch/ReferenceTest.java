package scratch;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class ReferenceTest {

    static class A {
        int i;
        A(int i) { this.i = i; }
    }

    void modifyA(A inner) {
        inner.i = -1;
    }

    @Test
    public void ReferenceModifyTest() {
        A outer = new A(5);
        modifyA(outer);

        assertEquals(-1, outer.i);
    }

    void assignA(A inner) {
        inner = new A(-1);
    }

    @Test
    public void ReferenceAssignTest() {
        A outer = new A(5);
        assignA(outer);

        // assertEquals(-1, outer.i)
        // Wrong! Java is pass-by-value, so references are *copied*
        // Assigning a copy has no effect on the underlying value

        assertEquals(5, outer.i);
    }

    @Test
    public void ReferenceCopyTest() {
        A foo = new A(5);
        A bar = foo;

        // Notice the use of ==, reference equality
        assertTrue(foo == bar);
        // foo and bar are variables that reference the same thing

        bar.i = -1;
        assertEquals(-1, foo.i);
        // modifications to bar's underlying value
        // also modify foo's underlying value


        bar = new A(9);
        // assigning bar changes what it references
        // but does not change what foo references

        assertTrue(foo != bar);
        assertEquals(-1, foo.i);
        assertEquals(9, bar.i);
    }
}
