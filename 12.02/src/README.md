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

In this class (and previous classes), you have learned **imperative** programming.
 
 - Objects with internal state
 - Modifications to state via methods
 - Methods are written as a list of statements

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
   - No implicit `this`, function is not attached to any instance
   - No system calls are invoked (e.g. `println`, write to file)

 - All the information needed for the function to run is in the argument
 
 - All calls to the function with the *same* argument
   **always** produce the same output.

### Is Java a Functional Language?

Not really.

No.

Java is first and foremost an object-oriented programming language.

Objects and methods are a core part of Java language design.
