package com.example.library.domain;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {
    private int id;
    private Status status;
    private Title title;

    private Set<Borrowing> borrowings = new HashSet<>();

    public Book() {
    }

    public Book(int id, Status status, Title title) {
        this.id = id;
        this.status = status;
        this.title = title;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name="STATUS")
    public Status getStatus() {
        return status;
    }

    @ManyToOne
    @JoinColumn(name = "TITLE_ID")
    public Title getTitle() {
        return title;
    }

    @OneToMany(
            targetEntity = Borrowing.class,
            mappedBy = "book",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    public Set<Borrowing> getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(Set<Borrowing> borrowings) {
        this.borrowings = borrowings;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setTitle(Title title) {
        this.title = title;
    }
}
