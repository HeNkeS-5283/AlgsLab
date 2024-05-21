package com.bu.algs.impl;

import com.bu.algs.BuHashable;
import com.bu.algs.BuMap;
import com.bu.algs.util.Objects;

public class MyMap <K extends BuHashable, V> implements BuMap<K,V> {

    private static final int Capacity = 16;

    Object[] buck = new Object[Capacity];

    int size = 0;
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        buck = new Object[Capacity];
    }

    @Override
    public V put(K key, V value) {
        int hash = key.hash();
        int place = hash % Capacity;

        Object oldValue = buck[place];
        if(oldValue == null){
            size++;
        } else {
            System.out.println("Bucket is take a value (" + oldValue + ") change in new value");
        }
        buck[place] = value;
        return (V) oldValue;
    }

    @Override
    public V get(K key) {
        int hash = key.hash();
        int place = hash & Capacity;

        return (V) buck[place];
    }

    @Override
    public V remove(K key) {
        int hash = key.hash();
        int place = hash & Capacity;

        Object old = buck[place];
        if(buck[place] != null){
            size--;
        }
        buck[place] = null;
        return (V) old;
    }

    @Override
    public boolean containsKey(K key) {
        int hash = key.hash();
        int place = hash & Capacity;

        return buck[place] != null;
    }

    @Override
    public boolean containsValue(V value) {
        for (Object i : buck) {
            if(Objects.equals(i,value)){
                return true;
            }
        }
        return false;
    }
}
