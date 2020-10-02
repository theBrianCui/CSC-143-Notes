package test;

import org.junit.Test;
import scratch.Place;
import scratch.School;
import scratch.University;

import static junit.framework.TestCase.assertEquals;

public class PlaceTest {

    @Test
    public void PlaceTest() {
        Place nsc = new Place("North Seattle College");
        assertEquals("North Seattle College", nsc.toString());
    }

    @Test
    public void SchoolTest() {
        School nsc = new School("North Seattle College");
        nsc.enroll("John");

        assertEquals("North Seattle College: John", nsc.toString());

        Place nsc2 = nsc;
        assertEquals("North Seattle College: John", nsc2.toString());

        nsc.expel("John");
        assertEquals("North Seattle College: ", nsc.toString());
    }

    @Test
    public void UniversityTest() {
        University nsc = new University("North Seattle College");
        nsc.enroll("John");

        assertEquals("North Seattle College: [Undecided: John]", nsc.toString());
        nsc.formDepartment("Computer Science");

        assertEquals("North Seattle College: [Computer Science: ] [Undecided: John]", nsc.toString());

        nsc.joinDepartment("John", "Computer Science");
        assertEquals("North Seattle College: [Computer Science: John] [Undecided: ]", nsc.toString());
    }
}
