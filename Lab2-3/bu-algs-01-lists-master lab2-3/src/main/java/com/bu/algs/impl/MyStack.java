package com.bu.algs.impl;

import com.bu.algs.BuStack;


public class MyStack<T> implements BuStack<T> {

   private Node<T> first;
   private class Node<T> {
       private T elem;
       private Node<T> next;

       public Node (T elem, Node<T> next){
           this.elem = elem;
           this.next = next;
       }
   }


    @Override
    public int size() {
        if (isEmpty()) return 0;
        int count = 1;
        Node<T> current = first;
        while (current.next != null){
            current = current.next;
            count++;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public boolean contains(T elem) {
        if (isEmpty()) return false;
        Node<T> current = first;
        while (current.next != null){
            if (current.elem == elem) return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public void clear() {
        first = null;
    }

    @Override
    public T push(T item) {
        first = new Node<>(item, first);
        return item;
    }

    @Override
    public T pop() {
        if (isEmpty()) return null;
        T elem = first.elem;
        first = first.next;
        return elem;
    }

    @Override
    public T peek() {
        if (isEmpty()) return null;
        return first.elem;
    }

    @Override
    public int search(T elem) {
        int count = 0;
        Node<T> current = first;

        while (current.next != null){

            if (current.elem == elem) return count;
            current = current.next;
            count++;

        }
        if(current.elem == elem) return count;
        return -1;
    }
}
