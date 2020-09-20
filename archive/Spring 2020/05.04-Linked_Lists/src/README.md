# Linked Lists and the List Interface

## Linked Lists

### Pointers and References Recap

**Memory addresses** are locations in memory, much like street addresses.

Every Object in memory has a dedicated memory address,
describing its physical location in memory.

**Pointers** are plain integers that store memory addresses.

A **reference** is a special kind of pointer that has a strict *type*
and does not permit pointer arithmetic.

In Java, every Object variable is actually a **reference** to the Object.
Java is *pass by value*, meaning arguments and return values are copied as references.

See: ReferenceTest.java

### Linked Lists: Motivation

Arrays and ArrayLists are *contiguous* by definition,
but this has its own consequences:

  - Contiguous region must exist in the heap to store array
  - Insertion at middle is costly, must copy all successive elements forward `O(n)`
  - Insertion at front is costly, must copy all successive elements forward `O(n)`
  - Deletion at front/middle is costly, must copy all successive elements backward `O(n)`
  
See: ArrayListTest.java

### Linked Lists: Description

The **Linked List** is a data structure where each element stores a value
(sometimes called a payload) and a *reference* to the next value.

Rather than store data contiguously, elements are stored separately.
Then, elements are *linked* together with pointers (references) in a chain.

By chaining several values together using references, a Linked List is formed.

Whiteboard: Singly Linked List

See: Node.java, NodeTest.java

Let's analyze the runtime cost of Linked List operations.

  - Indexing: `O(n)`
  - Iteration: `O(n)`

  - Insert Front: `O(1)`
  - Insert Back: `O(n)`, with tail pointer, `O(1)`
  - Insert Middle: `O(n)`, during iteration, `O(1)`

  - Remove Front: `O(1)`
  - Remove Back: `O(n)`, with tail pointer, `O(1)`
  - Remove Middle: `O(n)`, during iteration, `O(1)`

## Interfaces and Runtime

Java interfaces like Collection, and the classes the implement them like Array List,
*abstract* away the complexities of underlying implementation.

The simple `Node` structure acts as an internal container that manages the value and next item.

Using it directly, however, is inconvenient and complex:

  - Indexing and iteration requires looping over `Node` references
  - Failing to preserve the head `Node` can accidentally cause other nodes to be lost
  - Tracking list length requires counting every insertion and removal
  - Middle insertion and removal can be hard to get right

Let's write a wrapper class that manages the Node Object for us,
revealing a simpler interface for the Linked List.

See: LinkedList.java
