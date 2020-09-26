import java.util.Arrays;
import java.math.BigInteger;

public class Fibonacci {
    public static void main(String args[]) {
        System.out.println(Arrays.toString(computeRange(10)));
    }

    public static int[] computeRange(int upToIndex) {
        int[] fib = new int[upToIndex];
        for (int i = 0; i < upToIndex; ++i) {
            fib[i] = computeRecursive(i);
        }

        return fib;
    }

    // O(2^n)
    public static int computeRecursive(int n) {
        return 0;
    }
}
