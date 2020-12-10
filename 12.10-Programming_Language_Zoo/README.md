# Programming Language Zoo

## Past and Present

### C

The great grandfather of all modern "C-style" programming languages is of course C itself.

```
#include <stdio.h>
int main() {
    printf("Hello, World!\n");
}
```

C is like Java in many ways:

 - Static typing (variables have types, `int, char, double, ...`)
 - Block scope variables `{ }`
 - Conditionals `if { } else { }` and loops `for (...)` ...
 - Stack-based (pass-by-value, just like Java)

See: `hello.c`

```
gcc hello.c -o hello
./hello
```

C gives the programmer total control over how their program behaves.

Unlike Java, C distinguishes between values and pointers to those values.
Access to raw pointers is both a blessing and a curse.

See: `pointer.c`

C is primitive, lacking the following Java features:

 - Strong typing at runtime
 - Pointer safety by using only references
 - Garbage collection for heap memory
 - Classes and methods, C is not object-oriented (!)

C's simplicity gives it a small footprint and is ideal for embedded systems
or low level programming that prioritizes speed and efficiency.

### C++

C++ rode the wave of Object-Oriented Programming
and formally introduced *classes* to C,
including OOP features like inheritance, abstract methods, and polymorphism.

```
class A {
private:
    int payload;
public:
    A() : payload(0) {
        std::cout << "A()" << std::endl;
    }
}
```

C++ maintains *backwards compatibillity* with C.
Any C code can be compiled by a C++ compiler!

C++ also maintains a similar attitude towards programmer responsibility: the programmer must specify *exactly* what the program must do.

See: `classes.cpp`

Unique to C++ are operator overrides.

```
    A& operator++() {
        payload++;
        return *this;
    }

    A operator++(int) {
        A temp = *this;
        payload++;

        return temp;
    }
```

These allow you to apply operators normally reserved for primitives, onto custom class types! For example, rather than using `BigInteger.add(...)`, we could overload the `+` operator to do the same.

The C++ standard library features a robust set of data structures including:

 - `string` (analagous to Java `String`)
 - `vector<T>` (analagous to Java `ArrayList<T>`)
 - `list<T>` (analagous to Java `LinkedList<T>`).
 - and so many more

```
std::list<std::string> listOfStr;
listOfStr.push_back("one");
listOfStr.push_back("two");
listOfStr.push_back("three");

for (std::string str : listOfStr)  // for-each loop
    std::cout << str <<std::endl;
```

The language is well equipped to handle modern programming tasks and continues to receive major updates every three years.

```
for (vector<double>::iterator i = vector.begin();
     i != vector.end(); ++i)
    *i = 0.0;
    // iterator supports * operator, returns reference

for (auto &value : vector)
    value = 0.0;// reference assignment modifies vector
```

C++ is complex and intimidating compared to Java,
but features like pointers, references, and operator overloading make it an incredibly customizable language to work with.

C++ is best suited for high-performance projects
with high complexity and scale requirements.

### Python

Java, C, and C++ are known as **compiled languages**.

 1. *Parser* reads code character by character,
    determines the code structure (tree) and meaning

 2. *Compiler* turns code structure into assembly code, for the architecture

```
gcc hello.c -S -o hello.asm
```

 3. *Assembler* turns assembly into object code (bytecode)

```
gcc hello.c -c -o hello.o
```

 4. *Linker* joins dependency object code files into a standalone executable

```
gcc hello.c -o hello
```

Unlike Java, which is compiled with JVM bytecode, and run on a JVM implementation,
C and C++ both compile to "bare metal".

 - That means every processor architecture (MIPS, ARM, x86-64, etc) with its own bytecode will need their own compiler.

An **interpreted language** is one that sidesteps compilation and is instead executed "on the fly".

1. Parser reads code character by character, determines meaning of each statement

2. Interpreter executes statement immediately based on meaning.
   The interpreter is a pre-compiled binary that understands each statement
   (and has a function to handle each type)

   Any external dependencies are dynamically loaded at runtime.

3. GOTO 1

Python has taken off as the go-to interpreted language for quick scripting.

All you need is a `python` interpreter to run Python!

```
print("Hello, World!")

def factorial(i):
    if i <= 0:
        return 1
    return i * factorial(i - 1)
```

Python was designed to minimize code writing overhead
so programmers can focus on the algorithms themselves.

 - No variable types, argument types, or return types!
 - No semicolons!
 - No curly braces!
 - Everything's a HashMap underneath!
 - Built in structures like `list`, `dict`, `tuple`, `set`, and more!

See: `tuple.py`

Although most programmers learn Python as a language for quick, small tasks,
Python gets a lot of positive attention in the mathematics, AI, and machine learning communities.

Built-in support for `tuple` means the language can handle "vectors" and "matrices" (to any dimension) in the mathematical sense easily.

```
# 3D matrix, try this in Java!
# no class definitions, no interfaces == easy money
myVector = (((1, 2), (3, 4), (5, 6)),
            ((7, 8), (9, 8), (7, 6)),
            ((5, 4), (3, 2), (1, 0)))
```

As an **interpreted language**, Python has notable drawbacks.

 - Minimal "compile time" error reporting.
   The Python interpreter does a quick pass over the code before execution to catch obvious mistakes, but cannot catch type errors or runtime errors.

   In practice, it is extremely frustrating to see your program crash at the last second because of a typo!

 - Poor performance.
   Compared to C, C++, or even Java, Python can be *orders of magnitude slower*.

See: https://benchmarksgame-team.pages.debian.net/benchmarksgame/fastest/gpp-python3.html  

Python has another notable drawback - a political one.

In 2008, Python 3 was released and decidely *not* backwards compatible with Python 2.
Python 3 resolved many language flaws in Python 2.

See: https://docs.python.org/release/3.0.1/whatsnew/3.0.html

Unfortunately, it has taken a decade for the most used Python 2 packages
to be ported to Python 3.

See: http://www.randalolson.com/2016/09/03/python-2-7-still-reigns-supreme-in-pip-installs/

Python 2 will officially be retired by new year 2020.

See: https://pythonclock.org/

### JavaScript

Ah, yes, the programming language of the web.

JavaScript shares many ideas with Python as a language:

 - Interpreted, not compiled*
 - Dynamic typing, no type declarations
 - Everything's a HashMap underneath
 - Everything else is an array of some kind
 - New data types introduced in modern JS are Map(), Set(), and more

JavaScript features C-style syntax with the flexibility of Python.

See: `script.js`
See: `index.html` (open in browser)

Designed for the web, JavaScript has exclusive APIs for manipulating webpages.

With this in mind, JavaScript also has a "killer feature" unique to the language:
first class support for **asynchronous programming**.

C, C++, Java, and Python are all **synchronous**.
Code statements run in the order in which they are written (makes sense).

```
// java
String fileContents = "";
fileContents = Files.readString("hello.txt",
    StandardCharsets.US_ASCII);

fileContents += "world\n";

Files.write("hello.txt", StandardCharsets.US_ASCII);
// "blocking execution" until completion

System.out.println("done");
```

JavaScript deals with user-facing interfaces;
webpages shouldn't freeze up with every slow network request!

Instead of blocking, JavaScript has APIs for executing requests in the background,
while other code may continue execution.

When the request completes, a **callback** function
(typically a lambda) is invoked as a follow up.

See: `script.js`
See: `index.html` (open in browser)

Callbacks are executed in the order in which they arrive (a queue).

Users may continue interacting with the page while requests are ongoing.

While JavaScript was once exclusively used in the browser, featuring dedicated browser APIs for manipulating webpages, someone had the bright idea of running JavaScript on the server.

And `Node.js` was born.
https://nodejs.org/en/