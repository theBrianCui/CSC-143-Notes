package test;

import org.junit.Test;
import scratch.Circle;
import scratch.CircleDescendingComparator;
import scratch.CircleNameComparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class CircleTest {
    @Test
    public void circleCompareToTest() {
        Circle x = new Circle(5);
        Circle y = new Circle(10);

        assertEquals(-1, x.compareTo(y));
        assertEquals(1, y.compareTo(x));

        Circle z = new Circle(10);

        assertEquals(0, y.compareTo(z));
    }

    @Test
    public void circleSortTest() {
        List<Circle> circleList = Arrays.asList(
                new Circle(1),
                new Circle(9),
                new Circle(3),
                new Circle(0),
                new Circle(3),
                new Circle(7)
        );

        Collections.sort(circleList);

        List<Circle> expectedList = Arrays.asList(
                new Circle(0),
                new Circle(1),
                new Circle(3),
                new Circle(3),
                new Circle(7),
                new Circle(9)
        );

        assertEquals(expectedList, circleList);
    }

    @Test
    public void circleDescendingComparatorTest() {
        List<Circle> circleList = Arrays.asList(
                new Circle(1),
                new Circle(9),
                new Circle(3),
                new Circle(0),
                new Circle(3),
                new Circle(7)
        );

        Collections.sort(circleList, new CircleDescendingComparator());

        List<Circle> expectedList = Arrays.asList(
                new Circle(9),
                new Circle(7),
                new Circle(3),
                new Circle(3),
                new Circle(1),
                new Circle(0)
        );

        assertEquals(expectedList, circleList);
    }

    @Test
    public void circleNameComparatorTest() {
        List<Circle> circleList = Arrays.asList(
                new Circle(1, "Frank"),
                new Circle(9, "Bob"),
                new Circle(3, "Eli"),
                new Circle(0, "Charlie"),
                new Circle(3, "Daniel"),
                new Circle(7, "Alice")
        );

        Collections.sort(circleList, new CircleNameComparator());

        List<Circle> expectedList = Arrays.asList(
                new Circle(7, "Alice"),
                new Circle(9, "Bob"),
                new Circle(0, "Charlie"),
                new Circle(3, "Daniel"),
                new Circle(3, "Eli"),
                new Circle(1, "Frank")
        );

        assertEquals(expectedList, circleList);
    }
}
