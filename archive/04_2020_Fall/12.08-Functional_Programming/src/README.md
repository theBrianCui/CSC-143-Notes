# Functional Programming in Java

## Functional Programming

### On Static Methods

Methods in Java are functions attached to an *instance* of a type.

```
class Square implements Shape {
  int width;

  @Override
  double area() {
    return this.width * 2;
  }
}
```

In the `Square` class above, the *method signature*
that defines the method and how it is called,
shows that `area` returns a `double` and takes no arguments.

But there *is* an implicit argument: the instance `this`.
The `area` method cannot live on its own without a `Square` instance to attach to.

Sometimes we want to write standalone functions
which don't have a hard dependency on an instance.

```
class ShapeUtils {
  public static void printArea(Shape shape) {
    System.out.println(shape.area());
  }
}

```
The closest thing in Java is a *static method*.
The static method is attached to the *class*, not an *instance* of it.

```
Shape x = new Shape();
x.width = 5;
ShapeUtils.printArea(x);    // prints 10
```

### The Comparable<T> Interface

A well-known use of a "standalone function" is a *comparator*.

Recall the `Comparable<T>` interface in Java.
Classes which have a natural ordering (i.e. can be sorted, can be put in a BST)
must be comparable to each other.

A class which implements `Comparable<T>` is obligated to supply a `int compareTo(T o)` method
based on how `this` should be *naturally ordered* compared to `o`.

 - If `this` comes before `o`, return `-1`
 - If `this` and `o` are equal in order, return `0`
 - If `this` comes after `o`, return `1`

Remark: in a different universe, we might have used `enum`s instead of `-1, 0, 1`
        why did we settle on integers?
        
```
int compareTo(T o) {
    this.x - o.x;
}
```

See: Circle.java, CircleTest.java

When a class implements `Comparable<T>`,
we can use the Java standard library static method `sort` in the `Collections` utility class

```
List<Integer> list = Arrays.asList(1, 5, 2, 3, 10);

Collections.sort(list);

// list is now [1, 2, 3, 5, 10]
```

Remark: unlike `.equals(...)`, the `Comparable<T>` interface is optional (why?)

### The Comparator<T> Interface

A **comparator** is a function which compares two Objects to define their order.
The `.compareTo(T)` method is a comparator supplied by a class.

However, we may not always want to use the native comparator method:
we may want to arrange instances based on a different comparison.

 - Sorting people by age, instead of name
 - Sorting vehicles by weight, instead of price
 - Sorting music by release date, instead of popularity
    - Sorting music by release date, then popularity to break ties

 - Sorting in descending order, rather than ascending

We could:

 - Modify the `.compareTo(T)` method inside the class (not good, why?)
 
 - Extend the class and override `.compareTo(T)` (also not good, why?)
 
 - Write our own sorting function (not good as well, why?)

Ideally, we'd have a way to reuse `Collections.sort` *and* supply our own comparator.

The `Comparator<T>` interface (note the slight difference in spelling)
describes a standalone class with a method `compare(T, T)` that can be used in place of a native `compareTo(T)` method.

See: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Comparator.html

See: CircleDescendingComparator.java

See: CircleNameComparator.java

See: CircleTest.java

In an interesting design choice, `Comparator<T>` does not make `compare(T, T)` a static method
Instead, it is an instance method and the type must be constructed!

That seems strange until you realize Java does not* let you pass the class itself.

```
Collections.sort(list, MyComparator);           // not OK, need an actual type

Collections.sort(list, new MyComparator());     // OK, sort can invoke compare on the instance
```

*Remark: there is a feature in Java called *reflection* that does permit this.
         Reflection is a bit of a language hack that makes Java act like an interpreted language
         rather than a compiled language. Out of scope for this class, but kinda cool.

While the `Comparator<T>` interface solves our problem of "substituting" methods,
it is unwieldy to use - we must define an entire external class
*and* construct an instance of it just to use it.

We need a better way - a way to pass just a function as an argument - nothing more, nothing less.

### What is Functional Programming?

In this class (and previous classes), you have learned **imperative** programming.
 
 - Objects with internal state (object oriented programming)
 - Modifications to state via methods (procedural programming)
 - Methods are written as a list of statements (imperative programming)

   - variable assignment, `int x = 5 + x;`
   - control flow, `for (int i = 0; i < 100; ++i) { ... }`
   - method invocation, `myList.clear();`

There are some "drawbacks" to this model:

 - Methods (functions) hide behavior, side effects ambiguous
   `myList.clear()`: does it do what we expect?
                     what if it prints to console?
                     what if it writes to a file?
   
 - "Parameters" to methods hide the underlying object
   `myList.clear()`: takes no arguments; the `this` argument is implicit
   
 - Parameters passed in may modify the argument
   `myList.join(otherList)`: does `otherList` get destroyed?

While this *encapsulation* is a useful tool for abstraction,
the methods are **harder to test** for correctness
because the Object state can be infinitely complex.

```
class A {
  int i;
  double b;
  ArrayList<Integer> c;
}
```

There are infinite possible different instances (states) of class A.

**Functional programming** is based around the idea that
instead of writing *procedures* that are line-by-line instructions
which tell the computer *how* to do something,

we write *declarations* that tell the computer *what* to do.

If we can guarantee that each *declaration* is correct in their implementation,
a series of declarations will be a correct program.

### Pure Functions

Consider the following absolute value function:

```
public static int abs(int x) {
  if (x < 0) {
    return -1 * x;
  }

  return x;
}
```

Observations about `int abs(int)`:

 - The function is **pure**. It has no *side effects*.

   - The argument is not modified
   - No variables outside the function are modified
   - No system calls are invoked (e.g. `println`, write to file)
   - All the information needed for the function to run is in the argument
 
 - No implicit `this`, function is not attached to any instance
   The function itself has no influence over any *state*

 - All calls to the function with the *same* argument
   **always** produce the same output.

The `compare(T, T)` method from the `Comparator<T>` *can* be pure
by writing a comparator that only uses arguments and causes no side effects.

However, `compare(T, T)` is still an instance method,
and still suffers the same problems as OOP methods described before.

### Higher-Order Functions

A **higher-order function** is a function that *takes a function* as an argument.

`Collections.sort(List, Comparator)` can be thought of as a higher-order function:

 - The function itself accepts a "function" as an argument, the `Comparator<T>`
 - The `compare(T, T)` method inside the argument is invoked on pairs of elements in the list

"Okay that's nice," you say,
"but we still want to tease apart the method `compare` with its class."

Again, we'd like a way to pass *only* a pure function as an argument,
not an instance of a class that containing a function.

#### Lambdas

Formally, a **lambda** is an *anonymous function* - a function "without a name".

A lambda stands alone - it does not attach to a class like a (static) method,
instead, it can be treated as any other value expression like `1 + 1`.

In Java, the syntax for lambdas is as follows:

```
arguments -> return value
```

Really! The following expressions below are lambdas.
If there is no return statement, the expression on the right is returned.

```
a -> a * 2
a, b -> a + b
(int a, int b) -> a + b
```

If we want multiple lines, we can write a curly brace block,
and use an explicit return statement.

```
(Circle a, Circle b) -> {
    int stringCompare = a.name.compareTo(b.name);
    
    if (stringCompare == 0) {
        return a.compareTo(b);
    }
    return stringCompare;
}
```

Wow! Easy. Can we pass it in to `Collections.sort`?

See: LambdaTest.java

Yes we can! We can use a *lambda* that is *not attached* to a class,
or an instance of a class, to pass a function as an argument to another function!

### Not so fast / "Functional Interfaces"

As with many things in Java, lambdas still have some baggage.

Let's examine the method signature of `Collections.sort` again.

```
public static <T> void sort​(List<T> list, Comparator<? super T> c)
```

When we pass a comparator lambda to `Collections.sort`,
we are passing an Object that fulfills the `Comparator<T>` interface.

Again, the `Comparator<T>` interface appears like
(see https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Comparator.html)

```
interface Comparator<T> {
    public abstract int compare(T o1, T o2)

    ... other methods ... 
}
```

If a lambda is an *anonymous function*,
how could it have concretely fulfilled the `Comparator<T>` interface,
because clients of `Comparator<T>` expect a `compare(T, T)` method that is attached to an Object?

As it turns out, in Java, **lambdas may substitute interfaces with a single abstract method**.

An interface with a single abstract method is called a **functional interface** (Java-specific term).

The name of the abstract method does not matter:
as long as there is *exactly one*, a lambda can be used in place of it.

That lambda will replace the functionality of that single abstract method,
regardless of what that method is named.

For the substitution to be valid, the lambda must have
  - compatible arguments
  - compatible return type
  - see reading for more

See: SampleFunctionalInterface.java

See: LambdaTest.java

In the background, Java actually *constructs a concrete instance* of the interface,
where the lambda substitutes the abstract method requirement.

Remark: Not all lambdas are pure functions... but they can be. A+ for effort

### Is Java a Functional Language?

Not really.

Java is first and foremost an object-oriented programming language.

Objects and methods are a core part of Java language design.

However, since Java 8, Java has introduced several functional programming
features that let developers take advantage of both
OOP and functional programming patterns.

```
inOrder = BinaryTreeAlgorithms.inOrder(binarySearchTree);
output = inOrder.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(" "));

assertEquals("10 25 30 40 45 50 60 75 80 90 100 110", output);
```
