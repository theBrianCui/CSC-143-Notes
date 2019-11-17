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

