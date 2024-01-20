package com.kodilla.dodatek;

import java.util.Scanner;

public class SklepSpozywczy {

    public static void main(String[] args) {
        System.out.println("Witaj w sklepie spożywczym!");

        // Inicjalizacja zamówienia
        String zamowienie = "";

        // Pobierz wybór użytkownika
        Scanner scanner = new Scanner(System.in);

        // Wybór produktu
        System.out.println("Dostępne produkty:");
        System.out.println("1. Chleb");
        System.out.println("2. Mleko");
        System.out.println("3. Jajka");
        System.out.println("4. Ryż");
        System.out.println("5. Cukier");
        System.out.println("6. Masło");
        System.out.println("7. Jogurt");
        System.out.println("8. Pomidory");
        System.out.println("9. Ser");
        System.out.println("10. Szynka");

        System.out.print("Wybierz numer produktu: ");
        int numerProduktu = scanner.nextInt();

        // Sprawdź poprawność numeru produktu
        if (numerProduktu < 1 || numerProduktu > 10) {
            System.out.println("Nieprawidłowy numer produktu.");
            return;
        }

        // Wyświetl zamówienie
        zamowienie = "Zamówiono: " + nazwaProduktu(numerProduktu);
        System.out.println(zamowienie);
        System.out.println("Dziękujemy za zakupy!");

        // Zamknij Scanner
        scanner.close();
    }

    // Metoda pomocnicza do zwracania nazwy produktu na podstawie numeru
    private static String nazwaProduktu(int numerProduktu) {
        return switch (numerProduktu) {
            case 1 -> "Chleb";
            case 2 -> "Mleko";
            case 3 -> "Jajka";
            case 4 -> "Ryż";
            case 5 -> "Cukier";
            case 6 -> "Masło";
            case 7 -> "Jogurt";
            case 8 -> "Pomidory";
            case 9 -> "Ser";
            case 10 -> "Szynka";
            default -> "Nieznany produkt";
        };
    }
}
