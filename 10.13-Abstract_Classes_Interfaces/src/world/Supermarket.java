package world;

import lib.Pair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Supermarket extends Store {
    public Supermarket(String location, String company) {
        super(location, company);
    }

    @Override
    public Collection<Pair<String, Integer>> purchase(Collection<Pair<String, Integer>> order) {
        return null;
    }

    @Override
    public Collection<Pair<String, Integer>> getProducts() {
        ArrayList<Pair<String, Integer>> productList = new ArrayList<>();

        for (String p : this.supplies.keySet()) {
            productList.add(new Pair<>(p, this.supplies.get(p)));
        }
        return productList;
    }
}
