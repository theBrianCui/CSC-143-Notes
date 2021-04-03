package test;

import org.junit.Test;
import scratch.Sorter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class SorterTest {
    /* Implementation vs. Validation
        (P = NP?)

       In testing we don't care *how* the method is implemented.
       We care if it is implemented *correctly*.

       It is not always possible to verify correctness, but we can often come close.
       Code coverage is a good heuristic for how "close" we are to verifying that
       an implementation is correct and thoroughly tested.
     */
    private boolean isSorted(List<Integer> list) {
        if (list.size() == 0) {
            return true;
        }

        Integer first = list.get(0);
        for (Integer i : list) {
            int a = first.intValue();
            int b = i.intValue();

            if (a > b)
                return false;

            first = i;
        }

        return true;
    }

    @Test
    public void SortEmptyTest() {
        ArrayList<Integer> unsorted = new ArrayList<>();
        assertTrue(isSorted(unsorted));
    }

    @Test
    public void SortOneTest() {
        ArrayList<Integer> oneElement = new ArrayList<>(Arrays.asList(1));
        assertTrue(isSorted(oneElement));
    }

    @Test
    public void SortMultipleTest() {
        ArrayList<Integer> multiple = new ArrayList<>(Arrays.asList(1, 2, 3));
        assertTrue(isSorted(Sorter.sort(multiple)));
    }

    @Test
    public void SortUnsortedTest() {
        ArrayList<Integer> unsorted = new ArrayList<>(Arrays.asList(3, 2, 1, 0));
        assertFalse(isSorted(unsorted));

        assertTrue(isSorted(Sorter.sort(unsorted)));
    }

    @Test
    public void SortInPlaceTest() {
        List<Integer> unsorted = new ArrayList<>(Arrays.asList(3, 2, 1, 0));
        assertFalse(isSorted(unsorted));

        List<Integer> sorted = Sorter.sort(unsorted);
        assertFalse(unsorted == sorted);
    }
}
