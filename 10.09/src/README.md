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

The result of rule (3) is that we get several common "classes" that we can group algorithms into. From fastest (most efficient) to slowest (least efficient)...

 - `O(1)` - *Constant Time*, this function does not scale based on input. Virtually instant. Array lookup and assignment.
 
 - `O(log_2(n))` or `O(logn)` - *Logarithmic*, this function scales based on the log-base-2 of the input size. Extremely fast, like halving the input every step. Binary search.

 - `O(n)` - *Linear*, this function encounters (roughly) every element in the input. Generally pretty quick, though `O(logn)` is much preferred when available.

 - `O(n * log_2(n))` or `O(nlogn)` - *Linearithmic*, worse than linear time but not by a significant amount. Good sorting algorithms are linearithmic.

 - `O(n^2)` - *Quadratic* - grows quickly, only suited for "small" `n`. Slower sorting algorithms, like selection sort, are quadratic.

...
 
 - `O(2^n)` - *Exponential* - grows extremely quickly, intractable for large `n`. Used in "flood fill" search algorithms (trees, graphs).

Big O analysis is common during technical interviews, and is something you should always be conscious of while programming.
Often times programming challenges are designed to test the efficiency of your algorithm alongside the correctness of your solution.

*Remark:* `O(logn)` and `O(1)` are quite close in practice. For example, `log_2(2^30) = log_2(1073741824) = 30`. That's just 30 steps to search one billion entries!

### ArrayList and Big O

With our newfound knowledge of Big O, we can analyze the efficiency of arrays, our first "data structure".

 - Indexing (Lookup and Assignment): `O(1)`. The indexing operation is always fast for contiguous regions of memory.

 - Search (Linear vs. Binary): `O(n)` vs. `O(logn)`. Searching a sorted list using binary search is much faster.

 - Sorting: `O(nlogn)` best case. Not bad, all things considered.

 - Length: `O(1)` in Java, thanks to an internal `.length` property. (Property lookup is a form of indexing, to the compiler).

 - Size: `O(n)` exactly. We can use Big O to *evaluate memory cost* too.

Arrays are quite efficient! But frequently we need to do more than what the humble array provides.

The ArrayList gives us several more methods to consider.
Recall that the ArrayList doubles its internal size whenever it is completely full.

 - Append Back (`.add(E e)`): `O(???)`
 
 - Append Front (`.add(int index, E element)`): `O(???)`
 
 - Insert Middle (`.add(int index, E element)`): `O(???)`
 
 - Remove Middle (`.remove(int index)`): `O(???)`

As we can see, some operations are quite costly! Sneak peek of upcoming data structures:

See: https://www.bigocheatsheet.com/

## Interfaces and Runtime

Java interfaces like Collection were designed so that runtime and storage cost are abstracted away.

Calling `.add(int index, E element)` looks easy, but is computationally difficult!

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

