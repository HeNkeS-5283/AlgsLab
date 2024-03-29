package com.bu.algs.util;

public final class Objects {

    // empty constructor to make sure that instance of util class is impossible to create
    private Objects() {}

    public static boolean equals(Object a, Object b) {
        // check if links are pointed to the same memory address
        if (a == b) {
            return true;
        }

        // plain equals check for non-null objects
        if (a != null && b != null) {
            return a.equals(b);
        }

        return false;
    }
}
