package org.dddashhh.math.series;

public class ArccosSeries {
    private final ArcsinSeries arcsinSeries;

    public ArccosSeries(int limit) {
        this.arcsinSeries = new ArcsinSeries(limit);
    }

    public double calculate(double x) {
        if (x < -1 || x > 1) {
            return Double.NaN;
        }

        if (x > 0.9) {
            double newX = Math.sqrt((1 - x) / 2.0);
            return 2 * arcsinSeries.calculate(newX);
        } else if (x < -0.9) {
            double newX = Math.sqrt((1 + x) / 2.0);
            return Math.PI - 2 * arcsinSeries.calculate(newX);
        } else {
            return Math.PI / 2.0 - arcsinSeries.calculate(x);
        }
    }
}
