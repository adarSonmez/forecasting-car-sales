package com.tesla.ds;

import java.util.Arrays;
import java.util.Collections;

@SuppressWarnings("unchecked, unused")
public class MyArrayList<T> implements MyList<T>, Iterable<T> {
    private T[] arr;
    private int length;
    private int capacity;

    public MyArrayList() {
        this(16);
    }

    public MyArrayList(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        this.capacity = capacity;
        this.length = 0;
        arr = (T[]) new Object[capacity];
    }

    @Override
    public void add(T e) {
        // add element, handle capacity
        if (length + 1 >= capacity) {
            if (capacity == 0) capacity = 1;
            else capacity *= 2;
            T[] new_arr = (T[]) new Object[capacity];
            if (length >= 0) System.arraycopy(arr, 0, new_arr, 0, length);
            arr = new_arr;
        }

        arr[length++] = e;
    }


    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public T first() {
        return arr[0];
    }

    @Override
    public T last() {
        return arr[size() - 1];
    }

    @Override
    public T get(int index) {
        if (index >= length || index < 0) throw new IndexOutOfBoundsException();
        return arr[index];
    }

    public void set(int index, T e) {
        if (index >= length || index < 0) throw new IndexOutOfBoundsException();
        arr[index] = e;
    }

    public void clear() {
        for (int i = 0; i < length; i++) arr[i] = null;
        length = 0;
    }

    @Override
    public T removeFirst() {
        return removeAt(0);
    }

    @Override
    public T removeLast() {
        return removeAt(size() - 1);
    }

    @Override
    public T removeAt(int index) {
        // remove element and reduce capacity
        if (index >= length || index < 0) throw new IndexOutOfBoundsException();
        T data = arr[index];
        T[] new_arr = (T[]) new Object[length - 1];
        for (int i = 0, j = 0; i < length; i++, j++)
            if (i == index) j--;
            else new_arr[j] = arr[i];
        arr = new_arr;
        capacity = --length;
        return data;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < length; i++) {
            if (o == null) {
                if (arr[i] == null) return i;
            } else {
                if (o.equals(arr[i])) return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override
            public T next() {
                return arr[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public MyArrayList<T> getReverse() {
        MyArrayList<T> reversed = new MyArrayList<>();

        for (int i = size(); i > 0; i--) {
            reversed.add(arr[i - 1]);
        }
        return reversed;
    }

    public T[] sortInDescendingOrder() {
        T[] sorted;
        sorted = (T[]) new Integer[size()];
        System.arraycopy(arr, 0, sorted, 0, size());

        Arrays.sort(sorted, Collections.reverseOrder());

        return sorted;
    }

    @Override
    public String toString() {
        if (length == 0) return "[]";
        else {
            StringBuilder sb = new StringBuilder(length).append("[");
            for (int i = 0; i < length - 1; i++) sb.append(arr[i]).append(", ");
            return sb.append(arr[length - 1]).append("]").toString();
        }
    }
}
