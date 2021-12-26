package com.tesla.ds;

public class MyMap<K,V> {
    MyArrayList<K> keys = new MyArrayList<>();
    MyArrayList<V> values = new MyArrayList<>();

    public void put(K key, V value) {
        keys.add(key);
        values.add(value);
    }

    public MyArrayList<K> keys () {
        return keys;
    }

    public MyArrayList<V> values() {
        return values;
    }
}
