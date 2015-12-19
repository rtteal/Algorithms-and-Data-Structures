package datastructures;

import java.util.Arrays;

public class MinHeap<T extends Comparable<T>> {
    private static final int DEFAULT_CAPACITY = 16;
    private T[] array;
    private int size;

    public MinHeap() {
        @SuppressWarnings("unchecked")
        T[] tmp = (T[]) new Comparable[DEFAULT_CAPACITY];
        array = tmp;
    }

    public void add(T ele) {
        if (size == array.length - 1)
            array = resize();
        array[++size] = ele;
        bubbleUp();
    }

    private void bubbleUp() {
        int index = size;

        while (hasParent(index) && parent(index).compareTo(array[index]) > 0) {
            swap(parentIndex(index), index);
            index = parentIndex(index);
        }
    }

    public T remove() {
        T ele = array[1];
        array[1] = array[size];
        array[size--] = null;
        bubbleDown();
        return ele;
    }

    private void bubbleDown() {
        int i = 1;
        while (hasLeftChild(i)) {
            int lt = leftIndex(i), rt = rightIndex(i), smallerChild = lt;
            if (hasRightChild(i) && array[lt].compareTo(array[rt]) > 0) {
                smallerChild = rt;
            }
            if (array[i].compareTo(array[smallerChild]) > 0) {
                swap(i, smallerChild);
            } else {
                break;
            }
            i = smallerChild;
        }
    }

    private boolean hasParent(int i) {
        return i > 1;
    }


    private int leftIndex(int i) {
        return i * 2;
    }


    private int rightIndex(int i) {
        return i * 2 + 1;
    }


    private boolean hasLeftChild(int i) {
        return leftIndex(i) <= size;
    }


    private boolean hasRightChild(int i) {
        return rightIndex(i) <= size;
    }


    private T parent(int i) {
        return array[parentIndex(i)];
    }


    private int parentIndex(int i) {
        return i / 2;
    }


    private T[] resize() {
        return Arrays.copyOf(array, array.length * 2);
    }


    private void swap(int index1, int index2) {
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
