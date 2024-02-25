package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class HomeworkQueue implements Observable {
    private final List<Observer> observers = new ArrayList<>();
    private final String studentName;
    private final List<String> tasks = new ArrayList<>();

    public HomeworkQueue(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String task) {
        for (Observer observer : observers) {
            observer.update(task);
        }
    }

    public void addTask(String task) {
        tasks.add(task);
        notifyObservers(task);
    }

    public String getStudentName() {
        return studentName;
    }
}
