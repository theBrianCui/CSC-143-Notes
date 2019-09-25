package interview;

public class FizzBuzz {
    /*
        FizzBuzz is often considered a meme/joke interview question,
        but there are several online anecdotes of interviewers who are
        surprised to find how few applicants are able to get past what appears
        to be a simple programming problem. If you can write FizzBuzz, congratulations!
        You're in the top 1%.

        Write a program that prints the numbers 1 to 100, inclusive.
        Except, if the number is divisible by 3, print "Fizz".
        If the number is divisible by 5, print "Buzz".
        If the number is divisible by both, print "FizzBuzz".
     */

    public static void main(String args[]) {
        for (int i = 1; i <= 100; ++i) {
            System.out.println(fizzbuzz(i));
        }
    }

    public static String fizzbuzz(int i) {
        if (i % 3 == 0 && i % 5 == 0) {
            return "FizzBuzz";
        } else if (i % 3 == 0) {
            return "Fizz";
        } else if (i % 5 == 0) {
            return "Buzz";
        }

        return Integer.toString(i);
    }
}
