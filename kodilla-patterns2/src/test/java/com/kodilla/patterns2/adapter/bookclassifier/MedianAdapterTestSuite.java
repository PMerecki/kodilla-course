package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest() {
        // Given
        Set<Book> books = new HashSet<>();
        books.add(new Book("George R.R. Martin", "A Dance with Dragons", 2011, "0001"));
        books.add(new Book("J.K. Rowling", "Harry Potter and the Deathly Hallows", 2007, "0002"));
        books.add(new Book("Dan Brown", "The Da Vinci Code", 2003, "0003"));
        books.add(new Book("Suzanne Collins", "The Hunger Games", 2008, "0004"));
        books.add(new Book("Stieg Larsson", "The Girl with the Dragon Tattoo", 2005, "0005"));
        books.add(new Book("George Orwell", "1984", 1949, "0006"));
        books.add(new Book("Gabriel Garcia Marquez", "One Hundred Years of Solitude", 1967, "0007"));
        books.add(new Book("Jane Austen", "Pride and Prejudice", 1813, "0008"));
        books.add(new Book("Leo Tolstoy", "Anna Karenina", 1877, "0009"));
        books.add(new Book("Mary Shelley", "Frankenstein", 1818, "0010"));

        MedianAdapter medianAdapter = new MedianAdapter();

        // When
        int medianPublicationYear = medianAdapter.publicationYearMedian(books);

        // Then
        assertEquals(1985, medianPublicationYear);
    }
}