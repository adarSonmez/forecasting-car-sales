package com.tesla.ds;

/**
 * this is the world's simplest map implementation.
 */
@SuppressWarnings("unused")
public class MyMap<K, V> {
    MyDoublyLinkedList<K> keys = new MyDoublyLinkedList<>();
    MyDoublyLinkedList<V> values = new MyDoublyLinkedList<>();
    int size;

    public MyMap() {
        size = 0;
    }

    public void put(K key, V value) {
        keys.add(key);
        values.add(value);
        size++;
    }

    public MyDoublyLinkedList<K> keys() {
        return keys;
    }

    public MyDoublyLinkedList<V> values() {
        return values;
    }

    public V removeByKey(K key) {
        int index = values.indexOf(key);
        values.removeAt(index);
        size--;
        return values.removeAt(index);
    }

    public K removeByValue(K value) {
        int index = keys.indexOf(value);
        values.removeAt(index);
        size--;
        return keys.removeAt(index);
    }

    public int getSize() {
        return size;
    }
}
