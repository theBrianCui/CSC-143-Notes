package test;

import interview.FizzBuzz;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class FizzBuzzTest {
    String fizz = "Fizz";
    String buzz = "Buzz";
    String fizzbuzz = fizz + buzz;

    @Test
    public void DivisibleByThreeTest() {
        assertEquals(fizz, FizzBuzz.fizzbuzz(3));
        assertEquals(fizz, FizzBuzz.fizzbuzz(6));
        /* ... */

        for (int i = 3; i <= 100; i += 3) {
            assertTrue(FizzBuzz.fizzbuzz(i).contains(fizz));
        }
    }

    @Test
    public void DivisibleByFiveTest() {
        assertEquals(buzz, FizzBuzz.fizzbuzz(5));
        assertEquals(buzz, FizzBuzz.fizzbuzz(10));
        /* ... */

        for (int i = 5; i <= 100; i += 5) {
            assertTrue(FizzBuzz.fizzbuzz(i).contains(buzz));
        }
    }

    @Test
    public void DivisibleByBothTest() {
        assertEquals(fizzbuzz, FizzBuzz.fizzbuzz(15));
        assertEquals(fizzbuzz, FizzBuzz.fizzbuzz(30));
        /* ... */

        for (int i = 15; i <= 100; i += 15) {
            assertEquals(fizzbuzz, FizzBuzz.fizzbuzz(i));
        }
    }

    @Test
    public void IndivisibleTest() {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 || i % 5 == 0) continue;

            assertEquals(Integer.toString(i), FizzBuzz.fizzbuzz(i));
        }
    }
}
