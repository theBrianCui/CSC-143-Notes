package scratch;

public interface BasicInterface {
    String hello();
    int count();
}

class ConcreteClass implements BasicInterface {
    int count = 0;

    @Override
    public String hello() {
        count++;
        return String.format("Hello, World! %d", count);
    }

    @Override
    public int count() {
        return count;
    }

    public static void main(String args[]) {
        BasicInterface a = new ConcreteClass();

        System.out.println(a.hello());
        System.out.println(a.hello());
        System.out.println(a.count());

        // BasicInterface b = //new BasicInterface();
    }
}