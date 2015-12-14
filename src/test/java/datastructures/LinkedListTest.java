package datastructures;

import org.junit.Before;
import org.junit.Test;

import static java.lang.String.format;
import static org.junit.Assert.*;

public class LinkedListTest {

    LinkedList<Integer> list;

    @Before
    public void setUp() {
        list = new LinkedList<>();
    }

    @Test
    public void itAddsToTheList() throws Exception {
        for (Integer i = 0; i < 10; i++) {
            list.add(i);
        }
    }

    @Test
    public void itGetsFromTheList() throws Exception {
        for (Integer i = 0; i < 10; i++) {
            list.add(i);
        }
        for (Integer i = 0; i < 10; i++) {
            Integer actual = list.get(i);
            assertEquals(format("expected: %s != actual: %s.", i, actual), i, actual);
        }
    }

    @Test
    public void itReturnsTheCorrectSize() throws Exception {
        for (Integer i = 0; i < 10; i++) {
            list.add(i);
        }
        Integer actualSize = list.size();
        Integer expectedSize = 10;
        assertEquals(format("expected: %s != actual: %s.", expectedSize, actualSize), expectedSize, actualSize);
    }

    @Test
    public void isEmptyReturnsTrueWhenEmpty() throws Exception {
        assertTrue("The list is empty, but isEmpty is returning false.", list.isEmpty());
    }

    @Test
    public void isEmptyReturnsFalseWhenNotEmpty() throws Exception {
        list.add(12);
        assertFalse("The list is not empty, but isEmpty is returning true.", list.isEmpty());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void itGetsAnIndexThatDoesNotExist() {
        list.get(23);
    }
}