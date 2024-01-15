package com.kodilla.patterns.dodatek;

public class MinMax {

    public static void main(String[] args) {
        int[] numbers = {3, 1, 5, 6, 7, 9, 15, 3, 4, 7, 10};
        int minValue = findMinValue(numbers);
        int maxValue = findMaxValue(numbers);
        System.out.println("Minimalna wartosc: " + minValue);
        System.out.println("Maksymalna wartosc: " + maxValue);
    }

    private static int findMinValue(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int minValue = array[0];
        for (int number : array) {
            minValue = Math.min(minValue, number);
        }
        return minValue;
    }

    private static int findMaxValue(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int maxValue = array[0];
        for (int number : array) {
            maxValue = Math.max(maxValue, number);
        }
        return maxValue;
    }
}
