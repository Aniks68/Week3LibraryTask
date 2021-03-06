package services.serviceimplementation;

import enums.Role;
import models.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryUsersTest {
    LibraryUsers user;
    @BeforeEach
    void setUp() {
        user = new LibraryUsers("Martha", "Hassan", Role.TEACHER);
    }

    @Test
    @DisplayName("To borrow a book from the library")
    void borrowABook() {
        // Given
        Library decagonLib = new Library();
        Librarian librarian = new Librarian("Joe", "Clint");
        LibraryBook javaNote = new LibraryBook("Elvis", "Java for JJC", 8);
        user.borrowABook(javaNote, librarian);

        // Method check call
        final int expectedResult = 1;
        final int actualResult = decagonLib.getAppliedList().size();

        assertEquals(expectedResult, actualResult);
    }

    @Test@DisplayName("To return a borrowed book to the library")
    void returnBook() {
        // Given
        Librarian librarian = new Librarian("Joe", "Clint");
        LibraryBook ios = new LibraryBook("Elvis", "iOS for JJC", 8);
        user.borrowABook(ios, librarian);
        user.returnBook(ios);

        // Method check call
        final int expectedResult = 0;
        final int actualResult = user.getBorrowedBooks().size();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("To test the priority comparison")
    void compareTo() {
        // Given
        LibraryUsers user2 = new LibraryUsers("Maeli", "Elvira", Role.SENIOR_STUDENT);

        // Method check call
        final int expectedResult = 1;
        final int actualResult = user.compareTo(user2);

        assertEquals(expectedResult, actualResult);
    }
}