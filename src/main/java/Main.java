import enums.Role;
import models.Library;
import services.serviceimplementation.Librarian;
import services.serviceimplementation.LibraryBook;
import services.serviceimplementation.LibraryUsers;

//import static models.Library.availableBooks;

public class Main {
    public static void main(String[] args) {

        Library decagonLib = new Library();
        LibraryUsers ikay = new LibraryUsers("Ikechukwu", "Anene", Role.SENIOR_STUDENT);
        LibraryUsers emekus = new LibraryUsers("Emeka", "Chukwudozie", Role.SENIOR_STUDENT);
        LibraryUsers prosper = new LibraryUsers("Prosper", "Amalaha", Role.JUNIOR_STUDENT);
        LibraryUsers mark = new LibraryUsers("Mark", "Marve", Role.TEACHER);
        Librarian joe = new Librarian("Joe", "Matthew");



        LibraryBook javaNote = new LibraryBook("Elvis", "Java for JJC", 8);
        LibraryBook ios = new LibraryBook("Usman", "iOS for JJC", 11);
        LibraryBook node = new LibraryBook("Chima", "Node.js for JJC", 4);
        LibraryBook javaAdvanced = new LibraryBook("Prosper", "Java for JJC", 5);

        joe.addBook(decagonLib.getAvailableBooks(), javaNote);
        System.out.println(decagonLib.getAvailableBooks().size());
        joe.addBook(decagonLib.getAvailableBooks(), node);
        System.out.println(decagonLib.getAvailableBooks().size());

        System.out.println(decagonLib.getAvailableBooks().get(javaNote.getTitle()));
        System.out.println(prosper.getBorrowedBooks().size());
        prosper.borrowABook(javaNote, joe);
        System.out.println(decagonLib.getLentRecords().size());


        System.out.println("========================");
        joe.lendBook(javaNote, prosper);
        System.out.println(decagonLib.getAvailableBooks().get(javaNote.getTitle()));
        System.out.println(decagonLib.getLentRecords().size());
        System.out.println(prosper.getBorrowedBooks().size());

//        prosper.borrowABook(javaAdvanced, joe);
//        mark.borrowABook(javaNote, joe);
//        ikay.borrowABook(node, joe);
//        emekus.borrowABook(ios, joe);
//        mark.borrowABook(node, joe);
//        System.out.println("=============");
//        System.out.println(joe.requestQueue());
//        joe.lendBook(javaNote, mark);
//        joe.lendBook(node, prosper);

    }
}
