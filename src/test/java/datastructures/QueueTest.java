package datastructures;

import org.junit.Before;
import org.junit.Test;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QueueTest {

    private Queue<Integer> queue;

    @Before
    public void setUp() {
        queue = new Queue<>();
    }

    @Test
    public void itAddsAndRemovesFromTheQueue() {
        queue.add(1);
        queue.add(2);
        assertEquals(new Integer(1), queue.remove());
        assertEquals(new Integer(2), queue.remove());
    }

    @Test
    public void itMaintainsTheCorrectSizeWhenAddingAndRemovingManyElements() {
        int maxLen = Queue.DEFAULT_SIZE - 2;
        for (Integer i = 0; i < 1_000; i++) {
            queue.add(i);
            if (i - maxLen >= 0)
                assertEquals(new Integer(i - maxLen), queue.remove());
            assertTrue(format("%s != %s", queue.len(), Queue.DEFAULT_SIZE), queue.len() == Queue.DEFAULT_SIZE);
        }
    }

    @Test
    public void itAddsAndRemovesManyElements() {
        int size = 10_000;
        for (Integer i = 0; i < size; i++) {
            queue.add(i);
        }

        assertTrue(queue.size() == size);

        for (Integer i = 0; i < size; i++) {
            assertEquals(i, queue.remove());
        }
    }
}