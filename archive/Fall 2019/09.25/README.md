# IntelliJ, Test-Driven Development, Debugging, Project 0

## IntelliJ

IntelliJ is the preferred IDE of choice for this class.

IntelliJ Community Edition is completely free to use
and is compatible with your AdoptOpenJDK 11 install.

Download: [https://www.jetbrains.com/idea/](https://www.jetbrains.com/idea/)

You are welcome to use any IDE of choice for this class,
though I recommend IntelliJ for a number of reasons.

 - Robust debugging: real time variable and call stack inspection,
   plus expression evaluation

 - Built-in test suite support for jUnit: run and debug individual tests,
   see the expected vs. actual output for assertions
 
 - Built-in support for Git: use `git` entirely through the GUI,
   inline `git diff` shows changes directly in the editor

 - Customizable interface: light and dark theme, editor colors,
   customizable keyboard shortcuts

**Bonus**: IntelliJ supports Eclipse project configurations.

In the future (in other classes or at work),
you can open Eclipse projects inside your IntelliJ environment! 

## FizzBuzz and Software Testing

*FizzBuzz* is a fairly simple programming challenge that has become
a bit of an interviewing meme that filters programmers from non-programmer
candidates to programming jobs. The problem goes:

```
Write a function that prints the numbers from 1 to 100, inclusive.
Except, if the number is divisible by 3, print "Fizz".
        if the number is divisible by 5, print "Buzz".
        if the number is divisible by both, print "FizzBuzz".
```

Example output:
```
1
2
Fizz
4
Buzz ...
```

*Let's Write:* FizzBuzz

## Software Testing

### What is software testing?

Software testing is writing code to evaluate the correctness of code.

 - *Expectations* or *Assertions* check the outputs of a program
 - Tests enforce the specification for a program

There are two types of tests:

 - *Unit Tests:* test specific module or function
 - *Integration tests:* test large parts of program as a whole

Tests aren't magic - they're code!

```
public void myUnitTest() {
  ArrayList<Integer> array = new ArrayList<>();
  assertEquals(0, array.size());
  array.add(500);
  assertEquals(1, array.size());
}
```

A basic test is composed of a function (the test itself)
that contains *assertions* that must all pass for the test to pass.



See/write: FizzBuzzTest

Some languages like JavaScript separate the above three components:
 - Test Runner (runs tests in sequence, reports output)
 - Assertion library: expect(var).to.be(5)
 - Mocking library:

jUnit contains the first two. "Mockito" is a Java method mocking library (but we won't need it)

See: How do we add jUnit to our projects?
 - jUnit is included in all project code
 
Software testing provides great value to large team projects!
By *asserting* the behavior of a function or module,
you define a specification for that behavior and
you *protect* that behavior from being modified incorrectly.

 - "Presubmit gating" prevents developers from pushing (uploading) code
   that doesn't pass the test suite

Software testing is however, not foolproof and perfect.

*****************************************

BIG IDEA: Abstraction - what is it?
 - Taking complex things and making them *abstract*

sendBytes(recipient, bytes) {
}

receiveBytes(sender, bytes) {
}

What are Classes?
 - Blueprints for Objects
 - Containers of "state"
 - Exposes methods for implementing state

C Programming "Procedural" vs Java OOP Programming


See: Circle, a very simple container class
    // public: Anyone can access
    // protected: Myself and my children
    // private: Myself only

What are Interfaces (abstractly speaking)?
 -

What are Interfaces (Java?)
 - Describes methods a class must implement
 - Does NOT describe how the methods are implemented

Implement: Shape2D
See: Shape2DTest


See: Sorter
See: test.SorterTest


Let's talk about Project 0...
https://www.briancui.com/csc-143/projects/project0.html

