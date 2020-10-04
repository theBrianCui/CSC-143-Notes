package test;

import org.junit.Before;
import org.junit.Test;
import scratch.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class ShapeTest {
    Point origin;

    @Before
    public void setUp() {
        origin = new Point(0, 0);
    }

    @Test
    public void PointEqualityTest() {
        // The use of instanceof rather than .classOf()
        // permits the equality of a Point and a Point3D
        // Whether this behavior is desirable is up to you as a programmer

        assertEquals(origin, new Point3D(0, 0, 0));
    }

    @Test
    public void RectangleTest() {
        Rectangle r = new Rectangle(5, 10, origin);
        assertEquals(50, Math.round(r.area()));
    }

    @Test
    public void PolymorphicArgumentTest() {
        // A Point3D is a Point, so the Rectangle constructor
        // is happy to accept one.

        Rectangle r = new Rectangle(5, 10, origin);
        Rectangle q = new Rectangle(5, 10, new Point3D(0, 0, 0));

        // Rectangle equality only cares about equality of its properties
        // Implementation of Point is responsible for its Point equality

        assertEquals(r, q);
    }

    @Test
    public void PolymorphicSquareTest() {
        // Observe: Squares ARE Rectangles
        // Squares fulfill the interface already supplied by Rectangle

        Rectangle r = new Square(5, origin);

        assertEquals(25, Math.round(r.area()));

        // The correct version of .toString() is determined at runtime
        // Despite r being declared a Rectangle type,
        // .toString() is called on its subclass implementation

        assertEquals("Square: 5 x 5", r.toString());
    }

    @Test
    public void PolymorphicShapeTest() {
        // Rectangle, Square, Circle implement Shape

        Shape r = new Rectangle(2, 4, origin);
        Shape s = new Square(3, origin);
        Shape c = new Circle(10, origin);


























        // Shape exposes the methods provided by the Shape interface
        // Therefore we can safely call those methods
        // despite not knowing the actual implementation of the shape class

        assertEquals(8, Math.round(r.area()));
        assertEquals(9, Math.round(s.area()));
        assertEquals(314, Math.round(c.area()));
        assertEquals(r.getLocation(), origin);
        assertEquals(s.getLocation(), origin);
    }

    private Shape noop(Shape shape) {
        return shape;
    }

    @Test
    public void PolymorphicCastingTest() {
        // Sometimes you have a top-level class or interface
        // but you know for a fact that it's a lower level class,
        // i.e. you checked using instanceof

        // Casting is one way you can treat a class as a more specific type
        // HOWEVER, this does NOT override the polymorphic behavior of your method calls!
        Square square = new Square(2, origin);
        Circle circle = new Circle(10, origin);

        Shape s = noop(square);
        assertEquals("Square: 2 x 2", s.toString());

        s = noop(circle);
        assertEquals("Circle: Radius 10", s.toString());

        // Casting "down" the hierarchy is dangerous: the instance could actually be
        // a different type in the hierarchy, i.e. Circle cast to Rectangle
        try {
            Rectangle r = (Rectangle) s;
            fail();
        } catch (ClassCastException e) {
            // test does NOT Fail because exception was thrown and we enter this block
        }

        Rectangle castRect = (Rectangle) square;
        assertEquals("Square: 2 x 2", castRect.toString());

        Square castSquare = (Square) castRect;
        assertEquals("Square: 2 x 2", castSquare.toString());

        // You can always safely cast "up" the hierarchy.
        castRect = (Rectangle) castSquare;
        assertEquals("Square: 2 x 2", castSquare.toString());

        // Conclusion:

        // Classes expose interfaces through public methods that clients can invoke
        // Class hierarchies enable you to reuse and extend existing class behavior
        // Clients can continue to use high-level classes without knowledge of low-level implementations
        // The class forms a "layer of abstraction" between its interface and its implementation
    }
}
