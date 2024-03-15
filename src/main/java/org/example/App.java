package org.example;

import java.util.*;

public class App {
    public static void main( String[] args ) {

        Library rigase_iela_21 = new Library();
        System.out.println("11111");
        rigase_iela_21.readDataFromCsv("books.csv", "patrons.csv");
        rigase_iela_21.printBooksInLibrary();
        System.out.println("2222");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("aaa");
        rigase_iela_21.printRegisteredPatrons();
        System.out.println("-----------------------------------------------------------------------------------------");
        Book book1 = new Book(
                "123",
                "Name",
                "Ivars",
                new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime(),
                new Category("Animation",  new HashSet<>(Arrays.asList("Anime", "Fun")))
        );
        rigase_iela_21.registerBook(book1);
        System.out.println("Im here");
        System.out.println("-----------------------------------------------------------------------------------------");
        rigase_iela_21.printBooksInLibrary();
        System.out.println("Im here + aaaaaa");
        System.out.println("-----------------------------------------------------------------------------------------");
        Patrons janis = new Patrons("Janis", "Eglitis", "Salnas iela");
        rigase_iela_21.registerPatron(janis);
        rigase_iela_21.printRegisteredPatrons();
        System.out.println("1234556423");
        System.out.println("-----------------------------------------------------------------------------------------");
        janis.borrowABook(book1);
        rigase_iela_21.printBooksInLibrary();
        System.out.println("!!!!!!!!!!!!!!!!!!!!");
        System.out.println("-----------------------------------------------------------------------------------------");
        rigase_iela_21.printRegisteredPatrons();
    }
}
