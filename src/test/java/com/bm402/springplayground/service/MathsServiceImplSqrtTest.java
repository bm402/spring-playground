package com.bm402.springplayground.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathsServiceImplSqrtTest {
    private final MathsService mathsService = new MathsServiceImpl();
    private final double delta = 0.00001;

    @Test
    void whenNumIsPositiveInteger_thenShouldReturnCorrectValue() {
        double result = mathsService.sqrt(9);
        assertEquals(3, result, delta);
    }

    @Test
    void whenNumIsPositiveDouble_thenShouldReturnCorrectValue() {
        double result = mathsService.sqrt(6.25);
        assertEquals(2.5, result, delta);
    }

    @Test
    void whenNumIsOne_thenShouldReturnOne() {
        double result = mathsService.sqrt(1);
        assertEquals(1, result, delta);
    }

    @Test
    void whenNumIsZero_thenShouldReturnZero() {
        double result = mathsService.sqrt(0);
        assertEquals(0, result, delta);
    }

    @Test
    void whenNumIsNegative_thenShouldReturnNaN() {
        double result = mathsService.sqrt(-5);
        assertEquals(Double.NaN, result, delta);
    }
}
