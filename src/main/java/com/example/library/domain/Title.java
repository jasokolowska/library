package com.example.library.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "titles")
public class Title {
    private int id;
    private String title;
    private String author;
    private int publicationYear;
    private List<Book> books = new ArrayList<>();

    public Title() {
    }

    public Title(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name="TITLE")
    public String getTitle() {
        return title;
    }

    @NotNull
    @Column(name="AUTHOR")
    public String getAuthor() {
        return author;
    }

    @NotNull
    @Column(name="YEAR")
    public int getPublicationYear() {
        return publicationYear;
    }

    @OneToMany(
            targetEntity = Book.class,
            mappedBy = "title"
    )
    public List<Book> getBooks() {
        return books;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
