package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.example.Library.getBookById;

public class CsvHelper {

    public static Set<Book> readBooksFromCSV(String filePath) {
        Set<Book> books = new HashSet<>();

        try (CSVParser parser = new CSVParser(new FileReader(filePath), CSVFormat.DEFAULT.withDelimiter(';').withHeader())) {
            for (CSVRecord record : parser) {
                String id = record.get("ID");
                String title = record.get("Title");
                String author = record.get("Author");
                Date releaseDate = new SimpleDateFormat("dd.MM.yyyy").parse(record.get("ReleaseDate"));
                String categoryTitle = record.get("Category");
                String tagsString = record.get("Tags");
                boolean isBorrowed = Boolean.parseBoolean(record.get("IsBorrowed"));

                Set<String> tags = new HashSet<>(Arrays.asList(tagsString.split(",")));
                Category category = new Category(categoryTitle, tags);

                Book book = new Book(id, title, author, releaseDate, category);
                book.setBorrowed(isBorrowed);
                books.add(book);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return books;
    }

    public static Set<Patrons> readPatronsFromCSV(String filePath) {
        Set<Patrons> patronsSet = new HashSet<>();

        try (CSVParser parser = new CSVParser(new FileReader(filePath), CSVFormat.DEFAULT.withDelimiter(';').withHeader())) {
            for (CSVRecord record : parser) {
                String name = record.get("Name");
                String lastname = record.get("Lastname");
                String address = record.get("Address");
                String borrowedBookIds = record.get("BorrowedBookIds");

                Patrons patron = new Patrons(name, lastname, address);
                for (String id : borrowedBookIds.split(",")) {
                    Book book = getBookById(id.trim());
                    if (book != null) {
                        try {
                            patron.borrowABook(book);
                        } catch (Exception e) {
                            System.err.println("Error borrowing book: " + e.getMessage());
                        }
                    }
                }

                patronsSet.add(patron);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return patronsSet;
    }

    public static void addBookToCSV(String filePath, Book book) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            StringBuilder sb = new StringBuilder();
            sb.append(book.getId()).append(";");
            sb.append(book.getTitle()).append(";");
            sb.append(book.getAuthor()).append(";");
            sb.append(new SimpleDateFormat("yyyy-MM-dd").format(book.getReleaseDate())).append(";");
            sb.append(book.getCategory().getTitle()).append(";");
            sb.append(String.join(",", book.getCategory().getTags())).append(";");
            sb.append(book.isBorrowed()).append("\n");

            writer.write(sb.toString());

            System.out.println("Book added to CSV successfully.");
        } catch (IOException e) {
            System.err.println("Error adding book to CSV: " + e.getMessage());
        }
    }

    public static void addPatronToCSV(String filePath, Patrons patron) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            StringBuilder sb = new StringBuilder();
            sb.append(patron.getName()).append(";");
            sb.append(patron.getLastname()).append(";");
            sb.append(patron.getAddress()).append(";");

            if (!patron.getBooksBorrowed().isEmpty()) {
                sb.append(String.join(",", patron.getBooksBorrowed()));
            }
            sb.append("\n");

            writer.write(sb.toString());

            System.out.println("Patron added to CSV successfully.");
        } catch (IOException e) {
            System.err.println("Error adding patron to CSV: " + e.getMessage());
        }
    }
}
