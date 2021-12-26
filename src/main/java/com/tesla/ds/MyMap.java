package com.tesla.ds;

/**
 * this is the world's simplest map implementation.
 */
@SuppressWarnings("unused")
public class MyMap<K, V> {
    MyArrayList<K> keys = new MyArrayList<>();
    MyArrayList<V> values = new MyArrayList<>();
    int size;

    public MyMap() {
        size = 0;
    }

    public void put(K key, V value) {
        keys.add(key);
        values.add(value);
        size++;
    }

    public MyArrayList<K> keys() {
        return keys;
    }

    public MyArrayList<V> values() {
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
