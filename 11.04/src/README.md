# Trees, Recursion, and the Stack

## Previously, on CSC 143

**Linked Lists** are list structures composed of individual **nodes** that each store a payload value, and a reference to the next node.

```
class ListNode<T> {
  T payload;
  ListNode<T> next;

  ListNode(T payload) {
    this.payload = payload;
  }
}
```

A series of `ListNode`s daisy-chained together forms a *data structure* that stores an arbitrary number of elements.

```
ListNode<T> head = new ListNode<>(0);

head.next = new ListNode<>(1);
head.next.next = new ListNode<>(2);

// [0, 1, 2]
```

Reaching the `i`th element requires "walking" the list.

```
public static T get(int i) {
  ListNode<T> temp = head;
  for (int j = 0; j < i; j++) {
    temp = temp.next;
  }

  return temp.payload;
}
```

## Trees

Linked List nodes are, by nature, limited to a single *next element.* This is what makes the Linked List a sequentially *ordered collection*, actually, the `List<T>` interface in Java.

See: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/List.html

If we allow nodes to have *multiple successors*, or **children**, the resulting structure is a **Tree**.

**Whiteboard:** Linked List, Binary Tree

Some definitions:

 - Trees have a head node, called the **root**, much like Linked Lists.
 
 - Each node *can* have **child** nodes. For binary trees, each node can have *up to* two children.
 
 - Nodes that do not have children are called **leaves**, or leaf nodes.

Some observations:

 - Trees nodes are not sequential, and have no natural sense of order.
 
 - As a result, trees do not support indexing. How else can we identify nodes?

 - Trees are naturally `O(???)`, where `b` is the **branching factor** (max children per node) and `d` is the depth.

 - Linked Lists are trees, with a **branching factor** of one.

 - Trees cannot have cycles. What about linked lists?
 
 - Trees can be "unbalanced". What are the consequences?

**See:** BinaryTreeNode.java

### Tree Construction

Constructing a tree is similar to constructing a Linked List: construct nodes and attach them to each other using references.

**See:** BinaryTreeTest.java

Looking up an individual node to a tree requires "walking" the path to the node.

For a binary tree with `n` nodes, the Big O of lookup, given a path, is `O(???)` for a balanced binary tree.

Not every tree is a binary tree! The two-child limit is artificially imposed; 
we can TreeNode class where each node has limitless children.

**See:** TreeNode.java

### Tree Search

Searching a Linked List is easy: walk the list, look for the target value.

**See:** LinkedListTest.java

Searching a tree for a target value is much harder: we no longer have a linear path to walk down.

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

Searching is closely related to several problems that require traversing *all* nodes in the tree:

 - How many nodes are in the tree?
 - What are all the leaf nodes in the tree?
 - What's the maximum value stored in the tree?
 ...

Iteration won't work here. We need a new strategy.

### Recursion

**Recursion** is a strategy for solving problems by finding a solution based on smaller instances of the same problem.

Recursion involves two big ideas:

 - The **base case**, the simplest subproblem, where the solution is trivial.

   e.g. determining if a value exists in a Linked List, that only contains only a single node. (Easy!)

 - The **recursive case**, where a solution to a complex problem is derived from a simpler subproblem.
 
   e.g. determining if a value exists in a Linked List at the present head node,
        then determining if the value exists on the rest of the list (the simpler subproblem)

#### Writing Recursive Algorithms

Writing recursive algorithms follows the same process.

 1. Write a condition that covers the base case.
    This will return *exactly* the solution to the base case.

 2. Write the recursive case that returns a *combination* of recursive calls to subproblem(s).
 
 3. Pray the recursive case works.

**See:** RecursionTest.java

Steps (2) and (3) can be challenging - sometimes the subproblem is not obvious,
and the recursive call can result in an infinite loop!

### Tree Search, Recursive

Trees are naturally recursive: children are trees on their own, but a subset of the overall tree.

With the power of recursion, we can finally write our tree search algorithm.

 1. Base case: the root is null, or contains the value we're looking for.
 
 2. Recursive case: determine if the children subtrees contain the value we're looking for.
 
 3. Pray

**See:** RecursionTest.java

### Depth First Search

The `contains` recursive method is an example of a **depth first search**.

```
    public <T> boolean containsTree(BinaryTreeNode<T> root, T value) {
        ...

        boolean inLeft = containsTree(root.left, value);
        boolean inRight = containsTree(root.right, value);

        return inLeft || inRight;
    }
```

If you trace the recursive calls,

 1. the search searches all the way left down the tree,
 2. until there are no more left nodes, in which it steps one node to the righ,
 3. and then all the way left down that subtree, and so forth (GOTO 1)

This is like trying to solve a corn maze by going as far as possible first,
rather than inching out slowly in every direction from the starting point.

See: https://upload.wikimedia.org/wikipedia/commons/7/7f/Depth-First-Search.gif

DFS is in contrast to Breadth-First Search, which walks the tree one layer at a time.

See: https://upload.wikimedia.org/wikipedia/commons/5/5d/Breadth-First-Search-Algorithm.gif

The key implementation difference is that DFS uses the Stack, while BFS is implemented
using a Queue. More on that next time...
