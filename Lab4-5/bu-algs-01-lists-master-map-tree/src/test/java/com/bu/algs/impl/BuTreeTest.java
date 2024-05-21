package com.bu.algs.impl;

import com.bu.algs.BuTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BuTreeTest {

    @Test
    void testBST() {
        BuTree<Integer> buTree = new BuTreeImpl<>();

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
    void testToString() {
        BuTree<Integer> buTree = new BuTreeImpl<>();

        buTree.add(5);
        buTree.add(10);
        buTree.add(1);
        buTree.add(4);
        buTree.add(2);

        buTree.print();
        Assertions.assertEquals("[5 1 4 2 10 ]", buTree.toString());
    }
}
