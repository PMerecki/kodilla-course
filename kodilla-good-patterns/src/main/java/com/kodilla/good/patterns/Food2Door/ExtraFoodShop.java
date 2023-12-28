package com.kodilla.good.patterns.Food2Door;

public class ExtraFoodShop implements OrderProcessing {

    @Override
    public void process(OrderInformation orderInformation) {
        System.out.println("Order sent to Extra Food Shop");
        System.out.println("Ordered product: " + orderInformation.getProductName());
        System.out.println("Amount: " + orderInformation.getProductNumber());
    }
}
