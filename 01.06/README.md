# Day Zero

## Course Website

https://www.briancui.com/csc-143/

## Let's Talk About Java

Formally, Java is a compiled, strongly typed language.

### Compilation

Compiling Java is easy!

Installing Java on your computer will give you `javac` and `java`;
the first is for compilation; the second is for execution.

```
javac Hello.java
java Hello
```

Compiling Java is easy for us Java developers.

Compilation and execution is hard for the Java language engineers!

 - *Parsing* the language: distinguishing keywords, variables, blocks, etc
 - *Compiling* the parse tree: transforming expressions into low level machine language
 - *Assembling* the machine language into JVM bytecode
 - *Executing* the JVM on a variety of architecture, x86, ARM, MIPS, etc.

Compilation, for us Java developers, is a kind of **abstraction**.

**Abstraction** is about masking complexity with simple interfaces.

 - A grocery store sells meat and vegetables,
   which require pastures, farms, tractors, and processing plants

 - Compliation is complicated under the hood,
   but all we as Java developers have to do is run `javac`.

An **interface** is a set of interactions made available by a system.

 - A grocery store accepts money as a form of payment
   (instead of labor - raising chickens, etc)

 - `javac` takes a minimum of one argument, the file to be compiled.
 - `java` takes a minimum of one argument, the class to be executed.

Abstraction and interfaces go hand-in-hand,
and will be a recurring theme for this class.

### Strong Typing

Every variable has a **type**;
the validity of the type is **strongly** enforced.

*See:* Hello.java



 - Compiled: the language is translated from text to bytecode
    that the Java Virtual Machine (JVM) can understand

