package com.bm402.springplayground.service;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

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

    public double sqrt(double num) {
        if (num < 0) {
            return Double.NaN;
        }

        double lo = 0;
        double hi = num;
        double mid = (lo+hi)/2;
        double delta = 0.000001;

        while (mid*mid-delta > num || mid*mid+delta < num) {
            if (mid*mid < num) {
                lo = mid;
            } else {
                hi = mid;
            }
            mid = (lo+hi)/2;
        }

        return Double.parseDouble(new DecimalFormat("#.#####").format(mid));
    }
}
