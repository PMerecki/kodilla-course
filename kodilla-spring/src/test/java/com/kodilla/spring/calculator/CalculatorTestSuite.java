package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class CalculatorTestSuite {
    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);

        //When
        double addResult = calculator.add(3, 5);
        double subResult = calculator.sub(10, 3);
        double mulResult = calculator.mul(4, 7);
        double divResult = calculator.div(10, 2);

        //Then
        Assertions.assertEquals(8, addResult, 0.01);
        Assertions.assertEquals(7, subResult, 0.01);
        Assertions.assertEquals(28, mulResult, 0.01);
        Assertions.assertEquals(5, divResult, 0.01);
    }
}