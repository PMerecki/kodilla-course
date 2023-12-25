package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {

    private final Map<String, Boolean> airportMap;

    public FlightSearch() {
        airportMap = airportDataBase();
    }

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        return findAirport(flight.getArrivalAirport()) && findAirport(flight.getDepartureAirport());
    }

    private boolean findAirport(String airportName) throws RouteNotFoundException{
        if (airportMap.containsKey(airportName)) {
            return airportMap.get(airportName);
        }else {
            throw new RouteNotFoundException("Airport does not exist!");
        }
    }

    private Map<String, Boolean> airportDataBase() {
        Map<String, Boolean> airportDataBase = new HashMap<>();
        airportDataBase.put("Beijing", true);
        airportDataBase.put("London", true);
        airportDataBase.put("Berlin", false);
        airportDataBase.put("Paris", false);
        airportDataBase.put("Tokio", true);
        airportDataBase.put("Warsaw", false);

        return airportDataBase;
    }
}