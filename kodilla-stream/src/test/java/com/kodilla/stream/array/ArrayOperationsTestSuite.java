package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage(){
        //Given
        int numbers [] = {9, 8, 10, 5, 9, 5, 3, 4, 7, 3, 290, 12, 444};
        //When
        double average = ArrayOperations.getAverage(numbers);
        //Then
        Assertions.assertEquals(62.23, average, 0.001);
    }
}