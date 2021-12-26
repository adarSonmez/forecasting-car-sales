package com.tesla.ds;

public class MyDoublyLinkedList<T> implements MyList<T> {
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    public void clear() {
        Node<T> temp = head;
        while (temp != null) {
            Node<T> next = temp.next;
            temp.prev = temp.next = null;
            temp.data = null;
            temp = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void add(T e) {
        if (isEmpty()) {
            head = tail = new Node<>(e, null, null);
        } else {
            tail.next = new Node<>(e, tail, null);
            tail = tail.next;
        }
        size++;
    }

    private void addFirst(T e) {
        if (isEmpty()) {
            head = tail = new Node<>(e, null, null);
        } else {
            head.prev = new Node<>(e, null, head);
            head = head.prev;
        }
        size++;
    }

    public void add(int index, T data) throws Exception {
        if (index < 0 || index > size) throw new Exception("Illegal Index");
        else if (index == 0) addFirst(data);
        else if (index == size) add(data);
        else {
            Node<T> temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Node<T> newNode = new Node<>(data, temp, temp.next);
            temp.next.prev = newNode;
            temp.next = newNode;

            size++;
        }
    }

    @Override
    public T first() {
        if (isEmpty()) throw new RuntimeException("List is empty");
        return head.data;
    }

    @Override
    public T last() {
        if (isEmpty()) throw new RuntimeException("List is empty");
        return tail.data;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("List is empty");

        T data = head.data;
        head = head.next;
        --size;

        if (isEmpty()) tail = null;

        else head.prev = null;
        return data;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("List is empty, you cant remove");

        T data = tail.data;
        tail = tail.prev;
        --size;

        if (isEmpty()) head = null;
        else tail.next = null;
        return data;
    }

    private T remove(Node<T> node) {
        if (node.prev == null) return removeFirst();
        if (node.next == null) return removeLast();

        node.next.prev = node.prev;
        node.prev.next = node.next;

        T data = node.data;

        node.data = null;
        node.prev = node.next = null;

        --size;
        return data;
    }

    @Override
    public T removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Illegal Index");
        }

        int i;
        Node<T> temp;

        if (index < size / 2) {
            for (i = 0, temp = head; i != index; i++) {
                temp = temp.next;
            }
        } else {
            for (i = size - 1, temp = tail; i != index; i--) {
                temp = temp.prev;
            }
        }
        return remove(temp);
    }

    @Override
    public int indexOf(Object obj) {

        Node<T> temp = head;

        if (obj == null)
            for (int index = 0; temp != null; temp = temp.next, index++) {
                if (temp.data == null) {
                    return index;
                }
            }
        else
            for (int index = 0; temp != null; temp = temp.next, index++) {
                if (obj.equals(temp.data)) {
                    return index;
                }
            }

        return -1;
    }

    @Override
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<T> temp = head;
        while (temp != null) {
            sb.append(temp.data);
            if (temp.next != null) {
                sb.append(", ");
            }
            temp = temp.next;
        }
        sb.append(" ]");
        return sb.toString();
    }

    private static class Node<T> {
        private T data;
        private Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
}
