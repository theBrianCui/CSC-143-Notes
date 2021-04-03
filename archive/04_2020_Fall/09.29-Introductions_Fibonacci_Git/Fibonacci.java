import java.util.Arrays;
import java.math.BigInteger;

public class Fibonacci {
    public static void main(String args[]) {
        System.out.println(Arrays.toString(computeRange(
            10000
        )));
    }

    public static BigInteger[] computeRange(int upToIndex) {
        BigInteger[] fib = new BigInteger[upToIndex];
        for (int i = 0; i < upToIndex; ++i) {
            fib[i] = fibonacci(BigInteger.valueOf(i));
        }

        return fib;
    }

    // O(2^n)
    public static BigInteger fibonacci(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        }

        if (n.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }

        BigInteger first = BigInteger.ZERO;
        BigInteger second = BigInteger.ONE;
        BigInteger next = first.add(second);
    
        for (BigInteger i = BigInteger.TWO;
             i.compareTo(n) <= 0;
             i = i.add(BigInteger.ONE)) {
            next = first.add(second);
            first = second;
            second = next;
        }

        return next;
    }
}
