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
//                pair.right = value;
                // Pair is immutable - cannot be changed
            }
        }
        // Example end

        // ArrayList is a List
        // List provides ListIterator
        // ListIterator has a "set" method that lets us replace values

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

    public static void main(String args[]) {
        Table<String, Integer> peopleAge = new ArrayListTable<>();

        peopleAge.put("John", 20);
        peopleAge.put("Alfred", 70);
        peopleAge.put("Bruce", 40);

        for(Pair<String, Integer> pair : peopleAge) {
            System.out.println(pair.left + " : " + pair.right);
        }

        peopleAge.put("Alfred", 81);
        for(Pair<String, Integer> pair : peopleAge) {
            System.out.println(pair.left + " : " + pair.right);
        }

        String a = "hello world";
        String b = "hello world";
        String c = "hello world";

        a.equals(b);

        System.out.println(a.hashCode());
    }
}
