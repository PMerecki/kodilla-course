package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {
    private final Bun bun;
    private final int burgers;
    private final Sauce sauce;
    private final List<Ingredients> ingredients;

    public static class BigmacBuilder {
        private Bun bun;
        private int burgers;
        private Sauce sauce;
        private final List<Ingredients> ingredients = new ArrayList<>();

        public BigmacBuilder bun(Bun bun) {
            this.bun = bun;
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredients(Ingredients ingredient) {
            ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            return new Bigmac(bun, burgers, sauce, ingredients);
        }
    }

    public Bigmac(Bun bun, int burgers, Sauce sauce, List<Ingredients> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public int getBurgers() {
        return burgers;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Big Mac Recipe: " +
                "bun = " + bun +
                ", burgers = " + burgers +
                ", sauce = " + sauce +
                ", ingredients = " + ingredients;
    }
}