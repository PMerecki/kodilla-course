package com.kodilla.good.patterns.challenges;

public class Silnia {
    public double factorial(double a) throws ArithmeticException {
        int i, fact = 1;
        if (a == 0) {
            throw new ArithmeticException();
        }
        for (i = 1; i <= a; i++) {
            fact = fact * i;
        }
        return fact;
    }

    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {
        Silnia silnia = new Silnia();
        try {
            double result = silnia.factorial(5);
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println(1.0);
        } finally {
            System.out.println("End of program");
        }
    }
}