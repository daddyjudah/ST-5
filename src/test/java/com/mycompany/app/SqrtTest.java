package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SqrtTest {
    private static final double EPS = 1.0e-9;

    @Test
    void averageComputesMidpoint() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(12.0, sqrt.mean(10.0, 14.0), EPS);
    }

    @Test
    void averageIsOrderIndependent() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(12.0, sqrt.mean(14.0, 10.0), EPS);
    }

    @Test
    void goodReturnsTrueForNearPerfectGuess() {
        Sqrt sqrt = new Sqrt(2.0);
        assertTrue(sqrt.isAccurate(Math.sqrt(2.0), 2.0));
    }

    @Test
    void goodReturnsFalseForRoughGuess() {
        Sqrt sqrt = new Sqrt(2.0);
        assertFalse(sqrt.isAccurate(1.41, 2.0));
    }

    @Test
    void refineMovesCloserToTarget() {
        Sqrt sqrt = new Sqrt(9.0);
        double improved = sqrt.refine(5.0, 9.0);
        double before = Math.abs(5.0 * 5.0 - 9.0);
        double after = Math.abs(improved * improved - 9.0);
        assertTrue(after < before);
    }

    @Test
    void improveMatchesAverageOfGuessAndQuotient() {
        Sqrt sqrt = new Sqrt(2.0);
        double improved = sqrt.refine(2.0, 2.0);
        assertEquals(sqrt.mean(2.0, 1.0), improved, EPS);
    }

    @Test
    void iterReturnsGuessWhenAlreadyGood() {
        Sqrt sqrt = new Sqrt(16.0);
        assertEquals(4.0, sqrt.iterate(4.0, 16.0), EPS);
    }

    @Test
    void iterConvergesFromRoughStart() {
        Sqrt sqrt = new Sqrt(9.0);
        assertEquals(3.0, sqrt.iterate(2.0, 9.0), 1.0e-6);
    }

    @Test
    void calcMatchesMathSqrtForNonPerfectSquare() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), sqrt.result(), 1.0e-6);
    }

    @Test
    void calcReturnsExactForPerfectSquare() {
        Sqrt sqrt = new Sqrt(36.0);
        assertEquals(6.0, sqrt.result(), 1.0e-6);
    }

    @Test
    void calcReturnsZeroForZeroArgument() {
        Sqrt sqrt = new Sqrt(0.0);
        assertEquals(0.0, sqrt.result(), 1.0e-6);
    }

    @Test
    void calcHandlesSmallFraction() {
        Sqrt sqrt = new Sqrt(0.25);
        assertEquals(0.5, sqrt.result(), 1.0e-6);
    }
}
