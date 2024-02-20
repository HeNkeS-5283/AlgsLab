package com.bu.algs.impl;

import com.bu.algs.BuList;
import java.util.Comparator;

// TODO: implement as dynamic array. Do not use Java collections of any utils.
public class BuArrayList<T> implements BuList<T> {
        Object[] arrayList = new Object[0];
    @Override
    public int size() {
        return arrayList.length;
    }

    @Override
    public boolean isEmpty() {
        return arrayList.length == 0;
    }

    @Override
    public boolean contains(T elem) {
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i] == elem) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        arrayList = new Object[0];
    }

    @Override
    public boolean add(T elem) {
        if(arrayList.length > 0) {
            Object[] cloneArray = new Object[arrayList.length];

            for (int i = 0; i < arrayList.length; i++) {
                cloneArray[i] = arrayList[i];
            }

            arrayList = new Object[arrayList.length+1];

            for (int i = 0; i < cloneArray.length; i++) {
                arrayList[i] = cloneArray[i];
            }
            arrayList[arrayList.length-1] = elem;
            return true;
        }
            else {
            arrayList = new Object[arrayList.length+1];
            arrayList[0] = elem;
            return true;
        }
    }

    @Override
    public boolean add(T elem, int index) {
        return false;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public boolean remove(T elem) {
        int n = -1;
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i] == elem) {
                n = i;
                break;
            }
        }
        Object[] cloneArray = new Object[arrayList.length-1];
        for (int i = 0; i < cloneArray.length; i++) {
            if (i != n) {
                cloneArray[i] = arrayList[i];
            }
        }
        arrayList = cloneArray;
        return true;
    }

    @Override
    public T remove(int index) {
        Object[] cloneArray = new Object[arrayList.length-1];
        for (int i = 0; i < cloneArray.length; i++) {
            if (i != index) {
                cloneArray[i] = arrayList[i];
            }
        }
        arrayList = cloneArray;
        return (T) arrayList;
    }

    @Override
    public void sort(Comparator<T> comparator) {

    }
}
