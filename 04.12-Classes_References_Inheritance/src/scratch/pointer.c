#include <stdio.h>

struct A {
    int i;
    char c;
};

void printAByValue(struct A a) {
    printf("A by Value: [%d] [%c]\n", a.i, a.c);
};

void modifyAByValue(struct A a) {
    a.i = 333;
    a.c = 'v';
};

void modifyAByPointer(struct A* a) {
    a->i = 999;
    a->c = 'p';
}

int main() {
    struct A myStruct;
    myStruct.i = 111;
    myStruct.c = 'a';

    struct A* myPointer = &myStruct;

    printf("1. PRINT OUT A\n");
    printAByValue(myStruct);

    printf("2. MODIFICATION BY POINTER (struct address is copied, affects original)\n");
    modifyAByPointer(myPointer);
    printAByValue(myStruct);

    printf("3. MODIFICATION BY VALUE (struct itself is copied, does not affect original)\n");
    modifyAByValue(myStruct);
    printAByValue(myStruct);
}
