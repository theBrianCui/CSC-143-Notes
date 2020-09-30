package scratch;

import java.math.BigInteger;

public class A extends Object {
    public int i;

    A () { }

    public void print() {
        System.out.println("A");
        A.staticPrint();
    }

    private static void staticPrint() {
        System.out.println("Static A");
    }

    public static void main(String args[]) {
        A a = new A();
        a.print();

        a.equals(a);

        A.staticPrint();

        BigInteger one = BigInteger.ONE;

        BigInteger one1 = BigInteger.valueOf(1);
    }
}
