package test;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.css.Rect;
import scratch.*;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;

public class ShapeTest {
    Point origin = new Point(0, 0);
    Point3D origin3D = new Point3D(0, 0, 0);

    @Test
    public void ShapeTest() {
        Shape circle1 = new Circle("Wheel", 10, origin);
        Shape circle2 = new Circle("Wheel", 10, origin);

        assertEquals(circle1, circle2);
        assertEquals("Wheel (Circle: Radius 10)", circle1.toString());

        Shape rectangle1 = new Rectangle("Box", 2, 4, origin);
        Shape rectangle2 = new Rectangle("Crate", 4, 2, origin3D);

        assertFalse(rectangle1.equals(rectangle2));

        if (rectangle2 instanceof Rectangle) {
            ((Rectangle) rectangle2).rotate90();
        }

        rectangle2.setName("Box");

        assertEquals(rectangle1, rectangle2);
        assertEquals("Box (Rectangle: 2 x 4)", rectangle1.toString());
    }

    @Test
    public void PositionableTest() {
        // Shape implements Positionable AND Circle inherits Shape THUS Circle implements Positionable

        Positionable circle1 = new Circle("Wheel", 10, new Point(2, 4));

        Positionable circle2 = new Circle("Round", 10, new Point(1, 3));

        // As Positionable-s, the only methods I can invoke
        // are getLocation and setLocation without casting.
        assertFalse(circle1.equals(circle2));
        assertFalse(circle1.getLocation().equals(circle2.getLocation()));

        circle1.setLocation(origin);
        circle2.setLocation(origin);

        assertFalse(circle1.equals(circle2));
        assertEquals(circle1.getLocation(), circle2.getLocation());

        if (circle1 instanceof Shape) {
            ((Shape) circle1).setName("Round");
        }

        assertEquals(circle1, circle2);
    }
}
