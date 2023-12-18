package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class World {
    private final List<Continent>listOfContinentsOfTheWorld = new ArrayList<>();

    public void addContinent(Continent continent){
        listOfContinentsOfTheWorld.add(continent);
    }

    public BigDecimal getPeopleQuantity(){
        BigDecimal peopleQtyOfTheWorld = listOfContinentsOfTheWorld.stream()
                .flatMap(continent -> continent.getListOfCountriesInContinent().stream())
                .distinct()
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, country) -> sum = sum.add(country));

        return peopleQtyOfTheWorld;
    }
}