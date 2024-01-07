package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies() {

        //Given
        User millennials = new Millenials("Nancy");
        User yGeneration = new YGeneration("George");
        User zGeneration = new ZGeneration("Zack");

        //When
        String snapchat = millennials.sharePost();
        System.out.println("Millennials shares on: " + snapchat);
        String twitter = yGeneration.sharePost();
        System.out.println("YGeneration shares on: " + twitter);
        String facebook = zGeneration.sharePost();
        System.out.println("ZGeneration shares on: " + facebook);

        //Then
        Assertions.assertEquals("Snapchat", snapchat);
        Assertions.assertEquals("Twitter", twitter);
        Assertions.assertEquals("Facebook", facebook);
    }

    @Test
    public void testIndividualSharingStrategy() {

        //Given
        User millennials = new Millenials("Nancy");
        millennials.setSocialPublisher(new FacebookPublisher());

        //When
        String facebook = millennials.sharePost();
        System.out.println("Millenials shares on: " + facebook);

        //Then
        Assertions.assertEquals("Facebook", facebook);
    }
}