# ArrayList, Big O, Collections Interface

## Previously, on CSC 143

**Generics** are a powerful language feature that allow you re-use the *same class* with different **variable types**.

Generics are useful when your class *contains* a type but does not *depend* on its interface.
The type is provided by clients of the class.

**Abstract Classes** are classes that cannot be instantiated and can contain abstract methods.
 - Like Interfaces, abstract classes cannot be directly instantiated, and describe the public method interface for a class hierarchy
 - Unlike Interfaces, abstract classes live in the class hierarchy, and can contain variables and implementation

Java classes may *not* extend more than a single class, but they *may* implement any number of interfaces.

## ArrayList

Java arrays are primitive types, and can't be used where Object types are used (e.g. Generics).

The `ArrayList` is a Java class that holds a list of Objects, much like an array.

 - `array[index] = payload --> .set(index, payload)`
 - `array[index] --> get(index)`
 - `array.length --> size()`

### How do ArrayLists work?

In Java, arrays are a fixed length: `int[] num = new int[5]`

Practically, there is no such thing as an "unlimited length (primitive) array".
Accesses outside the array cause an `IndexOutOfBoundsException` to be thrown.

See: CollectionTest.java, test one

This is because of how arrays and Objects are stored in memory. An array must take up a contiguous chunk of space.
Memory is taken and freed unpredictably, so an array cannot exceed its initial boundaries.

Whiteboard: Memory layout, fixed length arrays, Objects in storage

So how is it possible that the ArrayList extend its length?

See: CollectionTest.java, test two

ArrayList is *backed* by a primitive array, but the *fixed length* limitation of arrays are abstracted away
so that the ArrayList provides "unlimited" length.

 1. Initialize with a default length
 2. When the array expands beyond the length:
   a. Allocate space for an array twice as long
   b. Copy Object references over to the new array
 3. GOTO 2

Whiteboard: ArrayList in memory

Array indexing is fast, but extending can be slow!

## Big O

**Big O** is a mathematical notation that describes the *runtime* or *space* of an algorithm, function, or procedure.

Formally, Big O is an *upper bound* on the growth rate of a function.
We can compute Big O with some simple rules:

 1. Start with an input, or backing data structure, of length `n`
 2. Count the number of "steps" in the algorithm as a function of `n`
 3. Drop constants and constant multipliers

See: BigO.java

The result of rule (3) is that we get several "classes" that we can group algorithms into. From fastest to slowest...

 - `O(1)` - "Constant Time", this function does not scale based on input. Virtually instant.
 
 - `O(log_2(n))` or `O(logn)` - "Logarithmic", this function scales based on the log-base-2 of the input size. Extremely fast.

 - `O(n)` - "Linear", this function encounters (roughly) every element in the input. Generally pretty quick, though `O(logn)` is much preferred when available..

 - `O(n * log_2(n))` or `O(nlogn)`


The bigger the "Big O" class, the more expensive the algorithm. Examples:

 - Array lookup is `O(1)`
 - Binary tree search is `O(logn)`
 - Linear search is `O(n)`
 - Merge sort is `O(n * log(n))`, or `O(nlogn)`
 - ...?


