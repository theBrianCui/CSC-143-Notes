
# .equals(), Polymorphism, Generics

## Previously, on CSC 143

Java treats Object variables as **references**, which are, internally, pointers to instances in memory.

Java is **pass by value**, which means arguments and return values are always copied to and from the function, respectively. As references are internally pointers, and pointers are plain integers, copying references is cheap.

**Inheritance** is one of the three pillars of Object-Oriented Programming.
 - Children classes inherit methods and properties of parents.
 - Children classes can *override* parent methods. The `@Override` decorator introduces a compile-time check.
 - Children classes can invoke parent methods by using `super`.

## Native Object Methods

All Classes inherit from Object, the top-level Java class.

See: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Object.html

Object provides some override-able methods that the Java designers decided were a core part of the language and required for every class. The ones we care about in this class are:

 - `.toString()`: Returns the `String` representation of the class (as decided by the developer)
 - `.equals()`: Compares two objects by *state* (rather than memory address, or physical equality)
 - `.hashCode()`: Identifies an object by its "hash". More on this in a few weeks...

#### public boolean .equals(Object o)

Recall `==` compares two Objects by memory address, and two primitive types by value.

`.equals()` extends the notion of value "semantic" equality to classes so you can compare different instances that with the same state but different references.

See: Point.java, Point3D.java

In general, `.equals()` is implemented as:

 1. Check if `o == null`, `return false` if true (why?)
 2. Check if `this == o`, early exit if true (why?)
 3. Check if the types are equal (`instanceof` or `.getClass()` - be careful of the differences!)
 
  - `instanceOf` permits parent classes to equal child classes,
                 but violates symmetry of equality
  - `getClass()` only allows Objects to be equal if their classes are equal,
                 preserves symmetry of equality
                 but violates Liskov Substitution Principle 
 
 4. Check `super.equal(o)` if `this` has a parent
 5. Check all variables are `.equal()`

See: PointTest.java

## Polymorphism

**Polymorphism** is the second pillar of Object-Oriented programming. Polymorphism is literally defined as "the condition of existing in several forms".

In OOP, Polymorphism is the notion that a *single interface* can be fulfilled by different, unique types (classes).

 - Different classes can implement the same Interface
 - Children classes naturally supply the same interface as their parents

This notion that a class fulfills a given interface allows us to treat think of instances as "being" the interface

 - Classes and their parents form an *"is-a"* relationship
 - Classes and their interfaces form an *"is-a"* relationship

See: ShapeTest.java

Java permits classes to substitute their respective parents and interfaces.

When a child is substituted for a parent, the *child's* implementation is used at runtime.

Clients using parent classes do not care about the underlying implementation, only the public interface.

The underlying implementation can be *extended* by children and used without knowledge of the parent (abstraction!)

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
Rectangle r = (Rectangle) sq;

```

## Generics

Generics are a powerful language feature that allow you re-use the *same class* with different **variable types**.

See: PairInt

Generics are useful when your class *contains* a type but does not *depend* on its interface.
The type is provided by clients of the class.

The syntax for declaring a *generic type* depends on where the type is scoped. When you see `<>`, expect generics~

 - To declare a generic class variable, declare generic types next to class name, e.g. `public class A<T>`
 - to declare a generic class variables for a child class, declare generic type next to the class name and parent, e.g. `public class B<T, V> extends A<T>`
 - To declare an instance of a given class with a generic type, construct it with the type attached, e.g. `A<int> = new A<int>();`
 - To declare a static method which accepts or returns a generic, declare the generic before the return value, e.g. `public static <B> B myMethod(B a)`

See: Pair, Triple
