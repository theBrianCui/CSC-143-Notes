package test;

import interview.FizzBuzz;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class FizzBuzzTest {
    String fizz = "Fizz";
    String buzz = "Buzz";

    @Test
    public void FizzBuzzThreesTest() {
        assertEquals("Fizz", FizzBuzz.fizzbuzz(3));
        assertEquals("Fizz", FizzBuzz.fizzbuzz(6));
        assertEquals("Fizz", FizzBuzz.fizzbuzz(9));

        for (int i = 3; i <= 100; i += 3) {
            assertTrue(FizzBuzz.fizzbuzz(i).contains("Fizz"));
        }
    }

    // Unit tests
    @Test
    public void FizzBuzzFiveTest() {
        assertEquals("Buzz", FizzBuzz.fizzbuzz(5));
        for (int i = 5; i <= 100; i += 5) {
            assertTrue(FizzBuzz.fizzbuzz(i).contains("Buzz"));
        }
    }

    // Integration test
    @Test
    public void FizzBuzzNumberTest() {
        for (int i = 1; i <= 100; ++i) {
            String output = FizzBuzz.fizzbuzz(i);
            if (i % 3 == 0) {
                assertTrue(output.contains("Fizz"));
            }
            if (i % 5 == 0) {
                assertTrue(output.contains("Buzz"));
            }
            if (i % 3 != 0 && i % 5 != 0) {
                assertEquals(Integer.toString(i), output);
            }
        }
    }
}
