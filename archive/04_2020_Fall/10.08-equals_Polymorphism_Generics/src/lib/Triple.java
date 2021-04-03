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

    public static void main(String args[]) {
        Triple<Integer, Integer, String> t = new Triple<>(1, 2, "A");

        Triple<Integer, Integer, String> z = Triple.createTriple(5, 5, "H");
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

class TripleInt extends Triple<Integer, Integer, Integer> {

    public TripleInt(Integer left, Integer right, Integer third) {
        super(left, right, third);
    }
}