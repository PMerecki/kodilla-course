package com.kodilla.testing;
import java.util.LinkedList;

public class Vowels {
    public static void main(String[] args) {
        String str = "anachroniczny";
        LinkedList<Character> list = new LinkedList<Character>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (vowel(c))
                list.add(c);
        }
        System.out.println("Vowels are:");
        for (Character c : list) {
            System.out.print(c);
        }
        System.out.print("\n");
    }

    public static boolean vowel(char character) {
        if ((character == 'a') || (character == 'e') || (character == 'i') || (character == 'o') || (character == 'u') || (character == 'y')
                || (character == 'A') || (character == 'E') || (character == 'I') || (character == 'O') || (character == 'U') || (character == 'Y')) {
            return true;
        } else {
            return false;
        }
    }
}