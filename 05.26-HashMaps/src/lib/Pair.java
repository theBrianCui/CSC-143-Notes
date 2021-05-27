package lib;

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

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

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
}
