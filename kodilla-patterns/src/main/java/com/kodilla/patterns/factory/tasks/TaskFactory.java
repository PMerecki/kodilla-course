package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING  = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task makeTask(final String taskClass) {
        return switch (taskClass) {
            case SHOPPING -> new ShoppingTask("Shopping task", "Cebula", 2.0);
            case PAINTING -> new PaintingTask("Painting task", "Czerwony", "Obraz");
            case DRIVING -> new DrivingTask("Driving task", "Londyn", "Maybach car");
            default -> null;
        };
    }
}
