package com.bu.algs.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BuLinkedListTest {

    @Test
    void size() {
        BuLinkedList<String> list = new BuLinkedList<>();
        Assertions.assertEquals(0, list.size());

        // test size increased when elem added
        list.add("foo");
        list.add("bar");
        Assertions.assertEquals(2, list.size());

        // test size decreased when elem removed
        list.remove("foo");
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void isEmpty() {
        BuLinkedList<String> list = new BuLinkedList<>();
        Assertions.assertTrue(list.isEmpty());

        // test list is not empty anymore when elem is added
        list.add("foo");
        Assertions.assertFalse(list.isEmpty());

        // test list is empty again when last elem is removed
        list.remove("foo");
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    void contains() {
        BuLinkedList<String> list = new BuLinkedList<>();
        list.add("foo");

        Assertions.assertTrue(list.contains("foo"));
        Assertions.assertFalse(list.contains("bar"));

        list.remove("foo");
        Assertions.assertFalse(list.contains("foo"));
    }

    @Test
    void clear() {
        BuLinkedList<String> list = new BuLinkedList<>();
        list.add("foo");
        list.add("bar");
        list.add("bus");

        list.clear();
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    void addAndGet() {
        BuLinkedList<String> list = new BuLinkedList<>();
        // add to the end
        list.add("foo");
        list.add("bar");

        // add to begin
        list.add("head", 0);

        // add to mid
        list.add("mid", 2);

        Assertions.assertEquals("head", list.get(0));
        Assertions.assertEquals("foo", list.get(1));
        Assertions.assertEquals("mid", list.get(2));
        Assertions.assertEquals("bar", list.get(3));
    }

    @Test
    void remove() {
        BuLinkedList<String> list = new BuLinkedList<>();
        list.add("foo");
        list.add("bar");
        list.add("bus");

        list.remove(0);
        Assertions.assertFalse(list.contains("foo"));

        list.remove("bus");
        Assertions.assertFalse(list.contains("bus"));
    }

    @Test
    void sort() {
        BuLinkedList<Integer> list = new BuLinkedList<>();
        list.add(5);
        list.add(3);
        list.add(8);
        list.add(14);
        list.add(1);

        list.sort();
        Assertions.assertEquals(1, list.get(0));
        Assertions.assertEquals(3, list.get(1));
        Assertions.assertEquals(5, list.get(2));
        Assertions.assertEquals(8, list.get(3));
        Assertions.assertEquals(14, list.get(4));
    }

    @Test
    void reverse() {
        BuLinkedList<Integer> list = new BuLinkedList<>();
        list.add(5);
        list.add(3);
        list.add(8);
        list.add(14);
        list.add(1);

        list.sort();
        Assertions.assertEquals(1, list.get(0));
        Assertions.assertEquals(14, list.get(1));
        Assertions.assertEquals(8, list.get(2));
        Assertions.assertEquals(3, list.get(3));
        Assertions.assertEquals(5, list.get(4));
    }
}
