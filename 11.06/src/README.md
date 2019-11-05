# Recursion, The Stack, and Tail Recursion

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

**Recursion** is a strategy for solving problems by finding a solution based on smaller instances of the same problem. Recursion involves two big ideas:1

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

### What is The Stack?

**The Stack** is a dedicated space in memory similar to **the Heap**. The Stack stores all the variables in the context of each function call.

**Whiteboard:** Memory Layout (Stack | Heap)

Remark: Traditionally, the "stack grows downwards", in terms of memory addresses. It is still a LIFO stack.

