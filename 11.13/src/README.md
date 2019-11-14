# Sorting, Merging, and Heaps

## Previously, on CSC 143

**The Stack** is a region of memory (like the Heap) that programs have for maintaining the context of each function call.

The Stack is *a Stack*, a type of last-in-first-out queue where the most recently pushed item is the first to be removed.

 - Every function call *pushes* a **stack frame** onto the Stack.
 - Every function return *pops* a stack frame off the Stack.

Stack frames contain information relevant to each call:

 - Arguments (copied from callers)
 - Local variables (references to Heap objects)
 - Return values (copied from callees)

**The Stack** is necessary for recursion to work: recursive calls maintain their context thanks to the stack,
and the final return value "bubbles up" the stack when the base case is reached.

**Binary Search Trees** are a special subset of Binary Trees with a special condition for storing comparable data:

 - All children to the left of the root node are less than the root node
 - All children to the right of the root node are greater than the root node

BSTs allow for **binary search**, a special kind of tree search that's `O(logn)` time
and `O(1)` in stack space when implemented iteratively.

We can use **in-order** traversal to view all the nodes in the BST in sorted order.

**Tail Recursion** is a special form of recursion where the solution to the recursive case is passed as an argument to recursive calls.

The recursive case returns *exactly* the recursive call,
passing the responsibility of combining subproblem solutions to the base case and the next callee.

Tail recursion is *not* a substitute for recursion, but can be optimized to `O(1)` stack space by the compiler.

## Sorting

**Sorting** a list is an old-fashioned problem with several well-known solutions.

Sorted lists have a number of useful properties:

 - List can be binary searched in `O(logn)` rather than linear searched `O(n)`
 - Merging two sorted sequences into a single sorted sequence is `O(n)` (more on this soon)
 - Finding the minimum and maximum values in the list are `O(1)`
 - They're nice and interesting to look at

### Naive Sorting Algorithms

**Selection Sort** is perhaps the simplest sort there is.

```
1. Divide the list into two parts: sorted and unsorted, where sorted starts empty
2. Search unsorted part for the minimum element
3. Append minimum element to back of sorted part
4. GOTO 2 until unsorted is empty
```

Whiteboard: Selection Sort
See: Sorting.java

Selection Sort Big O Performance:   `O(n^2)`
               Big O Stack Memory:  `O(1)`

Remark: The theoretical performance analysis of sorting algorithms assumes insertion, swap, and append are `O(1)`;
practically we can think of it as always implemented on a Linked List.

**Insertion Sort** is similar to selection sort, except it *inserts* values into the correct positions:

```
1. Divide the list into two parts: sorted and unsorted, where sorted contains the first element
2. Examine the first unsorted element
3. Insert it in the sorted part
4. GOTO 2 until unsorted is empty
```

Whiteboard: Insertion Sort

Insertion Sort Big O Performance:   `O(n^2)`
               Big O Stack Memory:  `O(1)`

### Optimal Sorting Algorithms

**Merge Sort** is an optimal performance sorting algorithm that uses recursion
and merging to construct a sorted list out of several smaller sorted lists.

We will focus on merge sort in this class: it's easy to understand and write.

#### Merging

**Merging** (not a formal term) is the technique of taking two sorted lists
and combining them into a single sorted list. This can be done in `O(n)`.

```
1. Examine the front element of the two lists
2. Pop the smaller list element onto the sorted result
3. GOTO 1 until at least one list is empty
4. Append the remaining list to the sorted result
```

Whiteboard: Merging two sorted Linked Lists

#### Merge Sort

Consider a recursive sorting algorithm, and the steps for writing a recursive algorithm:

 1. Write the base case. We can observe an empty or single-element list is already sorted.

```
If the list is null (empty), return the list
            or a single element, return the list
```

 2. Write the recursive case.

    If we pray in advance and assume the function sorts the lists correctly,
    we can use *merging* to combine two sorted sublists (subproblems).

    To get two sorted lists out of one sorted list... divide the list in half!

```
return merge(left half of list, right half of list)
```

 3. Pray

This is the algorithm for **merge sort**: recursively cut the list in half,
until only empty lists or sorted element lists remain. Merge all the sorted lists
until finally the entire list has been reassembled (merged) in sorted order.

Whiteboard: Merge Sort

Merge Sort Big O Performance:   `O(n * log(n))`
           Big O Stack Memory:  `O(log n)`

You'll get to implement Merge Sort on your next project.

#### Quick Sort

**Quicksort** is a popular optimal (on average) sorting algorithm that uses recursion
and a *pivot* value to divide the list into partitions.

```
1. Decide a pivot value (typically the last value)
2. Partition the list so all elements before the pivot are less than the pivot,
    and all elements greater than the pivot are after the pivot
3. Recursively quicksort the two partitions
```

Whiteboard: Quick Sort

Quick Sort Big O Performance Average:    `O(nlogn)`
           Big O Performance Worst Case: `O(n^2)`
           Big O Stack Memory:           `O(1)` when implemented iteratively

How can Quick Sort be worst case `O(n^2)` ???
...

Remark: We won't be implementing quick sort in this class -
there is a lot of algorithmic theory involved in picking pivot and partition strategies.

It is good to know what Quicksort is because of its popularity, average efficiency,
and similarities (what are these?) to Merge Sort.

## Heaps

Recall Queues: a first-in-first-out data structure that's like a queue in real life.
Elements *pushed* are *popped* in the same order.

A **priority queue** is a queue that assigns *priorities* to each element,
allowing higher priority elements to take priority over lower ones, even if they are pushed after.

 - Prioritizing high-impact bugs during software development
 - Administering aid hospital patients according to injuries
 - Serving the highest paying customers

Both lists and trees offer sorting (BSTs). Are they optimal for priority queues?

 - Sorted list: `O(1)` access to min element, but `O(n)` average insertion
 - Balanced Binary Search Tree: `O(logn)` access to min element, but `O(logn)` average insertion

Observe: BSTs have `O(logn)` access to *every* element, but we only need the *minimum* element.

Can we build a structure that has `O(1)` access to the minimum element, and `O(logn)` insertion?

### What is a Heap?

A **Heap** is a special kind of binary tree that is ideal for tracking *minimum* (or *maximum*) values.

Note that a Heap is different from the Heap.
Unlike The Stack, which is actually a Stack, the Heap is not actually a Heap.
The naming convention is indeed unfortunate.

Heap nodes have two unique properties that make them special (min-heap):

 1. Every heap node is less than or equal to its children (if any).
 
 2. The tree is *complete*. Every row of the tree is filled except for the bottom row (leaf nodes),
    which is filled from left to right.

Whiteboard: Min-Heap

Observe: accessing the minimum element in the tree is always `O(1)`!

Properties (1) and (2) are maintained by special insertion and removal procedures.

 - For *insertion*, always insert the node on the bottom row, open spot farthest to the left.
   
   Then *swap* the new node and its parent, repeatedly, until (1) is fulfilled.
   This is known as *bubbling up*.

 - For *deletion* of the minimum element, remove the root node and *swap* the leaf node
   farthest to the right into the root position.
   
   Then *swap* the new root node with its smaller child, repeatedly, until (1) is fulfilled.
   This is known as *bubbling down*.

An interesting side effect of property (2) is we can efficiently store Heaps in arrays:

 - The root element is at index 1 (for convenience)
 - The left child of an element is at index 2i
 - The right child of an element is at index 2i + 1
 - The parent of a node is floor(i / 2)

Let's analyze the performance:

 - Min-element Retrieval: `O(1)`
 - Min-element Deletion: `O(logn)`
 - New element Insertion worst-case: `O(logn)`
 - New element Insertion average: `O(1)`

How can new element insertion be average `O(1)`?

Why don't BSTs share this behavior?
