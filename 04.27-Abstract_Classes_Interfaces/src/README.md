# Abstract Classes, Interfaces

## Abstract Classes

We've discussed **abstraction** frequently in this class:
abstraction masks complexity with simple interfaces.

All classes we've written so far are **concrete**.
That is to say, they *can* be instantiated (constructed),
and have concrete method implementations.

An `interface` is thus not concrete. (`interface`s are abstract.)
An interface cannot be literally constructed, it has to be fulfilled by a concrete class.

### What is an abstract class?

An abstract class is like an `interface` in that it also cannot be directly constructed.

```
public abstract class AbstractShape {
    // Constructor OPTIONAL
    // If exists, cannot be directly called!
    // Must be called by a child using super(...)
} 
```

However, an abstract class is *still a class definition*!
Unlike interfaces, abstract classes:

 - can contain variables
 - can contain `abstract` method declarations without implementation
 - can contain concrete method implementations
 - can extend `abstract` classes and implement interfaces

See: Shape.java, Circle.java, Rectangle.java, ShapeTest.java

Much like interfaces, Abstract classes **force** concrete behaviors
to be defined in a child class.

 - Child classes are required to implement `abstract` methods,
   or be themselves `abstract`.

 - Abstract classes are well-suited for sharing code across a class hierarchy with 
   distinctive children, but a **shared interface** and **common implementations**.
   e.g. all child classes should share a constructor
 
 - Abstract classes that implement `interface`s are *not obligated*
   to provide concrete implementation for the abstract methods of the `interface`!
   (all methods declared in an `interface` are by nature `abstract`)
 
### When to use Abstract Classes vs. Interfaces?

 - Abstract classes can contain properties and implementation,
   Interfaces may only contain declarations.

 - Classes can only extend a single (abstract) class,
   but can implement several interfaces (e.g. `Iterable<T>` + `Comparable<T>`)
 
 - Abstract classes live in the class hierarchy.
   Interfaces can also extend each other,
   separate from a concrete class hierarchy.
 
 - Abstract classes can "implement" Interfaces

*Remark: In newer versions of Java, Interfaces can actually contain implementation.
For our purposes, we'll treat them as if they can't.*

Abstract classes are useful when we want reusable implementation
combined with an abstract idea, e.g. a "Shape" is abstract but can contain
useful concrete methods, like `setName` and `getPosition`

### Thinking in Interfaces

Perhaps you've seen the `ArrayList` before, a class that holds a list of Objects.

`ArrayList` is an array-like class that supports many familiar operations.

 - `array[index] = payload --> .set(index, payload)`
 - `array[index] --> .get(index)`
 - `array.length --> .size()`

But arrays are not the only data structure we can use to store objects.

Abstractly, every form of object storage is a collection...

The `Collection` interface is just that: an interface providing method stubs for all things that store groups of objects.

See: CollectionTest.java

When *using* Interfaces, we can work with classes
without a full understanding of the underlying implementation.

When *designing* Interfaces, we must think about what methods
should be common amongst all implementing classes.

 - "Collections" should have functionality to add, remove, and iterate
 - "Pets" should have names and species
 - "Buildings" should have addresses

## Project 1

See: Building.java, Store.java, Supermarket.java, Restaraunt.java
See: https://www.briancui.com/csc-143/projects/project1.html
