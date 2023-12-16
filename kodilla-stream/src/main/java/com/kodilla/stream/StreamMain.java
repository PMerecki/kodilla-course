package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String beautifiedText = poemBeautifier.beautify("She turned her head as there was a light dignified knocking at the front door", (text -> text.toUpperCase()));
        System.out.println(beautifiedText);

        String beautifiedText2 = poemBeautifier.beautify("His hands still in his pockets", (text -> "ABC" + text + "ABC"));
        System.out.println(beautifiedText2);

        String beautifiedText3 = poemBeautifier.beautify("Is everything all right?", (text -> text.replace(" ", "*")));
        System.out.println(beautifiedText3);

        String beautifiedText4 = poemBeautifier.beautify("I had nothing to do in the hall", (text -> text.length() + " letters ***" + text + "*** " + text.length() + " letters"));
        System.out.println(beautifiedText4);

        String beautifiedText5 = poemBeautifier.beautify("It does her good to get away", (text -> text.concat(String.valueOf(text.hashCode()))));
        System.out.println(beautifiedText5);

        String beautifiedText6 = poemBeautifier.beautify("I decided to call him", (text -> {
            StringBuilder sb = new StringBuilder();
            sb.append("|");
           for (int i = 0; i < text.length(); i++) {
                sb.append(text.charAt(i));
                sb.append("|");
            }
            return sb.toString();
        }));
        System.out.println(beautifiedText6);

        String beautifiedText7 = poemBeautifier.beautify("It was a matter of chance that I should have rented a house in one of the strangest communities in North America", (text -> text.chars()
                .mapToObj(i -> Character.toString((char) i))
                .collect(Collectors.joining("|"))
        ));
        System.out.println(beautifiedText7);}}

