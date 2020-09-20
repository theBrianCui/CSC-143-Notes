package scratch;

import java.util.Comparator;

public class CircleDescendingComparator implements Comparator<Circle> {

    @Override
    public int compare(Circle o1, Circle o2) {
        return -1 * o1.compareTo(o2);
    }
}
