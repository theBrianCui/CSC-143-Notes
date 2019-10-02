package scratch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class University<T, V> extends School<T> {

    private HashMap<V, HashSet<T>> departments;

    public University(String name) {
        super(name);
        this.departments = new HashMap<>();
    }

    public void formDepartment(V name) {
        departments.put(name, new HashSet<>());
    }

    @Override
    public void enroll(T student) {
        super.enroll(student);
    }

    public void joinDepartment(T student, V department) {
        if (!departments.containsKey(department)) {
            return;
        }

        departments.get(department).add(student);
    }

    public static <B> B myMethod(B a) {
        return a;
    }
}
