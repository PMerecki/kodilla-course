package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.*;

@DisplayName("Big Mac Test Suite")
public class BigmacTestSuite {
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @DisplayName("Test New Big Mac")
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