package test;

import org.junit.Test;
import scratch.Circle;
import scratch.SampleFunctionalInterface;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

public class LambdaTest {

    @Test
    public void circleLambdaTest() {
        List<Circle> circleList = Arrays.asList(
                new Circle(1, "Frank"),
                new Circle(9, "Bob"),
                new Circle(3, "Eli"),
                new Circle(0, "Charlie"),
                new Circle(3, "Daniel"),
                new Circle(7, "Alice")
        );

        Collections.sort(circleList, (Circle a, Circle b) -> {
            int stringCompare = a.name.compareTo(b.name);

            if (stringCompare == 0) {
                return a.compareTo(b);
            }
            return stringCompare;
        });

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

    @Test
    public void functionalInterfaceTest() {
        SampleFunctionalInterface lambdaSum = (a, b) -> a + b;

        assertEquals(15, lambdaSum.sumCanBeNamedAnything(5, 10));

        // only the method signature of the abstract method has to match
        // the actual purpose of the function doesn't matter to the compiler

        SampleFunctionalInterface lambdaDivide = (a, b) -> a / b;

        // not a sum! Java don't care
        assertEquals(5, lambdaDivide.sumCanBeNamedAnything(10, 2));

        // the comparator lambda fulfills the method signature of abstract method compare(T,  T)
        Comparator<Circle> stringComparator = (Circle a, Circle b) -> {
            int stringCompare = a.name.compareTo(b.name);

            if (stringCompare == 0) {
                return a.compareTo(b);
            }
            return stringCompare;
        };

        assertEquals(-1, stringComparator.compare(
                new Circle(5, "A"),
                new Circle(5, "B")
        ));

        Collections.sort(new ArrayList<Circle>(), stringComparator);
    }
}
