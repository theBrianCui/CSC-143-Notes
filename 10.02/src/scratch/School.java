package scratch;

import java.util.*;

public class School<T> extends Place {

    protected HashSet<T> students;

    public School(String name) {
        super(name);
        this.students = new HashSet<>();
    }

    public void enroll(T student) {
        this.students.add(student);
    }

    public void expel(T student) {
        if (students.contains(student)) {
            this.students.remove(student);
        }
    }

    public T getFirstStudent() {
        for (T student : students) {
            return student;
        }

        return null;
    }

    public Collection<T> listStudents() {
        return new ArrayList<T>(students);
    }

    public static <V> School<V> merge(School<V> a, School<V> b) {
        School<V> merged = new School<>(a.getName() + b.getName());

        for (V student : a.students) {
            merged.enroll(student);
        }

        for (V student : b.students) {
            merged.enroll(student);
        }

        return merged;
    }
}