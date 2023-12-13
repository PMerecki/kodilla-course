package com.kodilla.testing.library;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

class BookDirectoryTestSuite {
    @Mock
    private LibraryDatabase libraryDatabaseMock;
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }


    @Nested
    @DisplayName("Book Library Tests")
    class A {
        @DisplayName("Test List Books With Conditions Return List")
        @Test
        void testListBooksWithConditionsReturnList() {
            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOfBooks = new ArrayList<>();
            Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
            Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
            Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
            Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
            resultListOfBooks.add(book1);
            resultListOfBooks.add(book2);
            resultListOfBooks.add(book3);
            resultListOfBooks.add(book4);
            when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

            // When
            List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

            // Then
            assertEquals(4, theListOfBooks.size());
        }

        @DisplayName("Test List Books With Condition More Than 20")
        @Test
        void testListBooksWithConditionMoreThan20() {

            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOf0Books = new ArrayList<>();
            List<Book> resultListOf15Books = generateListOfNBooks(15);
            List<Book> resultListOf40Books = generateListOfNBooks(40);
            when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                    .thenReturn(resultListOf15Books);
            when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                    .thenReturn(resultListOf0Books);
            when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                    .thenReturn(resultListOf40Books);

            // When
            List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
            List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
            List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
            // Then

            assertEquals(0, theListOfBooks0.size());
            assertEquals(15, theListOfBooks15.size());
            assertEquals(0, theListOfBooks40.size());
        }

        @DisplayName("Test List Books With Condition Fragment Shorter Than 3")
        @Test
        void testListBooksWithConditionFragmentShorterThan3() {
            // Given
            LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

            // When
            List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

            // Then
            assertEquals(0, theListOfBooks10.size());
            verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
        }
    }

    @Nested
    @DisplayName("Library User Tests")
    class B {
        @DisplayName("Test List Books In Hands Of No Books")
        @Test
        void testListBooksInHandsOfNoBooks() {
            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            LibraryUser libraryUser = new LibraryUser("Jan", "Kowalski", "123456789");
            when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(Collections.emptyList());

            // When
            List<Book> books = bookLibrary.listBooksInHandsOf(libraryUser);

            // Then
            assertTrue(books.isEmpty());
        }

        @DisplayName("Test List Books In Hands Of One Book")
        @Test
        void testListBooksInHandsOfOneBook() {
            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            LibraryUser libraryUser = new LibraryUser("Jan", "Kowalski", "123456789");
            Book book = new Book("Title", "Author", 2000);
            when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(Collections.singletonList(book));

            // When
            List<Book> books = bookLibrary.listBooksInHandsOf(libraryUser);

            // Then
            assertEquals(1, books.size());
            assertEquals(book, books.get(0));
        }

        @DisplayName("Test List Books In Hands Of Five Books")
        @Test
        void testListBooksInHandsOfFiveBooks() {
            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            LibraryUser libraryUser = new LibraryUser("Jan", "Kowalski", "123456789");
            List<Book> expectedBooks = IntStream.rangeClosed(1, 5)
                    .mapToObj(i -> new Book("Title " + i, "Author " + i, 2000 + i))
                    .collect(Collectors.toList());
            when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(expectedBooks);

            // When
            List<Book> books = bookLibrary.listBooksInHandsOf(libraryUser);

            // Then
            assertEquals(5, books.size());
            assertTrue(books.containsAll(expectedBooks));
        }
    }
}
