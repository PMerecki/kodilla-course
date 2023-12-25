package com.kodilla.dodatek;


public class Potegowanie {
    static int potega(int a, int n)
    {
        if (n == 0) {
            throw new ArithmeticException();
        }
        if (a == 0){
            return a;
        }
        if (n == 1)
            return a;
        if (n % 2 == 0)
        {
            int s = potega(a, n / 2);
            return s * s;
        } else
        {
            int s = potega(a, n - 1);
            return a * s;
        }
    }
    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {
        Potegowanie potegowanie = new Potegowanie();
        try {
            int result = Potegowanie.potega(11, 2);
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println(1);
        } finally {
            System.out.println("End of program");
        }
    }
}