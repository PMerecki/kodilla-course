package com.kodilla.testing.collection;

import java.lang.*;
import java.util.*;

public class CollectionTestSuite {

        public static void main(String[] args) throws java.lang.Exception {

            Random theGenerator = new Random();
            final int NUM_TASKS = (50);
            String chr = "a";
            Deque<String> taskQueue1 = new ArrayDeque<>();

            for (int i = 0; i < NUM_TASKS; i++) {
                taskQueue1.offer(chr.repeat (theGenerator.nextInt(50) + 1));
            }

            OddNumbersExterminator taskExecutor = new OddNumbersExterminator();
            taskExecutor.executeTasks(taskQueue1);

            System.out.println("Even:");
            System.out.println(taskExecutor.even);
            System.out.println("Odd:");
            System.out.println(taskExecutor.odd);
        }
    }