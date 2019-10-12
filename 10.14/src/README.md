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
 
The most efficient algorithms have the smallest Big O.


## Linked Lists

Arrays and ArrayLists are *contiguous* by definition, but this has its own consequences:

  - Contiguous region must exist in the heap to store array
  - Insertion at middle is costly, must copy all successive elements forward `O(n)`
  - Insertion at front is costly, must copy all successive elements forward `O(n)`
  - Deletion at front/middle is costly, must copy all successive elements backward `O(n)`
  
See (Debug): ArrayListTest.java

The **Linked List** data structure takes a different approach:

Rather than store data contiguously, store each element separately. Then, *link* them together with pointers (references), in a given order.

Whiteboard: Array in memory
Whiteboard: Singly Linked List in memory

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

