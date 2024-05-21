package com.bu.algs.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFibanachi {
    @Test
    void test1() {
        Fibanachi fibanachi = new Fibanachi();

        Assertions.assertEquals(8, fibanachi.notRecorse(5));
        Assertions.assertEquals(13, fibanachi.notRecorse(6));
        Assertions.assertEquals(21, fibanachi.notRecorse(7));
        Assertions.assertEquals(34, fibanachi.notRecorse(8));

    }
    @Test
    void test2() {
        Fibanachi fibanachi = new Fibanachi();

        Assertions.assertEquals(8, fibanachi.recorse(5));
        Assertions.assertEquals(13, fibanachi.recorse(6));
        Assertions.assertEquals(21, fibanachi.recorse(7));
        Assertions.assertEquals(34, fibanachi.recorse(8));

    }
}
