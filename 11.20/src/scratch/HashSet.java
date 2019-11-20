package scratch;

import java.util.HashMap;

public class HashSet<T> {
    // the choice of Integer here is meaningless (but we'd prefer smaller values),
    // anything not-null demonstrates the key is present in the map

    private HashMap<T, Integer> internalMap = new HashMap<>();

    public void add(T value) {
        internalMap.put(value, 1);
    }

    public boolean contains(T value) {
        return internalMap.get(value) != null;
    }

    public void remove(T value) {
        internalMap.remove(value);
    }

    public int size() {
        return internalMap.size();
    }

    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<>();

        numbers.add(5);
        numbers.add(10);
        numbers.add(3);
        numbers.add(10);
        numbers.add(5);

        System.out.println("numbers in the set: " + numbers.size());
        System.out.println("numbers contains 5: " + numbers.contains(5));
        System.out.println("numbers contains 3: " + numbers.contains(3));
        System.out.println("numbers contains 99: " + numbers.contains(99));
    }
}
