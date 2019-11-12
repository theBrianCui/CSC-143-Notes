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

### Naive Search Algorithms

**Selection Sort** is perhaps the simplest sort there is.

```
1. Divide the list into two parts: sorted and unsorted, where sorted starts empty
2. Search unsorted part for the minimum element
3. Append minimum element to back of sorted part
4. GOTO 2 until unsorted is empty
```

Whiteboard: Selection Sort

Selection Sort Big O Performance:   `O(???)`
               Big O Stack Memory:  `O(???)`
               
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

Insertion Sort Big O Performance:   `O(???)`
               Big O Stack Memory:  `O(???)`

