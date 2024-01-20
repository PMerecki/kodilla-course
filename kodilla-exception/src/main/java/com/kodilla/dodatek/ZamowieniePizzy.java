package com.kodilla.dodatek;

import java.util.Scanner;

public class ZamowieniePizzy {

    public static void main(String[] args) {
        System.out.println("Witaj w programie zamawiania pizzy!");

        // Inicjalizacja zamówienia
        String zamowienie = "";

        // Pobierz wybór użytkownika
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wybierz rodzaj pizzy:");
        System.out.println("1. Pizza z szynką");
        System.out.println("2. Pizza margherita");
        System.out.println("3. Pizza z ananasem");

        int wyborPizza = scanner.nextInt();

        // Wybór dodatków
        System.out.println("Dodatki:");
        System.out.println("A. Szynka");
        System.out.println("B. Margherita");
        System.out.println("C. Ananas");

        char dodatek = scanner.next().charAt(0);

        switch (wyborPizza) {
            case 1:
                zamowienie = "Pizza z szynką, dodatek: ";
                break;
            case 2:
                zamowienie = "Pizza margherita, dodatek: ";
                break;
            case 3:
                zamowienie = "Pizza z ananasem, dodatek: ";
                break;
            default:
                System.out.println("Nieprawidłowy wybór pizzy.");
                return;
        }

        switch (dodatek) {
            case 'A':
                zamowienie += "Szynka";
                break;
            case 'B':
                zamowienie += "Margherita";
                break;
            case 'C':
                zamowienie += "Ananas";
                break;
            default:
                System.out.println("Nieprawidłowy wybór dodatku.");
                return;
        }

        // Wyświetl zamówienie
        System.out.println("Twoje zamówienie: " + zamowienie);
        System.out.println("Dziękujemy za zamówienie!");

        // Zamknij Scanner
        scanner.close();
    }
}