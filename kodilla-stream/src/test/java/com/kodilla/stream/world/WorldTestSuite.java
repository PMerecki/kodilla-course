package com.kodilla.stream.world;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;

@DisplayName("World Test Suite")
public class WorldTestSuite {

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

    @DisplayName("Test Get Quantity Of People In The World")
    @Test
    public void testGetPeopleQuantity(){
        //Given
        World world = new World();

        Continent europe = new Continent("Europe");
        Continent asia = new Continent("Asia");
        Continent southamerica = new Continent("South America");

        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(southamerica);


        Country poland = new Country("Poland", new BigDecimal(37766000));
        Country switzerland = new Country("Switzerland", new BigDecimal(8703000));
        Country italy = new Country("Italy", new BigDecimal(59110000));

        europe.addCountry(poland);
        europe.addCountry(switzerland);
        europe.addCountry(italy);


        Country japan = new Country("Japan", new BigDecimal(125700000));
        Country afganistan  = new Country("Afganistan", new BigDecimal(40100000));
        Country vietnam = new Country("Vietnam", new BigDecimal(102789598));

        asia.addCountry(japan);
        asia.addCountry(afganistan);
        asia.addCountry(vietnam);


        Country argentina = new Country("Argentina", new BigDecimal(45810000));
        Country brazil = new Country("Brazil", new BigDecimal(214300000));

        southamerica.addCountry(argentina);
        southamerica.addCountry(brazil);


        //When
        BigDecimal totalPeople = world.getPeopleQuantity();

        //Then
        BigDecimal totalPeopleExpected = new BigDecimal("634278598");
        Assertions.assertEquals(totalPeopleExpected, totalPeople);
    }
}