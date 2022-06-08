package com.bm402.springplayground.service;

import org.springframework.stereotype.Service;

@Service
public class MathsServiceImpl implements MathsService {

    public double pow(double base, int exponent) {
        if (exponent < 0) {
            return 1.0/powHelper(base, -exponent);
        }

        return powHelper(base, exponent);
    }

    private double powHelper(double base, int exponent) {
        if (exponent == 0) {
            return 1.0;
        }

        if (exponent % 2 == 1) {
            return base * powHelper(base, exponent-1);
        }

        double sqrt = powHelper(base, exponent/2);
        return sqrt*sqrt;
    }
}
