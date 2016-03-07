package datastructures;


import java.util.Iterator;

import static java.lang.String.format;

public class LinkedList<E> implements List<E>, Iterable<E> {

    private static class ListNode<E> {
        ListNode<E> prev;
        E ele;
        ListNode<E> next;

        ListNode(ListNode<E> prev, E e, ListNode<E> next) {
            this.prev = prev;
            this.ele = e;
            this.next = next;
        }
    }

    private ListNode<E> first;
    private ListNode<E> last;

    private int size;

    private void linkLast(E e) {
        ListNode<E> l = last;
        ListNode<E> n = new ListNode<>(l, e, null);
        last = n;
        if (l == null) {
            first = n;
        } else {
            l.next = n;
        }
        size++;
    }

    @Override
    public void add(E e) {
        linkLast(e);
    }

    @Override
    public E get(int index) {
        return getNode(index).ele;
    }

    private ListNode<E> getNode(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException(format("Index, %s, is not in range [0 - %s]", index, size - 1));
        }
        if (index < (size >> 1)) {
            ListNode<E> n = first;
            for (int i = 0; i < index; i++)
                n = n.next;
            return n;
        } else {
            ListNode<E> n = last;
            for (int i = size - 1; i > index; i--)
                n = n.prev;
            return n;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private ListNode<E> current = first;

            @Override
            public boolean hasNext() {
                return current != null && current.next != null;
            }

            @Override
            public E next() {
                E tmp = current.ele;
                current = current.next;
                return tmp;
            }
        };
    }
}
