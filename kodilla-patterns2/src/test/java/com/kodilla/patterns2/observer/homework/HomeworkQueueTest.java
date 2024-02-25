package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeworkQueueTest {

    @Test
    public void testUpdateHomeworks(){
        //Given
        HomeworkQueue johnTravolta = new HomeworkQueue("John Travolta");
        HomeworkQueue audreyHepburn  =new HomeworkQueue("Audrey Hepburn");
        HomeworkQueue donaldTrump = new HomeworkQueue("Donald Trump");

        Mentor mentor1 = new Mentor("Mentor 1");
        Mentor mentor2 = new Mentor("Mentor 2");

        johnTravolta.addObserver(mentor1);
        audreyHepburn.addObserver(mentor1);
        donaldTrump.addObserver(mentor2);

        //When
        johnTravolta.addTask("ShapeCollector");
        audreyHepburn.addTask("BookLibrary Mock");
        donaldTrump.addTask("index.html");
        johnTravolta.addTask("Wzorzec builder");
        donaldTrump.addTask("Fasada");

        //Then
        assertEquals(3,mentor1.getUpdateCount());
        assertEquals(2,mentor2.getUpdateCount());
    }
}