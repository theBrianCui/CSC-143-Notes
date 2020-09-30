#  Classes, References, OOP, and Inheritance

## Classes Reviewed

**Classes** are blueprints for objects: containers of *state*.

 - Properties (fields) maintain the state of a given instance.
 - Methods are functions attached to classes that manipulate state.
 - Access modifiers `public`, `protected`, and `private` can be used to hide implementation details
 - Classes expose **interfaces** that enable external clients to modify state.
   
   - Interfaces, formally, are like blueprints for classes
   - Interfaces do not contain implementation, classes are required to provide it
   - Classes can implement any number of interfaces (mix and match)
   - `Iterator<T>` and `Comparable<T>` in Project 0

When a class implements an interface,
the class must implement *every* method of the interface.

Just like classes, interfaces are a type,
that can be assigned to any implementing class!

See: BasicInterface.java

However, because an interface itself lacks a concrete implementation,
the interface cannot be directly constructed.

## Reading: Single Responsibility Principle

*Software entities (classes, modules, functions, etc)
 should only have one reason to change*

Big Idea: program specification should feature standalone pieces with individual responsibilities;
individual responsibilities should be fulfilled by independent entities

Changes to the program specification should be limited in scope to the affected responsible entities

Real world example: car systems
 - wheels: tires, rims, axles
 - power: engine, 12v battery
 - frame: doors, bumpers, hood, trunk

## References and Reference Types

"I understood that reference" -- Your computer

Primitive types: easy and familiar, space efficient

 - char 1 byte
 - int 4 bytes
 - float 4 bytes
 - double 8 bytes
 - long 8 bytes

Classes are a simple kind of **data structure**, a means of organizing data (bytes)

 - A class can store any amount of variables, including arrays of variables
 - A class can store mixed types
 - A class stores all these variables contiguously
 - Methods are stored next to variables, too

See: scrach.Mixture

Whiteboard: Primitive type in memory vs. Class in memory
 
Problem: at scale, classes lose practicality.
Java is **pass by value**, meaning function arguments are passed as copied bytes.

 - Arguments too big to copy!
 - Take up too much stack space for variables!
 - Return type is too big!

### Pointers

Every variable has a *memory address* which points to its stored location in physical memory.

Whiteboard: memory space, addresses

This is a plain integer, no different from the primitive `int`.

Instead of *copying* entire objects, we can instead point to object locations,
and copy their pointers instead.

Remember: Java is **pass by value**, so copying a pointer (`int`) is much cheaper than copying a whole class!

*Aside:* The difference between a "64-bit" and "32-bit" machine is size of the "pointer" data type (8 bytes * 8 bits = 64, 4 bytes * 8 bits = 32). So on a 64-bit machine, addresses are `long`.

See: pointer.c (C is also pass by value)

In practice, pointers are difficult to use.

 - Pointer arithmetic mistakes
 - No runtime type validation 
 - Memory leaks
 - Must be conscious of pass-by-value vs. pass-by-pointer-by-value

### References

Java does not expose raw pointers for the reasons above.
Instead, Java use a special form of pointer called a **reference**.

A **reference** in Java is like a pointer:
internally, it is a number which locates an Object in memory.

However, it comes with some key differences to pointers:

 - The underlying value (memory address) is not provided.
   You cannot perform arithmetic on this value as it is abstracted away.

 - The reference has a fixed type and cannot be assigned to an incompatible type.

In Java, **every** Object (non-primitive) variable declaration is actually a reference

 - When you use the `new` keyword, the instance is constructed in memory
   and the variable stores a reference to the instance

 - All function arguments are passed by value, as reference
 - Reference arithmetic does not exist
 - Garbage collector cleans up unused Objects
 
See: ReferenceTest.java

When comparing two Objects:
 - `==` compares their memory address (physical equality)
 - `.equals` should compare their *state*

## OOP: Inheritance

Object-Oriented Programming has three pillars:

 - **Inheritance**: Classes can be extensions of others.
 - **Polymorphism**: Classes that fulfill the same interface can be used interchangably for that interface.
 - **Encapsulation**: Classes expose (simple) interfaces to hide (complex) implementation.

### Inheritance

Inheritance is a form of code reuse that allows classes with similar behavior to share a common base.

When a child class **extends** a parent class...

 - All properties are inherited; those that are `protected` or `public` can be accessed via `this`.
 - All methods are inherited; those that are `protected` or `public` can be accessed via `this`.
 - Constructors are not inherited (why?)
 - The child can call the parent's constructor and methods using the `super` keyword.

The result:

 - The child exposes the **same interface** (public methods) as the parent
 - The child can optionally modify the parent's original methods
 - The child can optionally have methods the parent does not
 
See: Place.java, School.java, University.java
 
Child and parent classes thus form an **is-a** relationship.
An instance of the child **is** an instance of the parent,
but a parent class cannot be an instance of a child.

The use of a child instance in place of a parent instance is called *polymorphism.*
But we'll leave that for next time.
