#include <stdio.h>

int strlength(char *str) {
    int count = 0;
    while (*str != '\0') {
        count++;
        str++;
    }

    return count;
}

int main() {
    printf("Length of 'Hello, World!': %d\n", strlength("Hello, World!"));

    char myStr[6] = { 'H', 'e', 'l', 'l', 'o', '\0' };
    printf("Length of 'Hello': %d\n", strlength(myStr));

    *((unsigned int*)0) = 999999;
}
