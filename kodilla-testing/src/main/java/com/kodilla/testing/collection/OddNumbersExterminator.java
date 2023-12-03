package com.kodilla.testing.collection;

import java.util.*;
import java.lang.*;


class OddNumbersExterminator {

    List<String> executeTasks;
    List<String> even;
    List<String> odd;

    // constructor
    public OddNumbersExterminator() {
        executeTasks = new ArrayList<>();
        even = new ArrayList<>();
        odd = new ArrayList<>();

    }

    //method serving the list of tasks
    public void executeTasks(Deque<String> theQueue) {

        String task;
        while ((task = theQueue.poll()) != null) {
            System.out.println(task.length() + " " + task);
            if (task.length() % 2 == 0) {
                even.add(task);
            } else {
                odd.add(task);
            }
        }
    }
}