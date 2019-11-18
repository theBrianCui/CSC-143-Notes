# Hashing, Maps, and HashMaps

## Previously, on CSC 143

**Sorting** is a common real-world problem with several approaches in Computer Science.

  - Transactions in a bank account should appear sorted by date
  - Links in a Google search should be sorted by relevance
  - Names on a scoreboard should be sorted by score/time
  - Entries in a news feed should be sorted by age
  - Employee bonuses should be sorted based on performance

Because data is naturally noisy (unsorted) on its own, we need sorting to
organize and prioritize the information in a meaningful way.

*Naive* sorts like Selection and Insertion sort are simple to write,
but are inefficient in runtime, `O(n^2)`.

  - Naive sorts can be implemented iteratively,
    therefore minimizing stack space to `O(1)`

*Optimal* sorts like Merge and Quick sort are complicated,
but are optimal in runtime, `O(nlogn)`.

  - Merge sort uses the *merge* technique to recursively partition and
    merge small sorted lists into larger sorted lists.
    
    - Merging is an `O(n)` operation, and one-element lists are already sorted
    
    - Merge sort is *always* `O(nlogn)`,
      while consuming `O(logn)` stack space for recursion.
      
    **Errata**: Merge takes `O(n * logn)` stack space due to requiring `O(n)`
    auxiliary memory for each merge step. In the previous class, it was incorrectly
    stated as consuming only `O(logn)` stack memory.

  - Quicksort chooses a *pivot* value, and organizes elements around the *pivot*,
    then applies quick sort to the left and right partitions around the pivot
    
    **Errata**: Quicksort is recursive and takes `O(logn)` stack space due to
    recursive calls. In the previous class, it was incorrectly stated to be iterative
    and taking `O(1)` stack space.
      
    - Quicksort is on average `O(nlogn)` and only needs `O(logn)` stack space,
      though has a worst case performance of `O(n^2)` if a pivot is chosen poorly
      
    - Quicksort is quite popular in practice and is used as the foundation for
      the built-in sorting algorithm in Java and Python

**Priority Queues** are a type of queue (first-in-first-out) where every entry
in the queue gets a *priority* that dictates its position.

  - Patients in a hospital in the most critical condition should be treated first
  - Passengers who pay for first class should board before economy class
  - Bidders in an auction should be considered in order of highest price first

The data structures we've seen so far aren't ideal:

  - Sorted lists are `O(1)` min-lookup, but `O(n)` insertion
  - Binary Search Trees are `O(logn)` average min-lookup, but are also `O(logn)` insertion

**Heaps** are a tree-like data structure optimized for min-value lookup and insertion.

  - Root nodes are less than or equal to their child nodes
  - The tree is complete, filled top to bottom, left to right

Heaps give us `O(1)` min-lookup and average `O(1)` insertion, given a uniform distribution.

The *completeness* guarantee allows us to store heaps using *arrays* with no wasted space
and no reference overhead!

  - Given node at index `i`,
    - its left child is `2i`,
    - its right child is `2i + 1`,
    - its parent is `floor(i/2)`

**Addendum**: Practically, priority queues backed by heaps do not maintain order
within each priority. The only guarantee is a highest (or lowest) priority
element is removed first, but not necessarily the ordering of the elements
with equal priority.

## Hashing and Maps

Throughout this course, we have explored several ways of *storing* and *sorting* data.

*Associating*, or *mapping* data is another significant problem in Computer Science,
with real-world implications:

 - Students are *mapped* to grades, and the classes they take
 - Patients are *mapped* to medications at a pharmacy
 - Products are *mapped* to prices in a store
 - Employees are *mapped* to their salaries and job titles

We've seen some ways of associating data already:

 - Indices in an array map integers to stored values (lookup table, like Excel)
 - Paths in a tree are associated to end values (like navigating in Google Maps)
 - The `Pair<L, R>` class associates a left and right value

However, arrays and trees aren't general purpose:

 - Arrays can only map integers to values, and not arbitrary data (e.g. a String or "Student")
 - Trees must carefully arrange data for efficiency, paths may not be meaningful

See: Table.java

We can *make* arrays general purpose by storing `Pair<L, R>` values (think Project 1)

```
ArrayList<Pair<String, Integer>> recipe = new ArrayList<>();
```

See: ArrayListTable.java, TableTest.java

Problem: unsorted lookup is `O(n)`, which is not good.
         We could sort it, but that requires the data be `Comparable` in some meaningful way.

If we used a balanced Binary Search Tree as a backing container (sorted by key),
lookup would be `O(???)` and insertion would be `O(???)`.

Note that two keys that `.equals()` each other (value equality) should map to the same value.
        These two keys don't necessarily have to have reference equality, `==`.
        
If we used only reference equality, the following won't work,
        since the two strings "John" are not reference equal, but ARE value equal:

`table.get("John") == table.get("John")`

### Hashing

Let's start with an observation: Arrays are `O(1)` lookup tables with integer keys!

Except: Arrays are `O(1)` lookup tables with *integer keys*.

We want lookup tables that map generic keys to generic values.

**Big Idea:** If we can map generic keys to *integers* first in `O(1)`,
               then we can map those integers to values in `O(1)`!

```
Generic Key -> Integer -> Generic Value
```

We only need a single array lookup table that stores values.

All we need is an way to get integers out of keys, which can be any generic type.
Let's call that method `hashCode`.

#### Attempt #1: Map All Keys to Random

```
class person {
    ...
    Random rand = new Random(0);
    public int hashCode() {
        return rand.nextInt(...);
    }
}

class ArrayListTable {
    ...
    private ArrayList<Pair<K, V>> table = new ArrayList<>();

    public V get(K key) {
        return table.get(key.hashCode() % table.size());
    }
}
```
Is `hashCode` `O(1)` ?

Is `get` `O(1)`?

What's wrong with this solution?

#### Attempt #2: Map All Keys to Random, Store 2D Array, Walk List for Duplicates

```
class person {
    ...
    Random rand = new Random(0);
    public int hashCode() {
        return rand.nextInt();
    }
}

class ArrayListTable {
    ...
    private ArrayList<ArrayList<Pair<K, V>>> 2DTable = new ArrayList<>();

    public V get(K key) {
        for (Pair<K, V> pair : 2DTable.get(key.hashCode() % 2DTable.size())) {

            if (pair.left.equals(key))
                return pair.right;
        }
    }
}
```

Is `hashCode` `O(1)` ?

Is `get` `O(1)`?

What's wrong with this solution?

#### Attempt #3: Map Keys To Random at Construct Time

```
class person {
    Random rand = new Random(0);
    int hashCode;

    person() {
        hashCode = rand.nextInt(...);
    }

    public int hashCode() {
        return hashCode;
    }
}

class ArrayListTable {
    ...
    private ArrayList<ArrayList<Pair<K, V>>> 2DTable = new ArrayList<>();

    public V get(K key) {
        for (Pair<K, V> pair : 2DTable.get(key.hashCode() % 2DTable.size())) {

            if (pair.left.equals(key))
                return pair.right;
        }
    }
}
```

Is `hashCode` `O(1)` ?

Is `get` `O(1)`?

What's wrong with this solution?

#### What Makes a Good Hash Function?

A **Hash** is a function that takes arbitrary inputs and outputs values in a finite range.

Whiteboard: Hash Function Domain and Range

Observe: Infinite inputs map to finite outputs, meaning
         there will always be *collisions* where two inputs map to the same output.

What makes a good hash function?
 
 1. Predictability: The same input should always produce the same output.
 
 2. Randomness: Outputs should be uniformly distributed randomly (regardless of input)

Observe: Similar inputs `"Brian", "Bryan", "Ryan"` should appear randomly distributed in
         the output, despite their input similarity. Without randomness, hash tables
         degrade to `O(n)` lookup!

Hash function design is a significant focus of study in Computer Science. 

#### How is hashing implemented in Java?

In Java, every Object has a `.hashCode` function that returns a hash of the Object,
which is a plain `int`. Like `.toString`, `.hashCode` must be overridden by the developer
for custom classes.

See: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Object.html

The `.hashCode` dictates which table sublist the Object should be stored in.

The use of a lookup table (array) containing sublists to store Objects is called
**hashing with buckets**, where each sublist is a single "bucket". 

General rule: when you override `.equals`, override `.hashCode`.

