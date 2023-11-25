package com.kodilla;
import java.util.*;
import java.lang.*;

class Cannon {
    String name;
    public boolean loaded;
    public boolean unloaded;


    public Cannon(String name, boolean loaded) {
        this.name = name;
        this.loaded = loaded;
    }
    public String getName() {
        return name;
    }

    public boolean fire() {
        if (loaded) {
            System.out.println("Fire!");
        }
        return loaded = false;
    }

    public void load() {
        System.out.println(name + " is empty, loading.");
        loaded = true;
        fire();
    }
    public boolean isLoaded() {
        return loaded;
    }
}

public class Program {
    public static void main(String[] args) {
        LinkedList<Cannon> cannons = new LinkedList<>();
        cannons.add(new Cannon("Cannon1", true));
        cannons.add(new Cannon("Cannon2", false));
        cannons.add(new Cannon("Cannon3", false));
        cannons.add(new Cannon("Cannon4", true));
        cannons.add(new Cannon("Cannon5", false));
        cannons.add(new Cannon("Cannon6", true));

        for (Cannon cannon : cannons) {
            if (cannon.isLoaded()) {
                System.out.println(cannon.getName());
                cannon.fire();
            } else {
                System.out.println(cannon.getName());
                cannon.load();
            }
        }
    }
}