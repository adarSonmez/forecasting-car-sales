package com.tesla.ds;

import java.io.Serializable;

@SuppressWarnings("unchecked")
public class MyArrayList<T> implements MyList<T>, Iterable<T> {
    private T[] arr;
    private int len = 0;
    private int capacity = 0;

    public MyArrayList() {
        this(16);
    }

    public MyArrayList(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    @Override
    public void add(T elem) {
        if (len + 1 >= capacity) {
            if (capacity == 0) capacity = 1;
            else capacity *= 2;
            T[] new_arr = (T[]) new Object[capacity];
            if (len >= 0) System.arraycopy(arr, 0, new_arr, 0, len);
            arr = new_arr;
        }

        arr[len++] = elem;
    }


    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return len;
    }

    @Override
    public T first() {
        return null;
    }

    @Override
    public T last() {
        return null;
    }

    public T get(int index) {
        if (index >= len || index < 0) throw new IndexOutOfBoundsException();
        return arr[index];
    }

    public void set(int index, T elem) {
        if (index >= len || index < 0) throw new IndexOutOfBoundsException();
        arr[index] = elem;
    }

    public void clear() {
        for (int i = 0; i < len; i++) arr[i] = null;
        len = 0;
    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T removeAt(int index) {
        if (index >= len || index < 0) throw new IndexOutOfBoundsException();
        T data = arr[index];
        T[] new_arr = (T[]) new Object[len - 1];
        for (int i = 0, j = 0; i < len; i++, j++)
            if (i == index) j--;
            else new_arr[j] = arr[i];
        arr = new_arr;
        capacity = --len;
        return data;
    }

    @Override
    public int indexOf(Object obj) {
        for (int i = 0; i < len; i++) {
            if (obj == null) {
                if (arr[i] == null) return i;
            } else {
                if (obj.equals(arr[i])) return i;
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
        return new java.util.Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < len;
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

    @Override
    public String toString() {
        if (len == 0) return "[]";
        else {
            StringBuilder sb = new StringBuilder(len).append("[");
            for (int i = 0; i < len - 1; i++) sb.append(arr[i]).append(", ");
            return sb.append(arr[len - 1]).append("]").toString();
        }
    }
}
