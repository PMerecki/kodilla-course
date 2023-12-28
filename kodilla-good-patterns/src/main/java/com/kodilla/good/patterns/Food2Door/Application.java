package com.kodilla.good.patterns.Food2Door;

import java.util.HashMap;

public class Application {

    public static void main(String[] args) {

        PutTheData putTheData = new PutTheData();
        OrderInformation orderInformation = putTheData.orderInformation();
        SupplierList supplierList = new SupplierList();
        HashMap<Integer, OrderProcessing> theList = supplierList.getTheList();

        OrderService orderService = new OrderService(theList.get(orderInformation.getSupplier()), new OrderDone());

        orderService.order(orderInformation);
    }
}
