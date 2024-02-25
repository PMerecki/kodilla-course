package com.kodilla.patterns2.observer.homework;

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String task);
}
