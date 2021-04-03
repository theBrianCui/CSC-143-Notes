#include <iostream>

using namespace std;

class A {
public:
    int payload;

    A() : payload(0) {
        cout << "A()" << endl;
    }

    A(int i) : payload(i) {
        cout << "A(i)" << endl;
    }

    A(const A& a) : payload(a.payload) {
        cout << "A(const A& a)" << endl;
    }

    A& operator=(const A& a) {
        if (this == &a) {
            return *this;
        }

        payload = a.payload;
        return *this;
    }

    A& operator++() {
        payload++;
        return *this;
    }

    A operator++(int) {
        A temp = *this;
        payload++;

        return temp;
    }
};

int main() {
    cout << "Hello, World!" << endl;

    A b(10);            // shorthand call to A(i) constructor
    A b1 = A(10);       // alternative call to A(i) constructor
    A b2 = 10;          // implicit call to A(i) constructor;

    cout << endl;

    A copy = b;            // needs to be constructed, calls A(const A& a)
    A& reference = b;      // a "reference" to a, the two are identical
    A *pointer = &b;       // a pointer to a

    cout << "b.payload : " << b.payload << endl;
    cout << "copy.payload : " << copy.payload << endl;
    cout << "reference.payload : " << reference.payload << endl;
    cout << "pointer.payload : " << pointer->payload << endl;
    cout << endl;

    copy.payload = 15;
    reference.payload = 20;
    pointer->payload = 25;

    cout << "b.payload : " << b.payload << endl;
    cout << "copy.payload : " << copy.payload << endl;
    cout << "reference.payload : " << reference.payload << endl;
    cout << "pointer.payload : " << pointer->payload << endl;
    cout << endl;

    reference = ++b;

    cout << "b.payload : " << b.payload << endl;
    cout << "reference.payload : " << reference.payload << endl;
    cout << endl;

    copy = b++;

    cout << "b.payload : " << b.payload << endl;
    cout << "copy.payload : " << copy.payload << endl;
    cout << endl;

    return 0;
}
