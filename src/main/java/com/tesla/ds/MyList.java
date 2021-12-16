package com.tesla.ds;

public interface MyList<T> {
    void add(T elem);
    boolean isEmpty();
    int size();
    T first();
    T last();
    T removeFirst();
    T removeLast();
    T removeAt(int index);
    int indexOf(Object obj);
    boolean contains(Object obj);
    void clear();
}
