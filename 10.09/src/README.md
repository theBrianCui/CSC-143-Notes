# Generics, Abstract Classes, Interfaces

## Previously, on CSC 143

## Reading: Open-Closed Principle

**Generics** are a powerful language feature that allow you re-use the *same class* with different **variable types**.

Generics are useful when your class *contains* a type but does not *depend* on its interface.
The type is provided by clients of the class.

**Abstract Classes** are classes that cannot be instantiated and can contain abstract methods.
 - Like Interfaces, abstract classes cannot be directly instantiated, and describe the public method interface for a class hierarchy
 - Unlike Interfaces, abstract classes live in the class hierarchy, and can contain variables and implementation

Java classes may *not* extend more than a single class, but they *may* implement any number of interfaces.

## Collections

### ArrayList

Perhaps you've seen the `ArrayList` before, a class that holds a list of Objects.

Java arrays are primitive types, which aren't children of Object, and therefore aren't usable in many places (like generics).

`ArrayList` is an array-like generic class that supports many familiar operations.

 - `array[index] = payload --> .set(index, payload)`
 - `array[index] --> get(index)`
 - `array.length --> size()`

See: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ArrayList.html
See: CollectionTest.java

#### How do ArrayLists work?

In Java, arrays are a fixed length: `int[] num = new int[5]`

See: CollectionTest.java

Practically, there is no such thing as an "unlimited length (primitive) array".

This is because of how arrays and Objects are stored in memory. An array must take up a contiguous chunk of space.
Memory is taken and freed unpredictably, so an array cannot exceed its initial boundaries.

Whiteboard: Memory layout, fixed length arrays, Objects in storage

So how can the ArrayList extend its length?

See: CollectionTest.java

Languages that support limitless arrays are actually using ArrayList-like constructs under the hood!




## Project 1

See: Building.java, Store.java, Supermarket.java, Restaraunt.java
