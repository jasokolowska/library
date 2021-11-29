package com.example.library.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "readers")
public class Reader {
    private long id;
    private String firstName;
    private String lastName;
    private Date creation;

    public Reader() {
    }

    public Reader(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.creation = new Date();
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public long getId() {
        return id;
    }

    @NotNull
    @Column(name="FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    @NotNull
    @Column(name="LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    @NotNull
    @Column(name="CREATED")
    public Date getCreation() {
        return creation;
    }
}
