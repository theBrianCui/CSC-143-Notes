# Programming Language Zoo

## Previously, on CSC 143

The Java standard library has a built-in merge sort in utility class
`Collections` as a static method `Collections.sort`.

```
public static <T extends Comparable<? super T>> void sort​(List<T> list)
```

`Collections.sort` can sort any `List<T>`,
so long as the type `T` being sorted is a `Comparable` type.

Less formally, any type (`Integer`, `String`, etc.) that has an ordering
is comparable (two instances can be compared for order),
and therefore can be sorted.

The `Comparable` Interface demands the `public int compareTo(T o)` method,
which is a *comparator* that determines how two objects should be ordered.

Because `compareTo(T o)` is a method of the class `T` itself,
`T` has a natural ordering (ascending in some fashion)
and clients like `Collections.sort` will respect this natural ordering.

However, sometimes we want to sort things in a different way
that the developer of type `T` intended:

 - Sorting music by duration, instead of title
 - Sorting locations by name, instead of distance
 - Sorting employees by salary, instead of age

Ideally we could pass in a function to substitute the existing
`compareTo(T o)` method as our custom comparator.

Unfortunately Java does not permit functions to be passed as arguments!
Instead, we must provide a **concrete class instance** implementing `Comparator`,
which demands the `public int compare(T o1, T o2)` method. 

```
public static <T> void sort​(List<T> list, Comparator<? super T> c)
```
This is unweidly: all we want to do is provide a custom comparator function.

Instead, Java forces us to:

 1. define a class `T` that implements `Comparator<T>` 
 2. define a method `compare(T o1, T o2)` as our comparator
 3. create an instance of that class using `new T()`,
 4. pass that instance to `sort`.

**Functional programming** is a programming paradigm that
composes programs using *pure functions*.

 - No side effects
 - No implicit arguments
 - The same input produces the same output

Java **lambdas** are inspired by functional programming patterns,
allowing us to define inline functions with no class dependency.

```
(Circle o1, Circle o2) -> -1 * o1.compareTo(o2);
```

Remark: not all lambdas are pure functions,
        not all pure functions are lambdas

A **lambda** can substitute a concrete class instance
which implements a **functional interface** in Java.

In Java, functional interfaces are those with **exactly one**
abstract method.

```
interface Comparator<T> {
    public abstract int compare(T o1, T o2);
    ...
}
```

The lambda can be used anywhere the interface is used
so long as the method signature matches.

```
Comparator<Circle> c = (Circle o1, Circle o2) -> -1 * o1.compareTo(o2);
Collections.sort(myList, c);
```


