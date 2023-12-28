package com.kodilla.good.patterns.flightsSearcher;

public record Flight(String departureAirport, String arrivalAirport) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (!departureAirport().equals(flight.departureAirport())) return false;
        return arrivalAirport().equals(flight.arrivalAirport());
    }

    @Override
    public int hashCode() {
        int result = departureAirport().hashCode();
        result = 31 * result + arrivalAirport().hashCode();
        return result;
    }
}
