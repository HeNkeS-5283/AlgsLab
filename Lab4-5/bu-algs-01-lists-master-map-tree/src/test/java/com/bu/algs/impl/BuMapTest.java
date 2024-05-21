package com.bu.algs.impl;

import com.bu.algs.BuKey;
import com.bu.algs.BuMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BuMapTest {

    @Test
    void put() {
        BuMap<BuKey, String> map = new BuMapImpl<>();
        map.put(new BuKey("foo"), "bar");

        Assertions.assertEquals("bar", map.get(new BuKey("foo")));
    }

    @Test
    void size() {
        BuMap<BuKey, String> map = new BuMapImpl<>();
        Assertions.assertEquals(0, map.size());

        map.put(new BuKey("foo"), "bar");
        Assertions.assertEquals(1, map.size());

        map.remove(new BuKey("foo"));
        Assertions.assertEquals(0, map.size());
    }
}
