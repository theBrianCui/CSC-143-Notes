package test;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class ReferenceTest {
    class A {
        int i;

        A(int i) {
            this.i = i;
        }
    }

    @Test
    public void localTest() {
        A localA = new A(0);
        assertEquals(0, localA.i);

        A anotherA = new A(1);
        assertEquals(1, anotherA.i);

        // compare addresses
        assertFalse(localA == anotherA);

        // reference localA now points to the instance that anotherA points to
        // localA's original instance is garbage collected
        localA = anotherA;

        // memory addresses are equal -> references are equal -> instances are the same
        assertTrue(localA == anotherA);
        assertEquals(1, localA.i);
        assertEquals(1, anotherA.i);
    }

    // arguments are passed by value
    // reassigning that value (which is a copy of the reference) won't reassign the original reference
    void assignAArgument(A argumentA) {
        argumentA = new A(5);
        // this A   ^^^^^^^^^^ gets garbage collected once the function exits (why?)
    }

    @Test
    public void assignTest() {
        A localA = new A(0);
        assertEquals(0, localA.i);
        A originalA = localA;

        assignAArgument(localA);
        // assertEquals(5, a.i);
        assertEquals(0, localA.i);
        assertTrue(localA == originalA);
    }

    // still passed by value, so the reference is a copy, but the underlying address pointed to is unchanged
    // thus, modifications to the argument's properties modify the underlying instance
    void modifyAArgument(A argumentA) {
        argumentA.i = 5;
    }

    void assignModifyA(A argumentA) {
        argumentA = new A(10);
        argumentA.i = 5;
    }

    A modifyAReturn(A argumentA) {
        argumentA.i = 999;
        argumentA = new A(12);
        return argumentA;
    }

    @Test
    public void modifyTest() {
        A localA = new A(0);
        assertEquals(0, localA.i);
        A originalA = localA;

        modifyAArgument(localA);
        assertEquals(5, localA.i);
        // assertEquals(0, localA.i);
        assertTrue(localA == originalA);
    }

    /*
         Observe: because arguments are passed by value (reference gets copied),
         functions cannot change the original address of the reference,
         but can change the instance pointed to by the reference
     */
}
