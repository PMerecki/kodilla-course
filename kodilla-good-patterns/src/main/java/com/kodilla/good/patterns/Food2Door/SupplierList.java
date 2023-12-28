package com.kodilla.good.patterns.Food2Door;

import java.util.HashMap;

public class SupplierList {

    public HashMap<Integer, OrderProcessing> getTheList() {

        HashMap<Integer, OrderProcessing> theList = new HashMap<>();
        theList.put(1, new HealthyShop());
        theList.put(2, new GlutenFreeShop());
        theList.put(3, new ExtraFoodShop());

        return theList;
    }
}
