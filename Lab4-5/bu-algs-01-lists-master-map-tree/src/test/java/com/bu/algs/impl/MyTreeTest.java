package com.bu.algs.impl;

import com.bu.algs.BuTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyTreeTest {
    @Test
    void testBST() {
        MyTree<Integer> buTree = new MyTree<>();

        // assert empty tree
        Assertions.assertTrue(buTree.isEmpty());
        Assertions.assertEquals(0, buTree.size());

        // add elements
        buTree.add(1);
        buTree.add(2);
        buTree.add(3);

        // assert elements
        Assertions.assertFalse(buTree.isEmpty());
        Assertions.assertEquals(3, buTree.size());
        Assertions.assertTrue(buTree.contains(1));
        Assertions.assertTrue(buTree.contains(2));
        Assertions.assertTrue(buTree.contains(3));

        // clear tree
        buTree.clear();

        // assert empty tree
        Assertions.assertTrue(buTree.isEmpty());
        Assertions.assertEquals(0, buTree.size());
    }

    @Test
    void test1() {
        MyTree<Integer> tree = new MyTree<>();
        tree.add(12);
        tree.add(5);
        tree.add(3);
        tree.add(16);
        tree.add(22);
        tree.add(35);
        tree.add(11);

        tree.print();
        Assertions.assertTrue(tree.contains(5));
        Assertions.assertTrue(tree.contains(12));
        Assertions.assertTrue(tree.contains(3));
        Assertions.assertTrue(tree.contains(16));
        Assertions.assertTrue(tree.contains(22));
        Assertions.assertTrue(tree.contains(35));
        Assertions.assertTrue(tree.contains(11));

        Assertions.assertFalse(tree.contains(55));

        Assertions.assertEquals(7, tree.size());
    }

    @Test
    void delete() {
        MyTree<Integer> tree = new MyTree<>();
        tree.add(12);
        tree.add(5);
        tree.add(3);
        tree.add(16);
        tree.add(22);
        tree.add(35);
        tree.add(11);


        Assertions.assertEquals(3, tree.delete(3));
        tree.delete(3);
        tree.print();
        tree.delete(22);
        tree.print();
    }
}
