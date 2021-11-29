package com.example.library.domain;

public class Book {
    private long id;
    private long titleId;
    private Status status;

    public Book() {
    }

    public Book(Status status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public long getTitleId() {
        return titleId;
    }

    public Status getStatus() {
        return status;
    }
}
