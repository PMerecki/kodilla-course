package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            System.out.println(secondChallenge.probablyIWillThrowException(1.0, 1.5));
        } catch (Exception e) {
            System.out.println("Problem with method");
        } finally {
            System.out.println("I am gonna be here... always!");
        }
    }
}