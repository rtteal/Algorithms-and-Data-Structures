package datastructures;

import java.util.Objects;

public class HashTable<K,V> {

    private static final int DEFAULT_SIZE = 16;

    private static class Node<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    private Node<K,V>[] table;

    private int size;

    public V get(K key) {
        int n, hash = hash(key);
        if (table == null || (n = table.length) == 0) {
            return null;
        }
        Node<K,V> p = table[(n - 1) & hash];
        while (p != null) {
            if (p.hash == hash && Objects.equals(p.key, key)) {
                return p.value;
            }
            p = p.next;
        }
        return null;
    }

    public V put(K key, V value) {
        if (table == null || table.length == 0) {
            table = resize();
        }
        Node<K,V> p;
        int n = table.length, i, hash = hash(key);
        if ((p = table[i = (n - 1) & hash]) == null) {
            table[i] = new Node<>(hash, key, value, null);
        } else {
            while (true) {
                if (p.hash == hash && Objects.equals(p.key, key)) {
                    V oldVal = p.value;
                    p.value = value;
                    return oldVal;
                }
                if (p.next == null) {
                    break;
                }
                p = p.next;
            }
            p.next = new Node<>(hash, key, value, null);
        }
        if (++size == n) {
            table = resize();
        }
        return null;
    }

    private Node<K,V>[] resize() {
        if (table == null || table.length == 0) {
            return genericArr(DEFAULT_SIZE);
        } else {
            Node<K,V>[] tab = table;
            table = genericArr(table.length << 1);
            size = 0;
            for (Node<K,V> e : tab) {
                while (e != null) {
                    put(e.key, e.value);
                    e = e.next;
                }
            }
            return table;
        }
    }

    @SuppressWarnings({"rawtypes","unchecked"})
    private Node<K,V>[] genericArr(int len) {
        return (Node<K,V>[]) new Node[len];
    }

}
