# Hashing, Maps, and HashMaps

## Hashing and Maps

Throughout this course, we have explored several ways of *storing* and *sorting* data.

*Associating*, or *mapping* data is another significant problem in Computer Science,
with real-world implications:

 - Students are *mapped* to grades, and the classes they take
 - Patients are *mapped* to medications at a pharmacy
 - Products are *mapped* to prices in a store
 - Employees are *mapped* to their salaries and job titles

We've seen some ways of associating data already:

 - Class references (instances) are mapped to their properties,
   e.g. `school.getName()`

 - The `Pair<L, R>` class associates a left and right value,
   i.e. `pair.left` corresponds to `pair.right`

 - Indices in an array map integers to stored values (lookup table, like Excel)
 
 - Paths in a tree are associated to end values (like navigating in Google Maps)

However, arrays and trees aren't general purpose:

 - Arrays can only map integers to values, and not a generic type to a generic type
   (e.g. a String name associated to a String address)

 - Trees must carefully arrange data for efficiency, paths may not be meaningful

See: Table.java

We can *make* arrays general purpose by storing `Pair<L, R>` values (think Project 1)

```
ArrayList<Pair<String, Integer>> recipe = new ArrayList<>();
```

See: ArrayListTable.java, TableTest.java

Problem: unsorted lookup is `O(n)`, which is not good.
         We could sort it, but that requires the data be `Comparable` in some meaningful way.

If we used a balanced Binary Search Tree as a backing container (sorted by key),
lookup would be `O(logn)` and insertion would be `O(logn)`.

Note that two keys that `.equals()` each other (value equality) should map to the same value.
        These two keys don't necessarily have to have reference equality, `==`.
        
If we used only reference equality, the following won't work,
        since the two strings "John" are not reference equal, but ARE value equal:

`table.get("John") == table.get("John")`

### Hashing

Let's start with an observation: Arrays are `O(1)` lookup tables with integer keys!

Except: Arrays are `O(1)` lookup tables with *integer keys*.

We want lookup tables that map generic keys to generic values.

**Big Idea:** If we can map generic keys to *integers* first in `O(1)`,
               then we can map those integers to values in `O(1)`!

```
Generic Key -> Integer -> Generic Value
```

We only need a single array lookup table that stores values.

All we need is an way to get integers out of keys, which can be any generic type.
We'll use the integers as indices into an array, to locate the value associated with the key.

Let's call the method for transforming a key into an integer `hashCode`.

#### Attempt #1: Map All Keys to Random

```
class person {
    ...
    Random rand = new Random(0);
    public int hashCode() {
        return rand.nextInt(...);
    }
}

class ArrayListTable {
    ...
    private ArrayList<Pair<K, V>> table = new ArrayList<>();

    public V get(K key) {
        return table.get(key.hashCode() % table.size())
            .right;
    }
}
```
Is `hashCode` `O(1)` ? YES

Is `get` `O(1)`? YES

What's wrong with this solution?

 - hashCode is unpredictable, the index in the table changes with every call
 
 - two people can share the same hashCode and replace each other in the same array index

#### Attempt #2: Map All Keys to Random, Store 2D Array, Walk List for Duplicates

```
class person {
    ...
    Random rand = new Random(0);
    public int hashCode() {
        return rand.nextInt();
    }
}

class ArrayListTable {
    ...
    private ArrayList<ArrayList<Pair<K, V>>> 2DTable = new ArrayList<>();

    public V get(K key) {
        for (Pair<K, V> pair : 2DTable.get(key.hashCode() % 2DTable.size())) {

            if (pair.left.equals(key))
                return pair.right;
        }
        return null;
    }
}
```

Each index will store an ArrayList of its own of key-value pairs.

This way, if two `person` instances ever hash to the same index,
we can walk through each pair in that list
and compare the *actual* `person` instances with the keys in the pairs
to determine the associated value.

Is `hashCode` `O(1)` ? YES

Is `get` `O(1)`? NO

What's still wrong with this solution?

 - hashCode is still unpredictable
   - get() is unlikely to retrieve the value stored as hashCode returns random
 
   - two instances that should be .equal
     are likely to end up in different buckets

#### Attempt #3: Map Keys To User-Chosen Value at Construct Time

```
class person {
    int hashCode;

    person(int hashCode) {
        this.hashCode = hashCode;
    }

    public int hashCode() {
        return hashCode;
    }

    public boolean equals(Object o) {
        ...
    }
}

class ArrayListTable {
    ...
    private ArrayList<ArrayList<Pair<K, V>>> 2DTable = new ArrayList<>();

    public V get(K key) {
        for (Pair<K, V> pair : 2DTable.get(key.hashCode() % 2DTable.size())) {

            if (pair.left.equals(key))
                return pair.right;
        }
        return null;
    }
}
```

Is `hashCode` `O(1)` ? YES

Is `get` `O(1)`? Ehhh...

What's wrong with this solution?

 - hashCode distribution is dependent on the developer
 
 - If all instances used the same hashCode, then .get() would be O(n)
 
   - performance degrades back to ArrayList of Pairs as table
   
   - Challenging to manually distribute hashCodes evenly while also guaranteeing
     instances that are .equals have the same hashCode
   
 - Developer should not be required to accommodate the needs of a container structure
   (see open-closed principle) 

#### What Makes a Good Hash Function?

A **Hash** is a function that takes arbitrary inputs and outputs values in a finite range.

Whiteboard: Hash Function Domain and Range

Observe: Infinite inputs map to finite outputs, meaning
         there will always be *collisions* where two inputs map to the same output.

What makes a good hash function?
 
 1. Predictability: The same input should always produce the same output.
 
 2. Randomness: Outputs should be uniformly distributed randomly (regardless of input)

Observe: Similar inputs `"Brian", "Bryan", "Ryan"` should appear randomly distributed in
         the output, despite their input similarity.
         Without randomness, hash tables
         degrade to `O(n)` lookup!

Hash function design is a significant focus of study in Computer Science. 

#### How is hashing implemented in Java?

In Java, every Object has a `.hashCode` function
that returns a hash of the Object,
which is a plain `int`.

With Java library classes, we get a well defined `.hashCode` for free!
Like `.toString`, `.hashCode` must be overridden by the developer for custom classes.

See: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Object.html

The `.hashCode` dictates which table sublist the Object should be stored in.

The use of a lookup table (array) containing sublists to store Objects is called
**hashing with buckets**, where each sublist is a single "bucket".

Whiteboard: Hashing with Buckets

General rule: when you override `.equals`, override `.hashCode`.

 - Two instances that are `.equals` should have the same `.hashCode`
 
 - Two instances that have the same `.hashCode` may not necessarily be `.equals`

See: Pair.java

#### How do HashMaps work in Practice?

HashMaps use *hashing with buckets*, in effect storing a linked list on each table entry,
pushing an element to the list with each insertion.

HashMaps, like ArrayLists, start with a limited size table (array).
The bucket index is determined by `hashCode % size`.

Ideally every element gets its own bucket: `O(1)` lookup!
Collisions are inevitable; two+ elements can be stored in the same bucket.

*Uniform randomness* of hash functions helps to spread out elements across several buckets,
to minimize the cost of walking the sublists.

If hashing is `O(1)`, and lookup is almost always `O(1)`, we've achieved our goal:
generic lookup table with `O(1)` retrieval and storage!

##### Load Factor and Expanding HashMaps

If we pack too many elements in a HashMap, performance degrades to `O(n)`.

To avoid overcrowding, HashMaps have a **load factor** that determines when
the lookup table needs to be *expanded*.

This is just like how ArrayLists expand when they're out of room:
  - Allocate space for new HashMap table, twice as large
  - Iterate over all elements, re-hash keys, and insert them in *new* location

See: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/HashMap.html

Your next project will feature a HashMap implementation, including expansion!

## Conclusion

HashMaps are Magic: `O(1)` average insertion, retrieval, removal
                    contingent on good hash function
                   
At what cost? `O(n)` iteration, unordered, cannot be sorted (why?)
              Wasted space (how?)

A pattern emerges: space vs. time tradeoff
