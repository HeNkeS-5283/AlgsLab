package com.bu.algs.impl;

import com.bu.algs.BuHashable;
import com.bu.algs.BuMap;
import com.bu.algs.util.Objects;

public class BuMapImpl<K extends BuHashable, V> implements BuMap<K, V> {

    private static final int CAPACITY = 16;

    Object[] buckets = new Object[CAPACITY];
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
        buckets = new Object[CAPACITY];
    }

    @Override
    public V put(K key, V value) {
        int hash = key.hash();
        int bucketNumber = hash & CAPACITY;

        Object oldValue = buckets[bucketNumber];
        if (oldValue == null) {
            size++;
        } else {
            System.out.println("Bucket already case a value " + oldValue + ", collision detected");
        }

        buckets[bucketNumber] = value;
        return (V) oldValue;
    }

    @Override
    public V get(K key) {
        int hash = key.hash();
        int bucketNumber = hash & CAPACITY;

        return (V) buckets[bucketNumber];
    }

    @Override
    public V remove(K key) {
        int hash = key.hash();
        int bucketNumber = hash & CAPACITY;

        Object value = buckets[bucketNumber];
        if (value != null) {
            size--;
        }
        buckets[bucketNumber] = null;

        return (V) value;
    }

    @Override
    public boolean containsKey(K key) {
        int hash = key.hash();
        int bucketNumber = hash & CAPACITY;

        return buckets[bucketNumber] != null;
    }

    @Override
    public boolean containsValue(V value) {
        for (Object bucket : buckets) {
            if (Objects.equals(bucket, value)) {
                return true;
            }
        }
        return false;
    }
}
