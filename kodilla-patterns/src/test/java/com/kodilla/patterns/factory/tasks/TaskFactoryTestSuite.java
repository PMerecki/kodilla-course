package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskFactoryTestSuite {
    @Test
    public void testMakeShoppingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task shopping = taskFactory.makeTask(TaskFactory.SHOPPING);
        boolean beforeExecution = shopping.isTaskExecuted();
        shopping.executeTask();
        System.out.println(shopping);
        //Then
        assertEquals("Shopping task", shopping.getTaskName());
        Assertions.assertFalse(beforeExecution);
        assertTrue(shopping.isTaskExecuted());

    }

    @Test
    public void testMakePaintingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task painting = taskFactory.makeTask(TaskFactory.PAINTING);
        boolean beforeExecution = painting.isTaskExecuted();
        painting.executeTask();
        System.out.println(painting);
        //Then
        Assertions.assertEquals("Painting task", painting.getTaskName());
        Assertions.assertFalse(beforeExecution);
        Assertions.assertTrue(painting.isTaskExecuted());
    }

    @Test
    public void testMakeDrivingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task driving = taskFactory.makeTask(TaskFactory.DRIVING);
        boolean beforeExecution = driving.isTaskExecuted();
        driving.executeTask();
        System.out.println(driving);
        //Then
        Assertions.assertEquals("Driving task", driving.getTaskName());
        Assertions.assertFalse(beforeExecution);
        Assertions.assertTrue(driving.isTaskExecuted());
    }
}