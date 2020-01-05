# Recursion, The Stack, and Tail Recursion

## Project 2: Doubly Linked Lists Retrospective

What was easy?
What was hard?
What is a NullPointerException?
```
TreeNode a = null;
a.payload;
```
Stack vs. Queue?
Did you enjoy P2?

## Previously, on CSC 143

**Trees** are a type of data structure featuring several nodes that can each have an child nodes of their own.

 - Trees have a head node, called the **root**, much like Linked Lists.
 
 - Each node *can* have **child** nodes. For binary trees, each node can have *up to* two children.
 
 - Nodes that do not have children are called **leaves**, or leaf nodes.

Trees do not have a natural ordering, like linked lists - they are not sequential. To perform computations on trees, we need something more than linear iteration.

```
public <T> boolean contains(BinaryTreeNode<T> root, T value) {
  while (root != null) {
    if (root.payload.equals(value))
      return true;

    // ??? Do we look left or right ???
    // ??? If we pick the wrong direction, how do we back up ???
  }
}
```

**Recursion** is a strategy for solving problems by finding a solution based on smaller instances of the same problem. Recursion involves two big ideas:

 - The **base case**, the simplest subproblem, where the solution is trivial.

 - The **recursive case**, where a solution to a complex problem is derived from a simpler subproblem.

Trees are naturally recursive! Every child node of a root node is itself a subtree.

The `containsTree` recursive method is an example of a **depth first search**.

```
public <T> boolean containsTree(BinaryTreeNode<T> root, T value) {
    if (root == null) {
        return false;
    }

    if (root.payload.equals(value)) {
        return true;
    }

    boolean inLeft = containsTree(root.left, value);
    boolean inRight = containsTree(root.right, value);

    return inLeft || inRight;
}
```

## The Stack

**Whiteboard**: 5-Node Binary Tree Search

When tracing the recursive calls of `containsTree`, we observe the following:

 - The context of each function call is preserved until it returns
 - Each function call can only return when its own recursive calls return

This is the case with **all** function calls, not just recursive calls! The *caller* function must save its context (local variables) while the *callee* is running.

Then when the callee calls its own functions, it must save its own state, and so forth, recursively, all the way down.

Behind the scenes, **the Stack** is responsible for storing the context of each function call and passing return values from callees to callers.

### What is a Stack?

Recall that a Stack is a type of last-in-first-out queue structure.

Items are *pushed* onto the stack,
and *popped* of the stack in the opposite order in which they were pushed.

Just like a stack of heavy plates - we cannot access the bottom plate until the top plates are removed.

See: StackTest.java

### What is The Stack?

**The Stack** is a dedicated space in memory similar to **the Heap**.

The Stack stores a number of necessary variables to preserve the context of **every** function call.

 - Local variables (references)
 - Arguments passed to the function (copied by the caller)
 - The return address of the function (location of the caller)

**Whiteboard:** Memory Layout (Stack | Heap)

*Every time* a function is called (including `main(String args[])`):

 - The arguments passed to the function are *pushed* onto the Stack
 - Space is allocated (pushed) on the Stack for local variables during execution

The memory region consumed by the function is called the **stack frame**.

*Every time* a function returns,

 - The space allocated for the function is *popped*
 - The return value is copied into the stack frame of the previous function

The IntelliJ debugger will show you the state of the stack with every recursive call.

**Debug**: RecursionTest.java
**Whiteboard**: Recursive `contains` tree search

Remark: Traditionally, the "stack grows downwards", in terms of memory addresses. It is still a LIFO stack.

### Big O of Trees

Let `b` be the branching factor and `d` be the depth of the tree.

Given `b^d = n` nodes in a tree, it costs `O(n)` memory to store a tree.

Quick math: `log(n) = d`

What is the Big O of tree computations?

 - Exhaustive recursive tree search: `O(n)` in performance,
                                     `O(logn)` stack memory on average (balanced tree),
                                     `O(n)` stack memory worst case (unbalanced tree) 

 - Path tree search: `O(logn)` in performance on average (balanced tree),
                     `O(n)` in performance worst case (unbalanced tree),
                     `O(1)` in stack memory when implemented iteratively

 - Tree insertion (leaf only): `O(logn)` in performance on average,
                               `O(n)` in performance worst case,
                               `O(1)` in memory when implemented iteratively

Trees don't sound so great compared to our friends ArrayList and LinkedList:

 - ArrayList, LinkedList, and Tree both cost `O(n)` memory for storage (impossible to avoid)

 - ArrayList and LinkedList both cost `O(1)` stack memory to search
    ... compared to `O(logn)` average stack memory, `O(n)` worst case tree search

 - ArrayList has `O(n)` worst case insertion, LinkedList is `O(1)` insertion (during iteration)
    ... compared to `O(logn)` average, `O(n)` worst case tree insertion

Wow, trees are awful at everything! Why would anyone want to use them?

### Binary Search Trees

**Binary Search Trees**, or BSTs, are a special subset of Binary Trees, with the following condition for every node:

 - All child nodes to the left of the node are *less than* the current node.
 - All child nodes to the right of the node are *greater than* the current node.

**Whiteboard**: Binary Search Tree containing Integers

BSTs enable an efficient type of search called **Binary Search**. The general recursive algorithm follows:

```
 1. Base case: Examine the current node. If equals, return
 2. Else, compare the target value to the current node
    3. If target < current, recursively go LEFT
    4. If target > current, recursively go RIGHT
```

**Whiteboard**: Binary Search

Observe: every step in the search *halves* the remaining search space!
         The search performs *as if* we knew the exact path to the target node beforehand!

Binary search is `O(logn)` performance on average for a balanced tree,
                 `O(n)` performance worst case for an inbalanced tree
                 `O(1)` iteratively stack space, though

Compare to List search, always `O(n)`

A balanced binary tree `O(logn)` search *significantly* outperforms linear `O(n)` search for large `n`!
Example: `n = 2^30 ~ 1,000,000,000`. `logn = log(2^30) = 30`

**See:** https://www.bigocheatsheet.com/

All modern database software uses some kind of BST for efficient lookup and storage.
There are special BST designs (red-black tree, AVL tree, ...) that are self-balancing (and complicated).

`But wait! Trees don't store information sequentially. You told us that last class!
 How can we maintain ordering?` --You

Aha! Since BSTs are ordinary Binary Trees, we can leverage one of the DFS traversals to maintain order.

**Whiteboard**: *In-Order Traversal* with a BST
                  The result: lookup performed in sorted order!
                  We can convert a BST to a sorted list this way in `O(n)`!

You'll get to implement Binary Search on your next project.

Remark: Not every binary tree is a BST!
Don't make the mistake of telling an interviewer that binary tree search is always `O(logn)` in performance.

### Tail Recursion

Tail Recursion is a special form of recursion where the *solution* to the recursive case is
passed as an argument to the recursive call.

**See:** TailRecursionTest.java

Observations:

 - Unlike traditional recursion,
        - the base case returns the trivial solution OR the solution passed by the argument
        - the recursive return statement returns *exactly* the recursive call
            - as a result, tail recursion is not appropriate for tree search (why?)
        
 - Every iterative algorithm can be turned into a tail recursive algorithm, and vice versa
        - not possible with recursion, unless you manage your own stack

 - Tail recursion can be optimized to take `O(1)` stack space by the compiler (how?)

### Project 3

Trees and Recursion practice.

Algorithms heavy. Should compile out-of-the-box. 14/15 tests needed to get 100%, 15/15 gets you 110%.

See: https://www.briancui.com/csc-143/projects/project3.html
