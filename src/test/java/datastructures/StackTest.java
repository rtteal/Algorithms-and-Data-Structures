package datastructures;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;

public class StackTest {

    private Stack<Integer> stack;

    @Before
    public void setUp() {
        stack = new Stack<>();
    }

    @Test
    public void itPutsToTheStack() {
        stack.push(12);
    }

    @Test
    public void itPutsToTheStackAndPopsTheItem() {
        Integer expected = 11;
        stack.push(expected);
        Integer actual = stack.pop();
        assertEquals(format("Expected: %s != Actual: %s.", expected, actual), expected, actual);
    }

    @Test
    public void itPutsToTheStackAndPeeksTheItem() {
        Integer expected = 11;
        stack.push(expected);
        Integer actual = stack.peek();
        assertEquals(format("Expected: %s != Actual: %s.", expected, actual), expected, actual );
        actual = stack.peek();
        assertEquals(format("Expected: %s != Actual: %s.", expected, actual), expected, actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void itThrowsAnExcptionWhenTryingToPopAnEmptyStack() {
        stack.push(8);
        stack.pop();
        stack.peek();
    }

    @Test
    public void itPutsAndPopsManyItems() throws Exception {
        int limit = 2_000;
        for (Integer i = 0; i < limit; i++) {
            stack.push(i);
        }
        for (Integer i = limit - 1; i >= 0; i--) {
            Integer actual = stack.pop();
            assertEquals(format("Expected: %s != Actual: %s.", i, actual), i, actual);
        }
    }

}