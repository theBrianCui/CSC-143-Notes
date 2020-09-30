package world;

import lib.Pair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Restaraunt extends Store {
    public HashMap<String, Collection<Pair<String, Integer>>> recipes = new HashMap<>();
    public Restaraunt(String location, String company) {
        super(location, company);
    }

    @Override
    public Collection<Pair<String, Integer>> purchase(Collection<Pair<String, Integer>> order) {
        return null;
    }

    @Override
    public Collection<Pair<String, Integer>> getProducts() {
        return null;
    }

    public void learnRecipe(String name, Collection<Pair<String, Integer>> ingredients) {
        recipes.put(name, ingredients);
    }

}
