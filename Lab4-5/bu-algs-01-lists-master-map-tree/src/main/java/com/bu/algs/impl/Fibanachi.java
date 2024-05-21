package com.bu.algs.impl;

public class Fibanachi {
    int[] fibanachi = new int[1000];

    public int recorse(int index) {
        if (index == 0 || index == 1) {
            return 1;
        }
        return recorse(index - 2) + recorse(index - 1);
    }

    public int notRecorse(int index) {
        fibanachi[0] = 1;
        fibanachi[1] = 1;
        for (int i = 2; i < 1000; i++) {
            fibanachi[i] = fibanachi[i-1] + fibanachi[i-2];
        }
        return fibanachi[index];
    }
}
