package datastructures;

import java.util.NoSuchElementException;

public class Stack<E> {

    private static final int DEFAULT_SIZE = 16;

    private E[] stack;

    private int location = -1;

    public E peek() {
        if (location < 0) {
            throw new NoSuchElementException();
        }
        return stack[location];
    }

    public E pop() {
        E item = peek();
        stack[location--] = null;
        if (stack.length > DEFAULT_SIZE && location < stack.length / 4) {
            shrink();
        }
        return item;
    }

    public E push(E item) {
        if (stack == null || stack.length == 0 || location + 1 == stack.length)
            resize();
        stack[++location] = item;
        return item;
    }

    private void resize() {
        if (stack == null || stack.length == 0) {
            @SuppressWarnings({"unchecked", "rawtypes"})
            E[] tmp = (E[]) new Object[DEFAULT_SIZE];
            stack = tmp;
        } else {
            @SuppressWarnings({"unchecked", "rawtypes"})
            E[] tmp = (E[]) new Object[stack.length << 1];
            System.arraycopy(stack, 0, tmp, 0, stack.length);
            stack = tmp;
        }
    }

    private void shrink() {
        int size = stack.length >>> 1;
        @SuppressWarnings({"unchecked", "rawtypes"})
        E[] tmp = (E[]) new Object[size];
        System.arraycopy(stack, 0, tmp, 0, size);
        stack = tmp;
    }
}
