class Types {
    static class A {
        int x;
    }

    static class B extends A {
        int y;
    }

    public static void main(String args[]) {
        char myChar = 'h';
        int myInt = 2;
        boolean myBoolean = true;
        double myDouble = 3.14;

        long myLong = myInt;
        // myLong = myDouble; //   not OK

        // float myFloat = myDouble; // dangerous, converting to smaller width (4 byte)
        float myFloat = (float) 3.14;
        myDouble = myFloat; // OK, upgrading to float to larger width (8 byte)

        // int boolInt = (int) false;
        // incompatible types: boolean cannot be converted to int

        double doubleFromInt = 5 + 5.0; // OK, int + double -> double

        boolean fiveIsPositive = 5 > 0; // OK, int > int -> boolean
        boolean twoIsEven = isEven(2);
        boolean oneIsOdd = isOdd(1);

        String message = "Hello, World!";
        // Integer intMessage = (Integer) message;
        // incompatible types: String cannot be converted to Integer

        A myA = new A();
        B myB = new B();
        
        myA = myB; // OK, all B's are A's (more on this later)
        B mystery = (B) new A(); // is this OK?
    }

    // this works, but it's needlessly verbose
    public static boolean isEven(int x) {
        // the expression in the statement IS a boolean
        if (x % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    // ah, that's better
    public static boolean isOdd(int x) {
        return (x % 2) != 0;
    }
}
