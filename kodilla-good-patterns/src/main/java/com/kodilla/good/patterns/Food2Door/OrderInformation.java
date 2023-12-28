package com.kodilla.good.patterns.Food2Door;

public class OrderInformation {

    public int supplier;
    public int productNumber;
    public String productName;

    public OrderInformation(final int supplier, final int productNumber, final String productName) {
        this.supplier = supplier;
        this.productNumber = productNumber;
        this.productName = productName;
    }

    public int getSupplier() {
        return supplier;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public String getProductName() {
        return productName;
    }
}
