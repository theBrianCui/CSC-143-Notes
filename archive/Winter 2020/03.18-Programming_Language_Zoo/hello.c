#include <stdio.h>

int factorial(int x) {
    if (x <= 0) {
        return 1;
    }

    return x * factorial(x - 1);
}

int main() {
    printf("Hello, World!\n");

    for (int i = 0; i < 10; ++i) {
        printf("%d ", i);
    }

    printf("\n");

    for (int i = 0; i < 10; ++i) {
        printf("%d ", factorial(i));
    }

    printf("\n");
}
