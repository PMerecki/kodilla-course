package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    void testBasicPizza() {
        // Given
        Pizza pizza = new BasicPizza();

        // When
        BigDecimal cost = pizza.getCost();
        String description = pizza.getDescription();

        // Then
        assertEquals(new BigDecimal(15), cost);
        assertEquals("Basic pizza (dough, tomato sauce, cheese)", description);

        // Display pizza details after test
        System.out.println("Basic pizza:");
        System.out.println("Description: " + description);
        System.out.println("Cost: " + cost);
    }

    @Test
    void testBasicPizzaWithAdditive() {
        // Given
        Pizza pizza = new AdditiveDecorator(new BasicPizza());

        // When
        BigDecimal cost = pizza.getCost();
        String description = pizza.getDescription();

        // Then
        assertEquals(new BigDecimal(20), cost);
        assertEquals("Basic pizza (dough, tomato sauce, cheese), extra additive", description);

        // Display pizza details after test
        System.out.println("Pizza with additive:");
        System.out.println("Description: " + description);
        System.out.println("Cost: " + cost);
    }

    @Test
    void testBasicPizzaWithExtraCheese() {
        // Given
        Pizza pizza = new CheeseDecorator(new BasicPizza());

        // When
        BigDecimal cost = pizza.getCost();
        String description = pizza.getDescription();

        // Then
        assertEquals(new BigDecimal(18), cost);
        assertEquals("Basic pizza (dough, tomato sauce, cheese), extra cheese", description);

        // Display pizza details after test
        System.out.println("Basic pizza with extra cheese:");
        System.out.println("Description: " + description);
        System.out.println("Cost: " + cost);
    }

    @Test
    void testBasicPizzaWithAdditiveAndExtraCheese() {
        // Given
        Pizza pizza = new CheeseDecorator(new AdditiveDecorator(new BasicPizza()));

        // When
        BigDecimal cost = pizza.getCost();
        String description = pizza.getDescription();

        // Then
        assertEquals(new BigDecimal(23), cost);
        assertEquals("Basic pizza (dough, tomato sauce, cheese), extra additive, extra cheese", description);

        // Display pizza details after test
        System.out.println("Basic pizza with additive and extra cheese:");
        System.out.println("Description: " + description);
        System.out.println("Cost: " + cost);
    }
}
