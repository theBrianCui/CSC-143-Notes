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

### ArrayList

Classes are a layer of **abstraction** that mask complex implementation with simple interfaces (public methods).

The **ArrayList** is a class containing the primitive array that enables "unlimited" length.

  - ArrayList interface is a superset of the array interface, with indexing `O(1)`

  - ArrayList *extends* array functionality with `add()` append and insert, `remove()` from middle or ends.