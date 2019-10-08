package lib;

import java.math.BigInteger;

public class Triple<L, R, T> extends Pair<L, R> {
    T third;

    public Triple(L left, R right, T third) {
        super(left, right);
        this.third = third;
    }

    public static <A, B, C> Triple<A, B, C> createTriple(A left, B right, C third) {
        return new Triple<A, B, C>(left, right, third);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(this.getClass() == o.getClass())) {
            return false;
        }

        if (!super.equals((Pair) o)) {
            return false;
        }

        Triple other = (Triple) o;
        return this.third.equals(other.third);
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ this.third.hashCode();
    }

    public static void main(String[] args) {
        Triple<String, String, Integer> myTriple = new Triple<>("Brian", "Cui", 99);

        Triple<String, String, Integer> john = Triple.createTriple("John", "Doe", 18);

        // new BigInteger(5);
        BigInteger.valueOf(10);
    }
}
