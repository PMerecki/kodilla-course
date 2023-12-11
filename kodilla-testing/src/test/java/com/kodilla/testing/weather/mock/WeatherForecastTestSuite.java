package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class WeatherForecastTestSuite {

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
    @DisplayName("Temperatures test")

    @Test
    void testCalculateForecastWithMock() {
        //Given
        Temperatures temperaturesMock = mock(Temperatures.class);
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }
    @DisplayName("Average of given temperatures test")

    @Test
    void testCalculateAverageWithMock() {
        //Given
        Temperatures temperaturesMock = mock(Temperatures.class);
        Map<String, Double> average = new HashMap<>();
        average.put("Londyn", 12.7);
        average.put("Dubaj", 28.1);
        average.put("Waszyngton", 8.2);
        average.put("Rio De Janeiro", 26.7);
        average.put("Lagos", 34.3);
        when(temperaturesMock.getTemperatures()).thenReturn(average);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double averageOfTemperatures = weatherForecast.calculateAverage();

        //Then
        Assertions.assertEquals(22, averageOfTemperatures); ////Średnia
    }
    @DisplayName("Median of given temperatures test")

    @Test
    void testCalculateMedianWithMock() {
        //Given
        Temperatures temperaturesMock = mock(Temperatures.class);
        Map<String, Double> median = new HashMap<>();
        median.put("Neum", 13.5);
        median.put("Mostar", 12.2);
        median.put("Budapeszt", 3.1);
        median.put("Wiedeń", 8.2);
        median.put("Rzym", 11.1);
        median.put("Kair", 24.8);
        when(temperaturesMock.getTemperatures()).thenReturn(median);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double medianOfTemperatures = weatherForecast.calculateMedian();

        //Then
        Assertions.assertEquals(11.649999999999999, medianOfTemperatures);   ////Mediana
    }
}