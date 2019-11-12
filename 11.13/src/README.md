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

**The Stack** is necessary for recursion to work: recursive calls maintain their context thanks to the stack, and the final return value "bubbles up" the stack when the base case is reached.

**Binary Search Trees** are a special subset of Binary Trees with a special condition for storing comparable data:

 - All children to the left of the root node are less than the root node
 - All children to the right of the root node are greater than the root node

BSTs allow for **binary search**, a special kind of tree search that's `O(logn)` time and `O(1)` in stack space when implemented iteratively.

We can use **in-order** traversal to view all the nodes in the BST in sorted order.

**Tail Recursion** is a special form of recursion where the solution to the recursive case is passed as an argument to recursive calls. 

The recursive case returns *exactly* the recursive call, passing the responsibility of combining subproblem solutions to the base case and the next callee.

Tail recursion is *not* a substitute for recursion, but can be optimized to `O(1)` stack space by the compiler.

