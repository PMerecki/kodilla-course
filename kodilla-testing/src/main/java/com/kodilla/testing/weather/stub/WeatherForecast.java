package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    public double calculateAverage() {
        double sum = 0.0;
        for (Double temperature :
                temperatures.getTemperatures().values()) {
            sum += temperature;

        }
        return sum / temperatures.getTemperatures().values().size();
    }

    public double calculateMedian() {
        List<Double> temperaturesList = new ArrayList<>(temperatures.getTemperatures().values());
        Collections.sort(temperaturesList);

        if (temperaturesList.size() % 2 == 0) {
            return (temperaturesList.get(temperaturesList.size() / 2 - 1) +
                    temperaturesList.get(temperaturesList.size() / 2)) / 2.0;
        } else {
            return temperaturesList.get(temperaturesList.size() / 2);
        }
    }

}