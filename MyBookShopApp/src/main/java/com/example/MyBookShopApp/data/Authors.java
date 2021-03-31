package com.example.MyBookShopApp.data;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Authors {
    private ArrayList<Author> authors;

    public Authors(ArrayList<Author> authors) {
        this.authors = authors;
    }

    public Authors() {
        this.authors = new ArrayList<>();
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }

    public void add(Author author) {
        this.authors.add(author);
    }

/*    public void add(Author author) {
        authors.add(author);
    }*/
}
