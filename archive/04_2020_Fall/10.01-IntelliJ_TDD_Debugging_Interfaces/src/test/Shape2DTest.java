package test;

import org.junit.Test;
import scratch.Circle;
import scratch.Rectangle;
import scratch.Shape2D;

import static junit.framework.TestCase.assertEquals;

public class Shape2DTest {
    @Test
    public void RectangleTest() {
        Rectangle rect = new Rectangle(1, 2);

        assertEquals(1, rect.getWidth());
        assertEquals(2, rect.getHeight());

        rect.setWidth(2);
        rect.setHeight(1);
        assertEquals(2, rect.getWidth());
        assertEquals(1, rect.getHeight());

        rect.doubleDimensions();
        assertEquals(4, rect.getWidth());
        assertEquals(2, rect.getHeight());

        assertEquals(8, Math.round(rect.area()));
    }

    @Test
    public void CircleTest() {
        Circle circle = new Circle(5);
        assertEquals(5, circle.getRadius());

        circle.setRadius(10);
        assertEquals(10, circle.getRadius());

        assertEquals(314, Math.round(circle.area()));
    }

    @Test
    public void Shape2DTest() {
        Shape2D s1 = new Rectangle(1, 2);
        Shape2D s2 = new Circle(10);

        assertEquals(2, Math.round(s1.area()));
        assertEquals(314, Math.round(s2.area()));


        s2 = s1;
        assertEquals(2, Math.round(s2.area()));

    }
}
