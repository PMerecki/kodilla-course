package com.kodilla.good.patterns.Food2Door;

public class OrderService {

    private final OrderProcessing orderProcessing;
    private final OrderConfirmation orderConfirmation;

    public OrderService(final OrderProcessing orderProcessing, final OrderConfirmation orderConfirmation) {
        this.orderProcessing = orderProcessing;
        this.orderConfirmation = orderConfirmation;
    }

    public void order(final OrderInformation orderInformation) {
        boolean isSent = orderConfirmation.confirmIfDone(orderInformation);

        if (isSent) {
            orderProcessing.process(orderInformation);
        }
    }
}
