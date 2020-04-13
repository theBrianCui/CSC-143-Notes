import java.util.Arrays;
import java.math.BigInteger;

public class Fibonacci {
    public static void main(String args[]) {
        System.out.println(Arrays.toString(computeRange(500)));
    }

    public static int[] computeRange(int upToIndex) {
        int[] fib = new int[upToIndex];
        for (int i = 0; i <= upToIndex; ++i) {
            fib[i] = computeRecursive(i);
        }

        return fib;
    }

    // O(2^n)
    public static int computeRecursive(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return computeRecursive(n - 1) + computeRecursive(n - 2);
    }

    public static int compute(int n) {
        int low = 0;
        int high = 1;

        if (n == 0) {
            return low;
        }

        if (n == 1) {
            return high;
        }

        for (int i = 2; i <= n; ++i) {
            int next = low + high;
            low = high;
            high = next;
        }
        return high;
    }

    public static BigInteger fibBig(BigInteger index) {
        if (index.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        }

        if (index.equals(BigInteger.ONE)) {
            return BigInteger.valueOf(1);
        }

        BigInteger first = BigInteger.valueOf(0);
        BigInteger second = BigInteger.valueOf(1);
        BigInteger next = BigInteger.valueOf(-1);

        for (BigInteger i = BigInteger.valueOf(2);
             i.compareTo(index) < 0;
             i = i.add(BigInteger.ONE)) {

            next = first.add(second);
            first = second;
            second = next;
        }

        return next;
    }

}
