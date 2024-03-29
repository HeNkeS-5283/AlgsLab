package com.bu.algs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class BracesAnalyzerTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/braces_analyzer_test.csv", numLinesToSkip = 1)
    void bracesCorrect(String input, boolean expectedResult) {
        BracesAnalyzer bracesAnalyzer = new BracesAnalyzer();
        Assertions.assertEquals(expectedResult, bracesAnalyzer.bracesCorrect(input));
    }
}
