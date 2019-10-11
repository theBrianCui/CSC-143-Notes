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

The **Linked List** is a kind of data structure 