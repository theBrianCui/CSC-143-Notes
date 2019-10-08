package scratch;

import java.util.ArrayList;
import java.util.Arrays;

public class BigO {
    int[] array;
    public BigO(int n) {
        this.array = new int[n];
    }

    // O(???)
    public int get(int i) {
        return this.array[i];
    }

    // O(???)
    public void set(int i, int value) {
        this.array[i] = value;
    }

    // O(???)
    public int size() {
        return this.array.length;
    }

    // O(???)
    public int indexOf(int o) {
        for (int i = 0; i < this.array.length; ++i) {
            if (o == this.get(i))
                return i;
        }
        return -1;
    }

    // O(???)
    public String toString() {
        return Arrays.toString(array);
    }

    // O(???)
    public static char[][] triangle(int n) {
        char[][] square = new char[n][n];
        for (int row = 0; row < square.length; ++row) {
            for (int col = 0; col <= row; ++col) {
                square[row][col] = '*';
            }
        }

        return square;
    }

    // O(???)
    public void selectionSort() {
        for (int sortedIndex = 0; sortedIndex < array.length; ++sortedIndex) {

            int min = this.array[sortedIndex];
            int minIndex = sortedIndex;

            for (int i = sortedIndex; i < this.array.length; ++i) {
                int value = this.array[i];

                if (value < min) {
                    min = value;
                    minIndex = i;
                }
            }

            int temp = this.array[sortedIndex];
            this.array[sortedIndex] = min;
            this.array[minIndex] = temp;
        }
    }

    // O(???)
    public static int fib(int i) {
        if (i == 0)
            return 0;
        if (i == 1)
            return 1;
        return fib(i - 1) + fib(i - 2);
    }

    public static void main(String args[]) {
        BigO arr = new BigO(10);

        for (int i = 0; i < arr.size(); ++i) {
            arr.set(i, (int) Math.round(Math.random() * 100));
        }

        System.out.println(String.format("Before: %s", arr.toString()));
        arr.selectionSort();
        System.out.println(String.format("After: %s", arr.toString()));

        char[][] triangle = BigO.triangle(10);
        for (char[] row : triangle) {
            System.out.println(new String(row));
        }
    }
}
