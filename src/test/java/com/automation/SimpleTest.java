package com.automation;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class SimpleTest {
    @Test
    public void calculationPlusTest() {
        int a = 2;
        int b = 2;
        int sum = a + b;
        assertEquals(sum, 4);

    }

    @Test
    public void calculationMinusTest() {
        int a = 5;
        int b = 4;
        int sum = a - b;
        assertEquals(sum, 4, "Nau4ic 4itatb");

    }

    private boolean verifyPlusCalcculationAction(int a, int b, int result) {
        return a + b == result;
    }

    @Test
    public void verifyPlusCalcculationActionTest() {
        int a = 5;
        int b = 4;
        boolean result =(verifyPlusCalcculationAction(a, b, 9));
        assertTrue(result);

    }
}