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

 - A grocery store accepts money as a for payment
   (instead of labor - raising chickens)

 - `javac` takes a minimum of one argumene file to be compiled.
 - `java` takes a minimum of one argument class to be executed.

Abstraction and interfaces go hand-in-hand,
and will be a recurring theme for this class.

### Strong Typing

Every variable has a **type**;
the validity of the type is **strongly** enforced.

*See:* Types.java

 - You can't assign a variable to an *incompatible* type
 - You can't pass a variable as an incompatible argument
 - You can't cast an Object to an incompatible Object
 - You *can* transition from one primitive type to another type using operators

Java prevents us from making *type errors* (yay!)

However, some type errors can be detected at compile time (good)
     and some type errors are only detected at runtime (bad)

## Let's Talk About Version Control

*See:* Fibonacci.java

Problem:
 - Programming is complicated, most pieces of code depend on several others
 - one change can easily break everything, hard to recover working copy after overwriting
 - single source of truth prohibits large scale experimentation
 - someone else can clobber your code by overwriting it

Version Control: software for tracking code changes over time,
enabling you to follow different versions of your code as it is developed

What do we want in a VCS?
 - Easy to take snapshots of the current code base: "commits"
 - Easy to *branch* the existing code and track several variations at once
 - Easy to collaborate with others and allow others to make changes without interference
 - Easy on the filesystem

`git` is a popular command line Version Control Software (VCS)
 4. GOTO 1

Git stores all of its state information in the hidden `.git` folder,
which is generated when first running `git init` in the root of the repository.

Pro Tips:
 - Use the `.gitignore` file to ignore files from being tracked, e.g. `*.class`
 - commit early, commit often
 - Branching is cheap: `git branch`
 - checkout to time travel, branch if needed
