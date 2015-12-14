package datastructures;

import java.util.Objects;

public class HashTable<K,V> {

    private static final int DEFAULT_SIZE = 16;

    static class Node<K,V> {
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

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    private Node<K,V>[] table;

    private int size;

    public V get(K key) {
        int n, hash = hash(key);
        if (table == null || (n = table.length) == 0)
            return null;
        Node<K,V> p = table[(n - 1) & hash(key)];
        while (p != null) {
            if (p.hash == hash && Objects.equals(p.key, key)) {
                return p.value;
            }
            p = p.next;
        }
        return null;
    }

    public V put(K key, V value) {
        if (table == null || table.length == 0)
            table = resize();
        Node<K,V> p;
        int n = table.length, i, hash = hash(key);
        if ((p = table[i = (n - 1) & hash]) == null) {
            table[i] = new Node<>(hash, key, value, null);
        }
        else {
            while (true) {
                if (p.hash == hash && Objects.equals(p.key, key)) {
                    V oldVal = p.value;
                    p.value = value;
                    return oldVal;
                }
                if (p.next == null)
                    break;
                p = p.next;
            }
            p.next = new Node<>(hash, key, value, null);
        }
        if (++size == n)
            table = resize();
        return null;
    }

    private Node<K,V>[] resize() {
        if (table == null || table.length == 0) {
            @SuppressWarnings({"rawtypes","unchecked"})
            Node<K,V>[] tab = (Node<K,V>[]) new Node[DEFAULT_SIZE];
            return tab;
        } else {
            Node<K,V>[] tab = table;
            @SuppressWarnings({"rawtypes","unchecked"})
            Node<K,V>[] tmp = new Node[table.length << 1];
            table = tmp;
            size = 0;
            for (int i = 0; i < tab.length; i++) {
                Node<K,V> e = tab[i];
                while (e != null) {
                    put(e.key, e.value);
                    e = e.next;
                }
            }
            return table;
        }
    }

}
