package scratch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class University extends School {
    // Dictionary mapping String to Set
    private HashMap<String, HashSet<String>> departments;
    private HashSet<String> undecided;

    public University(String name) {
        super(name);
        this.departments = new HashMap<>();
        this.undecided = new HashSet<>();
    }

    public void formDepartment(String name) {
        departments.put(name, new HashSet<>());
    }

    @Override
    public void enroll(String student) {
        super.enroll(student);
        undecided.add(student);
    }

    public void joinDepartment(String student, String department) {
        if (!departments.containsKey(department)) {
            return;
        }

        undecided.remove(student);
        departments.get(department).add(student);
    }

    @Override
    public String toString() {
        ArrayList<String> departmentStudents = new ArrayList<>();

        for (String department : this.departments.keySet()) {

            String studentList = String.join(", ", this.departments.get(department));

            departmentStudents.add("[" + department + ": " + studentList + "]");
        }

        departmentStudents.add("[Undecided: " + String.join(", ", new ArrayList<>(undecided)) + "]");

        return this.getName() + ": " + String.join(" ", departmentStudents);
    }
}
