package scratch;

import lib.Pair;

import java.util.Collection;

public interface Table<K, V> extends Iterable<Pair<K, V>> {
    public V get(K key);
    public void put(K key, V value);
}
