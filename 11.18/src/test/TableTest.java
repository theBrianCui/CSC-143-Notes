package test;

import org.junit.Test;
import scratch.ArrayListTable;
import scratch.Table;

import static junit.framework.TestCase.assertEquals;

public class TableTest {
    @Test
    public void ArrayListTableTest() {
        Table<String, Integer> peopleAge = new ArrayListTable<>();

        peopleAge.put("John", 20);
        peopleAge.put("Alfred", 70);
        peopleAge.put("Bruce", 40);

        assertEquals(Integer.valueOf(20), peopleAge.get("John"));
        assertEquals(Integer.valueOf(40), peopleAge.get("Bruce"));
        assertEquals(null, peopleAge.get("Logan"));
    }
}
