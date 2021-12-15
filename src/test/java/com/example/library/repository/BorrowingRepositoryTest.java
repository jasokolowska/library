package com.example.library.repository;

import com.example.library.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BorrowingRepositoryTest {

    @Autowired
    private BorrowingRepository repository;
    @Autowired
    private TitleRepository titleRepository;

    @Test
    public void testBorrowingRepositorySave() {
        //Given
        Title title1 = new Title("Billy Summers", "Stephen King", 2020);
        Title title2 = new Title("21 lekcji na XXI wiek", "Yuval Noah Harari", 2018);
        Book king1 = new Book(1, Status.AVAILABLE, title1);
        Book harari1 = new Book(2, Status.AVAILABLE, title2);

        title1.getBooks().add(king1);
        title2.getBooks().add(harari1);

        king1.setTitle(title1);
        harari1.setTitle(title2);
        titleRepository.save(title1);
        titleRepository.save(title2);

        Reader reader1 = new Reader(1,"Joanna", "Sokołowska", new Date());
        Reader reader2 = new Reader(2,"Batrosz", "Drabicki", new Date());

        Borrowing borrowing1 = new Borrowing(new Date());
        borrowing1.setBook(king1);
        borrowing1.setReader(reader1);
        Borrowing borrowing2 = new Borrowing(new Date());
        borrowing2.setBook(harari1);
        borrowing2.setReader(reader1);
        Borrowing borrowing3 = new Borrowing(new Date());
        borrowing3.setBook(harari1);
        borrowing3.setReader(reader2);

        reader1.getBorrowings().add(borrowing1);
        king1.getBorrowings().add(borrowing1);
        reader1.getBorrowings().add(borrowing2);
        harari1.getBorrowings().add(borrowing2);
        reader2.getBorrowings().add(borrowing3);
        harari1.getBorrowings().add(borrowing3);

        //When
        repository.save(borrowing1);
        repository.save(borrowing2);
        repository.save(borrowing3);

        //Then
        assertEquals(2, reader1.getBorrowings().size());
        assertEquals(1, reader2.getBorrowings().size());
    }

}