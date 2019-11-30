# Functional Programming in Java

## Previously, on CSC 143

The fundamental structures covered in this class have many practical applications:

 - **Arrays**: `O(1)` fast indexing, made faster thanks to caching

 - **Linked List**: chain together data stored separately, useful at the operating system level

 - **Tree**: Balanced Binary Search Trees have `O(logn)` lookup and `O(logn)` insertion, plus sequential ordering (in-order traversal)

 - **Heap**: optimized for priority queue, `O(1)` retrieval and insertion (average)

 - **HashMap**: `O(1)` lookup table from generic to generic, great for string to value dictionary, though space inefficient

 - **Graph**: model real world networks, like transportation and infrastructure.
 
    - Can be stored in several ways: adjacency matrix, references as edges, concrete edge classes

    - **Dijkstra's Algorithm**: finds the shortest path from root to all other nodes
    
    - **Prim's Algorithm**: finds the *minimum spanning tree* of the graph
    
    - Both use a *priority queue* structure to be "greedy" and pick the best available option known so far

Observe: trade-off between space, time, complexity

 - **HashMap** is `O(1)` for all operations, but wastes space and requires good hashing function
 
 - Adjacency matrix for graphs is simple and fast for some use cases, but is `O(n^2)` in space
 
 - Naive sorts (selection sort, insertion sort) are `O(n^2)` in performance, but only `O(1)` in stack space as they may be implemented iteratively 
 
 - Optimal sorts (merge sort, quick sort) are `O(logn)` in performance, but `O(nlogn)` in stack space due to recursion

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

Sometimes we want to write "plain" functions (not a formal term)
which don't have a hard dependency on an instance.

```
class ShapeUtils {
  public static void printArea(Shape shape) {
    System.out.println(square.area());
  }
}

```
The closest thing to a standalone function is a *static method* in Java.
The static method is attached to the *class*, not an *instance*.

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
describes a standalone class with a method `compare(T, T)` that can be used in place
of a native `compareTo(T)` method.

See: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Comparator.html

See: CircleDescendingComparator.java

See: CircleNameComparator.java

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

While the `Comparator<T>` interface lets solves our problem of "substituting" methods,
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

If we can guarantee that each *declaration* is correct,
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
 - The `compare(T, T)` method is invoked on pairs of elements in the list

When we iterate over lists (for loop or for each),
the *action* that we take on the elements inside can often be
separated from the act of iteration itself, and thought of as a function.

 - Invoking a function, i.e. `println` for every element in the list
 - Transforming the list data, e.g. `toString` for every element of the list
 - Processing the list data, e.g. finding the sum of all the elements in the list

The three actions above translate to the three common functional programming operations below.

```
forEach(list, print)    // invoke "print" on every element in "list"
map(list, toString)     // transform every element in "list" to its "toString"  
reduce(list, sum)       // combine every element in the "list" using "sum"
```

### Is Java a Functional Language?

Not really.

Java is first and foremost an object-oriented programming language.

Objects and methods are a core part of Java language design.

However, since Java 8, Java has introduced several functional programming
features that let developers take advantage of both
OOP and functional programming patterns.

### Functional Interfaces in Java

## We've Come Full Circle

