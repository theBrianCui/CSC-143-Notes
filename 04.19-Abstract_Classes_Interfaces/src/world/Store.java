package world;

import lib.Pair;


import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public abstract class Store extends Building implements Business {
    private String company;
    protected HashMap<String, Integer> supplies = new HashMap<>();

    protected Store(String location, String company) {
        super(location);
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    /*
        New to HashMap? A HashMap is a sort of lookup table (dictionary)
        which maps keys to values. It has O(1) read and O(1) write.
        The Java HashMap is very similar to the Python dict().

        The interface is straightforward:
            - put(k, v) sets a key and value
            - get(k) retrieves a value
            - containsKey(k) checks if there is a value associated with a key
            - keySet() returns an iterable key set
    */
    public void supply(Collection<Pair<String, Integer>> load) {
        for (Pair<String, Integer> p : load) {
            if (supplies.containsKey(p.left)) {
                supplies.put(p.left, supplies.get(p.left) + p.right);
                continue;
            }

            supplies.put(p.left, p.right);
        }
    }

    public abstract Collection<Pair<String, Integer>> purchase(Collection<Pair<String, Integer>> order);

    /* Convenience overloaded method for single-item purchases. */
    public Collection<Pair<String, Integer>> purchase(Pair<String, Integer> order) {
        return this.purchase(Arrays.asList(order));
    }

    public abstract Collection<Pair<String, Integer>> getProducts();
}
