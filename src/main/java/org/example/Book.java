package org.example;

import java.util.Date;

public class Book {

    private String id; // New field for book ID

    private String title = "";

    private String author = "";

    private Date releaseDate;

    private Category category;

    private boolean isBorrowed;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public boolean getBorrowedStatus() {
        return this.isBorrowed;
    }

    public void setBorrowed(boolean borrowed) { //this can work for both returning and taking books
        this.isBorrowed = borrowed;
    }

    public Book(String id, String title, String author, Date releaseDate, Category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.category = category;
        this.isBorrowed = false;
    }


    public void printBook() {
        System.out.println("Book{" +
                                   "id='" + id + '\'' +
                                   ", title='" + title + '\'' +
                                   ", author='" + author + '\'' +
                                   ", releaseDate='" + releaseDate + '\'' +
                                   ", category.title='" + category.getTitle() + '\'' +
                                   ", category.tags=" + category.getTags() +
                                   ", isBorrowed=" + isBorrowed +
                                   '}');
    }
}
