package com.bu.algs.impl;

import com.bu.algs.BuKey;
import com.bu.algs.BuMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyMapTest {

    @Test
    void put_clear_remove() {
        BuMap<BuKey, String> map = new MyMap<>();
        map.put(new BuKey("foo"), "bar");

        Assertions.assertEquals("bar", map.get(new BuKey("foo")));

        map.put(new BuKey("fool"), "barer");
        map.put(new BuKey("fruit"), "bolls");

        map.remove(new BuKey("fool"));
        Assertions.assertEquals(2, map.size());

        map.clear();
        Assertions.assertTrue(map.isEmpty());
    }

    @Test
    void size_isEmpty() {
        BuMap<BuKey, String> map = new MyMap<>();
        Assertions.assertTrue(map.isEmpty());

        map.put(new BuKey("foo"), "bar");
        Assertions.assertEquals(1, map.size());
        map.put(new BuKey("foo"), "barly");
        Assertions.assertEquals(1, map.size());

        map.remove(new BuKey("foo"));
        Assertions.assertTrue(map.isEmpty());
    }

    @Test
    void containsKey_containsValue() {
        BuMap<BuKey, String> map = new MyMap<>();

        map.put(new BuKey("foo2"), "bar");
        map.put(new BuKey("frogs"), "car");
        map.put(new BuKey("man"), "man");
        map.put(new BuKey("canals"), "cen");
        map.put(new BuKey("vertigo"), "clear");
        Assertions.assertEquals(5, map.size());

        Assertions.assertFalse(map.containsKey(new BuKey("rein")));

        map.put(new BuKey("car"), "lada");

        Assertions.assertFalse(map.containsKey(new BuKey("man")));

        Assertions.assertTrue(map.containsValue("cen"));
    }

}
