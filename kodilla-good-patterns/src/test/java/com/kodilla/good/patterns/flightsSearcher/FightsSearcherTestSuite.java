package com.kodilla.good.patterns.flightsSearcher;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FightsSearcherTestSuite {

    private static FlightsService flightsService;
    private static FlightsDb flightsDbMock;
    private static Set<Flight> availableFlights;

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }

    @BeforeAll
    public static void beforeClass() {
        flightsDbMock = mock(FlightsDb.class);
        flightsService = new FlightsService(flightsDbMock);
        availableFlights = new HashSet<>();
        availableFlights.add(new Flight("WRO", "WAR"));
        availableFlights.add(new Flight("WAR", "GDA"));
        availableFlights.add(new Flight("WRO", "NYC"));
        availableFlights.add(new Flight("GDA", "NYC"));
        availableFlights.add(new Flight("WAR", "NYC"));
        availableFlights.add(new Flight("WRO", "GDA"));
    }


    @DisplayName("Available Flights From Test")
    @Test
    public void availableFlightsFromTest() {
        //Given
        String departureAirport = "WRO";
        Set<Flight> expected = new HashSet<>();
        expected.add(new Flight("WRO", "WAR"));
        expected.add(new Flight("WRO", "NYC"));
        expected.add(new Flight("WRO", "GDA"));
        //When
        when(flightsDbMock.availableFlights()).thenReturn(availableFlights);
        Set<Flight> result = flightsService.availableFlightsFrom(departureAirport);
        //Then
        Assertions.assertEquals(expected, result);
    }

    @DisplayName("No Available Flights From Test")
    @Test
    public void noAvailableFlightsFromTest() {
        //Given
        String departureAirport = "NYC";
        Set<Flight> expected = new HashSet<>();
        //When
        when(flightsDbMock.availableFlights()).thenReturn(availableFlights);
        Set<Flight> result = flightsService.availableFlightsFrom(departureAirport);
        //Then
        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Available Flights To Test")
    @Test
    public void availableFlightsToTest() {
        //Given
        String arrivalAirport = "NYC";
        Set<Flight> expected = new HashSet<>();
        expected.add(new Flight("WRO", "NYC"));
        expected.add(new Flight("GDA", "NYC"));
        expected.add(new Flight("WAR", "NYC"));
        //When
        when(flightsDbMock.availableFlights()).thenReturn(availableFlights);
        Set<Flight> result = flightsService.availableFlightsTo(arrivalAirport);
        //Then
        Assertions.assertEquals(expected, result);
    }

    @DisplayName("No Available Flights To Test")
    @Test
    public void noAvailableFlightsToTest() {
        //Given
        String arrivalAirport = "WRO";
        Set<Flight> expected = new HashSet<>();
        //When
        when(flightsDbMock.availableFlights()).thenReturn(availableFlights);
        Set<Flight> result = flightsService.availableFlightsTo(arrivalAirport);
        //Then
        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Available Connecting Flights Test")
    @Test
    public void availableConnectingFlightsTest() {
        //Given
        String departureAirport = "WRO";
        String arrivalAirport = "NYC";
        Set<List<Flight>> expected = new HashSet<>();

        List<Flight> wroWarWarNyc = new ArrayList<>();
        wroWarWarNyc.add(new Flight("WRO", "WAR"));
        wroWarWarNyc.add(new Flight("WAR", "NYC"));

        expected.add(wroWarWarNyc);

        List<Flight> wroGdaGdaNyc = new ArrayList<>();
        wroGdaGdaNyc.add(new Flight("WRO", "GDA"));
        wroGdaGdaNyc.add(new Flight("GDA", "NYC"));

        expected.add(wroGdaGdaNyc);
        //When
        when(flightsDbMock.availableFlights()).thenReturn(availableFlights);
        Set<List<Flight>> result = flightsService.availableConnectingFlights(departureAirport, arrivalAirport);
        //Then
        Assertions.assertEquals(expected, result);
    }

    @DisplayName("No Available Connecting Flights Test")
    @Test
    public void noAvailableConnectingFlightsTest() {
        //Given
        String departureAirport = "NYC";
        String arrivalAirport = "GDA";
        Set<List<Flight>> expected = new HashSet<>();

        //When
        when(flightsDbMock.availableFlights()).thenReturn(availableFlights);
        Set<List<Flight>> result = flightsService.availableConnectingFlights(departureAirport, arrivalAirport);
        //Then
        Assertions.assertEquals(expected, result);
    }
}
