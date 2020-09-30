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

## Course Evaluations

Course evaluations will be sent out over email tomorrow
03/12/2020.

Did you enjoy this class? Did you hate this class? Let me know!

Please provide honest and constructive feedback.
It means a lot and lets me improve this class for future quarters.
