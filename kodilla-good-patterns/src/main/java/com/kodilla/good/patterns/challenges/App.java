package com.kodilla.good.patterns.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();
        Map<String, List<String>> movieMap = movieStore.getMovies();

        movieMap.forEach((key, value) -> System.out.println(key + " " + String.join(" ! ", value)));

        final String movies = movieMap.entrySet()
                .stream()
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.joining(" ! "));
        System.out.println(movies);

        final String moviesByTZ = movieMap.entrySet()
                .stream()
                .flatMap(n -> {
                    List<String> list = new ArrayList<>();
                    list.add(n.getKey());
                    list.addAll(n.getValue());
                    return list.stream();
                })
                .collect((Collectors.joining(" ! ")));
        System.out.println(moviesByTZ);
    }
}