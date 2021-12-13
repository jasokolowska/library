package com.example.library.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "borrowings")
public class Borrowing {
    private int id;
    private Book book;
    private Reader reader;

    private Date borrowDate;
    private Date returnDate;

    public Borrowing() {
    }

    public Borrowing(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "BORROWING_ID", unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "BORROW_DATE")
    @Temporal(TemporalType.DATE)
    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    @Column(name = "RETURN_DATE")
    @Temporal(TemporalType.DATE)
    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BOOK_ID")
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "READER_ID")
    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }
}
