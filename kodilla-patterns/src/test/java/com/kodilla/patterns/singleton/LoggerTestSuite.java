package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoggerTestSuite {

    @Test
    public void getLastLogTest(){
        //Given
        String log = "log 1";
        String log2 = "log 2";
        //When
        Logger.getInstance().log(log);
        Logger.getInstance().log(log2);
        //Then
        Assertions.assertEquals(log2, Logger.getInstance().getLastLog());
    }
}