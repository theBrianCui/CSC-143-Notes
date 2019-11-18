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

We can *make* arrays general purpose by storing `Pair<L, R>` values (think Project 1)

```
ArrayList<Pair<String, Integer>> recipe = new ArrayList<>();
```

Problem: unsorted lookup is `O(n)`, which is not good.
         We could sort it, but that requires the data be `Comparable` in some meaningful way.

