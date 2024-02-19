package com.bu.algs.impl;

import com.bu.algs.BuList;

import java.util.ArrayList;
import java.util.Comparator;

// TODO: implement as dynamic array. Do not use Java collections of any utils.
public class BuArrayList<T> implements BuList<T> {

    private ArrayList<T> arrayList = new ArrayList<T>();

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    @Override
    public boolean contains(T elem) {
        return arrayList.contains(elem);
    }

    @Override
    public void clear() {
       arrayList.clear();
    }

    @Override
    public boolean add(T elem) {
        return arrayList.add(elem);
    }

    @Override
    public boolean add(T elem, int index) {
        return false;
    }

    @Override
    public T get(int index) {
        return arrayList.get(index);
    }

    @Override
    public boolean remove(T elem) {
        return arrayList.remove(elem);
    }

    @Override
    public T remove(int index) {
        return arrayList.remove(index);
    }

    @Override
    public void sort(Comparator<T> comparator) {
        arrayList.sort(comparator);}
}
