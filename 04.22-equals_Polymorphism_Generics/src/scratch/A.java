package scratch;

public class A {
    private int i;      // property

    public A(int i) {   // constructor
        this.i = i;
    }

    public int get() {  // method
        return this.i;
    }

    private void print() {
        System.out.println("A");
        A.staticPrint();
    }

    private static void staticPrint() { // static method
        System.out.println("Static A");
    }

    public static void main(String args[]) {
        A foo = new A(5);
        foo.print();

        A.staticPrint();

        foo.staticPrint(); // Java fun fact: this works

        A bar = new A(5);
        System.out.println(bar.toString());
        System.out.println(bar == foo);
        System.out.println(bar.equals(foo));
//        System.out.println(bar.hashCode());
    }
}
