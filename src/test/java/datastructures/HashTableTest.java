package datastructures;

import org.junit.Before;
import org.junit.Test;

import java.util.Objects;

import static java.lang.String.format;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class HashTableTest {

    HashTable<String, Integer> hashTable;

    @Before
    public void setUp() {
        hashTable = new HashTable<>();
    }

    @Test
    public void itPutsAndSuccessfullyGetsTheValue() {
        String key = "test";
        Integer expected = 3;
        hashTable.put(key, expected);
        Integer result = hashTable.get(key);
        assertNotNull(format("Get could not find expected value.  Expected %d, found '%s'.", expected, result), result);
        assertTrue(format("Get could not find expected value.  Expected %d, found '%s'.", expected, result), Objects.equals(expected, result));
    }

    @Test
    public void itSuccessfullyPutsAndGetsANullKeyAndValue() {
        hashTable.put(null, null);
        assertNull(hashTable.get(null));
    }

    @Test
    public void itSuccessfullyGetsANullValueForEmptyTable() {
        assertNull(hashTable.get("test"));
    }

    @Test
    public void itSuccessfullyPutsAndGetsTwoMillionValues() {
        int size = 2_000_000;
        for (int i = 0; i < size; i++) {
            hashTable.put("" + i, i);
        }
        for (Integer i = 0; i < size; i++) {
            Integer result = hashTable.get("" + i);
            assertEquals(format("Expected: %s, Found: %s. size=%s", i, result, size), result, i);
        }
    }

}