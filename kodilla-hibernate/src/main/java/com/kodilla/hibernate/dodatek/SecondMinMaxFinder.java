package com.kodilla.hibernate.dodatek;

public class SecondMinMaxFinder {

    public static void main(String[] args) {
        int[] numbers = {3, 1, 1, 5, 6, 7, 9, 15, 3, 4, 7, 10};

        int secondMin = findSecondMinimum(numbers);
        int secondMax = findSecondMaximum(numbers);

        System.out.println("Second Minimum: " + secondMin);
        System.out.println("Second Maximum: " + secondMax);
    }

    // Metoda znajdująca drugie minimum w tablicy
    private static int findSecondMinimum(int[] arr) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num < min) {
                secondMin = min;
                min = num;
            } else if (num < secondMin && num != min) {
                secondMin = num;
            }
        }

        return secondMin;
    }

    // Metoda znajdująca drugie maksimum w tablicy
    private static int findSecondMaximum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num != max) {
                secondMax = num;
            }
        }

        return secondMax;
    }
}