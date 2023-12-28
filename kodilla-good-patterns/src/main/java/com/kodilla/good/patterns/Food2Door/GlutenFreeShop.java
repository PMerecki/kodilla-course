package com.kodilla.good.patterns.Food2Door;

public class GlutenFreeShop implements OrderProcessing{

    @Override
    public void process(OrderInformation orderInformation) {
        System.out.println("Order sent to Gluten Free Shop");
        System.out.println("Ordered product: " + orderInformation.getProductName());
        System.out.println("Amount: " + orderInformation.getProductNumber());
    }
}
