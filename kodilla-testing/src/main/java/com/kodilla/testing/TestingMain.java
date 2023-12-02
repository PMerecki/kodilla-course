package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;

import com.kodilla.testing.calculator.Calculator;

    public class TestingMain {

        public static void main(String[] args) {
            SimpleUser simpleUser = new SimpleUser("theForumUser");

            String result = simpleUser.getUsername();

            if (result.equals("theForumUser")) {
                System.out.println("test OK");
            } else {
                System.out.println("Error!");
            }

            Calculator calculator = new Calculator();

            int add = calculator.add(5, 7);
            int subtract = calculator.subtract(30, 10);

            System.out.println(add);
            System.out.println(subtract);

        }
    }