package scratch;

import java.util.HashMap;

public class HashSet<T> {
    // the choice of Integer here is meaningless (but we'd prefer smaller values),
    // anything not-null demonstrates the key is present in the map

    HashMap<T, Integer> internalMap = new HashMap<>();

    public void add(T value) {
        internalMap.put(value, 1);
    }

    public boolean contains(T value) {
        return internalMap.get(value) != null;
    }

    public void remove(T value) {
        internalMap.remove(value);
    }
}
