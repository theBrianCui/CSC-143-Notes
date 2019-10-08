# Generics, Abstract Classes, Interfaces

## Previously, on CSC 143

All Java classes inherit from `Object`, which contains methods that all classes inherit like `.toString()`.

Developers are responsible for *overriding* these methods to produce the correct behavior.

`public boolean .equals(Object o)` is a method for comparing the *state* of two instances (semantic equality). This is distinct from `==`, which compares their two references (physical equality).

**Polymorphism** is the second pillar of OOP we have learned. Polymorphism enables us to fulfill interfaces (`interface`s and parent classes) with different concrete implementations.

Children and parents form an "is-a" relationship allowing children to substitute parents.

Method calls on references to parent classes or interfaces will always invoke the correct child implementation.

## Reading: Open-Closed Principle

Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.

Takeaways:

 - Extend existing code behavior, but do not affect its original specification (requirements, expectations)
 - Write code that is *stable* and can be re-used, not modified, for when requirements change
 - Rely on stable interfaces and abstract classes that never change, but can have concrete implementations that change

## Project 0 Retrospective

 - What did you enjoy?
 - What did you find easy?
 - What did you find frustrating, difficult, or time consuming?
 - Did you feel prepared for P0?

## Generics

Generics are a powerful language feature that allow you re-use the *same class* with different **variable types**.

See: PairInt

Generics are useful when your class *contains* a type but does not *depend* on its interface.
The type is provided by clients of the class.

The syntax for declaring a *generic type* depends on where the type is scoped. Generics are denoted inside angle brackets `<>`.

 - To declare a generic class variable, declare generic types next to class name, e.g. `public class A<T>`
 
 - To declare a generic class variables for a child class, declare generic type next to the class name and parent, e.g. `public class B<T, V> extends A<T>`
 
 - To declare an instance of a given class with a generic type, construct it with the type attached, e.g. `A<int> = new A<int>();`
 
   - When Java can infer the type, you can use shorthand `<>` instead of `<int>` on the right hand side
   
 - To declare a static method which accepts or returns a generic, declare the generic before the return value, e.g. `public static <B> B myMethod(B a)`

See: Pair, Triple

## Generics and Polymorphism

**Under the hood**: Java is replacing all generic types with `Object`. Every time you *construct* an instance of an assigned type (e.g. `Collection<String>`), the compiler treats the type as a sort of custom class.

When a class is generic, all its children are naturally generic (makes sense). The result is you can make the container more specific:

```
Collection<String> list = new ArrayList<Sting>();
```

More on Collections later.

## Abstract Classes

We've discussed **abstraction** frequently in this class: abstraction masks complicated processes with reveals simple interfaces.

All classes we've written so far are **concrete**. That is to say, they can be instantiated, and have complete method implementations.

An `interface` is thus not concrete. An interface cannot be literally constructed, it has to be fulfilled by a concrete class.

### What is an abstract class?

An abstract class is like an `interface` in that it cannot be directly constructed.

```
public abstract class AbstractShape {
    // No constructor allowed!
} 
```

However, an abstract class is *still a class definition*! Unlike interfaces, abstract classes:

 - can contain variables
 - can contain `abstract` method declarations without implementation
 - can contain concrete method implementations
 - can extend `abstract` classes and specify interfaces

See: Shape.java, Circle.java, Rectangle.java, ShapeTest.java

Abstract classes **force** concrete behaviors to be defined in a child class.

 - Child classes are required to implement `abstract` methods or be themselves `abstract`.
 - Abstract classes are well-suited for sharing code across a class hierarchy with distinctive children, but a **shared interface**.
 
### When to use Abstract Classes vs. Interfaces?

 - Abstract classes can contain properties and implementation, Interfaces may only contain declarations.

 - Classes can only extend a single (abstract) class, but can implement several interfaces (e.g. `Iterable<T>` + `Comparable<T>`)

*Remark: In newer versions of Java, Interfaces can actually contain implementation. For our purposes, we'll treat them as if they can't.*

### Collections Sneak Peek

Perhaps you've seen the `ArrayList` before, a class that holds a list of Objects.

Java arrays are primitive types, which aren't children of Object, and therefore aren't usable in many places (like generics).

`ArrayList` is an array-like class that supports many familiar operations.

 - `array[index] = payload --> .set(index, payload)`
 - `array[index] --> .get(index)`
 - `array.length --> .size()`

But arrays are not the only data structure we can use to store objects.

Abstractly, every form of object storage is a collection...

The `Collection` interface is just that: an interface providing method stubs for all things that store groups of objects.

See: CollectionTest.java

## Project 1

See: Building.java, Store.java, Supermarket.java, Restaraunt.java
See: https://www.briancui.com/csc-143/projects/project1.html
