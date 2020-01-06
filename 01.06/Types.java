class Types {
    static class A {
        int x;
    }

    static class B extends A {
        int y;
    }

    public static void main(String args[]) {
        char a = 'h';
        int b = 2;
        boolean c = true;
        double d = 3.14;

        long e = b;
        // e = d;   not OK

        // float f = d; // dangerous
        float f = (float) 3.14;
        d = f; // OK

        // int g = (int) c;
        // incompatible types: boolean cannot be converted to int

        String g = "Hello, World!";
        // Integer h = (Integer) g;
        // incompatible types: String cannot be converted to Integer

        A myA = new A();
        B myB = new B();
        
        myA = myB; // OK, all B's are A's (more on this later)
        B mystery = (B) new A(); // is this OK?
    }
}