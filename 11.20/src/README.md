# Graphs and Graph Traversal

## Previously, on CSC 143

Much of Data Structures (and CS in general) is focused on how we can efficiently look up data.

In this class we have explored *storing*, *sorting*, and *associating* data.

When we *associate* or *map* data to other data, we require a sort of "lookup table"
that correlates information, keys to values.

Lists and Trees are at best `O(nlogn)` for generic types; can we do better?

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

The **load factor** describes how full the HashMap will get before expanding.

When a HashMap expands, it walks *all* entries in all buckets,
re-hashing every key to determine its new location in the HashMap.

HashMaps are "magic"!
    - `O(1)` insertion
    - `O(1)` lookup
    - `O(1)` removal

But: HashMaps are not ordered and do not have natural sorting,
     without supplemental structures

## Graphs

