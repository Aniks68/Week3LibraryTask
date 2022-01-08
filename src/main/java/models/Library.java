package models;

import enums.Role;
import services.serviceimplementation.LibraryBook;
import services.serviceimplementation.LibraryUsers;

import java.time.LocalDateTime;
import java.util.*;

public class Library implements Comparable<Role> {
    public static Map<LibraryUsers, String> lentRecords = new HashMap<LibraryUsers, String>();
    public static Map<String, Integer> availableBooks = new HashMap<>();
    public static HashMap<LibraryUsers, LibraryBook> appliedList = new HashMap<LibraryUsers, LibraryBook>();
    public static LinkedHashMap<LocalDateTime, LibraryUsers> applyTime = new LinkedHashMap<>();
    public static Map<LibraryUsers, String> returningBooks = new HashMap<>();

    public Library() {
    }

    public static Map<LibraryUsers, String> getLentRecords() {
        return lentRecords;
    }

    public static Map<String, Integer> getAvailableBooks() {
        return availableBooks;
    }

    public static HashMap<LibraryUsers, LibraryBook> getAppliedList() {
        return appliedList;
    }

    public static LinkedHashMap<LocalDateTime, LibraryUsers> getApplyTime() {
        return applyTime;
    }

    public static Map<LibraryUsers, String> getReturningBooks() {
        return returningBooks;
    }

    @Override
    public int compareTo(Role o) {
        return 0;
    }


}
