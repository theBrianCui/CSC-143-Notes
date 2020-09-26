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
 
 - Built-in support for Git: use `git` entirely through the GUI menus

 - Customizable interface: light and dark theme, editor colors,
   keyboard shortcuts

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

 - **Unit Tests:** test specific module or function
 - **Integration tests:** test large parts of program as a whole

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

Assertions aren't magic - they're code too.

```
public void assertEquals(Object o1, Object o2) {
  if (!o1.equals(o2)) {
    throw new AssertionError(String.format("Assertion failed, %s != %s\n", o1, o2));
  }
}
```

There are several *testing libraries* available for languages that
contain all the needed components to write unit tests.

 - **Test Runner:** a program with a `main` method that runs tests and reports output)
 
 - **Assertion library:** a collection of assertions like `assertEquals` and `assertTrue`
 
 - Mocking library: a program that can substitute behavior of other classes

jUnit contains the first two: a runner and assertion library.
"Mockito" is a Java method mocking library (but we won't need it)

*See:* Setting up a new Java project in IntelliJ with jUnit

jUnit is included in all project code and should work out-of-the-box
(no additional downloads) for IntelliJ.

*See:* Writing tests for FizzBuzz
*Write:* FizzBuzz
*See:* Debugging FizzBuzz

#### Test-Driven Development

**Test-Driven Development** is the idea that we write tests firsts,
and write code second.

By writing tests first, we are forced to reason about the
**interface** of the code being tested, and the
**specification** for its functionality.

All of your projects in the class will use test-driven development!

Software testing is however, not foolproof and perfect.

 - Tests are NOT a substitute for a formal proof of correctness
 - Tests may not necessarily cover all use cases
 - Tests can be "cheated"
 - The test itself can be incorrect!

## Abstraction and Interfaces

Recall the notion of **abstraction**:
masking complex implementation details with simple interfaces.

### Classes and Objects

Java is an *Object-Oriented* programming language.
Before OOP, there was "procedural programming".

```
struct bread {
  int temperature;
}

void toastBread(bread* b) {
  b->temperature = b->temperature + 20;
}
```

Rather than defining standalone functions that are called throughout the program,
functionality is based on the usage of so-called **Objects**
and the manipulation of those Objects via functions attached to the instances,
known as **methods**.

```
class Bread {
  int temperature;

  void toast() {
    this.temperature += 20;
  }
}
```

In Java, a **class** is a blueprint for an Object. Classes contain:

 - *Properties* (sometimes called instance variables, or fields)
   that define the Object's internal state.

 - *Methods* (functions attached to the object) for modifying state

*See:* Circle, a very simple container class

Methods are a form of **abstraction** by hiding the underlying changes
to the class via function calls.

Furthermore, Java explicitly allows us to hide properties
or methods using *access modifiers*. 

 - `public`: Anyone can access
 - `protected`: Myself and my children (more on child classes later)
 - `private`: Myself only

### Interfaces

In general programming, an **interface** is a set of interactions
made available by a system.

In Java, we said classes were blueprints for Objects.

In Java, an **interface** is a blueprint for a class.

 - Describes methods a class *must* implement
 - Does NOT describe *how* the methods are implemented
 - Cannot have properties* (for the purposes of this class)

*See:* Shape2D
*See:* Shape2DTest

Unlike classes, interfaces cannot be directly constructed!
Instead, an interface must be fulfilled by a concrete class.

Interfaces are useful because they let clients (you)
use classes that fulfill the interface's requirements
*without any knowledge* of the underlying implementation! (Abstraction!)

*See:* Popular Java interfaces

A class can mix-and-match any number of interfaces,
so long as it fulfills all the methods of those interfaces.

## Project 0

Project 0 features some Java interfaces that you need to implement.

 - *Iterable*: describes classes which can be iterated over

 - *Iterator*: describes classes which iterate over a list or sequence

 - *Comparable*: describes classes which can be compared (ordered)

[Check out the Project 0 specification here](https://www.briancui.com/csc-143/projects/project0.html)
