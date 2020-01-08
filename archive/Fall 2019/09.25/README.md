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

 - Built-in test suite support for jUnit
 
 - Built-in support for Git
  
 - Customizable interface: light and dark theme, editor colors,
   customizable keyboard shortcuts

## FizzBuzz and Software Testing

Let's Write: FizzBuzz

What is software testing?
 - Writing code to evaluate the correctness of code
 - Set expectations for input and output
 - Develop specification for a program

Two types of tests:
 - Unit Tests: test specific module or function
 - Integration tests: test large parts of program

What does a test look like?
 - "Assertions" evaluate outcomes
   - assertEquals, assertTrue, fail()
 - jUnit 4

See/write: FizzBuzzTest

Some languages like JavaScript separate the above three components:
 - Test Runner (runs tests in sequence, reports output)
 - Assertion library: expect(var).to.be(5)
 - Mocking library:

jUnit contains the first two. "Mockito" is a Java method mocking library (but we won't need it)

See: How do we add jUnit to our projects?
 - jUnit is included in all project code

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

