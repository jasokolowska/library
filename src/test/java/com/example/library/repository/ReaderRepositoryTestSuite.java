package com.example.library.repository;

import com.example.library.domain.Reader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ReaderRepositoryTestSuite {

    @Autowired
    private ReaderRepository readerRepository;

    @Test
    void testReaderRepositorySave() {
        //Given
        Reader reader = new Reader("Joanna", "Sokołowska");

        //When
        readerRepository.save(reader);

        //Then
        int id = reader.getId();
        Optional<Reader> readerById = readerRepository.findById(id);
        assertTrue(readerById.isPresent());

        //CleanUp
        readerRepository.deleteById(id);

    }
}
