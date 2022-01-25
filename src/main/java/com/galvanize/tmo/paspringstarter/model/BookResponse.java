package com.galvanize.tmo.paspringstarter.model;

import java.util.ArrayList;

public class BookResponse {

    ArrayList<Book> books;

    public BookResponse(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
