import java.util.Arrays;
import java.math.BigInteger;

public class Fibonacci {
    public static void main(String args[]) {
        System.out.println(Arrays.toString(computeRange(5000)));
    }

    public static int[] computeRange(int upToIndex) {
        int[] fib = new int[upToIndex];
        for (int i = 0; i < upToIndex; ++i) {
            fib[i] = fibonacci(i);
        }

        return fib;
    }

    // O(2^n)
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int first = 0;
        int second = 1;
        int next = first + second;
        for (int i = 2; i <= n; ++i) {
            next = first + second;
            first = second;
            second = next;
        }

        return next;
    }
}
