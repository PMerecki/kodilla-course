package com.kodilla.good.patterns.Food2Door;

public class OrderDone implements OrderConfirmation {

    @Override
    public boolean confirmIfDone(OrderInformation orderInformation) {
        return true;
    }
}
