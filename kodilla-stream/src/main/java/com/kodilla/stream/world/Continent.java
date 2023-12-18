package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public final class Continent {
    private final List<Country> listOfCountriesInContinent = new ArrayList<>();
    private final String continentName;

    public Continent(String continentName) {
        this.continentName = continentName;
    }

    public String getContinentName() {
        return continentName;
    }

    public List<Country> getListOfCountriesInContinent() {
        return new ArrayList<>(listOfCountriesInContinent);
    }

    public void addCountry (Country country){
        listOfCountriesInContinent.add(country);
    }
}