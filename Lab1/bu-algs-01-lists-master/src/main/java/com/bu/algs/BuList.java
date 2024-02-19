package com.bu.algs;

import java.util.Comparator;

public interface BuList<T> extends BuCollection<T> {

    boolean add(T elem);

    boolean add(T elem, int index);

    T get(int index);

    boolean remove(T elem);

    T remove(int index);

    void sort(Comparator<T> comparator);
}
