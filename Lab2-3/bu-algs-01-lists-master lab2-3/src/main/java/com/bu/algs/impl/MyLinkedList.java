package com.bu.algs.impl;

import com.bu.algs.BuList;
import com.bu.algs.Reversible;
import com.bu.algs.Sortable;

public class MyLinkedList<T> implements BuList<T>, Sortable, Reversible, Comparable<T> {

    private Node<T> first;

    @Override
    public int compareTo(T o) {
        return 0;
    }

    static class Node<T> {
        private final T elem;
        private Node<T> next;

        public Node(T elem, Node<T> next) {
            this.elem = elem;
            this.next = next;
        }
    }

    @Override
    public int size() {

        if (first == null) {
            return 0;
        }

        int elem = 1;
        Node<T> current = first;

        while (current.next != null) {
            current = current.next;
            elem++;
        }

        return elem;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public boolean contains(T elem) {
        if (isEmpty()){
            return false;
        }

        if(size() == 1){
          if(first.elem == elem) return true;
          return false;
        }

        Node<T> current = first;



        while (current.next != null) {
            if (current.elem == elem){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public void clear() {
        first = null;
    }

    @Override
    public boolean add(T elem) {
        if(isEmpty()){
            first = new Node<>(elem, null);
            return true;
        }

        Node<T> current = first;

        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node<>(elem, null);
        return true;
    }

    @Override
    public boolean add(T elem, int index) {
        if(index < 0 || index > size()) {
            throw new RuntimeException("Invalid index");
        }

        if(index == 0){
            first = new Node<>(elem, first);
            return true;
        }


        Node<T> current = first.next;
        Node<T> prev = first;
        int currentIndex = 1;

        while (currentIndex < index) {
            prev = current;
            current = current.next;
            currentIndex++;
        }
        prev.next = new Node<>(elem, current);
        return true;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index > size()) {
            throw new RuntimeException("Invalid index");
        }

        if(index == 0){
            return first.elem;
        }

        Node<T> current = first.next;

        int currentIndex = 1;

        while (currentIndex < index) {
            current = current.next;
            currentIndex++;
        }

        return current.elem;
    }

    @Override
    public boolean remove(T elem) {
        if(isEmpty()){
            return false;
        }
        if (first.elem == elem){
            first = first.next;
            return true;
        }

        Node<T> current = first.next;
        Node<T> prev = first;


        while (current.next != null) {
            if(current.elem == elem){
                prev.next = current.next;
                return true;
            }

            current = current.next;
        }

        return false;
    }

    @Override
    public T remove(int index) {
        if(index < 0 || index > size()) {
            throw new RuntimeException("Invalid index");
        }

        if(isEmpty()){
            return null;
        }
        if (index == 0) {
            T deletedElement = first.elem;
            first = first.next;
            return deletedElement;
        }

        Node<T> current = first.next;
        Node<T> prev = first;
        int currentIndex = 1;

        while (currentIndex < index) {
            prev = current;
            current = current.next;
            currentIndex++;
        }
        prev.next = current.next;
        return current.elem;
    }

    @Override
    public void reverse() {

    }

    @Override
    public void sort() {
        if (isEmpty()) return;
        if (size() == 1) return;
        
    }

}
