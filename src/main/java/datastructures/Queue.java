package datastructures;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Queue<T> {

    static final int DEFAULT_SIZE = 16;

    private T[] queue;

    private int first;
    private int last;

    public Queue() {
        @SuppressWarnings("unchecked")
        T[] tmp = (T[]) new Object[DEFAULT_SIZE];
        queue = tmp;
    }

    public void add(T ele) {
        resizeIfNeeded();
        queue[last++ & (len() - 1)] = ele;
    }

    public T remove() {
        if (size() <= 0)
            throw new NoSuchElementException();
        resizeIfNeeded();
        T ele = queue[first & (len() - 1)];
        queue[first++ & (len() - 1)] = null;
        return ele;
    }

    public int size() {
        return last - first;
    }

    int len() {
        return queue.length;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private void resizeIfNeeded() {
        if (size() == len())
            queue = Arrays.copyOf(queue, len() << 1);
    }
}
