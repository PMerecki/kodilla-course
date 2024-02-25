package com.kodilla.patterns2.dodatek;

public class DecimalToBinaryConverter {

    public static String convertToBinary(int decimalNumber) {
        if (decimalNumber == 0) {
            return "0";
        }

        StringBuilder binary = new StringBuilder();
        while (decimalNumber > 0) {
            int remainder = decimalNumber % 2;
            binary.insert(0, remainder); // Wstawia resztę na początek
            decimalNumber /= 2;
        }

        return binary.toString();
    }

    public static void main(String[] args) {
        int decimalNumber = 11; // Przykładowa liczba dziesiętna
        String binaryNumber = convertToBinary(decimalNumber);
        System.out.println("Liczba dziesietna " + decimalNumber + " w systemie binarnym to: " + binaryNumber);
    }
}
