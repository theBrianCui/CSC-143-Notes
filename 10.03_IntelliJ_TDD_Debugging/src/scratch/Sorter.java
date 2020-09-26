package scratch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sorter {
    public static class SimpleComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            //return o1.compareTo(o2);
            int a = o1.intValue();
            int b = o2.intValue();

            return a - b;
        }
    }

    public static List<Integer> sort(List<Integer> c) {
        c.sort(new SimpleComparator());
        return c;
    }

    public static List<Integer> copySort(List<Integer> c) {
        List<Integer> copy = List.copyOf(c);
        sort(c);
        return copy;
    }
}
