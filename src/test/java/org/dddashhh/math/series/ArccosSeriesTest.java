package org.dddashhh.math.series;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ArccosSeriesTest {

    private static final double EPSILON = 0.001;

    @Test
    void testArccosAtZero() {
        ArccosSeries arccosSeries = new ArccosSeries(50);
        assertEquals(Math.PI / 2, arccosSeries.calculate(0), EPSILON);
    }

    @Test
    void testArccosAtOne() {
        ArccosSeries arccosSeries = new ArccosSeries(100);
        assertEquals(0, arccosSeries.calculate(1), EPSILON);
    }

    @Test
    void testArccosAtNegativeOne() {
        ArccosSeries arccosSeries = new ArccosSeries(100);
        assertEquals(Math.PI, arccosSeries.calculate(-1), EPSILON);
    }


    @ParameterizedTest
    @ValueSource(doubles = {0.25, 0.5, 0.75, 0.9, 0.99, -0.25, -0.5, -0.75, -0.9, -0.99})
    void testArccosWithinDomain(double x) {
        ArccosSeries arccosSeries = new ArccosSeries(50);
        double expected = Math.acos(x);
        double actual = arccosSeries.calculate(x);
        assertEquals(expected, actual, EPSILON, "Value at x = " + x + " is incorrect.");
    }

    @Test
    void testArccosApproximationConvergence() {
        double x = 0.6;
        double expected = Math.acos(x);


        ArccosSeries series5 = new ArccosSeries(5);
        ArccosSeries series10 = new ArccosSeries(10);
        ArccosSeries series15 = new ArccosSeries(15);
        ArccosSeries series50 = new ArccosSeries(50);

        double error5 = Math.abs(expected - series5.calculate(x));
        double error10 = Math.abs(expected - series10.calculate(x));
        double error15 = Math.abs(expected - series15.calculate(x));
        double error50 = Math.abs(expected - series50.calculate(x));


        assertTrue(error10 < error5);
        assertTrue(error15 < error10);
    }


    @Test
    void testArccosOutsideDomain() {
        ArccosSeries arccosSeries = new ArccosSeries(10);
        assertTrue(Double.isNaN(arccosSeries.calculate(1.000001)));
        assertTrue(Double.isNaN(arccosSeries.calculate(-1.000001)));
    }

    @Test
    void testArccosWithHighLimit() {
        ArccosSeries arccosSeries = new ArccosSeries(2000);
        assertDoesNotThrow(() -> arccosSeries.calculate(0.5));
    }
}