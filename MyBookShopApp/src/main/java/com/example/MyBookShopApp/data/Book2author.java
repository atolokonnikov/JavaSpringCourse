package com.example.MyBookShopApp.data;

import javax.persistence.*;

@Entity
public class Book2author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="book_id", referencedColumnName = "id", nullable=false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable=false)
    private Author author;

    @Column(nullable = false)
    private Integer sort_index = 0;

    public Integer getSort_index() {
        return sort_index;
    }

    public void setSort_index(Integer sort_index) {
        this.sort_index = sort_index;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book2author{" +
                "id=" + id +
                ", book=" + book +
                ", author=" + author +
                '}';
    }
}
