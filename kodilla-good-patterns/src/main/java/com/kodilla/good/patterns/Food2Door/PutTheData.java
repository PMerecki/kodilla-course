package com.kodilla.good.patterns.Food2Door;

import java.util.Scanner;

public class PutTheData {

    Scanner scanner = new Scanner(System.in);

    public OrderInformation orderInformation() {

        System.out.println("Choose supplier from 1 to 3");
        System.out.println("1 - Healthy Shop");
        System.out.println("2 - Gluten Free Shop");
        System.out.println("3 - Extra Food Shop");
        int supplier = scanner.nextInt();
        System.out.println("How many products?");
        int productNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Which product?");
        String productName = scanner.nextLine();

        scanner.close();

        return new OrderInformation(supplier, productNumber, productName);
    }
}
