# Linked Lists and the List Interface

## Previously, on CSC 143

Primitive arrays in Java and fixed length, `int[] array = new int[n];`, for good reasons:
 
  - By definition, arrays are contiguously stored.

  - Indexing beyond the space dedicated to the array is *dangerous* as it can overwrite other objects on the **heap**.

  - The allocation (`new`) and freeing of Objects (garbage collection) on the heap causes **fragmentation**, the interleaving of free and occupied heap space.

  - **Fragmentation** limits the availability of large, *contiguous* chunks of free memory.

As developers, fixed length arrays are a significant limitation.

  - We don't always know in advance how much space we need.
  - Allocating an array that's too small can cause us can run out of space when we need it.
  - Allocating an array that's too large can be wasteful.

### Big O

We use **Big O** to measure the runtime and memory cost of algorithms.

Big O can be determined with three steps:

 1. Start with some input size of length `n`
 2. Count the number of steps relative to `n`
 3. Drop constants and constant multipliers

Common "classes" of Big O are `O(1)` (constant time), `O(logn)` (logarithmic), `O(n)` (linear), `O(nlogn)` (linearithmic), `O(n^2)` (quadratic).

The smaller the Big O, the more efficient the algorithm.

## Linked Lists

### Pointers and References Recap

**Memory addresses** are locations in memory, much like street addresses.

Every Object in memory has a dedicated memory address, describing its physical location in memory.

**Pointers** are plain integers that store memory addresses.

A **reference** is a special kind of pointer that has a *type* and does not permit pointer arithmetic.

In Java, every Object variable is actually a **reference** to the Object. Java is *pass by value*, meaning arguments and return values are copied as references.

See: ReferenceTest.java

### Linked Lists: Motivation

Arrays and ArrayLists are *contiguous* by definition, but this has its own consequences:

  - Contiguous region must exist in the heap to store array
  - Insertion at middle is costly, must copy all successive elements forward `O(n)`
  - Insertion at front is costly, must copy all successive elements forward `O(n)`
  - Deletion at front/middle is costly, must copy all successive elements backward `O(n)`
  
See (Debug): ArrayListTest.java

### Linked Lists: Description

The **Linked List** is a kind of data structure where each element stores a value (sometimes called payload) and a *reference* to the next value.

Rather than store data contiguously, store each element separately. Then, *link* them together with pointers (references), in a given order.

By chaining several values together using references, a Linked List is formed.

Whiteboard: Singly Linked List

See: Node.java

Let's analyze the runtime cost of Linked List operations.

  - 

## Interfaces and Runtime

Java interfaces like Collection were designed so that runtime and storage cost are abstracted away.

Calling `.add(int index, E element)` looks easy, but its computational cost depends on the *child structure implementation!*

*Regardless* of the backing structure (Array-like or List-like or Set-like), Java interfaces guarantee such methods are always available.

Is this good design?








 - **YES:** Developers should expect a consistent and predictable interface for all similar Objects; the choice to use an inefficient concrete structure is the developer's fault.

 - **NO:** Developers should never have the option of using an inefficient concrete structure where a more efficient one is expected, method calls that are costly should not be made available

## What about memory management?

Big O does not often consider the cost of internal, practical memory management.

 - Cost to find and allocate space in the **heap**, the pool of memory where all Objects live.
 
   - Expanding the ArrayList requires scanning the heap for a new, large, contiguous space.
   - Other structures that distribute their memory usage across several small spaces in the heap are easier to manage.

 - Cost of cache "misses". Computers automatically store recently used and predictably used memory in faster cache storage.
 
   - ArrayList has the advantage that its references are contiguous, and more cache friendly: several references can be loaded into cache at once.
   - Other structures are less cache-friendly because they 

Most of the time, we ignore these memory management costs, but they can have real practical performance affects!

See: Next week's reading, ArrayList vs. LinkedList
>>>>>>> 7f8882cb6f3c65759dd4ab1e4efa85aa67fe7431

