package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {

        //Given
        Library library = new Library("my Library");
        Book book1 = new Book("Steve Jobs", "Walter Issacson", LocalDate.of(2011, Month.OCTOBER, 24));
        Book book2 = new Book("Promise Land", "Barack Obama", LocalDate.of(2020, Month.NOVEMBER, 17));
        Book book3 = new Book("One Flew Over the Cuckoo's Nest", "Ken Kesey", LocalDate.of(1962, Month.FEBRUARY, 1));
        Book book4 = new Book("Michael Jordan: The Life", "Roland Lazenby", LocalDate.of(2014, Month.MAY, 6));

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("my Library - shallow copy");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("my Library - deep copy");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        library.removeBook(book4);

        //Then
        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
        Assertions.assertEquals(3, library.getBooks().size());
        Assertions.assertEquals(3, clonedLibrary.getBooks().size());
        Assertions.assertEquals(4, deepClonedLibrary.getBooks().size());
        assertEquals(clonedLibrary.getBooks(), library.getBooks());
        assertNotEquals(deepClonedLibrary.getBooks(), library.getBooks());
    }
}