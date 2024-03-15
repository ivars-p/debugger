package org.example;

import java.util.Set;

import static org.example.CsvHelper.*;

public class Library {

    private static Set<Patrons> patrons; // patrons registered in system

    private static Set<Book> books; // books available for borrowing

    public Library() {
    }

    public void registerBook(Book book) {
        books.add(book);
    }

    public void removeBook(String filePath, Book book) {
        books.remove(book);
    }

    public void registerPatron(Patrons patron) {
        patrons.add(patron);
    }

    public void removePatron(Patrons patron) {
        patrons.remove(patron);
    }

    public void readDataFromCsv(String bookFileSrc, String patronFileSrc) {
        books = readBooksFromCSV(bookFileSrc);
        patrons = readPatronsFromCSV(patronFileSrc);
    }

    public static Book getBookById(String id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }

    public void printBooksInLibrary() {
        for (Book book : books) {
            book.printBook();
        }
    }

    public void printRegisteredPatrons() {
        for (Patrons patron : patrons) {
            patron.printPatron();
        }
    }
}
