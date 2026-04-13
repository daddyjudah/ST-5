package com.mycompany.app;

public class Sqrt {
    private static final double EPS = 1.0e-8;
    private static final int MAX_ITERS = 1000;
    private final double value;

    public Sqrt(double arg) {
        this.value = arg;
    }

    public double mean(double x, double y) {
        return (x + y) * 0.5;
    }

    public boolean isAccurate(double guess, double x) {
        double error = guess * guess - x;
        return Math.abs(error) <= EPS;
    }

    public double refine(double guess, double x) {
        double quotient = x / guess;
        return mean(guess, quotient);
    }

    public double iterate(double guess, double x) {
        double current = guess;
        int steps = 0;
        do {
            if (isAccurate(current, x)) {
                break;
            }
            current = refine(current, x);
            steps++;
        } while (steps < MAX_ITERS);
        return current;
    }

    public double result() {
        if (isZero(value)) {
            return 0.0;
        }
        return iterate(initialGuess(value), value);
    }

    private static boolean isZero(double x) {
        return x == 0.0;
    }

    private static double initialGuess(double x) {
        return x >= 1.0 ? x : 1.0;
    }
}
