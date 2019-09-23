
/*
Problem:
 - Programming is complicated, most pieces of code depend on several others
 - one change can easily break everything, hard to recover and track
 - single source of truth prohibits large experimentation
 - someone else can clobber your code

Version Control: software for tracking code changes over time, enabling you to follow different versions of your code as it is developed

What do we want in a VCS?
 - Easy to take snapshots of the current code base: "commits"
 - Easy to *branch* the existing code and track several variations at once
 - Easy to collaborate with others and allow others to make changes without interference
 - Easy on the filesystem

Git:
 - A "repository" is where all the code for a program is stored (root folder)
 - "Commits" are individual changes tagged with a message
 - "Branches" are different independent variations of your program
 - Your final program is the sum of your commits

Steps for use:
 1. Initialize repository
 2. Write code
 2.1 Check git status
 2.2 Git add
 3. Commit code with a message
 4. GOTO 2

Pro tips:
 - .gitignore
 - commit early, commit often
 - branching is cheap
 - store your code on GitHub, but make it private!
 - checkout to time travel, branch if needed

 */


import java.util.Arrays;

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
}
