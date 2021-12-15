package com.example.library.repository;

import com.example.library.domain.Book;
import com.example.library.domain.Reader;
import com.example.library.domain.Status;
import com.example.library.domain.Title;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TitleRepositoryTestSuite {

    @Autowired
    private TitleRepository titleRepository;

    @Test
    void testReaderRepositorySave() {
        //Given
        Title billySummers = new Title(1,"Billy Summers", "Stephen King", 2000);

        //When
        titleRepository.save(billySummers);

        //Then
        int id = billySummers.getId();
        Title titleById = titleRepository.findById(id);
        assertEquals("Billy Summers", titleById.getTitle());

        //CleanUp
        titleRepository.deleteById(id);
    }

    @Test
    void testTitleSaveWithBookCopies() {
        //Given
        Title billySummers = new Title(1,"Billy Summers", "Stephen King", 2000);
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();

        billySummers.getBooks().add(book1);
        billySummers.getBooks().add(book2);
        billySummers.getBooks().add(book3);

        book1.setTitle(billySummers);
        book2.setTitle(billySummers);
        book3.setTitle(billySummers);

        //When
        titleRepository.save(billySummers);
        int id = billySummers.getId();

        //Then
        assertNotEquals(0, id);

        //CleanUp
//        titleRepository.deleteById(id);
    }
}

