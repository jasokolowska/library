package com.example.library.service;

import com.example.library.domain.*;
import com.example.library.repository.BookRepository;
import com.example.library.repository.BorrowingRepository;
import com.example.library.repository.ReaderRepository;
import com.example.library.repository.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbService {

    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final BorrowingRepository borrowingRepository;
    private final TitleRepository titleRepository;

    public Reader saveReader(Reader reader) {
        return readerRepository.save(reader);
    }

    public Title saveTitle (Title title) {
        return titleRepository.save(title);
    }

    public Book saveBook (Book book) {
        return bookRepository.save(book);
    }

    public Borrowing saveBorrowing(Borrowing borrowing) {
        return borrowingRepository.save(borrowing);
    }

    public Reader getReader (int id) {
        return readerRepository.findById(id);
    }

    public Book getBook (int id) {
        return bookRepository.findById(id);
    }

    public Title getTitle (int id) {
        return titleRepository.findById(id);
    }

    public Optional<Borrowing> getBorrowing (int id) {
        return borrowingRepository.findById(id);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

}
