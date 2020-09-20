package lib;

import java.math.BigInteger;

/**
 * A simple container for two variables.
 * @param <L> Left value.
 * @param <R> Right value.
 */
public class Pair<L, R> {
    public final L left;
    public final R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public static <A, B> Pair<A, B> createPair(A left, B right) {
        return new Pair<A, B>(left, right);
    }

    public <A> A noop(A object) {
        return object;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(this.getClass() == o.getClass())) {
            return false;
        }

        Pair other = (Pair) o;
        return left.equals(other.left) && right.equals(other.right);
    }

    @Override
    public int hashCode() {
        return left.hashCode() ^ right.hashCode();
    }

    public static void main(String args[]) {
        Pair<String, Integer> nameToAge = new Pair<String, Integer>("Brian", 99);

        System.out.println("Name: " + nameToAge.left);
        System.out.println("Age: " + nameToAge.right);

        BigInteger z = nameToAge.noop(BigInteger.ZERO);

        Pair<String, Integer> john = Pair.createPair("John", 18);
    }
}
