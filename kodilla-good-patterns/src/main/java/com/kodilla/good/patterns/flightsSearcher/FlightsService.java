package com.kodilla.good.patterns.flightsSearcher;

import java.util.*;
import java.util.stream.Collectors;

public class FlightsService {
    private final FlightsDb flightsDb;

    public FlightsService(FlightsDb flightsDb) {
        this.flightsDb = flightsDb;
    }

    public Set<Flight> availableFlightsFrom(String departureAirport) {
        return flightsDb.availableFlights().stream()
                .filter(flight -> flight.departureAirport().equals(departureAirport))
                .collect(Collectors.toSet());
    }

    public Set<Flight> availableFlightsTo(String arrivalAirport) {
        return flightsDb.availableFlights().stream()
                .filter(flight -> flight.arrivalAirport().equals(arrivalAirport))
                .collect(Collectors.toSet());
    }

    public Set<List<Flight>> availableConnectingFlights(String departureAirport, String arrivalAirport) {
        Set<List<Flight>> setOfFlights = new HashSet<>();

        flightsDb.availableFlights().stream()
                .filter(flight -> flight.departureAirport().equals(departureAirport))
                .forEach(flight -> {
                    List <Flight> temp = flightsDb.availableFlights().stream()
                            .filter(fl -> (flight.arrivalAirport().equals(fl.departureAirport()) && fl.arrivalAirport().equals(arrivalAirport)))
                            .toList();

                    if (!temp.isEmpty()) {
                        List<Flight> flightsRoute = new ArrayList<>();
                        flightsRoute.add(flight);
                        flightsRoute.addAll(temp);
                        setOfFlights.add(flightsRoute);
                    }
                });
        return setOfFlights;
    }
}