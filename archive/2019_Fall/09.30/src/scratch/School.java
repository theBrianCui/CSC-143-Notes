package scratch;

import java.util.*;

public class School extends Place {
    protected HashSet<String> students;

    public School(String name) {
        super(name);
        this.students = new HashSet<>();
    }

    public void enroll(String student) {
        this.students.add(student);
    }

    public void expel(String student) {
        if (students.contains(student)) {
            this.students.remove(student);
        }
    }

    @Override
    public String toString() {
        // HashSet<String> implements Iterable<String>,
        // so String.join can iterate over set elements
        return super.toString() + ": " + String.join(", ", students);
    }
}
