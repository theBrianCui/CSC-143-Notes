
# .equals(), Polymorphism, Casting, Generics

## Classes: "Containers of State"

A `class` in Java is a blueprint for an object instance.

 - Classes contain properties (fields) that make up the state of an instance
 - Classes contain methods (functions) that manipulate those properties

   - Constructors are a special method for initializing a class instance
   - Constructors are invoked via the `new` keyword
   
   - `static` methods are a special kind of method
     not attached to an instance, but instead the class namespace

See: A.java

An `interface` in Java is a blueprint for a `class`.

 - Interfaces declare abstract methods *without* implementation

 - Classes that implement Interfaces must provide an implementation
   for every abstract method in the Interface

Java treats Object variables as **references**, which are, internally, pointers to instances in memory.

Java is **pass by value**, which means arguments and return values are always copied to and from the function, respectively. As references are internally pointers, and pointers are plain integers, copying references is cheap.

**Inheritance** is one of the three pillars of Object-Oriented Programming.
 - Children classes inherit methods and properties of parents.
 - Children classes can *override* parent methods. The `@Override` decorator introduces a compile-time check.
 - Children classes can invoke parent methods by using `super`.

## Native Object Methods

**All** classes inherit from Object, the top-level Java class.

See: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Object.html

Object has some built-in methods that all classes inherit.

These methods were decided by the Java developers as being a core part of the language,
and relevant for every class instance, and therefore available on every class.

The ones we care about are:

 - `.toString()`: Returns the `String` representation of the class (as decided by the developer)
 - `.equals()`: Compares two objects by *state* (rather than memory address, or physical equality)
 - `.hashCode()`: Returns the "hash" of an instance for use in fast lookup tables. More on this in a few weeks...

See: A.java

#### public boolean equals(Object o)

Recall `==` compares two Objects by memory address, and two primitive types by value.

`.equals()` extends the notion of value "semantic" equality to classes so you can compare different instances that with the same state but different references.

See: Point.java, Point3D.java

In general, `.equals()` is implemented as:

 1. Check if `o == null`, `return false` if true (why?)
 2. Check if `this == o`, early exit if true (why?)
 3. Check if the types are equal
    (`instanceof` or `.getClass()` - be careful of the differences!)
 
  - `instanceOf` permits parent classes to equal child classes,
                 but violates symmetry of equality
                 
  - `getClass()` only allows Objects to be equal if their classes are equal,
                 preserves symmetry of equality
                 but violates Liskov Substitution Principle 
 
 4. Check `super.equal(o)` if `this` has a parent
 5. Check all variables are `.equal()`

See: PointTest.java

*Question*: Does the *type of the reference* of an object instance
change which implementation of `.equals` is called? (No! see Polymorphism)

## Polymorphism

**Polymorphism** is the second pillar of Object-Oriented programming. Polymorphism is literally defined as "the condition of existing in several forms".

In OOP, Polymorphism is the notion that a *single interface* can be fulfilled by different, unique types (classes).

 - Different classes can implement the same `interface`
 - A class can implement any number of interfaces
 - Children classes naturally supply the same interface as their parents

This notion that a class *fulfills* a given interface
allows us to treat instances as "being" the interface

 - Classes and their parents form an *"is-a"* relationship
 - Classes and their interfaces form an *"is-a"* relationship

See: Shape.java, Circle.java, Rectangle.java, ShapeTest.java

Java permits references to class instances
to be assigned where parent and interface references are expected.

**BIG IDEA:** When a child is substituted for a parent,
the *child's* implementation is used at runtime.

Clients using parent classes do not care about the underlying implementation,
only the public interface.

The underlying implementation of an interface can be *extended* by children classes,
made more specific by the child class overriding parent methods,
and referenced as the parent class without knowledge of the child class (abstraction!)

### Casting

Casting is a way of treating one reference type (e.g. `Square`) to act as another (`Shape`). The two rules of casting are:

 - It is *always safe* to cast "up" the class hierarchy.
 - It is *dangerous* to cast "down" the class hierarchy.

To cast a reference, specify the desired reference type in parentheses next to the object.

```
Square square = new Square(5, origin);
Shape shape = square; // Always safe to cast up

// Dangerous: shape may not be a rectangle
// You should check using instanceof to determine
// if an instance is actually a class or a child 
Circle c = (Circle) shape;

if (shape instanceof Circle) { 
  // OK, shape is Circle
  Circle c = (Circle) shape;
}

```

## Generics

Generics are a powerful language feature that allow you re-use the *same class* with different **variable types**.

See: PairInt

Generics are useful when your class *contains* a type but does not *depend* on its interface.
The type is provided by clients of the class.

The syntax for declaring a *generic type* depends on where the type is scoped. 
When you see `<>`, expect generics.

 - To declare a generic class variable, declare generic types next to class name, e.g.
   `public class A<T>`
 
 - to declare a generic class variables for a child class, declare generic type next to the class name and parent, e.g. `public class B<T, V> extends A<T>`
 
 - To declare an instance of a given class with a generic type, construct it with the type attached, e.g.
 
   `A<Integer> a = new A<Integer>();`
 
 - To declare a static method which accepts or returns a generic, declare the generic before the return value, e.g. `public static <B> B myMethod(B a)`

See: Pair, Triple

*Why not just use Object everywhere?*

We could theoretically type all class fields as Object
to permit any type to be assigned to them.

However, upon retrieval, the class fields
will be of type Object as well. While functional,
we lose knowledge of the underlying type!

```
class Pair {
  Object left;
  Object right;

  Pair(Object l, Object r) {
    this.left = l;
    this.right = r;
  }
}

Pair p = new Pair("Hello", "World");

p.left.length(); // Invalid! Object has no length()
                 // Must do a cast, every time :(

```