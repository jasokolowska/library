package com.example.library.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "readers")
public class Reader {
    private int id;
    private String firstName;
    private String lastName;
    private Date creation;
    private Set<Borrowing> borrowings = new HashSet<>();

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
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

    @OneToMany(
            targetEntity = Borrowing.class,
            mappedBy = "reader",
            cascade = CascadeType.ALL,
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }
}
