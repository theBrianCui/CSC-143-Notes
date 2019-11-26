# Applications of Data Structures

## Previously, on CSC 143

**Graphs** are data structures composed of *nodes* and *edges*.

 - Any node can have an edge to any other node
 - Edges can be unidirectional or bidirectional
 - Edges can have a "weight" or "cost"

Graphs are useful for modeling real world networks:

 - Your social network: people are nodes, connections are edges
 - The Internet: devices are nodes, connections are edges
 - Google Maps: locations are nodes, streets are edges

Trees are graphs, except trees are acyclic.
Formally, a tree is a *directed acyclic graph*.

Unfortunately, we can't re-use tree recursion on graphs:

 - Nodes can be accessed more than once if a cycle is present
 - Function may never terminate if a cycle is present

We can leverage the `HashSet<T>` to mark nodes as visited,
so they aren't counted twice.

### Dijkstra's Algorithm

Dijkstra's Algorithm is an optimal graph search algorithm
for determining the shortest path between any node to all other nodes
in a weighted graph.

Dijkstra's Algorithms depends on a *proirity queue* to access nodes
in the order of least cost.

### Prim's Algorithm

Prim's Algorithm is an optimal graph search algorithm
for determining the *minimum spanning tree* of a weighted graph.

Prim's Algorithm is like Dijkstra's, except the priority queue is
composed of *edges* which are added to the tree in cheapest order.

## Project 3 Retrospective

Project 3 grades are released!

Please check your grade and submission comments to see the breakdown.

 - Half credit (-3.5) was awarded for methods that were implemented incorrectly,
   but were close and passing tests

 - For small mistakes, 1 point was deducted

If you received a score of 0, check your Canvas inbox ASAP.
If you want to dispute your grade, you have a week from today to email me.

There were a number of common mistakes with Project 3 worth discussing.

### Early Exit
```
boolean onlyEvenNodes(BinaryTreeNode<Integer> i) {
    if (i == null) {
        return false;
    }

    if (i.payload % 2 == 0) {
        return true;
    }

    return onlyEvenNodes(i.left) && onlyEvenNodes(i.right);
}
```

The second condition causes the function to exit early!
Only the root node gets processed, the recursive call never happens!

### Dropping the Ball
```
boolean onlyEvenNodes(BinaryTreeNode<Integer> i) {
    if (i == null) {
        return false;
    }

    onlyEvenNodes(i.left) && onlyEvenNodes(i.right);
    return i.payload % 2 == 0;
}
```
The result of the recursive call is never used or saved!
Once again only the root node matters; the recursive call is wasted.

### Redundant Calls
```
boolean onlyEvenNodes(BinaryTreeNode<Integer> i) {
    if (i == null) {
        return false;
    }

    if (i.left == null && i.right == null) {
        return i.payload % 2 == 0;
    }

    if (onlyEvenNodes(i.left) && onlyEvenNodes(i.right)) {
        return i.payload % 2 == 0 && onlyEvenNodes(i.left) && onlyEvenNodes(i.right);
    }
    return false;
}
```
The recursive calls are made twice, once in the condition,
and another time in the return statement.

This doubles the cost of every recursive call!
Save the result and re-use it in the return statement.

Also observe: there is an early exit opportunity here.
When `i.payload % 2 != 0`, the function can `return false` early
without having to examine child nodes, because the solution to the whole tree is known.

However, you can't always exit early (see above!) when the subproblem solution
does not present a solution for the whole tree.

### P3 General Discussion

 - What was easy?
 - What was hard?
 - What was interesting?
 - General thoughts on P3?

## Course Evaluations

Course evaluations will be sent out over email on 11/28/2019 (Thanksgiving Day).

Did you enjoy this class? Did you hate this class? Let me know!

Please provide honest and constructive feedback.
It means a lot and lets me improve this class for future quarters.
