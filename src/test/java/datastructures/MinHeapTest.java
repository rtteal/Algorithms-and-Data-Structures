package datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinHeapTest {
    MinHeap<Integer> heap;

    @Before
    public void setUp() {
        heap = new MinHeap<>();
    }

    @Test
    public void itAddsToTheMinHeap() {
        heap.add(1);
    }

    @Test
    public void itAddsAndRemovesFromTheHeap() {
        heap.add(6);
        heap.add(2);
        heap.add(67);
        heap.add(14);

        assertEquals(heap.remove(), new Integer(2));
        assertEquals(heap.remove(), new Integer(6));
        assertEquals(heap.remove(), new Integer(14));
        assertEquals(heap.remove(), new Integer(67));
    }

    @Test
    public void itAddsManyElementsToTheMinHeap() {
        int size = 2_000_000;
        for (Integer i = size - 1; i >= 0; i--) {
            heap.add(i);
        }
        for (Integer i = 0; i < size; i++) {
            assertEquals(i, heap.remove());
        }
    }
}