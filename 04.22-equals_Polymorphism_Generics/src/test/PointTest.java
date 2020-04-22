package test;

import org.junit.Test;
import scratch.Point;
import scratch.Point3D;

import static junit.framework.TestCase.*;

public class PointTest {
    @Test
    public void PointTest() {
        Point a = new Point(0, 0);
        Point b = new Point(5, 4);

        assertEquals(a, a); // a.equals(a)
        assertFalse(a.equals(b));
        b.x = 0;
        b.y = 0;

        // assertEquals calls .equals() on Objects,
        // == on primitives
        assertEquals(a, b);
        assertTrue(a.equals(b));
        assertTrue(b.equals(a));

        // references are unchanged and are still different
        assertFalse(a == b);
    }

    @Test
    public void Point3DTest() {
        Point a = new Point(0, 0);
        Point3D b = new Point3D(1, 2, 3);
        Point3D c = new Point3D(9, 8, 7);

        assertEquals(b, b);
        assertFalse(a.equals(b));
        b.x = 0;
        b.y = 0;

        // When we use instanceOf in our .equals(),
        // parents are allowed to equal children because
        // children are cast to the parent type.
        // Only the parent portion is compared.
        assertTrue(a.equals(b));

        // However, we lose an important property: symmetry
        assertFalse(b.equals(a));

        // The alternative to instanceOf is to compare
        // the two objects' .getClass() properties.
        // See the readings for more...

        assertFalse(b.equals(c));
        c.x = 0;
        c.y = 0;
        c.z = 3;

        assertEquals(b, c);
    }
}
