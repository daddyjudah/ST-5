package com.mycompany.app;

public class App {
    public static void main(String[] args) {
        double val = args.length > 0 ? Double.parseDouble(args[0]) : 2.0;
        Sqrt sqrt = new Sqrt(val);
        double result = sqrt.result();
        System.out.printf("Sqrt of %.1f = %.10f%n", val, result);
    }
}
