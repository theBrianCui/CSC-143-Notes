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
 
 - Each node *can* have **child** nodes.
 
 - Nodes that do not have children are called **leaves**, or leaf nodes.

Some observations:

 - Trees nodes are not sequential, and have no natural sense of order.
 
 - As a result, trees do not support indexing. How else can we identify nodes?

 - Trees are naturally `O(???)`, where `b` is the **branching factor** (max children per node) and `d` is the depth.

 - Linked Lists are trees, with a **branching factor** of one.

 - Trees cannot have cycles. What about linked lists?

**See:** BinaryTreeNode.java

### Tree Construction

Constructing a tree is similar to constructing a Linked List: construct nodes and attach them to each other using references.

**See:** BinaryTreeTest.java