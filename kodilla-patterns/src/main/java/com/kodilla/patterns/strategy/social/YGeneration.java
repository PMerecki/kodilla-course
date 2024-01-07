package com.kodilla.patterns.strategy.social;

public final class YGeneration extends User {

    public YGeneration(String userName) {
        super(userName);
        this.socialPublisher = new TwitterPublisher();
    }
}