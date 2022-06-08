package com.bm402.springplayground.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathsServiceImplTest {
    private final MathsService mathsService = new MathsServiceImpl();

    @Test
    void whenBaseIsPositiveAndExponentIsPositive_thenShouldReturnCorrectPositiveValue() {
        double result = mathsService.pow(5, 3);
        assertEquals(125, result);
    }

    @Test
    void whenBaseIsPositiveAndExponentIsNegative_thenShouldReturnCorrectPositiveValue() {
        double result = mathsService.pow(2, -3);
        assertEquals(0.125, result);
    }

    @Test
    void whenBaseIsNegativeAndExponentIsEvenPositive_thenShouldReturnCorrectPositiveValue() {
        double result = mathsService.pow(-3, 2);
        assertEquals(9, result);
    }

    @Test
    void whenBaseIsNegativeAndExponentIsOddPositive_thenShouldReturnCorrectNegativeValue() {
        double result = mathsService.pow(-3, 3);
        assertEquals(-27, result);
    }

    @Test
    void whenBaseIsNegativeAndExponentIsEvenNegative_thenShouldReturnCorrectPositiveValue() {
        double result = mathsService.pow(-2, -2);
        assertEquals(0.25, result);
    }

    @Test
    void whenBaseIsNegativeAndExponentIsOddNegative_thenShouldReturnCorrectNegativeValue() {
        double result = mathsService.pow(-2, -3);
        assertEquals(-0.125, result);
    }

    @Test
    void whenExponentIsZero_thenShouldReturnOne() {
        double result = mathsService.pow(5, 0);
        assertEquals(1, result);
    }

    @Test
    void whenExponentIsOne_thenShouldReturnBase() {
        double base = 3;
        double result = mathsService.pow(base, 1);
        assertEquals(base, result);
    }

    @Test
    void whenBaseIsZero_thenShouldReturnZero() {
        double result = mathsService.pow(0, 12);
        assertEquals(0, result);
    }

    @Test
    void whenResultIsTooLargeForDouble_thenShouldReturnInfinity() {
        double result = mathsService.pow(Double.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals(Double.POSITIVE_INFINITY, result);
    }
}
