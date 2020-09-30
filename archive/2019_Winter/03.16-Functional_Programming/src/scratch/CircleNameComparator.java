package scratch;

import java.util.Comparator;

public class CircleNameComparator implements Comparator<Circle> {

    @Override
    public int compare(Circle o1, Circle o2) {
        int stringCompare = o1.name.compareTo(o2.name);

        if (stringCompare == 0) {
            return o1.compareTo(o2);
        }

        return stringCompare;
    }
}
