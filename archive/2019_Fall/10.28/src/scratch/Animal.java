package scratch;

public class Animal {
    int i;

    @Override
    public String toString() {
        return "Animal" + i;
    }

    public static void main(String args[]) {
        Animal a = new Animal();
        a.i = 5;

    }
}
