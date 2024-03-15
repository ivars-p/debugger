package org.example;

import java.util.ArrayList;
import java.util.List;

public class Patrons {

    String name = "";
    String lastname = "";
    String address = "";
    List<String> booksBorrowed = new ArrayList<>();

    public Patrons(String name, String lastname, String address) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getBooksBorrowed() {
        return booksBorrowed;
    }

    public void setBooksBorrowed(List<String> booksBorrowed) {
        this.booksBorrowed = booksBorrowed;
    }

    public void borrowABook(Book book){
        booksBorrowed.add(book.getId());
        book.setBorrowed(true);
    }

    public void returnABook(Book book) throws Exception {
        booksBorrowed.remove(book.getId());
    }

    public void payFineForBook() {
        System.out.println("You pay fine - sry!");
    }

    public void printPatron() {
        System.out.println( "Patrons{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", booksBorrowed=" + booksBorrowed +
                '}');
    }
}
