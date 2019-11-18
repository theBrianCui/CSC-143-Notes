package scratch;

import lib.Pair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListTable<K, V> implements Table<K, V> {
    private ArrayList<Pair<K, V>> table = new ArrayList<>();

    public V get(K key) {
        for (Pair<K, V> pair : table) {
            if (pair.left.equals(key)) {
                return pair.right;
            }
        }

        return null;
    }

    public void put(K key, V value) {

        // Example code only, do not use
        for (Pair<K, V> pair : table) {
            if (pair.left.equals(key)) {
                // pair.right = value;
                // Pair is immutable - cannot be changed
            }
        }
        // Example end

        ListIterator<Pair<K, V>> i = table.listIterator();
        while (i.hasNext()) {
            Pair<K, V> pair = i.next();

            if (pair.left.equals(key)) {
                i.set(new Pair<>(key, value));
                return;
            }
        }

        table.add(new Pair<>(key, value));
    }


    @Override
    public Iterator<Pair<K, V>> iterator() {
        return table.iterator();
    }
}
