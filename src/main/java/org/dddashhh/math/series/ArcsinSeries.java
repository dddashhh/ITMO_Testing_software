package org.dddashhh.math.series;

import org.dddashhh.math.combinatorics.Factorial;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class ArcsinSeries {

    private final int limit;
    private static final MathContext MATH_CONTEXT = new MathContext(100, RoundingMode.HALF_UP);

    public ArcsinSeries(int limit) {
        if (limit <= 0) {
            throw new IllegalArgumentException("Limit must be a positive integer.");
        }
        this.limit = limit;
    }

    public double calculate(double x) {
        if (x < -1 || x > 1) {
            return Double.NaN;
        }

        BigDecimal xBigDecimal = new BigDecimal(x, MATH_CONTEXT);
        BigDecimal sum = BigDecimal.ZERO;

        for (int n = 0; n < limit; n++) {
            BigDecimal term = calculateTerm(xBigDecimal, n);
            sum = sum.add(term, MATH_CONTEXT);
        }

        return sum.doubleValue();
    }

    private BigDecimal calculateTerm(BigDecimal x, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative.");
        }

        if (n == 0) {
            return x;
        }

        BigDecimal numerator = Factorial.calculate(2 * n);
        BigDecimal denominator = BigDecimal.valueOf(4).pow(n, MATH_CONTEXT).multiply(Factorial.calculate(n).pow(2, MATH_CONTEXT), MATH_CONTEXT).multiply(BigDecimal.valueOf(2 * n + 1), MATH_CONTEXT);
        BigDecimal powerOfX = x.pow(2 * n + 1, MATH_CONTEXT);
        BigDecimal term = numerator.multiply(powerOfX, MATH_CONTEXT).divide(denominator, MATH_CONTEXT);

        return term;
    }

}