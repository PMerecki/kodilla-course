package com.kodilla.spring.forum;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class ForumUserTestSuite {
    @Test
    public void testGetUsername() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        ForumUser user = context.getBean(ForumUser.class);
        //When
        String name = user.getUserName();
        //Then
        Assertions.assertEquals("John Smith", name);
    }
}
