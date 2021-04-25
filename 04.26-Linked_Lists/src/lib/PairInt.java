package lib;

public class PairInt {
    public final Integer left;
    public final Integer right;

    public PairInt(int left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) {
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
