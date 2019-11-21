# Graphs and Graph Traversal

## Previously, on CSC 143

Much of Data Structures (and CS in general) is focused on how we can efficiently look up data.

In this class we have explored *storing*, *sorting*, and *associating* data.

When we *associate* or *map* data to other data, we require a sort of "lookup table"
that correlates information, keys to values.

Lists and Trees are at best `O(nlogn)` and `O(logn)` for generic types; can we do better?

**HashMaps** are derived from the observation that arrays are `O(1)` lookup tables
from integers (array indices) to generic values.

If we can find a magic **hash function** that converts generic data to an Integer,
then we can store the associated values in a plain array!

```
Generic Type --hash--> Integer --index--> Value
```

A good hash function has two primary guarantees:

 - **Predictability**: Two keys that are `equals()` have equal hashes.
   This ensures the same key always maps to the same value.

 - **Uniform Randomness**: Two keys that are not `equals()` have hashes that are
                             uniformly random distance apart.

With an `O(1)` hashing function, we can get a randomly distributed array index by using modulo:

```
hash % array.length
```

Because the *domain* of hash functions is the whole universe,
and the *range* of hash functions is finite (in Java, `int`),
collisions are inevitable.

To permit keys that hash to the same "bucket" (table row) to be in the same HashMap,
we use a technique called **hashing with buckets**.

We still use an array, but each array entry is a Linked List that stores key-value pairs.

```
array
  [0] ["A", 1] -> ["B", 2]
  [1]
  [2] ["C", 8]
  [3] ["D", 4] -> ["E", 5] -> ["F", 2]
```

To look up a key's associated value, we

 1. Hash the key, modulo array length
 2. Walk the list until we find a key-value pair where the keys are `.equals`

We need good randomness to spread values out across buckets,
otherwise, HashMap performance degrades to `O(n)`.

The **load factor** describes how full the HashMap will get before expanding. Current load factor = number of entries / size of array

When a HashMap expands, it walks *all* entries in all buckets,
re-hashing every key to determine its new location in the HashMap.

HashMaps are "magic"!
    - `O(1)` insertion
    - `O(1)` lookup
    - `O(1)` removal

But: HashMaps are not ordered and do not have natural sorting,
     without supplemental structures

## Old Friends

Remember the `HashSet<T>` from Project 1?

A *set* is a collection of Objects without duplicates. The interface is:

 - `.add(T)`: inserts a value into the set, no duplicates (`.equals()`)
 - `.contains(T)`: returns true if the value is in the set
 - `.remove(T)`: removes a value from the set

A **Hash Set** is actually just a Hash Table: `O(1)` insert, lookup, removal!

The Objects in the set are hashed and mapped to meaningless values-
the presence of the Object key alone indicates that the Object is in the set.

You could implement a `HashSet<T>` by leveraging a `HashMap<T>`.

See: HashSet.java

## Graphs

Let's think back to Linked Lists and Trees.

(Singly) Linked Lists are a structure where each internal node points to a single `next` node.

Trees are like Linked Lists, except a single node may have any number of `next` child nodes.

A limitation with trees is that they *may not contain cycles*.
 - Recursive searches are guaranteed to terminate (eventually a leaf node is reached)
 - Paths are guaranteed to have a limited length (max root to deepest leaf)

What happens when we remove this limitation?

A **Graph** is a data structure composed of independent nodes,
where each node can point to any number of other node in the graph.

Formally speaking, a graph `G = { V, E }` is:

 - A set of *vertices* `V` or *nodes*, which can hold payloads
 - A set of *edges* `E` where each edge connects two vertices
 - The set of nodes a node is connected to are called *neighbors*

Whiteboard: Graph Structure

Edges can have properties of their own:

 - Edges can be *directed* (one-way), or *undirected* (two-way)
 - Edges can have *weight*, or a "cost" to use - not in performance, but in semantics.

Graphs have many real world parallels and use cases!

 - Your social network: people are nodes, connections are edges
 - Maps/Navigation: locations are nodes, streets are (directed) edges
 - Networking: devices are nodes, edges are connections between nodes (forming the Internet)

*Trees are graphs*. By definition, a tree is a *directed acyclic graph*.

Remark: Graphs are unfortunately named, much like Heaps and The Heap.
        In CS, a Graph is a data structure.
        In Microsoft Excel, a Graph is a chart.
        Know the difference!

### Graphs in Programming

The most "natural" way to store a graph is to construct Node objects,
and use references as edges.

See: GraphNode.java, DirectedGraphNode.java, DirectedGraphNodeTest.java

Other forms of graph storage include 2D arrays (**adjacency list**),
where every node is a row/column (like a spreadsheet)
and a value is stored in the array if an edge exists between the two nodes.

```
        [0] [1] [2] [3] TIP
  T [0]  F   F   T   F
  A [1]  F   T   F   T
  I [2]  F   T   F   F
  L [3]  T   F   F   F
```

Whiteboard: output graph

These don't scale well `O(n^2)`, but are simple enough to implement,
and are easy to iterate over (at most two nested for loops, no recursion!)

### Graph Traversal

We know recursion for trees:

 1. Define a base case that solves a local subproblem
    - a tree with no child nodes is easy to solve
 
 2. Define a recursive case that combines subproblem solutions
    - walk all children and combine their results into a meaningful solution
 
 3. Pray, that the base case works, and the recursive case combines solutions

What happens when we try *tree recursion* on graphs?

See: DirectedGraphNodeTest.java

Problem: trees are acyclic, graphs may not be!

To avoid processing the same node more than once, we use a `HashSet`
that contains all the nodes visited so far.

### Famous Graph Algorithms

#### Shortest Path

Perhaps the most well-known application of *graphs* are for
*real-world navigation* like Google Maps.

 - Nodes are locations (buildings, parks, etc)
 - Edges are streets (one-way, two-way, highway, etc)
   - The *cost* or *weight* of a particular edge
     is the distance+time required to travel down the street.

Whiteboard: Graph of Locations and Streets

Problem: how do we *minimize* the cost of traveling from A to B?
         In other words, what is the **shorted path** from A to B?

Tree search algorithms (DFS, BFS) are a good start,
but assume all edges have the same weight.

Big idea: recursively search the graph and process nodes in the order
          of how "cheap" they are to access.
          
  For example, accessing the parking lot is cheap,
  accessing Mt. Everest is hard,
  so let's visit the parking lot first!

An algorithm which considers the best short term case first
is known as a **greedy algorithm**.

**Dijkstra's Algorithm** is a well-known greedy algorithm invented by Edsger Dijkstra
in 1956 (Dijkstra was a faculty at the University of Texas) for solving the shortest-path problem.

```
Initialize HashMap D of distances mapping nodes to minimum distances
    root -> 0
    all other nodes -> infinity

Initialize a Priority Queue, Q, with the the root node only
    The priority of each node is the minimum distance to reach that node that's known
    Root node has D[root] = priority = 0

Initialize a Visited Set, S, that starts empty

While Q is not empty,
    Pop a node V off priority Q
    
    If V is in visited set S:
        Continue
    Else:
        Insert V into visited set S
        
        For all neighbors U of V:
            If D[V] + EdgeCost(V, U) < D[U]:
                Insert U into Q
                D[U] = D[V] + EdgeCost(V, U)

Return D
```

Whiteboard: Dijkstra's Algorithm

Observations:

 - When a node is popped off Q, the fastest path to that node is known
 
 - A node can appear in Q more than once, but only gets processed once thanks to S
   
 - Does NOT work with negative edges (like taking a slide down a hill)

Big O of Dijkstra's depends on the choice of priority queue.
At least we know it's greater than `O(|V| + |E|)` (why?)

#### Minimum Spanning Tree

Another real-world graph problem with billions of dollars at stake
is formally known as the **Minimum Spanning Tree** problem.

Imagine you are in the utility business: connecting energy, water, oil, Internet

 - Every house must be connected to the grid
 - Want to minimize the cost of the pipes themselves

The MST is a subset of nodes and edges in a graph such that

 1. all nodes in the graph are connected to all other nodes by a path
 2. the sum cost of al the edges is minimized

Observe: MST is a "Tree" because the presence of any cycles indicates a redundant edge

Whiteboard: Minimum Spanning Tree

**Prim's Algorithm** was discovered by Czech mathematician Vojtěch Jarník in 1930 for finding MST.

```
Initialize connected vertex set S, that starts with the root

Initialize edge set E, that starts empty

Initialize a Priority Queue of Edges, Q, with all the root node's edges
    The priority of each edge is the cost of the edge

While S is not equal to all nodes in graph:
    Pop an edge X = (V, U) off Q

    If U is in connected vertex set S:
        Continue
    Else:
        Add U to connected S
        Add X to edge set E
    
        For all edges Y connected to U:
            Insert Y into Q

Return E
```

Whiteboard: Prim's Algorithm

Observations:

 - Prim's greedily adds the cheapest edge connected to the tree
 
 - Prim's avoids cycles by checking if a vertex is already connected

 - Prim's eventually processes every edge, but skips edges that don't add to the tree

 - Prim's is like a simpler Dijkstra's

We also know Big O of Prim's is at least `O(|V| + |E|)`.

## You Made It!

In this class we have seen every major data structure in Computer Science.
*cheers and applause*

 - Array (+ArrayList)
 - Linked List (+Doubly, Stack, Queue)
 - Tree (+BST)
 - Heap
 - HashMap (+Set)
 - Graph

What's the best camera? The one you have on you.

Poll: What's the best data structure?

Answer: _________

It's like asking between runtime and space. It's up to you as the engineer to make the call.

Much of CS research is based on how we can optimize these fundamental structures.

Are there more structures and algorithms to discover? Yes!

 - Heap was discovered in 1964. Inventor J.W.J. Williams passed away in 2012, not long ago.

See: Project 4
