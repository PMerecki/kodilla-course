package com.kodilla.spring.portfolio;

public record Board(TaskList toDoList, TaskList inProgressList, TaskList doneList) {
}