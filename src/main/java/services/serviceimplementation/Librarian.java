package services.serviceimplementation;

import models.Person;
import services.LibrarianServices;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import static models.Library.*;

public class Librarian extends Person implements LibrarianServices {

    public Librarian(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public void addBook(Map<String, Integer> bookList, LibraryBook book) {
        if (bookList.containsKey(book.getTitle())) {
            int availCopy = bookList.get(book.getTitle());
            bookList.replace(book.getTitle(), availCopy+=book.getCopies());
        } else bookList.put(book.getTitle(), book.getCopies());
    }

    @Override
    public void lendBook(LibraryBook book, LibraryUsers user) {

        try {
            if (availableBooks.containsKey(book.getTitle()) && (availableBooks.get(book.getTitle()) != 0)) {
                requestQueue();
                lentRecords.put(user, book.getTitle());
                user.getBorrowedBooks().add(book);
                updateAvailCopies(availableBooks, book);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Apologies, " + book.getTitle() + " is not available now.");
        }
    }

    @Override
    public void updateAvailCopies(Map<String, Integer> bookList, LibraryBook book) {
        try {
            if (bookList.containsKey(book.getTitle())) {
                int availCopy = bookList.get(book.getTitle());
                bookList.replace(book.getTitle(), availCopy-1);
            }
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void acceptReturnedBooks(LibraryUsers users, LibraryBook book) {
        try {
            if ((lentRecords.containsKey(users)) && (lentRecords.get(users).equals(book.getTitle()))) {
                lentRecords.remove(users, book.getTitle());
                updateReturnedCopies(book);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("You are either not in the record or returning the wrong book");
        }
    }

    private void updateReturnedCopies(LibraryBook book) {
        try {
            if (availableBooks.containsKey(book.getTitle())) {
                int availCopy = availableBooks.get(book.getTitle());
                availableBooks.replace(book.getTitle(), availCopy+1);
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public Queue<LibraryUsers> requestQueue() {
        return bookRequestPriorityQueue;
    }

    private static Queue<LibraryUsers> bookRequestPriorityQueue =
            new PriorityQueue<>(new Comparator<LibraryUsers>() {
                @Override
                public int compare(LibraryUsers o1, LibraryUsers o2) {
                    final int user1Priority = o1.getRole().getPriority();
                    final int user2Priority = o2.getRole().getPriority();
                    if (user1Priority < user2Priority) {
                        return -1;
                    } else if (user1Priority > user2Priority) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });


}
