package com.kodilla.exception.test;

public class App {
    public static void main(String[] args) {
        Flight BerlinLondon = new Flight("Berlin", "London");
        Flight BeijingWarsaw = new Flight("Beijing", "Warsaw");
        Flight ParisWarsaw = new Flight("Paris", "Warsaw");
        Flight TokioLondon = new Flight("Tokio", "London");
        Flight WarsawDubai = new Flight("Warsaw", "Dubai");

        FlightSearch flightSearch = new FlightSearch();

        try {
            boolean existBerlinLondon = flightSearch.findFlight(BerlinLondon);
            System.out.println("Flight Berlin - London: " + existBerlinLondon);
        } catch (RouteNotFoundException e) {
            System.out.println("Airport does not exist!");
        }

        try {
            boolean existBeijingWarsaw = flightSearch.findFlight(BeijingWarsaw);
            System.out.println("Flight Beijing - Warsaw: " + existBeijingWarsaw);
        } catch (RouteNotFoundException e) {
            System.out.println("Airport does not exist!");
        }

        try {
            boolean existParisWarsaw = flightSearch.findFlight(ParisWarsaw);
            System.out.println("Flight Paris - Warsaw: " + existParisWarsaw);
        } catch (RouteNotFoundException e) {
            System.out.println("Airport does not exist!");
        }

        try {
            boolean existTokioLondon = flightSearch.findFlight(TokioLondon);
            System.out.println("Flight Tokio - London: " + existTokioLondon);
        } catch (RouteNotFoundException e) {
            System.out.println("Airport does not exist!");
        }

        try {
            boolean existWarsawDubai = flightSearch.findFlight(WarsawDubai);
            System.out.println("Flight Tokio - London: " + existWarsawDubai);
        } catch (RouteNotFoundException e) {
            System.out.println("Airport does not exist!");
        }
    }
}