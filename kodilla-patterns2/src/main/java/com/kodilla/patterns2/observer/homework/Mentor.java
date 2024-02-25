package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {
    private final String mentorName;
    private int updateCount;

    public Mentor(String mentorName) {
        this.mentorName = mentorName;
        this.updateCount = 0;
    }

    @Override
    public void update(String task) {
        System.out.println(mentorName + " received new task: " + task);
        updateCount++;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
