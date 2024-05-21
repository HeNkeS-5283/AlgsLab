package com.bu.algs.impl;

import com.bu.algs.BuStack;
import com.bu.algs.util.Objects;

public class BuStackImpl<T> implements BuStack<T> {

    private Node<T> top;

    @Override
    public int size() {
        int count = 0;
        Node<T> current = top;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public boolean contains(T elem) {
        Node<T> current = top;
        while (current != null) {
            if (Objects.equals(elem, top.elem)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public void clear() {
        top = null;
    }

    @Override
    public T push(T item) {
        top = new Node<>(item, top);
        return item;
    }

    @Override
    public T pop() {
        if (top == null) {
            return null;
        }
        T result = top.elem;
        top = top.next;
        return result;
    }

    @Override
    public T peek() {
        if (top == null) {
            return null;
        }
        return top.elem;
    }

    @Override
    public int search(T elem) {
        int index = 0;
        Node<T> current = top;
        while (current != null) {
            if (Objects.equals(elem, current.elem)) {
                return index;
            }
            index++;
            current = current.next;
        }

        return -1;
    }

    private static class Node<T> {

        private final T elem;

        private final Node<T> next;

        public Node(T elem, Node<T> next) {
            this.elem = elem;
            this.next = next;
        }
    }
}
