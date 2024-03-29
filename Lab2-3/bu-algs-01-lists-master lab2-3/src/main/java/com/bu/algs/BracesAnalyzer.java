package com.bu.algs;

import com.bu.algs.impl.BuStackImpl;

import java.util.stream.Stream;

public class BracesAnalyzer {

    private static final Braces PARENTHESES = new Braces('(', ')');
    private static final Braces CURLY_BRACES = new Braces('{', '}');
    private static final Braces SQUARE_BRACKETS = new Braces('[', ']');
    private static final Braces ANGLE_BRACKETS = new Braces('<', '>');

    private static final Braces[] BRACES = { PARENTHESES, CURLY_BRACES, SQUARE_BRACKETS, ANGLE_BRACKETS };

    public boolean bracesCorrect(String s) {
        BuStack<Character> stack = new BuStackImpl<>();
        for (char c : s.toCharArray()) {
            if (isOpenBrace(c)) {
                stack.push(c);
            }

            if (isCloseBrace(c)) {
                if (stack.isEmpty()) {
                    return false;
                }

                char open = stack.pop();
                char expectedOpen = getExpectedOpenBrace(c);
                if (open != expectedOpen) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isOpenBrace(char c) {
        return Stream.of(BRACES)
                .anyMatch(brace -> c == brace.open);
    }

    private static boolean isCloseBrace(char c) {
        return Stream.of(BRACES)
                .anyMatch(brace -> c == brace.close);
    }

    private static char getExpectedOpenBrace(char closeBrace) {
        return Stream.of(BRACES)
                .filter(brace -> brace.close == closeBrace)
                .map(Braces::getOpen)
                .findAny()
                .orElseThrow(() -> new IllegalStateException("Not found open brace for close " + closeBrace));
    }

    private static class Braces {

        private final char open;
        private final char close;

        public Braces(char open, char close) {
            this.open = open;
            this.close = close;
        }

        public char getOpen() {
            return open;
        }
    }
}
