package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BigmacTestSuite {
    @Test
    public void testNewBigMac() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun(Bun.WITH_SESAME)
                .burgers(2)
                .sauce(Sauce.THOUSAND_ISLANDS)
                .ingredients(Ingredients.CHEESE)
                .ingredients(Ingredients.CHILI_PEPPERS)
                .ingredients(Ingredients.LETTUCE)
                .build();
        System.out.println(bigmac);

        //When
        int Burgers = bigmac.getBurgers();
        int IngredientsList = bigmac.getIngredients().size();

        //Then
        Assertions.assertEquals(2, Burgers);
        Assertions.assertEquals(3, IngredientsList);
        Assertions.assertTrue(bigmac.getIngredients().contains(Ingredients.CHILI_PEPPERS));
        Assertions.assertFalse(bigmac.getIngredients().contains(Ingredients.BACON));
    }
}