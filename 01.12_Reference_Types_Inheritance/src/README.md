# References, Classes, OOP, and Inheritance

## Previously... on CSC 143

**Automated Testing** or **Software Testing** is the process of using software to evaluate the correctness of software. Two types of tests:

 - Unit tests evaluate individual functions, methods, or short chunks of code with few responsibilities
 - Integration tests evaluate many functions used together, large chunks of code, or the entire program

Tests contain **assertions** that compare expected vs. actual outputs; the test fails if they do not match

**Classes** are blueprints for objects: containers of *state*.

 - Methods are functions attached to classes that manipulate state.
 - Access modifiers `public`, `protected`, and `private` can be used to hide implementation details
 - Classes expose (or implement) **Interfaces** that specify the class' methods but not its implementation, a form of **abstraction**.
   
   - Interfaces are like blueprints for classes
   - Classes can implement any number of interfaces (mix and match)
   - `Iterator<T>` and `Comparable<T>` in Project 0

## Reading: Single Responsibility Principle

*A class should only have one reason to change*.

## References and Reference Types

"I understood that reference" -- Your computer

Primitive types: easy and familiar, space efficient

 - char 1 byte
 - int 4 bytes
 - float 4 bytes
 - double 8 bytes
 - long 8 bytes
 
Whiteboard: types, bytes, and boxes

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

Instead of *copying* entire objects, we can instead point to object locations, and copy their pointers instead.
Remember: Java is **pass by value**, so copying a pointer (`int`) is much cheaper than copying a whole class!

*Aside:* The difference between a "64-bit" and "32-bit" machine is size of the "pointer" data type (8 bytes * 8 bits = 64, 4 bytes * 8 bits = 32). So on a 64-bit machine, addresses are `long`.

See: pointer.c (C is also pass by value)

In practice, pointers are difficult to use.

 - Pointer arithmetic mistakes
 - No runtime type validation 
 - Memory leaks
 - Must be conscious of pass-by-value vs. pass-by-pointer

### References

Java does not expose raw pointers for the reasons above; instead, Java use a special form of pointer called a **reference**.

 - **Every** Object (non-primitive) variable declaration is actually a reference
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

Inheritance is a form of code reuse that allows classes with share behavior to share a common base.

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

The use of a child instance in place of a parent instance is called *polymorphism.* But we'll leave that for next time.
