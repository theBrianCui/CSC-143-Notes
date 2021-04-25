package lib;

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
}
