package scratch;

import java.util.ArrayList;
import java.util.Arrays;

public class BigO {
    int[] array;
    public BigO(int n) {
        this.array = new int[n];
    }

    // O(1) - constant time
    public int get(int i) {
        return this.array[i];
    }

    // O(1) - constant time
    public void set(int i, int value) {
        this.array[i] = value;
    }

    // O(1) - property lookup is constant time
    public int size() {
        return this.array.length;
    }

    // O(n) - linear time
    public int indexOf(int o) {
        for (int i = 0; i < this.array.length; ++i) {
            if (o == this.get(i))
                return i;
        }
        return -1;
    }

    // O(n) - linear time
    public String toString() {
        // O(n)
        return Arrays.toString(array); // O(n)
    }

    // O(n^2)
    public static char[][] triangle(int n) {
        char[][] square = new char[n][n];
        for (int row = 0; row < square.length; ++row) { // O(n * n)
            for (int col = 0; col <= row; ++col) { // O(n)
                square[row][col] = '*'; // O(1)
            }
        }

        return square;
    }

    // O(n^3)
    public static int[][][] cube(int n) {
        int[][][] cube = new int[n][n][n];
        int counter = 0;

        for (int row = 0; row < n; ++row) {
            for (int col = 0; col < n; ++col) {
                for (int depth = 0; depth < n; ++ depth) {
                    cube[row][col][depth] = counter++;
                }
            }
        }

        return cube;
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

    // O(n)
    public boolean isSorted() {
        int current = this.get(0);
        for (int value : this.array) {
            if (value < current)
                return false;

            current = value;
        }

        return true;
    }

    // O(log(n))
    private int indexOfBinarySearch(int target) {
        return this.binSearch(target, 0, this.size());
    }

    private int binSearch(int target, int begin, int end) {
        if (end < begin || begin >= this.size()) {
            return -1;
        }

        if (begin == end) {
            if (target == this.get(begin)) {
                return begin;
            }
            return -1;
        }

        int middle = (begin + end) / 2;
        int middleElement = this.get(middle);
        if (target == middleElement) {
            return middle;
        }

        if (target > middleElement) {
            return binSearch(target, middle + 1, end);
        }
        return binSearch(target, begin, middle);
    }

    // O(2^n)
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

        int first = arr.get(0);
        System.out.println("First item: " + first);

        System.out.println(String.format("Before: %s", arr.toString()));
        arr.selectionSort();
        System.out.println(String.format("After: %s", arr.toString()));

        System.out.println(String.format("indexOfBinSearch(%d) returns: %d", first, arr.indexOfBinarySearch(first)));
        System.out.println(String.format("indexOfBinSearch(%d) returns: %d", 999, arr.indexOfBinarySearch(999)));
        System.out.println(String.format("indexOfBinSearch(%d) returns: %d", -1, arr.indexOfBinarySearch(-1)));

        char[][] triangle = BigO.triangle(10);
        for (char[] row : triangle) {
            System.out.println(new String(row));
        }
    }
}
