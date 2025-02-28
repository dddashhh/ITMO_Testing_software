package org.dddashhh.math.combinatorics;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Factorial {

    private static final MathContext MATH_CONTEXT = new MathContext(100, RoundingMode.HALF_UP);

    public static BigDecimal calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        if (n == 0) {
            return BigDecimal.ONE;
        }

        BigDecimal result = BigDecimal.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigDecimal.valueOf(i), MATH_CONTEXT);
        }
        return result;
    }
}