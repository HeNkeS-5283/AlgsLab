package com.bu.algs.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyStackTest {
    @Test
    void size() {
        MyStack<Integer> stack = new MyStack<>();
        Assertions.assertEquals(0, stack.size());

        stack.push(2);
        stack.push(5);
        stack.push(6);
        Assertions.assertEquals(3, stack.size());

        stack.pop();
        Assertions.assertEquals(2, stack.size());
    }
    @Test
    void isEmpty() {
        MyStack<Integer> stack = new MyStack<>();
        Assertions.assertTrue(stack.isEmpty());

        stack.push(8);
        stack.push(6);

        Assertions.assertFalse(stack.isEmpty());
    }

    @Test
    void contains() {
        MyStack<String> stack = new MyStack<>();

        stack.push("Oleg");
        stack.push("Maks");
        stack.push("Sasha");
        stack.push("Kiril");

        Assertions.assertTrue(stack.contains("Sasha"));
        Assertions.assertTrue(stack.contains("Kiril"));

        stack.pop();
        Assertions.assertFalse(stack.contains("Kiril"));
    }

    @Test
    void clear() {
        MyStack<Integer> stack = new MyStack<>();

        stack.push(8);
        stack.push(6);
        stack.push(7);
        stack.push(9);
        Assertions.assertFalse(stack.isEmpty());

        stack.clear();
        Assertions.assertTrue(stack.isEmpty());
    }

    @Test
    void pushAndPeek() {
        MyStack<Integer> stack = new MyStack<>();

        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(18);
        stack.push(12);

        Assertions.assertEquals(5, stack.size());
        Assertions.assertEquals(12, stack.peek());

        stack.push(35);
        Assertions.assertEquals(35, stack.peek());
    }

    @Test
    void pop() {
        MyStack<Integer> stack = new MyStack<>();

        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(18);
        stack.push(12);

        Assertions.assertEquals(12, stack.pop());
        Assertions.assertEquals(18, stack.pop());
        Assertions.assertEquals(3, stack.size());
    }

    @Test
    void search() {
        MyStack<Integer> stack = new MyStack<>();

        stack.push(11);
        stack.push(8);
        stack.push(7);
        stack.push(18);
        stack.push(12);

        Assertions.assertEquals(2, stack.search(7));
        Assertions.assertEquals(4, stack.search(11));
        Assertions.assertEquals(0, stack.search(12));

    }
}
