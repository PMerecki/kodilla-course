package com.kodilla.good.patterns.flightsSearcher;

import java.util.Set;

public record FlightsDb(Set<Flight> availableFlights) {
}
